/**
* @author MOHAMMED BERRABAH
* @version 0.1 : Date : Tue May 07 11:43:42 CEST 2013
*
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JeuDeLaVieUI extends JPanel implements Observateur {
	
	private int generationCourante=0;
	private final JeuDeLaVie jeu;
	private JButton bPlayStop;
	private JButton bNextGen;
	private JSlider sVitesse;
	private JButton bmode;
	private JLabel nbVivante;

	public JeuDeLaVieUI(JeuDeLaVie j) {		
		this.jeu = j;
		
		JFrame fenetre = new JFrame("Jeu de la Vie");		
		fenetre.setLayout(new BorderLayout());
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		JPanel jp2 = new JPanel();
		jp2.setLayout(new BorderLayout());
		
		bPlayStop = new JButton("Play");
		bNextGen = new JButton("Avancer generation");
		sVitesse = new JSlider(0,1000);
		bmode = new JButton("Normale");
		nbVivante = new JLabel("Generation "+generationCourante+": 0 cellules vivantes");
		
		bPlayStop.setPreferredSize(new Dimension(150,30));
		bNextGen.setPreferredSize(new Dimension(150,30));
		sVitesse.setPaintTicks(true);
		bmode.setPreferredSize(new Dimension(150,30));
		
		fenetre.add(this,BorderLayout.CENTER);
		jp.add(bPlayStop,BorderLayout.WEST);
		jp.add(sVitesse,BorderLayout.CENTER);
		jp.add(bNextGen,BorderLayout.EAST);
		fenetre.add(jp,BorderLayout.NORTH);
		jp2.add(bmode,BorderLayout.WEST);
		jp2.add(nbVivante,BorderLayout.EAST);
		fenetre.add(jp2,BorderLayout.SOUTH);
		
		bPlayStop.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(bPlayStop.getText()=="Play") {
					jeu.setArretBoucle(false);	
					bPlayStop.setText("Stop");
					(new Thread(jeu)).start();
				}
				else {
					bPlayStop.setText("Play");
					jeu.setArretBoucle(true);
				}
			}
		});
		
		bNextGen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(jeu.getArretBoucle())
					jeu.calculerGenerationSuivante();	
			}	
		});
		
		sVitesse.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jeu.setVitesse(sVitesse.getValue());	
			}	
		});
		jeu.setVitesse(sVitesse.getValue());
		
		bmode.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(bmode.getText()=="Hard") {
					jeu.setVisiteur(new Visiteur2(jeu));
					bmode.setText("Normale");	
				}
				else {
					jeu.setVisiteur(new VisiteurClassique(jeu));
					bmode.setText("Hard");
				}
			}	
		});
		
		fenetre.setSize(650,650);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
	
	public void actualise() {
		repaint();
		generationCourante++;
		nbVivante.setText("Generation "+generationCourante+": "+jeu.nbCelluleVivante()+" cellules vivantes");
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(int x=0; x<jeu.getXMax(); x++) {
			for(int y=0; y<jeu.getYMax(); y++) {
				if(jeu.getGrille(x,y).estVivante())
					g.fillOval(x*3,y*3,3,3);
			}
		}	
	}
}
