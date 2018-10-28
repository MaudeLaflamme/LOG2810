public abstract class AbstractVehicule 
{
    /* Attributs */
    int batterie;

    /* Constructeur */
    AbstractVehicule()
    {
        this.batterie = 100;
    }

    /* Méthodes */

     /*Retourne l'autonomie courante de la batterie*/
    public int getBatterie()
    {
        return this.batterie;
    }

    /* Méthodes abstraites */
    public abstract void perteBatterie(char patient);

}