/**
* @author MOHAMMED BERRABAH
* @version 0.1 : Date : Tue May 07 10:05:08 CEST 2013
*
*/
public final class Cellule {	
	private CelluleEtat etat;
	private int x, y;
	
	public Cellule(int x, int y, CelluleEtat etat) {
		this.x = x;
		this.y = y;
		this.etat = etat;	
	}
	
	public void vit() {
		etat = etat.vit();	
	}
	
	public void meurt() {
		etat = etat.meurt();	
	}
	
	public boolean estVivante() {
		return etat.estVivante();
	}
	
	int nombreVoisinesVivantes(JeuDeLaVie jeu){
		int cpt=0;
		int xMax=jeu.getXMax()-1;
		int yMax=jeu.getYMax()-1;
		if(x==0){
			if(jeu.getGrille(x+1,y).estVivante()==true){
				cpt=cpt+1;
			}
			if(y==0){
				if(jeu.getGrille(x,y+1).estVivante()==true){
					cpt=cpt+1;
				}	
				if(jeu.getGrille(x+1,y+1).estVivante()==true){
					cpt=cpt+1;
				}
			}else if(y==yMax){
				if(jeu.getGrille(x,y-1).estVivante()==true){
					cpt=cpt+1;
				}	
				if(jeu.getGrille(x+1,y-1).estVivante()==true){
					cpt=cpt+1;
				}
			}else{
				if(jeu.getGrille(x,y+1).estVivante()==true){
					cpt=cpt+1;
				}	
				if(jeu.getGrille(x+1,y+1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x,y-1).estVivante()==true){
					cpt=cpt+1;
				}	
				if(jeu.getGrille(x+1,y-1).estVivante()==true){
					cpt=cpt+1;
				}
			}
		}else if(x==xMax){
			if(jeu.getGrille(x-1,y).estVivante()==true){
				cpt=cpt+1;
			}
			if(y==0){
				if(jeu.getGrille(x,y+1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x-1,y+1).estVivante()==true){
					cpt=cpt+1;
				}
			}else if(y==yMax){
				if(jeu.getGrille(x-1,y-1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x,y-1).estVivante()==true){
					cpt=cpt+1;
				}				
			}else{
				if(jeu.getGrille(x,y+1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x-1,y+1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x-1,y-1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x,y-1).estVivante()==true){
					cpt=cpt+1;
				}
			}
		}else{
			if(jeu.getGrille(x-1,y).estVivante()==true){
				cpt=cpt+1;
			}
			if(jeu.getGrille(x+1,y).estVivante()==true){
				cpt=cpt+1;
			}
			if(y==0){
				if(jeu.getGrille(x,y+1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x-1,y+1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x+1,y+1).estVivante()==true){
					cpt=cpt+1;
				}
			}else if(y==yMax){
				if(jeu.getGrille(x-1,y-1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x,y-1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x+1,y-1).estVivante()==true){
					cpt=cpt+1;
				}
			}else{
				if(jeu.getGrille(x,y+1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x-1,y+1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x+1,y+1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x-1,y-1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x,y-1).estVivante()==true){
					cpt=cpt+1;
				}
				if(jeu.getGrille(x+1,y-1).estVivante()==true){
					cpt=cpt+1;
				}
			}			
		}
		return cpt;
	}

	public void accepte(Visiteur v) {
		etat.accepte(v,this);
	}

}