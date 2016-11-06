import java.util.Random;

public class Tuile {
	
	int x;
	int y;
	int valeur;
	
	public void setTuile(int x, int y, int valeur){
		this.x = x;
		this.y = y;
		this.valeur = valeur;
	}
	
	// génère une tuile et la place de manière aléatpire à un emplacement vide
	public void RdmTuile(Plateau plateau){
		Random r = new Random();
		do{
			x = r.nextInt(plateau.getTaille());
			y = r.nextInt(plateau.getTaille());
		}while(plateau.getCase(x,y) != 0);
		
		if(plateau.getCase(x,y) == 0)
		{
			setTuile(x,y, Math.random() < 0.9 ? 2 : 4); // Probabilité de 0.9 qu'une tuile 2 apparaisse
		}
	}
	
	public int getTuile(){
		return valeur;
	}
	
	public int getXTuile(){
		return x;
	}
	
	public int getYTuile(){
		return y;
	}
}
