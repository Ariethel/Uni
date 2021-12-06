import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet.FontAttribute;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.FlowLayout;

public class main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEasy = new JLabel("Easy",SwingConstants.CENTER);
		contentPane.add(lblEasy, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JCheckBox chckbxBold = new JCheckBox("Bold");
		chckbxBold.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lblEasy.setFont( e.getStateChange() == 1 ? (lblEasy.getFont().deriveFont(Font.BOLD,18)):(lblEasy.getFont().deriveFont(Font.PLAIN,18)));
			}
		});
		
		panel.add(chckbxBold);
		
		JCheckBox chckbxItalic = new JCheckBox("Italic");
		chckbxItalic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lblEasy.setFont( e.getStateChange() == 1 ? (lblEasy.getFont().deriveFont(Font.ITALIC,18)):(lblEasy.getFont().deriveFont(Font.PLAIN,18)));
			}
		});
		panel.add(chckbxItalic);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton rdbtnSans = new JRadioButton("Gothic");
		rdbtnSans.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lblEasy.setFont(e.getStateChange() == 1 ? (new Font ("daewoo-gothic-medium",Font.PLAIN,18)):(getFont()));
			}
		});
		panel_1.add(rdbtnSans);
		
		JRadioButton rdbtnSerif = new JRadioButton("bitstream-courier");
		rdbtnSerif.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lblEasy.setFont(e.getStateChange() == 1 ? (new Font ("bitstream-courier",Font.PLAIN,18)):(getFont()));

			}
		});
		panel_1.add(rdbtnSerif);
		
		JRadioButton rdbtnMonospace = new JRadioButton("Fixed");
		rdbtnMonospace.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lblEasy.setFont(e.getStateChange() == 1 ? (new Font ("misc-fixed-medium-o-semicondensed",Font.PLAIN,18)):(getFont()));
			}
		});
		panel_1.add(rdbtnMonospace);
	}

}
