import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RectangleDemo extends JPanel {

   public static void main(String[] a) {
      JFrame f = new JFrame();
      f.setSize(400, 400);
      f.add(new RectangleDemo());
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
   }

   public void paint(Graphics g) {
	  g.setColor(Color.RED);
      g.fillRect (0, 0, 400, 400);
      Font font = new Font("Serif", Font.PLAIN, 36);
      g.setFont(font);
      g.setColor(Color.BLUE);
      g.drawString("hi", 50, 50);
   }
}