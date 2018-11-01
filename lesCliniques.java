import java.util.ArrayList;

//classe Clinique
public class Clinique
{
    public class Voisin
    {
        Clinique voisin;
        int temps;
    
        /* Constructeur par paramètre de voisins */
        Voisin(Clinique voisin, int temps){
        	this.voisin = voisin;
        	this.temps = temps;
        }
    }
    
    /* Attributs */
    boolean recharge;
    ArrayList<Voisin> voisins = new ArrayList<Voisin>();

    /* Constructeur par paramètre*/
    Clinique(int recharge)
    {
    	if(recharge == 1)
    		this.recharge = true;
    	else
    		this.recharge = false;
    }
    
    void addVoisin(ArrayList<Voisin> voisin) {
    	this.voisins = voisin;
    }
    
    ArrayList<Voisin> getVoisins() {
    	return voisins;
    }

	


}