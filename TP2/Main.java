import java.io.IOException;

public class Main{
	
	public static void main(String[] args) throws IOException{
			WordUI w = new WordUI();
			Lexique lexique = new Lexique(w);
			String nomFichier = "./src/lexique6.txt";
			lexique.openFiles(nomFichier);
			lexique.readFiles();
		}
	}
