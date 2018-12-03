import java.util.ArrayList;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Mots{
	private int nbUtilisations = 0;
	private int recemmentUtilise = 0; 
	private ArrayList<Mots> enfants;
	private String nom;
	
	/* Constructeur */
	Mots(String nom) {
		enfants = new ArrayList<Mots>();
		this.nom = nom;
	}
	
	/* Méthodes get/set des attributs*/
	public int getNbUtilisations() {
		return this.nbUtilisations;
	}
	
	public void setNbUtilisations() {
		this.nbUtilisations++;
	}
	
	public int getRecemmentUtilise() {
		return this.recemmentUtilise;
	}
	
	public void setRecemmentUtilise(int i) {
		this.recemmentUtilise = i;
	}
	
	public ArrayList<Mots> getEnfants(){
		return this.enfants;
	}
	public String getNom() {
		return this.nom;
	}
	
	/*
     * Methode qui ajoute les enfants du mot courant dans une String, puis 
	 * ajoute les enfants des enfants de maniere recursive.
     * @param -
     * @return enfants - Une String contenant tous les mots enfants du mot courant. 
     */
	public String printEnfants() {
		String enfants = "";
		for (Mots word : this.enfants) {
			enfants += (word.getNom() + '\n');
			enfants += word.printEnfants();
		}
		return enfants;
	}
	
	/***
     * Methode qui retourne une String de tous les mots commençant par une
	 * chaine de caracteres entree par l'utilisateur, en faisant appel a la
	 * methode printEnfants()
     * @param lettresEntrees la chaine de caractere entree par l'utilisateur.
     * @return enfants Une String contenant tous les mots commençant par lettresEntrees.
     */
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
	
	/***
     * Methode recursive ajoutant un mot a l'arbre modelisant le lexique.
	 * La methode appelle la methode isParent() afin de verifier si le mot
	 * a ajouter est deja dans l'arbre.
     * @param mot le mot a ajouter a l'arbre.
     * @return void
     */
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
	
	/***
     * Methode qui cherche dans les enfants et les enfants des
	 * enfants du mot courant, le mot passe en parametre.
     * @param mot le mot a chercher dans l'arbre.
     * @return boolean qui renvoie si le mot a ete trouve ou non.
     */
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
	
	/***
     * Methode qui cherche dans le lexique et retourne le mot correspondant
	 * au mot entre par l'utilisateur.
     * @param lettresEntrees chaine de caracteres entree par l'utilisateur.
     * @return word le mot trouve.
     */
	public Mots findWord(String lettresEntrees) {
		for(Mots word : this.getEnfants()) {
			if(lettresEntrees.startsWith(word.getNom())) {
				if(word.getNom().equals(lettresEntrees))
					return word;
			return word.findWord(lettresEntrees);
			}
		}
		return null;		
	}
}
