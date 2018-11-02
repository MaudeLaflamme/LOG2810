import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
	
	Interface() {
	}
	
	/**
	* interface du programme qui prend l'entree de l'usager
	* @return reponse de l'usager parmis les lettres a, b, c, d.
	*/
	
	public void afficherInterface(Graphe graph) {
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
			
		
		while (!reponse.equals("d")) {
			this.repondreInterface(reponse, graph);
			System.out.println("Veuillez entrer une autre option: ");
			reponse = entree.nextLine();
		}
			
		System.out.println("Fermeture du programme");
	}
	
	
	public void repondreInterface(String userInput, Graphe graph) {
					    			
		
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
				int[][] reponse = d.creerTabReponse(departEnNum, graph);

				d.plusCourtChemin(reponse, graph.getCarte());
				
				//afficher tableau -- temporaire
				for (int i = 0; i < graph.getCarte().size(); i++)
					System.out.println("[" + i + "] Clinique" + reponse[i][0] + "\t\t" + reponse[i][1] + "\n" );
				//Fin afficher tableau
				
				System.out.println("Quelle est l'arrivee voulue ? [1 -29]");
				int arriveeVoulue = cin.nextInt() - 1;
				System.out.println("Veuillez entrer le type de patient [1: Faible risque, 2: Moyen risque, 3: Risque eleve]");
				int typePatient = cin.nextInt();
				String ordreFinal = d.ordre(reponse, departEnNum, arriveeVoulue);
				
				//Ã€ enlever 
				
				Vehicule auto = new Vehicule();
				int tempsMax = auto.maxBatterieNINH(typePatient);
				int tempsMaxL = auto.maxBatterieLIION(typePatient);
				System.out.println("VOICI LE TEMPS MAXIMUM NIMH : " + tempsMax);
				System.out.println("VOICI LE TEMPS MAXIMUM LI-ION : " + tempsMaxL);
				String messageClient = "";
				
				
				boolean rechargeTrouve = true;
				int tempsPris = 0;
				if (tempsMax < reponse[arriveeVoulue][0]) {
					System.out.println("Le tempsMaxNIMH est plus petit que le temps nécessaire. Appel de trouverRecharge...");
					rechargeTrouve = d.trouverRecharge(ordreFinal, graph, tempsMax, typePatient, departEnNum);
					if (rechargeTrouve == false ) {
						System.out.println("Imposssible de trouver borne et se rendre en NIMH, essayon LION");
						if (tempsMaxL < reponse[arriveeVoulue][0]) {
							rechargeTrouve = d.trouverRecharge(ordreFinal, graph, tempsMaxL, typePatient, departEnNum);
							if (rechargeTrouve == false)
								messageClient += "Le transport est refuse, car aucune voiture ne peut se rendre a destination";
							else {// Cas ou la batterie Li-ION fait le trajet avec recharge
								tempsPris += 120;
								messageClient += "Le type de batterie utilisee : LI-ION\n Le pourcentage de batterie finale est : "+  (160 - auto.perteBatterieLIION(typePatient, tempsMaxL));
								
							}
								
						}
						else { // Cas ou la batterie Li-ION fait le trajet sans recharge
							messageClient += "Le type de batterie utilisee : LI-ION\n Le pourcentage de batterie finale est : " + auto.perteBatterieLIION(typePatient, tempsMaxL);
						}
					}
					else { // Cas ou la batterie NIMH fait le trajet avec recharge
						tempsPris += 120;
						messageClient += "Le type de batterie utilisee: NIMH\n Le pourcentage de batterie finale est: " + (160 - auto.perteBatterieNINH(typePatient, tempsMax));
					}
						
						
				}
				else { // Cas ou la batterie NIMH fait le trajet sans recharge
					messageClient += "Le type de batterie utilisee: NIMH\n Le pourcentage de batterie finale est: " + auto.perteBatterieNINH(typePatient, tempsMax);
				}	
				messageClient += "Chemin pris : " + ordreFinal + " temps pris : " + (reponse[arriveeVoulue][0]+ tempsPris);
				
				
				
				break;
				
			case "c" : 
				Scanner in = new Scanner(System.in);
				System.out.println("Vous avez choisi l'option (c)");
				System.out.println("Veuillez entrer une clinique de depart");
				int depart = in.nextInt();
				System.out.println("Veuillez entrer le type de vehicule [1: Ni-MH, 2:Li-ion]");
				int vehicule = in.nextInt();
				System.out.println("Veuillez entrer le type de patient [1: Faible risque, 2: Moyen risque, 3: Risque eleve]");
				int patient = in.nextInt();
				System.out.println(graph.extraireSousGraphe(depart, vehicule, patient));
				break;
				
		}
	}


	}


