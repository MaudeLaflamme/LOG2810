/**
*  Lexique.java
*  Implementation of the Class Lexique
*  Original author: Balea, Laflamme and Pak
*  Last modified : 3 dec 2018
**/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Lexique{
	
	private static int RECENT = 5;
	private Mots root;
	private Scanner x;
	private WordUI w;
	
	
	/* Constructeur. */
	Lexique(WordUI w) {
		this.root = new Mots("");
		this.w = w;
	}

	/**
     * Cette methode permet l'ouverture du fichier en question.
     * @param nomFichier est le nom du fichier desire pour la lecture du lexique.
     * @return void
     */
	public void openFiles(String nomFichier) {
		
		try {
			x = new Scanner(new File(nomFichier));
			
		}
		catch(Exception e) {
			System.out.println("Not found" + e);
			
		}
	}

	/**
     * Cette methode permet de lire le fichier et de mettre les mots 
     * dans un tableau de String.
     * @param -
     * @return void
     */
	public void readFiles() {
		
		/* Les mots du fichier lexique sont mis dans un arbre */
		while(x.hasNextLine()) {
			String mot = x.nextLine();
			this.root.addWord(new Mots(mot));
		}
		/* Fermeture du fichier lexique, car l'arbre contient les mots du fichier */
		closeFiles();
		
		String stopper = "0";
		while (true) {
		String input = w.t.getText();
		/* Si le input est nul, on initiliase le tableau a*/
		if (input == null) {
			w.a.clear();
			w.update();
		}
		/* Si le input n'est pas nul, on recherche le input dans l'arbre et on l'ajoute 
		 * dans le tableau recent */
		else if (!input.equals(stopper)) {
		w.b.setEnabled(false);
		String mot = input;
		String banque = "";
		if(mot != null) {
			banque += this.root.printWords(mot);
			Scanner dansString = new Scanner(banque);
			while (dansString.hasNext())
				w.a.add(this.root.findWord(dansString.next()));
			w.update();
			stopper = mot;
			Mots m = this.root.findWord(mot);
			if (m != null) {
				
				w.b.setEnabled(true);
			}
			this.updateRecent();

		}
		}
	}
	}
	/**
     * Cette methode permet une mise a jour du tableau des mots recents jusqu'a 5 mots max
     * @param -
     * @return void
     */
	public void updateRecent() {
		if (w.motsPlusUtilises.size() > 1) {
			for (int i = 1; i < w.motsPlusUtilises.size(); i ++) {
				if (w.motsPlusUtilises.get(0).equals(w.motsPlusUtilises.get(i))) {
					w.motsPlusUtilises.remove(i);
				}
			}
		}
		if (w.motsPlusUtilises.size() > RECENT) {
			w.motsPlusUtilises.get(RECENT).setRecemmentUtilise(0); // consignes : 0 pour faux
			w.motsPlusUtilises.remove(RECENT);
		}
		w.updateWithoutClear();
	}
	
	/**
     * Cette methode permet la fermeture du fichier lexique.
     * @param -
     * @return void
     */
	public void closeFiles() {
		x.close();
	}
	
	
	
}


