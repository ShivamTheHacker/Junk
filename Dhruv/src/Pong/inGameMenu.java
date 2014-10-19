package Pong;

import java.awt.Color;
import java.awt.Graphics2D;

import PapaPong.Dimension;

public class inGameMenu {

	private Dimension dimension = new Dimension(this.getClass());

	public void paint(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, dimension.WIDTH, 40);
		g.setColor(Color.WHITE);
		g.fillRect(100, 10, 50, 20);
		g.fillRect(225, 10, 50, 20);
		g.fillRect(350, 10, 50, 20);
	}

}
