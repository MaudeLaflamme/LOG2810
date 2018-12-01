
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
	
	private ArrayDeque<Mots> motsPlusUtilises;
	private Mots root;
	private Scanner x;
	
	/* Constructeur par défaut */
	Lexique() {
		this.motsPlusUtilises = new ArrayDeque<Mots>();
		this.root = new Mots("");
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
		Scanner y = new Scanner(System.in);

		System.out.print("ENtrer un mot: " + '\n');
		String mot = y.next();
		if(this.root.findWord(mot) != null) 
			this.root.findWord(mot).printEnfants();
		else
			System.out.print("Ce mot ne se trouve pas dans le lexique.");
		
		
	}	
			
	/* Fermeture du fichier */
	public void closeFiles() {
		x.close();
	}
	
	
	
}


