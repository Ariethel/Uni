

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Gui {

	private JFrame frame;

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
		Idraulico i1 = new Idraulico(1, 0, "a", "a", null);
		Idraulico i2 = new Idraulico(2, 0, "b", "b", null);
		Idraulico i3 = new Idraulico(3, 0, "c", "c", null);
		Idraulico i4 = new Idraulico(4, 0, "d", "d", null);
		Idraulico i5 = new Idraulico(5, 0, "e", "e", null);
		
		TecnicoCaldaia t1 = new TecnicoCaldaia(6, 0, "aa", "bb", null, null, 0, 0)
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
