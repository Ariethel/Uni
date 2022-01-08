import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

public class Gestione {

	private JFrame secondFrame;
	private JTextField txtCheckin;
	private JTextField txtCheckout;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestione window = new Gestione();
					window.secondFrame.setVisible(true);
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
		secondFrame = new JFrame();
		secondFrame.setBounds(100, 100, 450, 300);
		secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		secondFrame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		txtCheckin = new JTextField();
		txtCheckin.setText("Check-In");
		panel.add(txtCheckin);
		txtCheckin.setColumns(10);
		
		txtCheckout = new JTextField();
		txtCheckout.setText("Check-Out");
		panel.add(txtCheckout);
		txtCheckout.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Singola");
		comboBox.addItem("Doppia");
		comboBox.addItem("Matrimoniale");
		panel.add(comboBox);
		
		panel_1 = new JPanel();
		secondFrame.getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnChiedi = new JButton("Chiedi");
		panel_1.add(btnChiedi);
		
		JButton btnPrenota = new JButton("Prenota");
		panel_1.add(btnPrenota);
		
		JPanel panel_2 = new JPanel();
		secondFrame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextArea txtrDettagli = new JTextArea();
		txtrDettagli.setText("Dettagli");
		panel_2.add(txtrDettagli);
	}
}
