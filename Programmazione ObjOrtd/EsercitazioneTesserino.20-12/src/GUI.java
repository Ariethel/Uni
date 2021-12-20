import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	PagamentoPasti pp = new PagamentoPasti();	
	double paga = 0;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblNomeFile = new JLabel("Nome File:");
		panel.add(lblNomeFile);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc = new JFileChooser();
				jfc.showOpenDialog(btnOpen);
				lblNomeFile.setText("Nome file: " + jfc.getName(jfc.getSelectedFile()));
				try {
					pp = riempiLista(jfc.getSelectedFile());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			private PagamentoPasti riempiLista(File selectedFile) throws ClassNotFoundException, IOException {
				PagamentoPasti pp = new PagamentoPasti(); 
				FileInputStream fis = new FileInputStream(selectedFile);
				ObjectInputStream ois = new ObjectInputStream(fis);
				pp = (PagamentoPasti) ois.readObject();
				
				return pp;
			}
		});
		panel.add(btnOpen);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblTesserino = new JLabel("Tesserino:");
		lblTesserino.setBounds(12, 29, 75, 15);
		panel_1.add(lblTesserino);
		
		textField = new JTextField();
		textField.setBounds(112, 27, 114, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblSommaIncassata = new JLabel("Somma incassata");
		lblSommaIncassata.setBounds(0, 56, 453, 44);
		panel_1.add(lblSommaIncassata);
		
		JButton btnPaga = new JButton("Paga");
		btnPaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cerca = textField.getText();
				ArrayList<Tesserino> tesserini = new ArrayList<Tesserino>();
				tesserini = pp.getTesserini();
				for (Tesserino tesserino : tesserini) {
					if (cerca.equalsIgnoreCase(tesserino.getCodice())) {
						try {
							paga += tesserino.paga();
						} catch (TesserinoScadutoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SaldoInsufficienteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						lblSommaIncassata.setText("Somma incassata: " + paga);
						
					}
					
						
				}
			}
		});
		btnPaga.setBounds(309, 24, 117, 25);
		panel_1.add(btnPaga);
		
		
	}
}
