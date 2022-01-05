package scuolasci;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.net.ssl.ExtendedSSLSession;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CorsoSci cSci1 = new CorsoSci("A", 4, 14, null);
		CorsoSci cSci2 = new CorsoSci("B", 4, 14, null);
		CorsoSci cSci3 = new CorsoSci("C", 5, 14, null);
		CorsoSci cSci4 = new CorsoSci("D", 6, 14, null);
		CorsoSci cSci5 = new CorsoSci("E", 7, 14, null);
		
		CorsoSnowboard cSnowboard1 = new CorsoSnowboard("AA", 6, 10, null);
		CorsoSnowboard cSnowboard2 = new CorsoSnowboard("BB", 6, 10, null);
		CorsoSnowboard cSnowboard3 = new CorsoSnowboard("CC", 7, 10, null);
		CorsoSnowboard cSnowboard4 = new CorsoSnowboard("DD", 8, 10, null);
		CorsoSnowboard cSnowboard5 = new CorsoSnowboard("EE", 9, 10, null);
		
		ElencoCorsi<Corso> corsi = new ElencoCorsi<>();
		corsi.aggiungiCorso(cSci1);
		corsi.aggiungiCorso(cSci2);
		corsi.aggiungiCorso(cSci3);
		corsi.aggiungiCorso(cSci4);
		corsi.aggiungiCorso(cSci5);
		
		corsi.aggiungiCorso(cSnowboard1);
		corsi.aggiungiCorso(cSnowboard2);
		corsi.aggiungiCorso(cSnowboard3);
		corsi.aggiungiCorso(cSnowboard4);
		corsi.aggiungiCorso(cSnowboard5);
		
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblTipo = new JLabel("Tipo:");
		panel.add(lblTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Corso Sci");
		comboBox.addItem("Corso Snowboad");

		panel.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		JButton btnElenca = new JButton("Elenca");
		btnElenca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Corso> trovati = (ArrayList<Corso>) corsi.dammiCorsi((String) comboBox.getSelectedItem());
				for (Corso corso : trovati) {
					JOptionPane.showConfirmDialog(null, corso.toString());
				}
				for (Corso corso : trovati) {
					textArea.append(corso.toString() + "\n");
				}
			}
		});
		panel.add(btnElenca);
		
		
	}

}
