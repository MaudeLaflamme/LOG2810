import java.util.*; // importe toute les librairies java

public class main 
{
	/**
	 * Fonction principale
	 * @param args (non utilise)
	 */
	public static void main(String[] args) {
		
		Interface inter = new Interface();	
		String userInput = inter.afficherInterface(); 
		Graphe graph = new Graphe();					
		while (!userInput.equals("d")) {     			
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
					Dijkstra d = new Dijkstra();
					Scanner cin = new Scanner(System.in);
					System.out.println("Vous avez choisi l'option (b)");
					int departEnNum;
					
					System.out.println("Ou commencer ? [1 - 29] ");
					departEnNum = cin.nextInt() - 1;
					
					int[][] reponse = new int[graph.getCarte().size()][2]; // besoin d'un tableau a deux colonnes
 					for (int i = 0; i < graph.getCarte().size(); i++)
 						reponse[i][0] = Integer.MAX_VALUE;
 					reponse[departEnNum][0] = 0;
 					
 					d.plusCourtChemin(reponse, graph.getCarte());
 					
 					//afficher tableau -- temporaire
 					for (int i = 0; i < graph.getCarte().size(); i++)
 						System.out.println("[" + i + "] Clinique" + reponse[i][0] + "\t\t" + reponse[i][1] + "\n" );
 					
 					System.out.println("Quelle est l'arrivee voulue ? [1 -29]");
 					int arriveeVoulue = cin.nextInt() - 1;
 					System.out.println("Veuillez entrer le type de patient [1: Faible risque, 2: Moyen risque, 3: Risque eleve]");
 					int typePatient = cin.nextInt();
 					String ordreFinal = d.ordre(reponse, departEnNum, arriveeVoulue);
 					
 					Vehicule auto = new Vehicule();
 					int tempsMax = auto.maxBatterieNINH(typePatient);
 					
 					if (tempsMax < reponse[arriveeVoulue][0]) {
 						ArrayList<String> cliniquesBornees = new ArrayList<String>();
 						for (int i = 0; i < graph.getCarte().size(); i++)
 							if (graph.getCarte().get(i).getRecharge() == true)
 								cliniquesBornees.add(Integer.toString(i));
 						for (int i = 0; i < cliniquesBornees.size();i++) {
 							if(ordreFinal.contains(cliniquesBornees.get(i) + 1))
 									System.out.println("On devra s'arreter à la borne " + 
 											(Integer.parseInt(cliniquesBornees.get(i)) + 1) + 
 											" et recharger les batteries pour faire ce parcours");
 							//else
 								//int intermediaire = d.bornePlusProche(cliniquesBornees);
 						}
 					}
 					
					System.out.println("Chemin pris : " + ordreFinal + " temps pris : " + reponse[arriveeVoulue][0]);
					
					
					
					break;
					
				case "c" : 
					Scanner allo = new Scanner(System.in);
					System.out.println("Vous avez choisi l'option (c)");
					System.out.println("Veuillez entrer une clinique de depart");
					int depart = allo.nextInt();
					System.out.println("Veuillez entrer le type de vehicule [1: Ni-MH, 2:Li-ion]");
					int vehicule = allo.nextInt();
					System.out.println("Veuillez entrer le type de patient [1: Faible risque, 2: Moyen risque, 3: Risque eleve]");
					int patient = allo.nextInt();
					System.out.println(graph.extraireSousGraphe(depart, vehicule, patient));
					break;
			}
			userInput = inter.afficherInterface(); // pour recommencer le while
		}
        System.out.println("Fermeture du programme");
    }
}