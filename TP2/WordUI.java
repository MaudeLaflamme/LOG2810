import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class WordUI extends JFrame implements ActionListener {
	JPanel p = new JPanel();
	JButton b = new JButton("Rechercher");
	JTextField t = new JTextField("", 20);
	JLabel l = new JLabel("Quel mot du lexique voulez-vous chercher?");
	
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	JList list = new JList(dlm);
	JScrollPane s = new JScrollPane(list);
	ArrayList<Mots> a = new ArrayList<Mots>();
	
	DefaultListModel<String> dlmRecent = new DefaultListModel<String>();
	JList listRecent = new JList(dlmRecent);
	JScrollPane sRecent = new JScrollPane(listRecent);
	ArrayList<Mots> motsPlusUtilises = new ArrayList<Mots>();
	
	ArrayList<Mots> memoire = new ArrayList<Mots>();
	
	

		
	public void actionPerformed(ActionEvent event) {
		memoire.get(0).setNbUtilisations();
		
		int occ = memoire.get(0).getNbUtilisations();
		
		String out = "Occurences : " + occ + "\nDans les récents : " + memoire.get(0).getRecemmentUtilise() ;
		JOptionPane.showMessageDialog(null, out);
		t.setText("");
		this.motsPlusUtilises.add(0,memoire.get(0));
		memoire.get(0).setRecemmentUtilise(1);
		
	}
			

	
	public WordUI() {
			super("Word UI ver.2");
			
			setSize(400,400);
			setResizable(true);
			
		
			b.addActionListener(this);
			
			p.add(l); // entrée utilisateur
			p.add(t); // boite de mots
			p.add(b); // boutons
			p.add(s); //
			p.add(sRecent);
			add(p);
			
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
			
		}
	
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
	
	public void updateWithoutClear() {
		this.dlmRecent.removeAllElements();
		for (Mots element : this.motsPlusUtilises) {
			this.dlmRecent.addElement(element.getNom());
		}
	}
	
}

