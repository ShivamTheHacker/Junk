package Pong;

import java.awt.Color;
import java.awt.Graphics2D;

public class Buttons {

	private Menu menu;

	public Buttons(Menu menu) {
		this.menu = menu;
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 780);
		g.setColor(Color.CYAN);
		g.fillRect(20, 20, 460, 740);
		g.setColor(Color.ORANGE);
		g.fillRect(200, 360, 100, 60);
	}
	
}
