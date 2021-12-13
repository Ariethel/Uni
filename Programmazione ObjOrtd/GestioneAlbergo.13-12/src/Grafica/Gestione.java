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

public class Gestione {

	private JFrame frmGestione;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtTelefono;
	private JTextField txtCarta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestione window = new Gestione();
					window.frmGestione.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gestione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestione = new JFrame();
		frmGestione.setResizable(false);
		frmGestione.setTitle("Gestione Prenotazione");
		frmGestione.setBounds(100, 100, 450, 300);
		frmGestione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestione.getContentPane().setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setText("Nome");
		txtNome.setBounds(12, 12, 114, 19);
		frmGestione.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setText("Cognome");
		txtCognome.setBounds(146, 12, 114, 19);
		frmGestione.getContentPane().add(txtCognome);
		txtCognome.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setText("Telefono");
		txtTelefono.setBounds(284, 12, 114, 19);
		frmGestione.getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCarta = new JTextField();
		txtCarta.setText("Carta");
		txtCarta.setBounds(12, 35, 114, 19);
		frmGestione.getContentPane().add(txtCarta);
		txtCarta.setColumns(10);
		
		JButton btnEliminaPrenotazioni = new JButton("Elimina prenotazioni");
		btnEliminaPrenotazioni.setBounds(12, 83, 154, 38);
		frmGestione.getContentPane().add(btnEliminaPrenotazioni);
		
		JButton btnEliminaPrenotazioni_1 = new JButton("Modifica prenotazioni");
		btnEliminaPrenotazioni_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminaPrenotazioni_1.setBounds(221, 83, 154, 38);
		frmGestione.getContentPane().add(btnEliminaPrenotazioni_1);
	}
}
