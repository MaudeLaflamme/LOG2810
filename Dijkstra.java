import java.util.ArrayList;

public class Dijkstra {
	
	
	Dijkstra() {
	}
	
	
	int[][] creerTabReponse(int depart, Graphe graph){
		
		int[][] reponse = new int[graph.getCarte().size()][2]; // besoin d'un tableau a deux colonnes
			for (int i = 0; i < graph.getCarte().size(); i++)
				reponse[i][0] = Integer.MAX_VALUE;
			reponse[depart][0] = 0;
			return reponse;
		
	}
	boolean trouverRecharge(String ordreFinal, Graphe graph, int tempsMax, int patient, int depart) {
		
			ArrayList<String> cliniquesBornees = new ArrayList<String>();
			for (int i = 0; i < graph.getCarte().size(); i++) {
				if (graph.getCarte().get(i).getRecharge() == true)
					cliniquesBornees.add(Integer.toString(i + 1));
			}
			int positionBorne = Integer.MAX_VALUE;
			for (int i = 0; i < cliniquesBornees.size();i++) {
				if(ordreFinal.contains(cliniquesBornees.get(i))) {
					positionBorne = Integer.parseInt(cliniquesBornees.get(i));
					System.out.println("On pourrait s'arreter a la borne " + 
							positionBorne + 
								" et recharger les batteries pour faire ce parcours\n");
				}
			}
			if (positionBorne == Integer.MAX_VALUE) {
				return false;
			}
			else {
			System.out.println("Tentons d'aller a " + positionBorne);
					int[][] reponseBorne = this.creerTabReponse(depart, graph);
					this.plusCourtChemin(reponseBorne, graph.getCarte());
					//System.out.println(" temps pris : " + reponseBorne[positionBorne - 1][0]);
					if (tempsMax < reponseBorne[positionBorne - 1][0]){
							return false;
					}
					else 
						return true;
					}
			}
		
			
			
	void plusCourtChemin(int reponse[][], ArrayList<Clinique> carte) {
		for (int j = 0; j < carte.size(); j++ ) { // faut repeter la fonction pour chaque node
		
			int index = 0;
			int min = Integer.MAX_VALUE;
			
			// 1 - examine shortest unvisited neighbors (bool)
			for (int i = 0 ; i < carte.size(); i++)
				if (reponse[i][0] < min && carte.get(i).isVisited() == false) {
					index = i;
					min = reponse[i][0];
				}
			
			// 2 - calculate distance between point and neighbors
			// 3 - if shortest distance less than current -> update
			for (int i = 0; i < carte.get(index).getVoisins().size(); i++) {
				int newDistance = reponse[index][0] + carte.get(index).getVoisins().get(i).temps;
				int voisinNameInNum = carte.get(index).getVoisins().get(i).numIdentification - 1;
				if (newDistance < reponse[voisinNameInNum][0]) {
					reponse[voisinNameInNum][0] = newDistance;
					reponse[voisinNameInNum][1] = index;
				}
			}
			// 4 - le 0 (1) est visit� (bool = true)
			carte.get(index).setVisited(true);
		}
		// on remet tout les visites a false
		for (int i = 0; i < carte.size(); i++)
			carte.get(i).setVisited(false);
	}
	
	String ordre(int tableau[][], int depart, int arrive) {
		if (arrive == depart)
			return Integer.toString(depart + 1);
		else
			return ordre(tableau, depart, tableau[arrive][1]) + " -> " + Integer.toString(arrive + 1);
	}
	
}
