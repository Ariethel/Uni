import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.spec.ECFieldFp;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui {

	private JFrame frame;
	private JTextField txtPartenza;
	private JTextField txtDestinazione;
	private JPanel panel_1;
	private JPanel panel_2;
	private JComboBox comboBoxVoli;
	private JComboBox comboBoxPosti;
	private JPanel panel_3;
	private JButton btnPrenota;
	private JTextArea textArea;
	private JPanel panel_4;
	private JTextField txtNome;
	private JTextField txtCognome;

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
		//Lettura file
		FileInputStream fis = new FileInputStream("giggino.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ElencoVoli ev = (ElencoVoli) ois.readObject();
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtPartenza = new JTextField();
		txtPartenza.setText("Partenza");
		panel.add(txtPartenza);
		txtPartenza.setColumns(10);
		
		txtDestinazione = new JTextField();
		txtDestinazione.setText("Destinazione");
		panel.add(txtDestinazione);
		txtDestinazione.setColumns(10);
		
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		comboBoxVoli = new JComboBox();
		panel_2.add(comboBoxVoli);
		
		comboBoxPosti = new JComboBox();
		panel_2.add(comboBoxPosti);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		
		textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ElencoVoli ris = new ElencoVoli();
				try {
					ris = ev.cerca(txtPartenza.getText(), txtDestinazione.getText());
				} catch (BadCodeException e1) {
					e1.printStackTrace();
				}
				textArea.setText("");
				for (Volo volo : ris.getVoli()) {
					textArea.append(volo.toString() + "\n");
					comboBoxVoli.addItem(volo.getCodiceVolo());
					for (Posto posto : volo.getPosti()) {
						if (posto.isStato())
							comboBoxPosti.addItem(posto.getFila() + posto.getPosizione());
					}
				}
				
			}
		});
		panel.add(btnCerca);
		
		panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(2, 1, 5, 5));
		
		txtNome = new JTextField();
		txtNome.setText("Nome");
		panel_4.add(txtNome);
		txtNome.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setText("Cognome");
		panel_4.add(txtCognome);
		txtCognome.setColumns(10);
		
		btnPrenota = new JButton("Prenota");
		btnPrenota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileOutputStream fp = new FileOutputStream("Prenotazioni");
					String buf = (txtCognome.getText()+ " "+ txtNome.getText()+" "+comboBoxVoli.getSelectedItem() + " "+ comboBoxPosti.getSelectedItem() + "\n");
					fp.write(buf.getBytes());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		panel_3.add(btnPrenota);
		
		
		
		
	}

}
