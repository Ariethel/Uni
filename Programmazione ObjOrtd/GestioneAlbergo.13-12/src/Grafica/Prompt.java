package Grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Prompt {

	private JFrame frmHoteltransilvania;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prompt window = new Prompt();
					window.frmHoteltransilvania.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prompt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHoteltransilvania = new JFrame();
		frmHoteltransilvania.setTitle("HotelTransilvania");
		frmHoteltransilvania.setBounds(100, 100, 450, 300);
		frmHoteltransilvania.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHoteltransilvania.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frmHoteltransilvania.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
	}
}
