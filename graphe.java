// classe graphe 
public class Graphe 
{
    /* Attributs */
    Clinique[] carte;



    /* Constructeur*/
    Graphe()
    {

    }
    public Graphe creerGraphe(string nomFichier)
    {
        //Écrire méthode creerGraphe
    }
    public void lireGraphe()
    {
        //Écrire méthode lireGraphe()
    }

    /* Calcule le plus court chemin entre deux cliniques, selon le type de patient.
        Retourne une string contenant le type de véhicule utilisé, le pourcentage final de la batterie,
        la liste du chemin utilisé, et la longueur du trajet. Si le transport est refusé, la string contient la raison 
        du refus du transport. */
    public String plusCourtChemin(Patient patient, Clinique depart, Clinique arrive)       
    {
        String message = " ";

        //Écrire méthode plusCourtChemin

        return message;
    }

    /* Calcule le plus long chemin à partir d'une clinique selon le type de véhicule et le type
        de patient. Retourne une string contenant l'énumération du chemin parcouru, par exemple "1,4,6,13" */
    public String extraireSousGraphe(Clinique depart, AbstractVehicule vehicule, Patient patient)
    {
        String chemin = " ";

        //Écrire méthode extraireSousGraphe

        return chemin;
    }
}