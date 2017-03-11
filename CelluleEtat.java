/**
* @author MOHAMMED BERRABAH
* @version 0.1 : Date : Tue May 07 10:05:18 CEST 2013
*
*/
public interface CelluleEtat {
	public CelluleEtat vit();
	public CelluleEtat meurt();
	public boolean estVivante();
	public void accepte(Visiteur v, Cellule c);
}