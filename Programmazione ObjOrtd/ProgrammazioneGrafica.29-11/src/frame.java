//Stampare un quadrato all'interno del frame con un colore specificato dall'utente (rgb)
import javax.swing.*;

import java.awt.*;

public class frame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 400;
		frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		frame.setTitle("Prova");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String input = JOptionPane.showInputDialog("red: ");
		int red = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("green: ");
		int green = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog("blue: ");
		int blue = Integer.parseInt(input);
		
		Color fillColor = new Color(red,green,blue);
		
		frame.setVisible(true);
		
		ColoredSquareComponent component = new ColoredSquareComponent(fillColor);
		
		frame.add(component);
	}

}
