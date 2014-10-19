package Pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import PapaPong.Dimension;
import PapaPong.Game;

public class Aimer {

	private Dimension dimension = new Dimension(this.getClass());
	private Game game;

	public Aimer(Game game) {
		this.game = game;
	}

	public void paint(Graphics2D g) {
		int meetingPointComX = 0;
		int meetingPointComY = 0;
		int meetingPointUserX = dimension.WIDTH;
		int meetingPointUserY = dimension.HEIGHT;
		g.setColor(Color.MAGENTA);

		g.drawRect(game.racquet.userPaddleX + 60, game.racquet.y + 60, game.racquet.WIDTH,
				game.racquet.HEIGHT);

		g.drawLine(game.ball.ballX, game.ball.ballY, meetingPointComX,
				meetingPointComY);
		g.drawLine(game.comPaddle.getComX(), game.comPaddle.getComY(),
				meetingPointComX, meetingPointComY);

		g.drawLine(game.ball.ballX, game.ball.ballY, meetingPointUserX,
				meetingPointUserY);
		g.drawLine(game.racquet.userPaddleX, game.racquet.userPaddleX, meetingPointUserX,
				meetingPointUserY);

		AffineTransform rotate = AffineTransform.getRotateInstance(
				game.racquet.rotateAngle, game.racquet.userPaddleX, game.racquet.y);
		if (rotate != null) {
			g.setTransform(rotate);
		}
		// AIMER
		g.setColor(Color.RED);
		g.drawLine(game.racquet.userPaddleX + game.racquet.WIDTH / 2, game.racquet.y,
				game.racquet.userPaddleX + game.racquet.WIDTH / 2, game.racquet.y - 40);
	}

}
