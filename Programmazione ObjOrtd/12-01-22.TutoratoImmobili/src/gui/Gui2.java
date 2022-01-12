package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import immobili.Appartamento;
import immobili.Garage;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui2 {

	private JFrame frame;
	private JTextField textFieldCodice;
	private JTextField textFieldImporto;
	private JTextField textFieldIndirizzo;
	private JTextField textFieldProprietario;
	private JTextField textFieldBalconi;
	private JTextField textFieldStanze;
	private JTextField textFieldPostiAuto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui2 window = new Gui2();
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
	public Gui2() {
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
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Codice: ");
		panel.add(lblNewLabel);
		
		textFieldCodice = new JTextField();
		panel.add(textFieldCodice);
		textFieldCodice.setColumns(10);
		
		JLabel lblImporto = new JLabel("Importo:");
		panel.add(lblImporto);
		
		textFieldImporto = new JTextField();
		panel.add(textFieldImporto);
		textFieldImporto.setColumns(10);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo:");
		panel.add(lblIndirizzo);
		
		textFieldIndirizzo = new JTextField();
		panel.add(textFieldIndirizzo);
		textFieldIndirizzo.setColumns(10);
		
		JLabel lblProprietario = new JLabel("Proprietario:");
		panel.add(lblProprietario);
		
		textFieldProprietario = new JTextField();
		panel.add(textFieldProprietario);
		textFieldProprietario.setColumns(10);
		
		JLabel lblTipologia = new JLabel("Tipologia: ");
		panel.add(lblTipologia);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Appartamento");
		comboBox.addItem("Garage");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("Appartamento")) {
					textFieldBalconi.enable();
					textFieldStanze.enable();
					textFieldPostiAuto.disable();
				}
				
				if (comboBox.getSelectedItem().equals("Garage")) {
					textFieldPostiAuto.enable();
					textFieldBalconi.disable();
					textFieldStanze.disable();
				}
			}
		});
		panel.add(comboBox);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		panel.add(label_1);
		
		JLabel lblBalconi = new JLabel("Balconi:");
		panel.add(lblBalconi);
		
		textFieldBalconi = new JTextField();
		panel.add(textFieldBalconi);
		textFieldBalconi.setColumns(10);
		
		JLabel lblStanze = new JLabel("Stanze:");
		panel.add(lblStanze);
		
		textFieldStanze = new JTextField();
		panel.add(textFieldStanze);
		textFieldStanze.setColumns(10);
		
		JLabel lblPostiAuto = new JLabel("Posti Auto: ");
		panel.add(lblPostiAuto);
		
		textFieldPostiAuto = new JTextField();
		panel.add(textFieldPostiAuto);
		textFieldPostiAuto.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("Appartamento")) {
					Appartamento appartamento = new Appartamento(Integer.parseInt(textFieldCodice.getText()), textFieldIndirizzo.getText(), textFieldProprietario.getText(), Double.parseDouble(textFieldImporto.getText()),Integer.parseInt(textFieldStanze.getText()),Integer.parseInt(textFieldBalconi.getText()));
					textArea.append(appartamento.toString() + "\n");
				}
				
				if (comboBox.getSelectedItem().equals("Garage")) {
					Garage garage = new Garage(Integer.parseInt(textFieldCodice.getText()), textFieldIndirizzo.getText(), textFieldProprietario.getText(), Double.parseDouble(textFieldImporto.getText()), Integer.parseInt(textFieldPostiAuto.getText()));
					textArea.append(garage.toString() + "\n");
				}
			}
		});
		panel_1.add(btnAggiungi);
	}

}
