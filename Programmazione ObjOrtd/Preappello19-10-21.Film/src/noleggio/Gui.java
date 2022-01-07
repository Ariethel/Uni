package noleggio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Gui {

	private JFrame frame;
	private JTextField textField;

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
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Gui() throws IOException, ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws IOException, ClassNotFoundException {
		FileInputStream fp = new FileInputStream("giggino.bin");
		ObjectInputStream ois = new ObjectInputStream(fp);
		ElencoNoleggi en = (ElencoNoleggi) ois.readObject();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel lblFilm = new JLabel("Film:");
		panel.add(lblFilm);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		textArea.setText("");
		for (Noleggio nol : en.getNoleggi()) {
			textArea.append(nol.toString() + "\n");
		}
		String def = textArea.getText();
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Noleggio> trovati = en.cerca(textField.getText());
				if (trovati.isEmpty()) textArea.setText(def);
				else {
					textArea.setText("");
					for (Noleggio noleggio : trovati) {
						textArea.append(noleggio.toString() + "\n");
					}
				}
			}
		});
		panel.add(btnCerca);
		
		
	}

}
