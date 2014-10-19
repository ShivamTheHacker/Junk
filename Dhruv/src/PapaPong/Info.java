package PapaPong;

import java.awt.Graphics2D;

public class Info {

	private Dimension v = new Dimension(this.getClass());
	private Game game;

	public Info(Game game) {
		this.game = game;
	}

	public void paint(Graphics2D g) {
		int[][] nc = game.racquet.calculateAngledBoundingBox();
		g.drawString("Rotate Angle: " + game.racquet.rotateAngle, v.scoreX,
				v.HEIGHT - v.wallWidth * 2 - 60);
		g.drawString("X1: " + nc[0][0] + ", Y1: " + nc[0][1], v.scoreX,
				v.HEIGHT - v.wallWidth * 2 - 45);
		g.drawString("X2: " + nc[1][0] + ", Y1: " + nc[1][1], v.scoreX,
				v.HEIGHT - v.wallWidth * 2 - 30);
		g.drawString("X1: " + nc[2][0] + ", Y2: " + nc[2][1], v.scoreX,
				v.HEIGHT - v.wallWidth * 2 - 15);
		g.drawString("X2: " + nc[3][0] + ", Y2: " + nc[3][1], v.scoreX,
				v.HEIGHT - v.wallWidth * 2);
	}

}
