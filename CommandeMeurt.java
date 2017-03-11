/**
* @author MOHAMMED BERRABAH
* @version 0.1 : Date : Mon May 13 14:55:30 CEST 2013
*
*/
public class CommandeMeurt extends Commande {
	
	CommandeMeurt(Cellule c) {
		this.cellule = c;
	}
	
	public void executer() {
		this.cellule.meurt();
	}
	
}