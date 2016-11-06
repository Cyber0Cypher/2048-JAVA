import java.util.ArrayList;

public class Plateau {
	private int taille;
	
	ArrayList<ArrayList<Integer>> plateau = new ArrayList<ArrayList<Integer>>();
	
	// Initialisation des cases du plateau à zero suivant la taille
	public Plateau(int taille){
		this.taille = taille;
		for(int j=0; j<taille; j++){
			plateau.add(j, new  ArrayList<Integer>());
			for(int i=0; i<taille; i++){
				plateau.get(j).add(i, 0);
			}
		}
	}
	
	public int getTaille(){
		return taille;
	}
	
	public void setTaille(int taille){
		this.taille = taille;
	}
	
	public int getCase(int x, int y)
	{
		return plateau.get(y).get(x);
	}
	
	public void setCase(int x, int y, int valeur)
	{
		plateau.get(y).set(x,valeur);
	}
	
	// fonction qui insere une tuile crée sur le plateau
	public void insererTuile(Plateau plateau, Tuile tuile){
		tuile.RdmTuile(plateau);
		int tuileX = tuile.getXTuile();
		int tuileY = tuile.getYTuile();
		if(getCase(tuileX, tuileY) == 0){
			setCase(tuileX, tuileY,tuile.getTuile());
		}
	}
	
	public boolean glisserTuile(String direction){
		switch(direction){
		case "z" : return haut();
		case "s" : return bas();
		case "d" : return droite();
		case "q" : return gauche();
		case "o" : System.out.println("Vous avez quitté la partie !");
			return false;
		default : System.out.println("Erreur de saisie !");
			return false;
		}
	}
	
	
	public boolean haut() {
		boolean bouge = false; // Variable qui vérifie si des tuiles ont bougéées. si aucunes tuiles bouges rien ne se passe et la saisie doit être repetée
		ArrayList<Boolean> compile = new ArrayList<Boolean>();
		for(int i=0; i<taille; i++){
			compile.add(false);
		}
		
		for (int k=0; k<taille-1; k++){
			for (int j=taille-2; j>=0; j--){
				for(int i=0; i<taille; i++){
					if(getCase(i,j) != 0 && getCase(i,j+1) == 0){
						setCase(i,j+1,getCase(i,j));
						setCase(i,j, 0);
						bouge = true;
					}
					if(getCase(i,j) != 0 && getCase(i,j+1) == getCase(i,j) && compile.get(i) == false){
						setCase(i,j+1, getCase(i,j+1)*2);
						setCase(i,j, 0);
						bouge = true;
						compile.set(i, true);
					}
				}
			}
		}
		return bouge;
	}
	
	public boolean bas() {
		boolean bouge = false;
		ArrayList<Boolean> compile = new ArrayList<Boolean>();
		for(int i=0; i<taille; i++){
			compile.add(false);
		}
		
		for (int k=0; k<taille-1; k++){
			for (int j=1; j<taille; j++){
				for(int i=0; i<taille; i++){
					if(getCase(i,j) != 0 && getCase(i,j-1) == 0){
						setCase(i,j-1,getCase(i,j));
						setCase(i,j, 0);
						bouge = true;
					}
					if(getCase(i,j) != 0 && getCase(i,j-1) == getCase(i,j) && compile.get(i) == false){
						setCase(i,j-1, getCase(i,j-1)*2);
						setCase(i,j, 0);
						bouge = true;
						compile.set(i, true);
					}
				}
			}
		}
		return bouge;
	}
	
