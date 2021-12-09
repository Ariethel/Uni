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

public class ArchivioAutomezzi {
	
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
						ArrayList<Automezzo> automezzi;
						automezzi = getFromFile(openFileChooser.getSelectedFile());
						for (Automezzo a : automezzi) {
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
		
		JMenuItem mntmSaveFile = new JMenuItem("Save File");
		mnFile.add(mntmSaveFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JRadioButton rdbtnAutomezzi = new JRadioButton("Autoveicoli");
		rdbtnAutomezzi.setBounds(128, 5, 102, 23);
		buttonGroup.add(rdbtnAutomezzi);
		panel.add(rdbtnAutomezzi);
		
		JRadioButton rdbtnMotocicli = new JRadioButton("Motocicli");
		rdbtnMotocicli.setBounds(235, 5, 87, 23);
		buttonGroup.add(rdbtnMotocicli);
		panel.add(rdbtnMotocicli);
		
		textField = new JTextField();
		textField.setBounds(12, 67, 114, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTarga = new JLabel("Targa");
		lblTarga.setBounds(12, 40, 70, 15);
		panel.add(lblTarga);
		
		JLabel lblAlimentazione = new JLabel("Alimentazione");
		lblAlimentazione.setBounds(158, 35, 122, 24);
		panel.add(lblAlimentazione);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(148, 64, 132, 24);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(308, 65, 61, 22);
		panel.add(comboBox_1);
		
		JLabel lblNPosti = new JLabel("N Posti");
		lblNPosti.setBounds(308, 40, 70, 15);
		panel.add(lblNPosti);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.setBounds(318, 90, 117, 25);
		panel.add(btnCerca);
	}
}
