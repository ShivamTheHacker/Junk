package Pong;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class RacquetOld {
	private static final int Y = 700;
	private static final int comY = 100;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	int x = 0;
	int xSpeed = 0;
	private Game game;

	public RacquetOld(Game game) {
		this.game = game;
	}
	
	public void newGame() {
		x = 0;
		xSpeed = 0;
	}

	public void move() {
		if (x + xSpeed > 0 && x + xSpeed < game.getWidth() - WIDTH)
			x = x + xSpeed;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, WIDTH, HEIGHT);
		g.fillRect(game.getBallX(), 100, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
		xSpeed = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xSpeed = -1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xSpeed = 1;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}

	public Rectangle getComBounds() {
		return new Rectangle(game.getBallX(), comY, WIDTH, HEIGHT);
	}

	public int getTopY() {
		return Y;
	}

	public int getComTopY() {
		return comY;
	}
	
	public int getComX() {
		return game.getBallX();
	}
	
	public int getWidth() {
		return WIDTH;
	}
}