	public boolean droite() {
		boolean bouge = false;
		ArrayList<Boolean> compile = new ArrayList<Boolean>();
		for(int i=0; i<taille; i++){
			compile.add(false);
		}
		
		for (int k=0; k<taille-1; k++){
			for (int i=taille-2; i>=0; i--){
				for(int j=0; j<taille; j++){
					if(getCase(i,j) != 0 && getCase(i+1,j) == 0){
						setCase(i+1,j,getCase(i,j));
						setCase(i,j, 0);
						bouge = true;
					}
					if(getCase(i,j) != 0 && getCase(i+1,j) == getCase(i,j) && compile.get(j) == false){
						setCase(i+1,j, getCase(i+1,j)*2);
						setCase(i,j, 0);
						bouge = true;
						compile.set(j, true);
					}
				}
			}
		}
		return bouge;
	}
	
	public boolean gauche() {
		boolean bouge = false;
		ArrayList<Boolean> compile = new ArrayList<Boolean>();
		for(int i=0; i<taille; i++){
			compile.add(false);
		}
		
		for (int k=0; k<taille-1; k++){
			for (int i=1; i<taille; i++){
				for(int j=0; j<taille; j++){
					if(getCase(i,j) != 0 && getCase(i-1,j) == 0){
						setCase(i-1,j,getCase(i,j));
						setCase(i,j, 0);
						bouge = true;
					}
					if(getCase(i,j) != 0 && getCase(i-1,j) == getCase(i,j) && compile.get(j) == false){
						setCase(i-1,j, getCase(i-1,j)*2);
						setCase(i,j, 0);
						bouge = true;
						compile.set(j, true);
					}
				}
			}
		}
		return bouge;
	}


	public void afficherPlateau(){
		System.out.println("+----------+----------+------------+------------+-------------+");
		System.out.println("| z ->HAUT |  s ->BAS | d ->DROITE | q ->GAUCHE | o ->QUITTER |");
		System.out.println("+----------+----------+------------+------------+-------------+");
		for (int j=taille-1; j>=0; j--){
			for(int index=0; index<taille; index++){
					System.out.print("+------");
			}
			System.out.println("+");
			for(int index=0; index<taille; index++){
					System.out.print("|      ");
			}
			System.out.println("|");
			for(int i=0; i<taille; i++){
				if(getCase(i,j)<=9){
					System.out.print("|   "+getCase(i,j)+"  ");
				}
				else if(getCase(i,j)<=99)
				{
					System.out.print("|  "+getCase(i,j)+"  ");
				}
				else if(getCase(i,j)<=999)
				{
					System.out.print("|  "+getCase(i,j)+" ");
				}
				else
				{
					System.out.print("| "+getCase(i,j)+" ");
				}
			}
			System.out.println("|");
			for(int index=0; index<taille; index++){
				System.out.print("|      ");
			}
			System.out.println("|");
			
		}
		for(int index=0; index<taille; index++){
			System.out.print("+------");
		}
		System.out.println("+");
		
//		System.out.println("| "+getCase(0,3)+" | "+getCase(1,3)+" | "+getCase(2,3)+" | "+getCase(3,3)+" |");
//		System.out.println("+---+---+---+---+");
//		System.out.println("| "+getCase(0,2)+" | "+getCase(1,2)+" | "+getCase(2,2)+" | "+getCase(3,2)+" |");
//		System.out.println("+---+---+---+---+");
//		System.out.println("| "+getCase(0,1)+" | "+getCase(1,1)+" | "+getCase(2,1)+" | "+getCase(3,1)+" |");
//		System.out.println("+---+---+---+---+");
//		System.out.println("| "+getCase(0,0)+" | "+getCase(1,0)+" | "+getCase(2,0)+" | "+getCase(3,0)+" |");
//		System.out.println("+---+---+---+---+");
	}
	
	public boolean gagne(){
		for (int i=0; i<4; i++){
			for (int j=0; j<4; j++){
				if(getCase(i,j) != 0 && (int) getCase(i,j) == 2048){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean perdu(){
		int nbTuile = 0;
		for (int i=0; i<4; i++){
			for (int j=0; j<4; j++){
				if(getCase(i,j) != 0){
					nbTuile++;
				}
			}
		}
		if(nbTuile >= 16){
			return true;
		}
		else{
			return false;
		}
	}
}
