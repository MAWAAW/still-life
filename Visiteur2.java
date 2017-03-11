/**
* @author MOHAMMED BERRABAH
* @version 0.1 : Date : Fri May 17 11:05:05 CEST 2013
*
*/
public class Visiteur2 extends Visiteur {
	
	public Visiteur2(JeuDeLaVie jeu) {
		super(jeu);	
	}
	
	public void visiteCelluleVivante(Cellule c) {
		if(c.nombreVoisinesVivantes(jeu)<3 || c.nombreVoisinesVivantes(jeu)==5 || c.nombreVoisinesVivantes(jeu)>8) {
			CommandeMeurt cm = new CommandeMeurt(c);
			jeu.ajouteCommande(cm);
		}
	}
	
	public void visiteCelluleMorte(Cellule c) {
		if(c.nombreVoisinesVivantes(jeu)==3 || c.nombreVoisinesVivantes(jeu)==6 || c.nombreVoisinesVivantes(jeu)==7 || c.nombreVoisinesVivantes(jeu)==8) {
			CommandeVit cv = new CommandeVit(c);
			jeu.ajouteCommande(cv);
		}
	}
	
}