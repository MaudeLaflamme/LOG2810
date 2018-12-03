/**
 *  WordUI.java
 *  Implementation of the Class WordUI
 *  Original author: Balea, Laflamme and Pak
 *  Last modified : 3 dec 2018
 **/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

@SuppressWarnings("serial")
public class WordUI extends JFrame implements ActionListener {
	JPanel p = new JPanel();
	
	JLabel l = new JLabel("Quel mot du lexique voulez-vous chercher?");
	
	JTextField t = new JTextField("", 20);
	JButton b = new JButton("Rechercher");
	
	JLabel d = new JLabel("5 derniers mots recherches : ");
	
	// a represente les mots trouvés du lexique, relie au list qui est dans l'interface
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	JList<String> list = new JList<String>(dlm);
	JScrollPane s = new JScrollPane(list);
	ArrayList<Mots> a = new ArrayList<Mots>();
	
	// motsPlusUtilises relie au listRecent qui est affiche dans l'interface
	DefaultListModel<String> dlmRecent = new DefaultListModel<String>();
	JList<String> listRecent = new JList<String>(dlmRecent);
	JScrollPane sRecent = new JScrollPane(listRecent);
	ArrayList<Mots> motsPlusUtilises = new ArrayList<Mots>();
	
	// utile pour avoir acces a Mots, memoire == a
	ArrayList<Mots> memoire = new ArrayList<Mots>();
	
	

	/**
     * Actions a faire a l'appui du bonton :
     *  - incrementer nbUtilisation
     *  - afficher les labels dans un popup
     *  - ajouter mot recherche dans motsPlusUtilises
     * @param event est le clic du bouton
     */
	public void actionPerformed(ActionEvent event) {
		memoire.get(0).setNbUtilisations();
		
		int occ = memoire.get(0).getNbUtilisations();
		
		String out = "Occurences : " + occ + "\nDans les récents : " + memoire.get(0).getRecemmentUtilise() ;
		JOptionPane.showMessageDialog(null, out);
		t.setText("");
		this.motsPlusUtilises.add(0,memoire.get(0));
		memoire.get(0).setRecemmentUtilise(1);
		
	}
			

	/**
     * Constructeur. Cree l'interface et ajoute les elements du ui.
     */
	public WordUI() {
			super("Word UI ver.2");
			
			setSize(400,400);
			setResizable(false);
			
		
			b.addActionListener(this);
			
			p.add(l);
			p.add(t); 
			p.add(b);
			p.add(s);
			p.add(d);
			p.add(sRecent);
			add(p);
			
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
			
		}
	
	/**
     * Met a jour le tableau a dans l'interface. On clear a a chaque fois pour
     * ne pas afficher les elements en double. memoire permet de se rappeler 
     * du tableau a pour l'appel dans actionPerformed
     */
	public void update() {
		this.dlm.removeAllElements();
		for (Mots element : a) {
			this.dlm.addElement(element.getNom());
		}
		memoire.clear();
		for(Mots mots : this.a) {
			memoire.add(mots);
		}
		this.a.clear();
	}
	
	/***
     * Met a jour le tableau motsPlusUtilises
     */
	public void updateWithoutClear() {
		this.dlmRecent.removeAllElements();
		for (Mots element : this.motsPlusUtilises) {
			this.dlmRecent.addElement(element.getNom());
		}
	}
	
}

