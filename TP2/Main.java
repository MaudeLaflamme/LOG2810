import java.io.IOException;

public class Main{
	
	public static void main(String[] args) throws IOException{
			Lexique lexique = new Lexique();
			String nomFichier = "lexique6.txt";
			lexique.openFiles(nomFichier);
			lexique.readFiles();
			lexique.closeFiles();
		}
	}