import java.io.IOException;

public class Main{
	
	public static void main(String[] args) throws IOException{
			Lexique lexique = new Lexique();
			String nomFichier = "/Users/dalyn/eclipse-workspace/TP42810/src/lexique 1.txt";
			lexique.openFiles(nomFichier);
			lexique.readFiles();
			lexique.closeFiles();
		}
	}
