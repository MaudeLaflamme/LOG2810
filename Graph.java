

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {
	
	/* Permet d'indiquer les voisins avec le temps des sommets*/
	class Voisin{
		private int voisin; 
		private int tps;
		public Voisin(int voisin, int tps){
			this.voisin=voisin;
			this.tps = tps;
		}
		@Override
		public String toString(){
			return "("+voisin+","+tps+")";
		}
	} 
	/* Permet d'indiquer si le sommet possède une borne */
	class Borne{
		private boolean isBorne;
		private int sommet;
		public Borne() { 
			isBorne = false; //"0".equals("isBorne");  dans le fichier c 0 ou 1
		}
		public Borne(int sommet, boolean isBorne) {
			this.sommet = sommet;
			this.isBorne = isBorne;
		}
		
		boolean isBorne() {
			return isBorne;
		}
		
		@Override
		public String toString(){
			return "("+sommet+isBorne+")";
		}
	}
	
	private List<Voisin> G[];
	/* Constructeur par défaut */
	public Graph() {
	};
	/* Constructeur par paramètre*/
	public Graph(int sommet){
		G=new LinkedList[sommet];
		for(int i=1;i<G.length;i++) {
			G[i]=new LinkedList<Voisin>();
		}
	}
	
	/* Permet de vérifier s'ils sont voisins */
	boolean isConnected(int sommet,int voisin){
		for(Voisin i: G[sommet])
			if(i.voisin==voisin) return true;
		return false;
	}
	 
	
	/* Test du voisin pour l'affichage */
	void addVoisin(int sommet,int voisin, int tps){
		G[sommet].add(0,new Voisin(voisin,tps)); 
	}
	
	/* Pour l'affichage du graphe */
	@Override
	public String toString(){
		String result="";
		for(int i=1;i<G.length;i++)
			result+=i+"=>"+G[i]+"\n";
		return result;
	}
	
public static void creerGraphe(String nomFichier) {
	/* Permet d'initialiser le graph */	
	//int size = nomFichier.length();
	//Graph g=new Graph(size);
		
	}
	/* Permet de lire les données et les afficher */
	public static void lireFichier(String nomFichier) throws IOException {
//		File file = new File(nomFichier);
		//Graph graph = new Graph();
		
		
		/* Vérifier si le fichier */
//		if (!Desktop.isDesktopSupported()) {
//			System.out.println("Desktop is not supported");
//			return;
//		} 
		/* Ouverture du fichier */
//		Desktop desktop = Desktop.getDesktop();
//		if (file.exists())
//			desktop.open(file);
		String splitBy = ",";
		String line = null;
		/* */
		try {
		FileReader fileReader = new FileReader(nomFichier);
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		while ((line = bufferedReader.readLine()) != null) {
			
			//int sommet = Integer.parseInt(line.substring(1, line.));
			//int voisin = Integer.parseInt(line.substring("," + 1));
			//int tps = Integer.parseInt(line.substring());
			 
			System.out.println(line);
			
		}
		bufferedReader.close();
	}
		/* */
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file" + nomFichier);
		}
		/* */
		catch(IOException ex) {
			System.out.println("Error reading file" + nomFichier);
		}
	}

	public static void main(String[] args) throws IOException {
		
		String fichier = "/Users/dalyn/eclipse-workspace/fichier/src/centresLocaux.txt";
		
		creerGraphe(fichier);
		lireFichier(fichier);
		
		/* Affichage du graph */
		int size = fichier.length();
		Graph g=new Graph(size);
		
		System.out.println(g);
		System.out.println(g.isConnected(1,2));
	}
}