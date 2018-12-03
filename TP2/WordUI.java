import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import WordUI.HandlerClass;

public class WordUI extends JFrame implements ActionListener {
	JPanel p = new JPanel();
	JButton b = new JButton("Occurences");
	JTextField t = new JTextField("", 20);
	JLabel l = new JLabel("Quel mot du lexique voulez-vous chercher?");
	
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	JList list = new JList(dlm);
	JScrollPane s = new JScrollPane(list);
	ArrayList<String> a = new ArrayList<String>();
	
	DefaultListModel<String> dlmRecent = new DefaultListModel<String>();
	JList listRecent = new JList(dlmRecent);
	JScrollPane sRecent = new JScrollPane(listRecent);
	ArrayList<Mots> motsPlusUtilises = new ArrayList<Mots>();
	
	

		
	public void actionPerformed(ActionEvent event) {
		int occ = this.motsPlusUtilises.get(0).getNbUtilisations();
		int dansRecents = this.motsPlusUtilises.get(0).getRecemmentUtilise();
		String out = "Occurences : " + occ + "\nDans les recents : " + dansRecents;
		JOptionPane.showMessageDialog(null, out);
	}
			

	
	public WordUI() {
			super("Word UI ver.2");
			
			setSize(400,400);
			setResizable(true);
			
		
			b.addActionListener(this);
			
			p.add(l);
			p.add(t);
			p.add(b);
			p.add(s);
			p.add(sRecent);
			add(p);
			
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
			
		}
	
	public void update() {
		this.dlm.removeAllElements();
		for (String element : a) {
			this.dlm.addElement(element);
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

