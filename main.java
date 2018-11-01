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
		while (!userInput.equals("d")) {     // et savoir l'entrée de l'usager
			switch (userInput) {		 
				case "a" :
					System.out.println("Vous avez choisi l'option (a)");
					System.out.println("Entrer le nom du fichier: ");
					Scanner fichier = new Scanner(System.in);
					String nomFichier = fichier.nextLine();
					Graphe graph = new Graphe();
					graph.creerGraphe(nomFichier);
					graph.lireGraphe();
					break;
				case "b" :
					System.out.println("Vous avez choisi l'option (b)");
					break;
				case "c" : 
					System.out.println("Vous avez choisi l'option (c)");
					break;
			}
			userInput = Interface(); // pour recommencer le while
		}
        System.out.println("Fermeture du programme");
    }

}