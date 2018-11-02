import java.util.ArrayList;

//classe Clinique
public class Clinique
{
    
    /* Attributs */
    private boolean recharge;
    private ArrayList<Voisin> voisins = new ArrayList<Voisin>();
    private boolean visited;
    
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
    	visited = false;
    }
    
    void addVoisin(Voisin voisin) {
    	
    	this.voisins.add(voisin);
    }
    
    ArrayList<Voisin> getVoisins() {
    	return this.voisins;
    }

	boolean getRecharge() {
		return this.recharge;
	}
	
	boolean isVisited() {
		return visited;
	}
	
	void setVisited(boolean b) {
		visited = b;
	}


}