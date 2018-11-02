import java.util.ArrayList;

public class Dijkstra {
	
	Dijkstra() {
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
