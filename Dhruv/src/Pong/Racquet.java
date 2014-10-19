/*
______________________________________
|\   ____\|\   __  \|\   ___ \|\  ___ \               
\ \  \___|\ \  \|\  \ \  \_|\ \ \   __/|              
 \ \  \    \ \  \\\  \ \  \ \\ \ \  \_|/__            
  \ \  \____\ \  \\\  \ \  \_\\ \ \  \_|\ \           
   \ \_______\ \_______\ \_______\ \_______\          
    \|_______|\|_______|\|_______|\|_______|       
 */

package Pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class Racquet {
	public int WIDTH = 60;
	public int HEIGHT = 10;
	public int x = 0;
	private int xSpeed = 1;
	public int y = 700;
	private int ySpeed = 1;
	public double rotateAngle = 0.0;
//	private Dimension dimension = new Dimension(this.getClass());
	private Game game;

	public Racquet(Game game) {
		this.game = game;
	}

	public void newGame() {

	}

	public void newPoint() {
		x = 0;
		xSpeed = 1;
		y = 700;
		ySpeed = 1;
		rotateAngle = 0.0;
	//	WIDTH = dimension.racquetWidth;
	//	HEIGHT = dimension.racquetHeight;
	}

	public void move() {
		if (checkBoundsX()) {
			x = x + xSpeed;
		}
		if (checkBoundsY()) {
			y = y + ySpeed;
		}
	}

	public boolean checkBoundsX() {
		boolean check = false;
	//	if (x + xSpeed > 0 && x + xSpeed < game.getWidth() - dimension.racquetWidth) {
	//		check = true;
	//	}
		return check;
	}

	public boolean checkBoundsY() {
		boolean check = false;
	//	if (y + ySpeed > 0 && y + ySpeed < game.getHeight() - dimension.racquetHeight) {
	//		check = true;
	//	}
		return check;
	}

	public void paint(Graphics2D g) {
		// getShape();
		g.drawString((int) rotateAngle + "," + WIDTH + "," + HEIGHT, x - 10,
				y - 10);
		g.drawString(x + "," + y, x - 10, y + 60);
		g.setColor(Color.MAGENTA);
		AffineTransform rotate = AffineTransform.getRotateInstance(rotateAngle,
				x, y);
		if (rotate != null) {
			g.setTransform(rotate);
		}

		if (rotateAngle == 0.0) {
			g.fillRect(x, y, 60, 10);
		} else if (rotateAngle == Math.PI) {
			g.fillRect(x - 60, y - 10, 60, 10);
		}
		if (rotateAngle == Math.PI / 2) {
			g.fillRect(x - 10, y, 10, 60);
		} else if (rotateAngle == Math.PI + Math.PI / 2) {
			g.fillRect(x, y - 60, 10, 60);
		}
	}

	public void keyReleased(KeyEvent e) {
		xSpeed = 0;
		ySpeed = 0;
	}

	public void keyPressed(KeyEvent e) {
		int ballXSpeed = Math.abs(game.ball.xSpeed);
		int ballYSpeed = Math.abs(game.ball.ySpeed);
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xSpeed = -ballXSpeed;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			xSpeed = ballXSpeed;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (y > 400) {
				ySpeed = -ballYSpeed;
			} else {
				ySpeed = 0;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ySpeed = ballYSpeed;
		}

		if (e.getKeyCode() == KeyEvent.VK_Z) {
			upRotateAngle();
		}
		if (e.getKeyCode() == KeyEvent.VK_X) {
			// downRotateAngle();
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			xSpeed--;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			xSpeed++;
		}
	}

	public void getShape() {
		// FIND LENGTH OF THIRD SIDE
		System.out.println(2 * (WIDTH * WIDTH));
		System.out.println(Math.cos(0));
		// double finale = (2*(WIDTH * WIDTH)) - ((2*(WIDTH * WIDTH)) *
		// (Math.cos(rotateAngle * 180)));
		// System.out.println(finale);
		/*
		 * int a = WIDTH; System.out.println(a); int b = WIDTH * WIDTH;
		 * System.out.println(b); double c = 2 * b; double e = c *
		 * Math.cos(rotateAngle * 180); System.out.println(e); double f = c * e;
		 * System.out.println(f); double g = c - f; System.out.println(g);
		 */
	}

	private void upRotateAngle() {
		rotateAngle += Math.PI / 2;
		if (rotateAngle == 2 * Math.PI) {
			rotateAngle = 0.0;
		}

		if (rotateAngle == 0.0) {
			System.out.println("0.0");
		//	WIDTH = 60;
		//	HEIGHT = 10;
		} else if (rotateAngle == Math.PI / 2) {
			System.out.println("Math.PI/2");
		//	WIDTH = 10;
		//	HEIGHT = 60;
		} else if (rotateAngle == Math.PI) {
			System.out.println("Math.PI");
			//WIDTH = 60;
			//HEIGHT = 10;
		} else if (rotateAngle == Math.PI + Math.PI / 2) {
			System.out.println("Math.PI + Math.PI/2");
			//WIDTH = 10;
			//HEIGHT = 60;
		}
	}

	private void downRotateAngle() {
		rotateAngle -= Math.PI / 2;
		if (rotateAngle < 0.0) {
			rotateAngle = 0.0;
		}
		if (rotateAngle == Math.PI / 2 || rotateAngle == Math.PI / 2 + Math.PI) {
			//WIDTH = 10;
			//HEIGHT = 60;
		} else if (rotateAngle == Math.PI) {
			//WIDTH = 60;
			//HEIGHT = 10;
		}
	}

	public boolean checkPaddleBounds() {
		boolean check = false;
		if (y > 400) {
			check = true;
		}
		return check;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public int getUserX() {
		return x;
	}

	public int getUserY() {
		return y;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}
}

/*
 * 
 * if (rotateAngle == Math.PI / 2 || rotateAngle == Math.PI / 2 + Math.PI) {
 * WIDTH = 10; HEIGHT = 60; } else if (rotateAngle == 0.0) { WIDTH = 60; HEIGHT
 * = 10; } else if (rotateAngle == 2 * Math.PI) { WIDTH = 60; HEIGHT = 10;
 * rotateAngle = 0.0; }
 */