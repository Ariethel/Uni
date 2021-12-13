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
import javax.swing.JInternalFrame;

public class Richiesta {

	private JFrame frmRichiesta;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtTelefono;
	private JButton btnVerificaDisponibilita;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Richiesta window = new Richiesta();
					window.frmRichiesta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Richiesta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRichiesta = new JFrame();
		frmRichiesta.setTitle("Richiesta Prenotazione");
		frmRichiesta.setBounds(100, 100, 450, 300);
		frmRichiesta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRichiesta.getContentPane().setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setText("CheckIn");
		txtNome.setBounds(12, 12, 114, 19);
		frmRichiesta.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setText("CheckOut");
		txtCognome.setBounds(146, 12, 114, 19);
		frmRichiesta.getContentPane().add(txtCognome);
		txtCognome.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setText("Tipologia");
		txtTelefono.setBounds(284, 12, 114, 19);
		frmRichiesta.getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnVerificaDisponibilita = new JButton("Verifica Disponibilita");
		btnVerificaDisponibilita.setBounds(284, 42, 117, 25);
		frmRichiesta.getContentPane().add(btnVerificaDisponibilita);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(12, 70, 270, 188);
		frmRichiesta.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);
	}
}
