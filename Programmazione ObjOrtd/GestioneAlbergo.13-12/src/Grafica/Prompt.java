package Grafica;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Prompt {

	private JFrame frmHoteltransilvania;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prompt window = new Prompt();
					window.frmHoteltransilvania.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prompt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHoteltransilvania = new JFrame();
		frmHoteltransilvania.setTitle("HotelTransilvania");
		frmHoteltransilvania.setBounds(100, 100, 450, 300);
		frmHoteltransilvania.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHoteltransilvania.getContentPane().setLayout(null);
		
		JButton btnGestionePrenotazioni = new JButton("Gestione Prenotazioni");
		btnGestionePrenotazioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		
		btnGestionePrenotazioni.setBounds(42, 88, 117, 25);
		frmHoteltransilvania.getContentPane().add(btnGestionePrenotazioni);
		
		JButton btnRichiestaPrenotazione = new JButton("Richiesta Prenotazione");
		btnRichiestaPrenotazione.setBounds(258, 88, 117, 25);
		frmHoteltransilvania.getContentPane().add(btnRichiestaPrenotazione);
		
		JMenuBar menuBar = new JMenuBar();
		frmHoteltransilvania.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(mntmOpen);
			}
		});
		mnFile.add(mntmOpen);
	}
}
