import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// classe graphe 
public class Graphe 
{
    /* Attributs */
    Clinique[] carte;

    /* Constructeur par paramètre*/
    Graphe(Clinique[] carte)
    {
    	Graphe g = new Graphe(carte);
    	System.out.println(g);
    }
    public static void creerGraphe(String nomFichier)
    {
    	
    	Graphe(carte);
    }
    public static void lireGraphe(String nomFichier)
    {
    	String line = null;
	
		try {
		FileReader fileReader = new FileReader(nomFichier);
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		//StringBuilder string = new StringBuilder();
		while ((line = bufferedReader.readLine()) != null) {
			
			System.out.println(line);
		}
		bufferedReader.close();
	}
		/* */
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file" + nomFichier);
		}
		/* */
		catch(IOException ex) {
			System.out.println("Error reading file" + nomFichier);
		}
	}
    
public static void main(String[] args) throws IOException {
	
	String fichier = "/Users/dalyn/eclipse-workspace/fichier/src/centresLocaux.txt";
	
	creerGraphe(fichier);
	lireGraphe(fichier);	
}
}
//    /* Calcule le plus court chemin entre deux cliniques, selon le type de patient.
//        Retourne une string contenant le type de véhicule utilisé, le pourcentage final de la batterie,
//        la liste du chemin utilisé, et la longueur du trajet. Si le transport est refusé, la string contient la raison 
//        du refus du transport. */
//    public String plusCourtChemin(Patient patient, Clinique depart, Clinique arrive)       
//    {
//        String message = " ";
//
//        //Écrire méthode plusCourtChemin
//
//        return message;
//    }
//
//    /* Calcule le plus long chemin à partir d'une clinique selon le type de véhicule et le type
//        de patient. Retourne une string contenant l'énumération du chemin parcouru, par exemple "1,4,6,13" */
//    public String extraireSousGraphe(Clinique depart, AbstractVehicule vehicule, Patient patient)
//    {
//        String chemin = " ";
//
//        //Écrire méthode extraireSousGraphe
//
//        return chemin;
//    }
//}