/**
* @author MOHAMMED BERRABAH
* @version 0.1 : Date : Mon May 13 15:40:42 CEST 2013
*
*/
public class VisiteurClassique extends Visiteur {
	
	VisiteurClassique(JeuDeLaVie jeu) {
		super(jeu);
	}
	
	public void visiteCelluleVivante(Cellule c) {
		if(c.nombreVoisinesVivantes(jeu)<2 || c.nombreVoisinesVivantes(jeu)>3)
			jeu.ajouteCommande(new CommandeMeurt(c));
	}
	
	public void visiteCelluleMorte(Cellule c) {
		if(c.nombreVoisinesVivantes(jeu)==3)
			jeu.ajouteCommande(new CommandeVit(c));
	}
	
}