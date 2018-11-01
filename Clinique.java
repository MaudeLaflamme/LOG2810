import java.util.ArrayList;

//classe Clinique
public class Clinique
{
    
    /* Attributs */
    boolean recharge;
    ArrayList<Voisin> voisins = new ArrayList<Voisin>();
    
    /* Constructeur*/
    
    Clinique(){
    }
    
    Clinique(int recharge)
    {
    	if(recharge == 1)
    		this.recharge = true;
    	else
    		this.recharge = false;
    	voisins = new ArrayList<Voisin>();
    }
    
    void addVoisin(Voisin voisin) {
    	
    	this.voisins.add(voisin);
    }
    
    ArrayList<Voisin> getVoisins() {
    	return this.voisins;
    }

	


}