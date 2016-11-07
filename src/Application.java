import java.util.Scanner;


public class Application {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("+--------------------+");
		System.out.println("|        2048        |");
		System.out.println("+--------------------+");
		System.out.println("+---------------------------------------+");
		System.out.println("| Veuillez choisir la taille du plateau |");
		System.out.println("+---------------------------------------+");
		
		int taille = sc.nextInt();
		Plateau plateau = new Plateau(taille);
		sc.nextLine();
		
		Tuile tuile = new Tuile();
		String saisie;
		
		plateau.insererTuile(plateau, tuile);
		plateau.afficherPlateau();
		saisie = jouer(sc);
		boolean bouge = plateau.glisserTuile(saisie);
		do{
			if(plateau.gagne())	// Si le joueur remporte la partie
			{
				System.out.println("+----------------------------------------------------------+");
				System.out.println("|               Bravo ! Vous avez gagné !                  |");
				System.out.println("|             Vous pouvez continuer de jouer               |");
				System.out.println("+----------------------------------------------------------+");
			}
			if(bouge) // On vérifie que des tuiles ont bougées, si ce n'est pas le cas aucune autre tuile n'est inseré
			{
				plateau.insererTuile(plateau, tuile);
				plateau.afficherPlateau();
			}
			saisie = jouer(sc);
			bouge = plateau.glisserTuile(saisie);
			
			if(plateau.perdu()) // Si le joueur perd la partie
			{
				System.out.println("+----------------------------------------------------------+");
				System.out.println("|               Dommage! Vous avez perdu !                 |");
				System.out.println("|                 La partie est terminée                   |");
				System.out.println("+----------------------------------------------------------+");
			}
			
		}while(!plateau.perdu() && saisie != "o");
		
	}

	private static String jouer(Scanner sc) {
		return sc.nextLine();
	}
}
