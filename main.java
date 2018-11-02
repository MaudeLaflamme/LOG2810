import java.util.*; // importe toute les librairies java
//public enum Patient {faible, moyen, eleve}


public class main 
{
	/**
	* interface du programme qui prend l'entrée de l'usager
	* @return reponse de l'usager parmis les lettres a, b, c, d.
	*/
	public static String Interface () {
		Scanner entree = new Scanner(System.in); //objet qui regarder l'entrée de l'usager
		System.out.println(
				"***************************************************\n" + 
				"*    Véhicules Médicalisées Autonomes Montréal    *\n" +
				"***************************************************\n" +
				"* Veuillez choisir une des options suivantes :    *\n" +
				"*                                                 *\n" +
				"* (a) Mettre à jour la carte                      *\n" +
				"* (b) Déterminer le plus cours chemin sécuritaire *\n" + 
				"* (c) Extraire un sous-graphe                     *\n" +
				"* (d) Quitter                                     *\n" +
				"*                                                 *\n" +
				"***************************************************\n"
				);
		String reponse = entree.nextLine();
		while ( !reponse.equals("a") &&
				!reponse.equals("b") &&
				!reponse.equals("c") &&
				!reponse.equals("d") &&
				!reponse.equals("quitter")) { // c'Est comme ça qu'on compare des strings
			System.out.println("Entrée non valide, choisissez entre a, b, c ou d");
			reponse = entree.nextLine();
		}
		if (reponse.equals("quitter")) 
			reponse = "d"; // juste pour simplifier le double cas (d) et (quitter) en un seul cas
		return reponse;
	}
	
	/**
	 * Fonction principale
	 * @param args (non utilise)
	 */
	public static void main(String[] args) 
	{
		String userInput = Interface(); 	// tout d'abord on veut afficher l'interface 
		Graphe graph = new Graphe();
		while (!userInput.equals("d")) {     // et savoir l'entrée de l'usager
			switch (userInput) {		 
				case "a" :
					System.out.println("Vous avez choisi l'option (a)");
					System.out.println("Entrer le nom du fichier: ");
					Scanner fichier = new Scanner(System.in);
					String nomFichier = fichier.nextLine();
					graph.creerGraphe(nomFichier);
					graph.lireGraphe();
					break;
				case "b" :
					Dijkstra d = new Dijkstra(); // pour acceder aux fonctions dijkstra
					Scanner cin = new Scanner(System.in);
					System.out.println("Vous avez choisi l'option (b)");
					int departEnNum;
					
					// on demande ou commencer � l'usager
					System.out.println("O� commencer ? [1 - 29] ");
					departEnNum = cin.nextInt() - 1;
					
					//Creation d'une structure avec la reponse
					int[][] reponse = new int[graph.getCarte().size()][2]; // besoin d'un tableau � deux colonnes
 					for (int i = 0; i < graph.getCarte().size(); i++)
 						reponse[i][0] = Integer.MAX_VALUE;
 					reponse[departEnNum][0] = 0;
 					
 					//appel de la fonction dijkstra 29 fois, 1 fois pour chaque clinique
 					for (int i = 0; i < graph.getCarte().size(); i++)
 						d.plusCourtChemin(reponse, graph.getCarte());
 					
 					//donner l'ordre
 					System.out.println("Quelle est l'arriv�e voulue [1 -29]");
 					int arriveeVoulue = cin.nextInt() - 1;
 					String ordreFinal = d.ordre(reponse, departEnNum, arriveeVoulue);
					System.out.println("Chemin pris : " + ordreFinal + " temps pris : " + reponse[arriveeVoulue][0]);
					
					// on veut tout remettre les cliniques � false
					for (int i = 0; i < graph.getCarte().size(); i++)
						graph.getCarte().get(i).setVisited(false);

					break;
				case "c" : 
					Scanner allo = new Scanner(System.in);
					System.out.println("Vous avez choisi l'option (c)");
					System.out.println("Veuillez entrer une clinique de départ");
					int depart = allo.nextInt();
					System.out.println("Veuillez entrer le type de véhicule [1: Ni-MH, 2:Li-ion]");
					int vehicule = allo.nextInt();
					System.out.println("Veuillez entrer le type de patient [1: Faible risque, 2: Moyen risque, 3: Risque élevé]");
					int patient = allo.nextInt();
					System.out.println(graph.extraireSousGraphe(depart, vehicule, patient));
					break;
			}
			userInput = Interface(); // pour recommencer le while
		}
        System.out.println("Fermeture du programme");
    }

}