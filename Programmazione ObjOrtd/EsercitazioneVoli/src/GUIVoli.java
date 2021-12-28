import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class GUIVoli {

	private JFrame frame;
	private JTextField txtPartenza;
	private JTextField txtDestinazione;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIVoli window = new GUIVoli();
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
	public GUIVoli() {
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
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		txtPartenza = new JTextField();
		txtPartenza.setText("Partenza");
		panel.add(txtPartenza);
		txtPartenza.setColumns(10);
		
		txtDestinazione = new JTextField();
		txtDestinazione.setText("Destinazione");
		panel.add(txtDestinazione);
		txtDestinazione.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(4, 1, 0, 0));
		
		JButton btnVisualizza = new JButton("Visualizza");
		panel_1.add(btnVisualizza);
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextArea txtrVoli = new JTextArea();
		txtrVoli.setText("Voli");
		panel_2.add(txtrVoli);
	}

}
