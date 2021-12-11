import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class ArchivioAutomezzi<E> {
	
	private ArrayList<Automezzo> getFromFile(File selectedFile) throws IOException, ClassNotFoundException {
		FileInputStream is = new FileInputStream(selectedFile);
		ObjectInputStream ois = new ObjectInputStream(is);
		ArrayList<Automezzo> mezziLetti = (ArrayList<Automezzo>) ois.readObject();
		ois.close();
		return mezziLetti;
	}

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	ArrayList<Automezzo> automezzi; //Array dove conservo gli oggetti letti da file
	String cercaTipo; //Variabile globale per cercare Autoveicolo o Motociclo
	String targa; //Variabile globale per la targa
	String alimentazione; //Variabile globale per l'alimentazione
	String numPosti; //Variabile globale per il numero di posti
	ArrayList<Automezzo> risultati = automezzi;
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArchivioAutomezzi window = new ArchivioAutomezzi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ArchivioAutomezzi() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		//Comportamento pulsante open
		JMenuItem mntmOpenFile = new JMenuItem("Open File");
		mntmOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser openFileChooser = new JFileChooser();
				openFileChooser.showOpenDialog(mntmOpenFile);
				if (!openFileChooser.getSelectedFile().getName().endsWith(".txt"))
					throw new BadDataFormatException("Mi serve un file txt");
				else {
					try {
						automezzi = getFromFile(openFileChooser.getSelectedFile()); //Funzione per prendere gli oggetti da un file
						for (Automezzo a : automezzi) { //Questo ciclo serve solo a stampare gli oggetti come test
							JOptionPane.showInputDialog(a.toString());
						}
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});
		
		mnFile.add(mntmOpenFile);
		
		
		//Comportamento pulsante save
		JMenuItem mntmSaveFile = new JMenuItem("Save File");
		mnFile.add(mntmSaveFile);
		
		
		
		//Comportamento pulsante exit
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		
		
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		
		
		
		
		//Pulsanti per capire che tipo di mezzo cercare
		JRadioButton rdbtnAutoveicoli = new JRadioButton("Autoveicoli");
		rdbtnAutoveicoli.setText("Autoveicoli");
		rdbtnAutoveicoli.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rdbtnAutoveicoli.isSelected()) {
					cercaTipo = rdbtnAutoveicoli.getText();
					JOptionPane.showInputDialog(cercaTipo);
				}
					
				
				
			}
		});
		rdbtnAutoveicoli.setBounds(128, 5, 102, 23);
		buttonGroup.add(rdbtnAutoveicoli);
		panel.add(rdbtnAutoveicoli);
		
		JRadioButton rdbtnMotocicli = new JRadioButton("Motocicli");
		rdbtnMotocicli.setText("Motocicli");
		rdbtnMotocicli.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rdbtnMotocicli.isSelected()) {
					cercaTipo = rdbtnMotocicli.getText();
					JOptionPane.showInputDialog(cercaTipo);
				}
					
			}
		});
		rdbtnMotocicli.setBounds(235, 5, 87, 23);
		buttonGroup.add(rdbtnMotocicli);
		panel.add(rdbtnMotocicli);
		
		
	
		
		
		
		textField = new JTextField("Press Enter");
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				targa = textField.getText();
				JOptionPane.showInputDialog(targa);
			}
		});
		textField.setBounds(12, 67, 114, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTarga = new JLabel("Targa");
		lblTarga.setBounds(12, 36, 134, 24);
		panel.add(lblTarga);
		
		JLabel lblAlimentazione = new JLabel("Alimentazione");
		lblAlimentazione.setBounds(158, 35, 122, 24);
		panel.add(lblAlimentazione);
		
		JLabel lblNPosti = new JLabel("N Posti");
		lblNPosti.setBounds(308, 40, 70, 15);
		panel.add(lblNPosti);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cercaTipo.equals("Autoveicoli"))
					risultati = (ArrayList<Automezzo>) cercaAutoveicoli(cercaTipo,targa,alimentazione,numPosti);
				else if (cercaTipo.equals("Motocicli"))
					risultati = (ArrayList<Automezzo>) cercaMotocicli(cercaTipo,targa,alimentazione,numPosti);
				
				
				for (Automezzo aut : risultati) {
					JOptionPane.showConfirmDialog(null, aut.toString());
				}
			}		
			

			private ArrayList<Automezzo> cercaAutoveicoli(String cercaTipo, String targa, String alimentazione, String numPosti) {
				ArrayList<Automezzo> trovati = null;
				for (Automezzo aut : automezzi) {
					if (aut instanceof Autoveicolo) {
						Autoveicolo autoveicolo = (Autoveicolo) aut;
						if (autoveicolo.getTarga().equals(targa) && autoveicolo.getAlimentazione().equals(alimentazione) && (Integer.toString(autoveicolo.getNumPosti()).equals(numPosti)))
							trovati.add(autoveicolo);
					}
				}
				return trovati;
			}
			
			private ArrayList<Automezzo> cercaMotocicli(String cercaTipo, String targa, String alimentazione, String numPosti){
				ArrayList<Automezzo> trovati = null;
				for (Automezzo aut : automezzi) {
					if (aut instanceof Motociclo) {
						Motociclo motociclo = (Motociclo) aut;
						if (motociclo.getTarga().equals(targa) && (Integer.toString(motociclo.getNumPasseggeri())).equals(numPosti))
							trovati.add(motociclo);
					}
				}
				return trovati;
				
			}
			
			
		});
		btnCerca.setBounds(318, 90, 117, 25);
		
		panel.add(btnCerca);
		
		
		//ComboBox alimentazione
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(158, 64, 112, 24);
		comboBox.addItem("Benzina");
		comboBox.addItem("GPL");
		comboBox.addItem("Metano");
		comboBox.addItem("Diesel");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alimentazione = (String) comboBox.getSelectedItem();
				JOptionPane.showInputDialog(alimentazione);
			}
		});
		panel.add(comboBox);
		
		
		//ComboBox Numero Posti
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(308, 64, 112, 24);
		comboBox_1.addItem("1");
		comboBox_1.addItem("2");
		comboBox_1.addItem("3");
		comboBox_1.addItem("4");
		comboBox_1.addItem("5");
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numPosti = (String) comboBox_1.getSelectedItem();
				JOptionPane.showInputDialog(numPosti);
			}
		});
		
		
		panel.add(comboBox_1);
		
		//Comportamento del pulsante cerca
		JTextPane txtpnRicerca = new JTextPane();
		txtpnRicerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				for (Automezzo automezzo : risultati) {
					txtpnRicerca.setText(automezzo.toString());
				}
			}
		});
		
		txtpnRicerca.setBounds(12, 98, 294, 132);
		panel.add(txtpnRicerca);
	}
}
