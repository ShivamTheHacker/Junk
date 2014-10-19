package Pong;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int ballDiameter = 30;
	public int ballX = 200;
	public int ballY = 200;
	int xSpeed = 1;
	int ySpeed = 1;
	private Game game;
	public boolean gameOver;

	public Ball(Game game) {
		this.game = game;
	}

	public void newGame() {
		ballX = 200;
		ballY = 200;
		xSpeed = 1;
		ySpeed = 1;
		gameOver = false;
	}
	
	public void move() {
		System.out.println(ballX + " , " + ballY);
		if (ballX + xSpeed < 0) {
			xSpeed = 1;
		}
		if (ballX + xSpeed > game.getWidth() - ballDiameter) {
			xSpeed = -1;
		}
		if (ballY + ySpeed < 0) {
			ySpeed = 1;
		}
		if (ballY + ySpeed > game.getHeight() - ballDiameter) {
			gameOver = true;
			game.gameOver();
			// ySpeed *= -1;
		}
		if (collision()) {
			ySpeed = -1;
		}
		if (ballY == game.comRacquet.getComTopY()) {
			ySpeed *= -1;
		}
		ballX = ballX + xSpeed;
		ballY = ballY + ySpeed;
	}

	public int getX() {
		return ballX;
	}

	public int getY() {
		return ballY;
	}

	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	private boolean comCollision() {
		return game.comRacquet.getComBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(ballX, ballY, ballDiameter, ballDiameter);
	}

	public Rectangle getBounds() {
		return new Rectangle(ballX, ballY, ballDiameter, ballDiameter);
	}
}

/*&& ballX > game.comRacquet.getComX()
&& ballX < game.comRacquet.getComX()
		+ game.comRacquet.getWidth()*/


// ballY = game.racquet.getTopY() - ballDiameter;