import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestioneLibreria {
	
	public Libreria libreria;
	public ArrayList<Libro> result;

	private JFrame frame;
	
	public ArrayList<Libro> popolaLibreria(File file) throws IOException, ClassNotFoundException {
		FileInputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);
		ArrayList<Libro> result;
		result = (ArrayList<Libro>) ois.readObject();
		return result;
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneLibreria window = new GestioneLibreria();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestioneLibreria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 129, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.showOpenDialog(mntmOpen);
				try {
					result = popolaLibreria(jfc.getSelectedFile());
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				libreria = new Libreria(result);
				for (Libro libro : result) {
					JOptionPane.showConfirmDialog(null, libro.toString());
				}
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Libro libro : result) {
					comboBox.addItem(libro.getTitolo());
				}
			}
		});
		
		comboBox.setBounds(12, 29, 146, 24);
		frame.getContentPane().add(comboBox);
		
		JButton btnVisualizza = new JButton("Visualizza");
		btnVisualizza.setBounds(239, 29, 117, 25);
		frame.getContentPane().add(btnVisualizza);
		
		JTextPane txtpnDettagli = new JTextPane();
		txtpnDettagli.setText("Dettagli");
		txtpnDettagli.setBounds(22, 58, 286, 193);
		frame.getContentPane().add(txtpnDettagli);
	}
}
