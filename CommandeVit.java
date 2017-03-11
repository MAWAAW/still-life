/**
* @author MOHAMMED BERRABAH
* @version 0.1 : Date : Mon May 13 14:55:23 CEST 2013
*
*/
public class CommandeVit extends Commande {
	
	CommandeVit(Cellule c) {
		this.cellule = c;
	}
	
	public void executer() {
		this.cellule.vit();
	}
	
}