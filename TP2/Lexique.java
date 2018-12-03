
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Lexique{
	
	private static int RECENT = 5;
	private ArrayDeque<Mots> motsPlusUtilises;
	private Mots root;
	private Scanner x;
	private WordUI w;
	
	/* Constructeur par défaut */
	Lexique(WordUI w) {
		this.motsPlusUtilises = new ArrayDeque<Mots>();
		this.root = new Mots("");
		this.w = w;
	}
	

	/* Ouverture */
	public void openFiles(String nomFichier) {
		
		try {
			x = new Scanner(new File(nomFichier));
			
		}
		catch(Exception e) {
			System.out.println("Not found" + e);
			
		}
	}
	/* Lire le fichier et met les mots dans un tableau de String */
	public void readFiles() {
		while(x.hasNextLine()) {
			String mot = x.nextLine();
			this.root.addWord(new Mots(mot));
		}
		//Scanner y = new Scanner(System.in);
		String stopper = "0";
		while (true) {
		String input = w.t.getText();
		if (input == null) {
			w.a.clear();
			w.update();
		}
		else if (!input.equals(stopper)) {
		String mot = input;
		String banque = "";
		if(mot != null) {
			banque += this.root.printWords(mot);
			Scanner dansString = new Scanner(banque);
			while (dansString.hasNext())
				w.a.add(dansString.next());
			w.update();
			stopper = mot;
			Mots m = this.root.findWord(mot);
			if (m != null) {
				w.motsPlusUtilises.add(0,m);
				m.setNbUtilisations();
				m.setRecemmentUtilise(1); //consignes : 1 pour vrai
				this.updateRecent();
			}

		}
		}
	}
	}
		
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
	
	/* Fermeture du fichier */
	public void closeFiles() {
		x.close();
	}
	
	
	
}


