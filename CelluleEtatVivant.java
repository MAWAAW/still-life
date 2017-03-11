/**
* @author MOHAMMED BERRABAH
* @version 0.1 : Date : Tue May 07 10:05:28 CEST 2013
*
*/
public class CelluleEtatVivant implements CelluleEtat {
	private static volatile CelluleEtatVivant instance;
	
	public final static CelluleEtatVivant getInstance() {
		if(CelluleEtatVivant.instance == null) {
			synchronized(CelluleEtatVivant.class) {
				if(CelluleEtatVivant.instance == null)
					CelluleEtatVivant.instance = new CelluleEtatVivant();
			}	
		}
		return CelluleEtatVivant.instance;	
	}
	
	public CelluleEtat vit() {
		return this;	
	}
	
	public CelluleEtat meurt() {
		return new CelluleEtatMort();	
	}
	
	public boolean estVivante() {
		return true;
	}
	
	public void accepte(Visiteur v, Cellule c) {
		v.visiteCelluleVivante(c);
	}
}