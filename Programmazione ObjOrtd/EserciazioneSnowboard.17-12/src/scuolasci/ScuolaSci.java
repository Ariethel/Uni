package scuolasci;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.GregorianCalendar;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class ScuolaSci {

	private JFrame frmScuolaSci;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScuolaSci window = new ScuolaSci();
					window.frmScuolaSci.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ScuolaSci() {
		initialize();
	}

	private void initialize() {
		ElencoCorsi corsi = new ElencoCorsi();
		GregorianCalendar data = new GregorianCalendar(2021,11,12);
		CorsoSci cs1 = new CorsoSci(1, 4, 15, data);
		data = new GregorianCalendar(2021,9,11);
		CorsoSci cs2 = new CorsoSci(2, 2, 13, data);
		data = new GregorianCalendar(2021,4,22);
		CorsoSci cs3 = new CorsoSci(3, 8, 11, data);
		data = new GregorianCalendar(2021,1,1);
		CorsoSci cs4 = new CorsoSci(4, 6, 9, data);
		data = new GregorianCalendar(2021,7,6);
		CorsoSci cs5 = new CorsoSci(5, 5, 7, data);
		
		data = new GregorianCalendar(2021,7,6);
		CorsoSnowboard csn1 = new CorsoSnowboard(1, 6, 8, data);
		data = new GregorianCalendar(2021,9,11);
		CorsoSnowboard csn2 = new CorsoSnowboard(2, 1, 10, data);
		data = new GregorianCalendar(2021,4,22);
		CorsoSnowboard csn3 = new CorsoSnowboard(3, 10, 12, data);
		data = new GregorianCalendar(2021,9,11);
		CorsoSnowboard csn4 = new CorsoSnowboard(4, 8, 14, data);
		data = new GregorianCalendar(2021,11,12);
		CorsoSnowboard csn5 = new CorsoSnowboard(5, 9, 16, data);
		
		corsi.aggiungiCorso(cs1);
		corsi.aggiungiCorso(cs2);
		corsi.aggiungiCorso(cs3);
		corsi.aggiungiCorso(cs4);
		corsi.aggiungiCorso(cs5);
		corsi.aggiungiCorso(csn1);
		corsi.aggiungiCorso(csn2);
		corsi.aggiungiCorso(csn3);
		corsi.aggiungiCorso(csn4);
		corsi.aggiungiCorso(csn5);
		
		frmScuolaSci = new JFrame();
		frmScuolaSci.setTitle("Scuola SCi");
		frmScuolaSci.setBounds(100, 100, 450, 300);
		frmScuolaSci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScuolaSci.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmScuolaSci.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JComboBox comboBox = new JComboBox();
		for (Corso corso : corsi.getCorsi()) {
			comboBox.addItem(corso);
		}
		
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmScuolaSci.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnInformazioni = new JTextPane();
		txtpnInformazioni.setFont(new Font("FreeMono", Font.BOLD | Font.ITALIC, 18));
		txtpnInformazioni.setText("Informazioni");
		panel_1.add(txtpnInformazioni, BorderLayout.CENTER);
		
		JButton btnVisualizza = new JButton("Visualizza");
		btnVisualizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpnInformazioni.setText(comboBox.getSelectedItem().toString());
			}
		});
		panel.add(btnVisualizza);
		
		
	}

}
