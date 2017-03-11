/**
* @author MOHAMMED BERRABAH
* @version 0.1 : Date : Tue May 07 11:04:28 CEST 2013
*
*/
import java.util.*;
import java.lang.Math;

public class JeuDeLaVie implements Observable,Runnable {
	private Cellule[][] grille;
	private int xMax;
	private int yMax;
	private List<Observateur> observateurs = new ArrayList<Observateur>();
	private List<Commande> commandes = new ArrayList<Commande>();
	private Visiteur visiteur;
	private int nbVivant;
	private boolean arretBoucle = true;
	private int vitesse = 0;
	
	
	public JeuDeLaVie() {
		this.xMax = 150;
		this.yMax = 150;
		this.grille = new Cellule[xMax][yMax];
	}
	
	/** Getters et Setters */
	public int getXMax() { return xMax; }
	public int getYMax() { return yMax; }
	public Cellule getGrille(int x, int y) { return this.grille[x][y]; }
	public Visiteur getVisiteur() { return visiteur; }
	public void setVisiteur(Visiteur v) { visiteur=v; }
	public boolean getArretBoucle() { return arretBoucle; }
	public void setArretBoucle(boolean b) { arretBoucle=b; }
	public int getVitesse() { return vitesse; }
	public void setVitesse(int v) { vitesse=v; }
	
	public void initialiseGrille() {
		for(int i=0; i<xMax; i++) {
			for(int j=0; j<yMax; j++) {
				if(Math.random()<0.5)
					grille[i][j] = new Cellule(i,j,CelluleEtatVivant.getInstance());
				else	
					grille[i][j] = new Cellule(i,j,CelluleEtatMort.getInstance());
			}
		}		
	}
	
	public int nbCelluleVivante() {
		int x, y;
		nbVivant=0;		
		for(x=0; x<getXMax(); x++){
			for(y=0; y<getYMax(); y++){
				if(getGrille(x,y).estVivante())
					nbVivant+=1;
			}
		}
		return nbVivant;
	}
	
	public void attacheObservateur(Observateur o) {
		this.observateurs.add(o);
	}
	
	public void detacheObservateur(Observateur o) {
		this.observateurs.remove(o);
	}
	
	public void notifieObservateurs() {
		for(Observateur o : observateurs)
			o.actualise();
	}
	
	public void ajouteCommande(Commande c) {
		this.commandes.add(c);
	}
	
	public void executeCommande() {
		for(Commande c : commandes)
			c.executer();
		commandes.clear();
	}
	
	public void distribueVisiteur() {
		for(int i=0; i<xMax; i++) {
			for(int j=0; j<yMax; j++) {
				grille[i][j].accepte(visiteur);
			}
		}
	}
	
	public void calculerGenerationSuivante() {
		distribueVisiteur();
		executeCommande();
		notifieObservateurs();
	}
	
	public void run() {
	
		while(arretBoucle==false) {
			try {
				Thread.sleep(vitesse);
			}catch(Exception e) {
				System.out.println(e.getMessage());	
			}
			calculerGenerationSuivante();
		}	
		
	}
	
	public static void main(String args[]) {
		JeuDeLaVie jdv = new JeuDeLaVie();
		Visiteur2 v2 = new Visiteur2(jdv);
		jdv.visiteur = v2;
		jdv.initialiseGrille();
		JeuDeLaVieUI jdvUI = new JeuDeLaVieUI(jdv);
		jdv.attacheObservateur(jdvUI);
		Observateur2 o2 = new Observateur2(jdv);
		jdv.attacheObservateur(o2);
	}
	
}











