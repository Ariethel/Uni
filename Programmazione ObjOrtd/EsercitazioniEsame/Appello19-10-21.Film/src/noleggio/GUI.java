package noleggio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JTextField textField;

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
	 * @throws BadIDException 
	 */
	public GUI() throws BadIDException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws BadIDException 
	 */
	private void initialize() throws BadIDException {
		Film f1 = new Film("AAA", "Star Wars");
		Film f2 = new Film("BBB", "Star Trek");
		Film f3 = new Film("CCC", "LOTR");
		Noleggio n1 = new Noleggio(f1, 111, 0);
		Noleggio n2 = new Noleggio(f2, 222, 1);
		Noleggio n3 = new Noleggio(f3, 333, 2);
		ElencoNoleggi en = new ElencoNoleggi();
		en.aggiungNoleggio(n1);
		en.aggiungNoleggio(n2);
		en.aggiungNoleggio(n3);

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel lblFilm = new JLabel("Film");
		panel.add(lblFilm);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(null);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String defaultText = "";
				for (Noleggio nol : en.getNoleggi()) {
					defaultText += nol.toString() + "\n";
				}
				ArrayList<Noleggio> trovati = new ArrayList<Noleggio>();
				trovati = en.cerca(textField.getText());
				if (trovati.isEmpty())
					textArea.setText(defaultText);
				else {
					String trovatiText = "";
					for (Noleggio noleggio : trovati) {
						trovatiText += noleggio.toString() + "\n";
					}
					textArea.setText(trovatiText);
				}
			}
		});
		panel.add(btnCerca);
		
		
		
	}
}
