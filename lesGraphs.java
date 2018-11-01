

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Clinique.Voisin;

public class Graphe{
	
private Scanner x;
private ArrayList<Clinique> carte;

Graphe(){
	
}
/* Créer le graphe avec les routes et les sommets à partir d'un fichier */
public void creerGraphe(String nomFichier) {
	
}

/* Affiche le graphe */
public void lireGraphe() {
	
}

/* Ouverture du fichier */
public void openFiles() {
	try {
		x = new Scanner(new File("/Users/dalyn/eclipse-workspace/fichier/src/centresLocaux.txt"));
	}
	catch(Exception e) {
		System.out.println("Not find");
	}
}
/* Lire les sommets, voisin et le tps */
public void readGraphe() {
	int index = 1;
	while(x.hasNextLine()) {
		ArrayList<Voisin> lesVoisins = new ArrayList<Voisin>();
		String line = x.nextLine();
		if(line.equals("")) {
		int sommet = x.nextInt();
		int voisin = x.nextInt();
		int temps = x.nextInt();
			if(sommet == index) {
		Voisin unVoisin = new Voisin(carte[voisin - 1], temps);
		lesVoisins.add(unVoisin);
		
			}
		//System.out.printf("%s %s %s\n", sommet,voisin,temps);
		}
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
}
