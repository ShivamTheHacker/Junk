/*
______________________________________
|\   ____\|\   __  \|\   ___ \|\  ___ \               
\ \  \___|\ \  \|\  \ \  \_|\ \ \   __/|              
 \ \  \    \ \  \\\  \ \  \ \\ \ \  \_|/__            
  \ \  \____\ \  \\\  \ \  \_\\ \ \  \_|\ \           
   \ \_______\ \_______\ \_______\ \_______\          
    \|_______|\|_______|\|_______|\|_______|       
 */

// Algorithms used

/* Used to calculate rotated points
 *  __  __     __					  __	 __		  __
 * | newX |   | cos(angle)  -sin(angle) |	| originalX |
 * |      | = |							| * |			|
 * | newY |   | sin(angle)  cos(angle)	|	| originalY |
 *  --  --     --					  --	 --		  --
 */

package PapaPong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class Racquet {
	private Dimension var = new Dimension(this.getClass());
	public int userPaddleX = var.startPaddleX;
	public int userPaddleY = var.startUserPaddleY;
	private int userPaddleXSpeed = 0;
	private int userPaddleYSpeed = 0;
	public double rotateAngle = 0.0;
	public boolean paddleLifted = false;
	private Game game;

	public Racquet(Game game) {
		this.game = game;
	}

	public void newGame() {

	}

	public void newPoint() {
		userPaddleX = var.startPaddleX;
		userPaddleXSpeed = var.originalPaddleXSpeed;
		userPaddleY = var.startUserPaddleY;
		userPaddleYSpeed = var.originalPaddleYSpeed;
		rotateAngle = 0.0;
	}

	public void move() {
		if (checkBoundsX()) {
			userPaddleX = userPaddleX + userPaddleXSpeed;
		}
		if (checkBoundsY()) {
			userPaddleY = userPaddleY + userPaddleYSpeed;
		}
	}

	public boolean checkBoundsX() {
		boolean check = false;
		if (userPaddleX + userPaddleXSpeed > 0
				&& userPaddleX + userPaddleXSpeed < var.WIDTH
						- var.racquetWidth) {
			check = true;
		}
		return check;
	}

	public boolean checkBoundsY() {
		boolean check = false;
		if (userPaddleY + userPaddleYSpeed > 0
				&& userPaddleY + userPaddleYSpeed < var.HEIGHT
						- var.racquetHeight) {
			check = true;
		}
		return check;
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.MAGENTA);
		AffineTransform rotate = AffineTransform.getRotateInstance(rotateAngle,
				userPaddleX, userPaddleY);
		if (rotate != null) {
			g.setTransform(rotate);
		}
		if (!paddleLifted) {
			g.fillRect(userPaddleX, userPaddleY, var.racquetWidth,
					var.racquetHeight);
		} else {
			g.fillRect(userPaddleX - 4, userPaddleY - 4, var.racquetWidth + 2,
					var.racquetHeight + 2);
		}
		// calculateAngledBoundingBox();
		// Positive is below***
	}

	public void keyReleased(KeyEvent e) {
		userPaddleXSpeed = 0;
		userPaddleYSpeed = 0;
		paddleLifted = false;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			userPaddleXSpeed = -var.originalPaddleXSpeed;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			userPaddleXSpeed = var.originalPaddleXSpeed;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			userPaddleYSpeed = -var.originalPaddleYSpeed;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			userPaddleYSpeed = var.originalPaddleYSpeed;
		}
		if (e.getKeyCode() == KeyEvent.VK_Z) {
			riseRotateAngle();
		}
		if (e.getKeyCode() == KeyEvent.VK_X) {
			lowerRotateAngle();
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// LIFT PADDLE
			paddleLifted = true;
		}

	}

	private void riseRotateAngle() {
		rotateAngle += Math.PI / 4;
		if (rotateAngle == Math.PI + Math.PI / 4) {
			rotateAngle = -(Math.PI / 2 + Math.PI / 4);
		}
	}

	private void lowerRotateAngle() {
		rotateAngle -= Math.PI / 4;
		if (rotateAngle == -(Math.PI * 2)) {
			rotateAngle = 0;
		}
		if (rotateAngle == -Math.PI) {
			rotateAngle = Math.PI;
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(userPaddleX, userPaddleY, var.racquetWidth,
				var.racquetHeight);
	}

	public int getUserX() {
		return userPaddleX;
	}

	public int getUserY() {
		return userPaddleY;
	}

	public int[][] calculateAngledBoundingBox() {
		int[] x1y1 = getNewXY(userPaddleX, userPaddleY);
		int[] x2y1 = getNewXY(userPaddleX + var.racquetWidth, userPaddleY);
		int[] x1y2 = getNewXY(userPaddleX, userPaddleY + var.racquetHeight);
		int[] x2y2 = getNewXY(userPaddleX + var.racquetWidth, userPaddleY
				+ var.racquetHeight);
		int[][] nc = { x1y1, x2y1, x1y2, x2y2 }; // nc = newCoordinates
		return nc;
	}

	public int[] getNewXY(int x, int y) {
		double cos = Math.cos(rotateAngle);
		double sin = Math.sin(rotateAngle);
		double newX = (cos * x) + ((-sin) * y);
		double newY = (sin * x) + (cos * y);
		int[] xy = { (int) newX, (int) newY };
		return xy;
	}
}

/*
 * 
 * if (rotateAngle == Math.PI / 2 || rotateAngle == Math.PI / 2 + Math.PI) {
 * WIDTH = 10; HEIGHT = 60; } else if (rotateAngle == 0.0) { WIDTH = 60; HEIGHT
 * = 10; } else if (rotateAngle == 2 * Math.PI) { WIDTH = 60; HEIGHT = 10;
 * rotateAngle = 0.0; }
 * 
 * 
 * double a = (WIDTH * Math.sqrt(2.0)) / 2; double b = (HEIGHT * Math.sqrt(2.0))
 * / 2; int intA = (int) a; int intB = (int) b; int c = 0; if (a + b > intA +
 * intB + 0.5) { c = intA + intB + 1; } else if (a + b < intA + intB + 0.5) { c
 * = intA + intB - 1; } int boundingBoxY = 0; if (rotateAngle > 0.0) {
 * boundingBoxY -= intA; } else if (rotateAngle < 0.0) { boundingBoxY += intA; }
 * boundingBox = new Rectangle(userPaddleX, boundingBoxY, c, c);
 */