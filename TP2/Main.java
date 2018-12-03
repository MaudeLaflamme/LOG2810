import java.io.IOException;

public class Main{
	
	public static void main(String[] args) throws IOException{
		
			WordUI w = new WordUI();
			Lexique lexique = new Lexique(w);
			String nomFichier = "./lexique 2.txt";
			lexique.openFiles(nomFichier);
			lexique.readFiles();
			//lexique.closeFiles();
		}
	}
