import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;

public class Gui {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCheckin;
	private JTextField txtCheckout;
	private JPanel panel_1;
	private JFrame secondFrame = new JFrame("Gestione Prenotazioni");
	private JFrame thirdFrame = new JFrame("Richiesta Prenotazioni");
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
		Clienti c1 = new Clienti("Renzullo", "Antonio", 111, 1);
		Clienti c2 = new Clienti("Carbone", "Simon", 222, 2);
		Clienti c3 = new Clienti("Catanese", "Antongiulio", 333, 3);
		
		Stanze s1 = new Stanze(1, 1, 1, "Singola", null);
		Stanze s2 = new Stanze(2, 2, 2, "Doppia", null);
		Stanze s3 = new Stanze(3, 3, 3, "Matrimoniale", null);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rdbtnRichiesta = new JRadioButton("Richiesta");
		buttonGroup.add(rdbtnRichiesta);
		panel.add(rdbtnRichiesta);
		
		JRadioButton rdbtnGestione = new JRadioButton("Gestione");
		buttonGroup.add(rdbtnGestione);
		panel.add(rdbtnGestione);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JButton btnProcedi = new JButton("Procedi");
		btnProcedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnGestione.isSelected()) {
					secondFrame.setVisible(true);
					secondFrame.setBounds(100, 100, 450, 300);
					secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					JPanel panel = new JPanel();
					secondFrame.getContentPane().add(panel, BorderLayout.NORTH);
					panel.setLayout(new GridLayout(2, 2, 0, 0));
					
					txtCheckin = new JTextField();
					txtCheckin.setText("Check-In");
					panel.add(txtCheckin);
					txtCheckin.setColumns(10);
					
					txtCheckout = new JTextField();
					txtCheckout.setText("Check-Out");
					panel.add(txtCheckout);
					txtCheckout.setColumns(10);
					
					JComboBox comboBox = new JComboBox();
					comboBox.addItem("Singola");
					comboBox.addItem("Doppia");
					comboBox.addItem("Matrimoniale");
					panel.add(comboBox);
					
					JPanel panel_1 = new JPanel();
					secondFrame.getContentPane().add(panel_1, BorderLayout.EAST);
					panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					
					JButton btnChiedi = new JButton("Chiedi");
					btnChiedi.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						}
					});
					panel_1.add(btnChiedi);
					
					
					JButton btnPrenota = new JButton("Prenota");
					panel_1.add(btnPrenota);
					
					JPanel panel_2 = new JPanel();
					secondFrame.getContentPane().add(panel_2, BorderLayout.CENTER);
					panel_2.setLayout(new GridLayout(0, 1, 0, 0));
					
					JTextArea txtrDettagli = new JTextArea();
					txtrDettagli.setText("Dettagli");
					panel_2.add(txtrDettagli);
				}
				
					
				if (rdbtnRichiesta.isSelected()) {
					thirdFrame.setVisible(true);
				}
					
			}
		});
		panel_1.add(btnProcedi);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.showOpenDialog(mntmOpen);
				
			}
		});
		mnFile.add(mntmOpen);
	}

}
