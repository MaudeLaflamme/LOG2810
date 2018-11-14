public class Vehicule 
{
    /* Attributs */
    int batterie;

    /* Constructeur */
    Vehicule()
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
    public void perteBatterieNINH(int patient)
    {
        if(patient == 1){
            this.batterie -= 6;
        }
        else if (patient == 2){
            this.batterie -= 12;
        }
        else {
            this.batterie -= 48;
        }

    }
    
    public void perteBatterieLIION(int patient)
    {
        if(patient == 1 ){
            this.batterie -= 5;
        }
        else if (patient == 2 ){
            this.batterie -= 10;
        }
        else {
            this.batterie -= 30;
        }

    }
    
    public int maxBatterieNINH(int patient) {
    	
    	if(patient == 1) 
    		return((80/6) * 60);			//80% de batterie avec une perte de 5% par heure, puis on transforme en minutes.
    	else if(patient == 2)
    		return((80/12)*60);
    	else
    		return((80/48)*60);
    		
    }
    
    public int maxBatterieLIION(int patient) {
    	if(patient == 1) 
    		return((80/5) * 60);			//80% de batterie avec une perte de 5% par heure, puis on transforme en minutes.
    	else if(patient == 2)
    		return((80/10)*60);
    	else
    		return((80/30)*60);
    		
    }

}