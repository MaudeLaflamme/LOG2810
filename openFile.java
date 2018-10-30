package openFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class openFile{
	
private Scanner x;

/* Ouverture du fichier */
public void openFiles() {
	try {
		x = new Scanner(new File("/Users/dalyn/eclipse-workspace/fichier/src/centresLocaux.txt"));
	}
	catch(Exception e) {
		System.out.println("Not find");
	}
}
/* Lire les sommets, voisin et le tps */
public void readGraphe() {

	while(x.hasNextLine()) {
		String line = x.nextLine();
		if(line.equals("")) {
		String sommet = x.next();
		String voisin = x.next();
		String temps = x.next();
		System.out.printf("%s %s %s\n", sommet,voisin,temps);
		}
	}
}
/* Lecture des sommets et de leur borne */
public void readBorne() {
	while(x.hasNext()) {
		String sommetb = x.next();
		String borne = x.next();
		String line = x.nextLine();
		if(line.equals(""))  {
		System.out.printf("%s %s\n", sommetb,borne);
		}
	}
}
/* Fermeture du fichier */
public void closeFiles() {
	x.close();
}
    /* Test */
public static void main(String[] args) {
	
	openFile r = new openFile();
	r.openFiles();
	//r.readGraphe();
	
	r.readBorne();
	r.closeFiles();
	}
}


