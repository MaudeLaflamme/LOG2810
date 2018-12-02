import java.util.ArrayList;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Mots{
	private int nbUtilisations;
	private boolean recemmentUtilise;
	private ArrayList<Mots> enfants;
	private String nom;
	
	Mots(String nom) {
		enfants = new ArrayList<Mots>();
		this.nom = nom;
	}
	
	public int getNbUtilisations() {
		return this.nbUtilisations;
	}
	
	public boolean getRecemmentUtilise() {
		return this.recemmentUtilise;
	}
	
	public ArrayList<Mots> getEnfants(){
		return this.enfants;
	}
	public String getNom() {
		return this.nom;
	}
	
	public String printEnfants() {
		String enfants = "";
		for (Mots word : this.enfants) {
			enfants += (word.getNom() + '\n');
			enfants += word.printEnfants();
		}
		return enfants;
	}
	
	public String printWords(String lettresEntrees) {
		String enfants = "";
		for(Mots word : this.enfants) {
			if(word.getNom().startsWith(lettresEntrees)) {
				enfants += word.getNom() + '\n';
				enfants += word.printEnfants();
			}
			else if(lettresEntrees.startsWith(word.getNom())) {
				enfants += word.printWords(lettresEntrees);
			}
		}
		return enfants;
	}
	
	public void addWord(Mots mot) {
		for(Mots word : this.enfants) {
			if(mot.getNom().startsWith(word.getNom())) { 
				word.addWord(mot);
				break;
			}
		}
		if(!(this.isParent(mot)))
			this.enfants.add(mot);
	}
	
	public boolean isParent(Mots mot) {
		for(Mots word : this.enfants) {
			if(mot.getNom().startsWith(word.getNom())) {
				if(word.getNom().equals(mot.getNom()))
						return true;
				return word.isParent(mot);
			}
		}
		return false;
	}
	
	public Mots findWord(String mot) {
		for(Mots word : this.getEnfants()) {
			if(mot.startsWith(word.getNom())) {
				if(word.getNom().equals(mot))
					return word;
			return word.findWord(mot);
			}
		}
		return null;		
	}
}
