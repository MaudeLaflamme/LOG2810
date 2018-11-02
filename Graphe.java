

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graphe{
	
private Scanner x;
private Scanner y;
private ArrayList<Clinique> carte;

Graphe(){
		
		this.carte = new ArrayList<Clinique>();
	}
	
	public ArrayList<Clinique> getCarte(){
		
		return this.carte;
	}
	/* Cr�er le graphe avec les routes et les sommets � partir d'un fichier */
	public void creerGraphe(String nomFichier) {
		openFiles(nomFichier);
		readBorne();
		readGraphe();
		closeFiles();
		
	}
	
	/* Affiche le graphe */
	public void lireGraphe() {
		String out = "";
		System.out.println("(" + carte.get(1).getVoisins().get(1).numIdentification);
		for(int i=0; i < carte.size(); i++) {
			out = ("(" + "Clinique"+(i+1) +", " + "(");
			for(int j = 0; j< carte.get(i).getVoisins().size(); j++) {
				out += "(" + carte.get(i).getVoisins().get(j).numIdentification;
				out += ", " + carte.get(i).getVoisins().get(j).temps + "), ";
			}
			out += "\n";	
			System.out.println(out);
		}
	}
	
	/* Ouverture du fichier */
	public void openFiles(String nomFichier) {
		try {
			x = new Scanner(new File(nomFichier));
			y = new Scanner(new File(nomFichier));
		}
		catch(Exception e) {
			System.out.println("Not find");
		}
	}
	/* Lire les sommets, voisin et le tps */
	public void readGraphe() {
		while(y.hasNextLine()) {
			String line = y.nextLine();
			if(line.equals("")) {
				int sommet = y.nextInt();
				int voisin = y.nextInt();
				int temps = y.nextInt();
				Voisin unVoisin = new Voisin(voisin, temps);
				this.carte.get(sommet-1).addVoisin(unVoisin);
				Voisin autreVoisin = new Voisin(sommet, temps);
				this.carte.get(voisin-1).addVoisin(autreVoisin);
			
				}
			//System.out.printf("%s %s %s\n", sommet,voisin,temps);
			}
		}
	/* Lecture des sommets et de leur borne */
	public void readBorne() {
		while(x.hasNext()) {
			int sommetb = x.nextInt();
			int borne = x.nextInt(); // bool
			String line = x.nextLine();
			if(line.equals(""))  {
			Clinique uneClinique = new Clinique(borne);
			carte.add(uneClinique);
			//System.out.printf("%s %s\n", sommetb,borne);
			}
		}
	}
	/* Fermeture du fichier */
	public void closeFiles() {
		x.close();
	}
	
	
	public String extraireSousGraphe(int depart, int vehicule, int patient) {
			
		Vehicule auto = new Vehicule();
		int tempsMax;
		if(vehicule == 1)
			tempsMax = auto.maxBatterieNINH(patient);
		else
			tempsMax = auto.maxBatterieLIION(patient);
		
		/* Creation d'une structure de reponse */
		Dijkstra dijk = new Dijkstra();			
		int[][] reponse = new int[carte.size()][2];			
		for(int i = 0; i < carte.size(); i++) {
			reponse[i][0]= Integer.MAX_VALUE;
		}
		reponse[depart-1][0] = 0;
		
		/* Appel de l'algorithme de Dijkstra */
		dijk.plusCourtChemin(reponse, carte);
		int indexPlusLong = 0;
		for(int i = 0; i < carte.size(); i++) {
			if(reponse[i][0] >= indexPlusLong && reponse[i][0]<= tempsMax)
				indexPlusLong = i;
		}
		System.out.println(indexPlusLong);
		// on veut tout remettre les cliniques � false
		for (int i = 0; i < carte.size(); i++)
			carte.get(i).setVisited(false);

		String ordreFinal = "Le chemin le plus long possible est:" + dijk.ordre(reponse, (depart -1), indexPlusLong);
		return ordreFinal;
	}
}
