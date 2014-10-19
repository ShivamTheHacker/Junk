package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

	private static int FRAME_SPEED = 10;

	Ball ball = new Ball(this);
	RacquetOld racquet = new RacquetOld(this);
	RacquetOld comRacquet = new RacquetOld(this);
	public int ballX;
	public int ballY;

	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
	}

	private void move() {
		ball.move();
		racquet.move();
	}

	public int getBallX() {
		return ball.getX();
	}

	public int getBallY() {
		return ball.getY();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		// Smoothes curves on shapes.
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		ball.paint(g2d);
		racquet.paint(g2d);
	}

	public void gameOver() {
		System.out.println("DIALOG");
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over",
				JOptionPane.YES_NO_OPTION);
		System.out.println("ENDED");
		ball.newGame();
		racquet.newGame();
		// System.exit(ABORT);
	}

	public void startHere() throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(500, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		System.out.println("HI");
		while (ball.gameOver == false) {
			game.move();
			game.repaint();
			Thread.sleep(FRAME_SPEED);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		new Game().startHere();
	}
}