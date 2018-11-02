import java.util.Scanner;

public class Interface {
	
	Interface() {
	}
	
	/**
	* interface du programme qui prend l'entree de l'usager
	* @return reponse de l'usager parmis les lettres a, b, c, d.
	*/
	String afficherInterface() {
		Scanner entree = new Scanner(System.in); //objet qui regarder l'entree de l'usager
		System.out.println(
				"***************************************************\n" + 
				"*    Vehicules Medicalisees Autonomes Montreal    *\n" +
				"***************************************************\n" +
				"* Veuillez choisir une des options suivantes :    *\n" +
				"*                                                 *\n" +
				"* (a) Mettre a jour la carte                      *\n" +
				"* (b) Determiner le plus cours chemin securitaire *\n" + 
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
				!reponse.equals("quitter")) { // c'Est comme ca qu'on compare des strings
			System.out.println("Entree non valide, choisissez entre a, b, c ou d");
			reponse = entree.nextLine();
		}
		if (reponse.equals("quitter")) 
			reponse = "d"; // juste pour simplifier le double cas (d) et (quitter) en un seul cas
		return reponse;
	}
}
