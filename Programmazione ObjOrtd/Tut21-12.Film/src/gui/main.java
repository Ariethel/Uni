package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import noleggio.Azione;
import noleggio.BadIDException;
import noleggio.Commedia;
import noleggio.ElencoNoleggi;
import noleggio.Film;
import noleggio.Noleggio;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class main {

	private JFrame frame;
	private JTextField textField;
	ElencoNoleggi noleggi = new ElencoNoleggi();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws BadIDException 
	 */
	public main() throws BadIDException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws BadIDException 
	 */
	private void initialize() throws BadIDException {
		Film f1 = new Film("Star Wars 4", 88123);
		Azione a1 = new Azione("Star Trek", 12512);
		Commedia c1 = new Commedia("Natale in casa Cupiello", 00001);
		Noleggio n1 = new Noleggio(f1, 14, 123);
		Noleggio n2 = new Noleggio(a1, 0, 456);
		Noleggio n3 = new Noleggio(c1, 7, 789);
		noleggi.aggiungiNoleggio(n1);
		noleggi.aggiungiNoleggio(n2);
		noleggi.aggiungiNoleggio(n3);
	
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel lblFilm = new JLabel("Film:");
		panel.add(lblFilm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextArea txtrRisultati = new JTextArea();
		panel_1.add(txtrRisultati);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrRisultati.setText("");
				ArrayList<Noleggio> trovati = noleggi.cerca(textField.getText());
				for (Noleggio noleggio : trovati) {
					txtrRisultati.append(noleggio.toString() + "\n");
				}
			}
		});
		panel.add(btnCerca);
		
		
	}

}
