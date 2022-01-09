import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Gui {

	private JFrame frame;
	Registrazioni registrazioni = new Registrazioni();

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
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.showOpenDialog(mntmOpen);
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(jfc.getSelectedFile());
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				ObjectInputStream ois = null;
				try {
					ois = new ObjectInputStream(fis);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					registrazioni = (Registrazioni) ois.readObject();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		mnFile.add(mntmOpen);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextArea textArea = new JTextArea();
		panel_1.add(textArea);
		
		JLabel lblIncassoTotale = new JLabel("Incasso totale: ");
		panel_1.add(lblIncassoTotale);
		
		JLabel lblIncasso = new JLabel("Incasso:");
		panel_1.add(lblIncasso);
		
		JButton btnStudenti = new JButton("Studenti");
		btnStudenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblIncassoTotale.setText("Incasso: " + registrazioni.dammiTotale());
				try {
					ArrayList<Registrazione> trovati = registrazioni.dammiRegistrazionePerTipoPartecipante(0);
					textArea.setText("");
					for (Registrazione r : trovati) {
						textArea.append(r.toString() + "\n");
					}
					Registrazioni rr = new Registrazioni();
					for (Registrazione r : trovati) {
						rr.aggiungiRegistrazione(r);
					}
					lblIncasso.setText("Incasso Studenti: " + rr.dammiTotale());
				} catch (InvalidParameterException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		panel.add(btnStudenti);
		
		JButton btnProfessionisti = new JButton("Professionisti");
		btnProfessionisti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblIncassoTotale.setText("Incasso: " + registrazioni.dammiTotale());
				try {
					ArrayList<Registrazione> trovati = registrazioni.dammiRegistrazionePerTipoPartecipante(1);
					textArea.setText("");
					for (Registrazione r : trovati) {
						textArea.append(r.toString() + "\n");
					}
					Registrazioni rr = new Registrazioni();
					for (Registrazione r : trovati) {
						rr.aggiungiRegistrazione(r);
					}
					lblIncasso.setText("Incasso Professionisti: " + rr.dammiTotale());
				} catch (InvalidParameterException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnProfessionisti);
		
	
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel_1.add(btnCerca);
	}

}
