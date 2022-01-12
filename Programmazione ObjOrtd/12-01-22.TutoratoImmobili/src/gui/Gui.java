package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import immobili.Appartamento;
import immobili.Catasto;
import immobili.Garage;
import immobili.Immobile;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Gui {

	private JFrame frame;
	private JTextField textField;
	Catasto catasto = new Catasto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
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
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblImporto = new JLabel("Importo:");
		panel.add(lblImporto);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Immobile> trovati = catasto.cercaImmobili(Double.parseDouble(textField.getText()));
				String output = ""; 
				for (Immobile immobile : trovati) { 
					output += immobile.toString() + "\n"; 
				} 
				JOptionPane.showConfirmDialog(btnCerca, output);
				 
			}
		});
		panel.add(btnCerca);
		
		JTextArea textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnGenera = new JButton("Genera");
		btnGenera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				Random rn = new Random();
				for (int i = 0; i < 10; i++) {
					Appartamento appartamento = new Appartamento(rn.nextInt(),null, null, rn.nextDouble(), rn.nextInt(), rn.nextInt());
					textArea.append(appartamento.toString() + "\n");
					catasto.aggiungi(appartamento);
				}
				
				for (int i = 0; i < 5; i++) {
					Garage garage = new Garage(rn.nextInt(), null, null, rn.nextDouble(), rn.nextInt());
					textArea.append(garage.toString() + "\n");
					catasto.aggiungi(garage);
				}
			}
		});
		panel_1.add(btnGenera);
		
		
	}

}
