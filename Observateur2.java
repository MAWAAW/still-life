/**
* @author MOHAMMED BERRABAH
* @version 0.1 : Date : Fri May 17 10:59:55 CEST 2013
*
*/
public class Observateur2 implements Observateur {
	private JeuDeLaVie jeu;
	private int generationCourante=0;
	
	public Observateur2(JeuDeLaVie jeu) {
		this.jeu = jeu;	
	}
	
	public void actualise() {
		generationCourante++;
		int nbVivant=0, x, y;
		for(x=0; x<jeu.getXMax(); x++) {
			for(y=0; y<jeu.getYMax(); y++) {
				if(jeu.getGrille(x,y).estVivante())
					nbVivant++;	
			}
		}
		System.out.println("Generation "+generationCourante+": "+nbVivant+" cellules vivantes");
	}
	
}