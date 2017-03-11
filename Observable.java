/**
* @author MOHAMMED BERRABAH
* @version 0.1 : Date : Tue May 07 11:41:44 CEST 2013
*
*/
public interface Observable {
	public void attacheObservateur(Observateur o);
	public void detacheObservateur(Observateur o);
	public void notifieObservateurs();
}