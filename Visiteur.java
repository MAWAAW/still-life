/**
* @author MOHAMMED BERRABAH
* @version 0.1 : Date : Mon May 13 15:39:11 CEST 2013
*
*/
public abstract class Visiteur {
	protected JeuDeLaVie jeu;
	Visiteur(JeuDeLaVie jeu) {
		this.jeu = jeu;
	}
	abstract public void visiteCelluleVivante(Cellule c);
	abstract public void visiteCelluleMorte(Cellule c);
}