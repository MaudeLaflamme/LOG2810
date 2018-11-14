
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Lexique{
	
	private ArrayList<Mots> mots;
	private ArrayList<Mots> motsPlusUtilises;
	private ArrayList<Mots> lexique;
	private Scanner x;
	
	/* Constructeur par défaut */
	Lexique() {
		this.lexique = new ArrayList<Mots>();
	}
	
	public ArrayList<Mots> getLexique(){
		return this.lexique;
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
		//String out = "";
		while(x.hasNextLine()) {
			String mot = x.nextLine();
			lexique.add(mot);
			
			/* Permet d'afficher tous les chars des mots */
			for(int i = 0; i < mot.length(); i++) {
				System.out.println(mot.charAt(i));
					
			}
		}
		
	}
	/* Fermeture du fichier */
	public void closeFiles() {
		x.close();
	}
}


