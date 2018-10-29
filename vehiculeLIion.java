
public class vehiculeLIion extends AbstractVehicule 
{


    /* Cette méthode est appelée à chaque fois que le trajet total atteint 60 minutes*/
    public void perteBatterie(Patient patient)
    {
        if(patient == 'f'){
            this.batterie -= 5;
        }
        else if (patient == 'm'){
            this.batterie -= 10;
        }
        else {
            this.batterie -= 30;
        }

    }



}