/**
* @author MOHAMMED BERRABAH
* @version 0.1 : Date : Tue May 07 10:05:36 CEST 2013
*
*/
public class CelluleEtatMort implements CelluleEtat {
	private static volatile CelluleEtatMort instance;
	
	public final static CelluleEtatMort getInstance() {
		if(CelluleEtatMort.instance == null) {
			synchronized(CelluleEtatMort.class) {
				if(CelluleEtatMort.instance == null)
					CelluleEtatMort.instance = new CelluleEtatMort();
			}
		}
		return CelluleEtatMort.instance;
	}
	
	public CelluleEtat vit() {
		return new CelluleEtatVivant();
	}
	
	public CelluleEtat meurt() {
		return this;
	}
	
	public boolean estVivante() {
		return false;
	}
	
	public void accepte(Visiteur v, Cellule c) {
		v.visiteCelluleMorte(c);
	}
}