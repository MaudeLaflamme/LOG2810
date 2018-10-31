import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// classe graphe 
public class Graphe 
{
    /* Attributs */
    Clinique[] carte;

    /* Constructeur par param�tre*/
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
//        Retourne une string contenant le type de v�hicule utilis�, le pourcentage final de la batterie,
//        la liste du chemin utilis�, et la longueur du trajet. Si le transport est refus�, la string contient la raison 
//        du refus du transport. */
//    public String plusCourtChemin(Patient patient, Clinique depart, Clinique arrive)       
//    {
//        String message = " ";
//
//        //�crire m�thode plusCourtChemin
//
//        return message;
//    }
//
//    /* Calcule le plus long chemin � partir d'une clinique selon le type de v�hicule et le type
//        de patient. Retourne une string contenant l'�num�ration du chemin parcouru, par exemple "1,4,6,13" */
//    public String extraireSousGraphe(Clinique depart, AbstractVehicule vehicule, Patient patient)
//    {
//        String chemin = " ";
//
//        //�crire m�thode extraireSousGraphe
//
//        return chemin;
//    }
//}