

public class vehiculeNINH extends AbstractVehicule 
{


    /* Cette méthode est appelée à chaque fois que le trajet total atteint 60 minutes*/
    public void perteBatterie(Patient patient)
    {
        if(patient == faible){
            this.batterie -= 6;
        }
        else if (patient == moyen){
            this.batterie -= 12;
        }
        else {
            this.batterie -= 48;
        }

    }



}
