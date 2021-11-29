import javax.swing.JComponent;
import java.awt.*;

import java.awt.Color;

public class ColoredSquareComponent extends JComponent{
	
	//Costruttore
	public ColoredSquareComponent(Color c) {
		this.c = c;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
	
		g2.setColor(this.c);
		
		final int SQUARE_LENGHT = 100; //Creo un quadrato 100x100
		
		Rectangle square = new Rectangle((getWidth() - SQUARE_LENGHT)/2,(getHeight() - SQUARE_LENGHT)/2,SQUARE_LENGHT,SQUARE_LENGHT);
		
		g2.fill(square);
	}
	
	private Color c;
}
