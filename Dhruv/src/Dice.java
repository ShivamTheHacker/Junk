import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Dice extends JPanel implements ActionListener {

	JPanel totalGUI, fullPanel;
	JLabel number;
	JButton roll;

	int currentBackgroundColor;
	int currentTextColor;

	Color red = Color.RED;
	Color green = Color.GREEN;
	Color blue = Color.BLUE;
	Color yellow = Color.YELLOW;
	Color cyan = Color.CYAN;
	Color magenta = Color.MAGENTA;
	Color[] primary = { red, green, blue };
	Color[] secondary = { cyan, magenta, yellow };

	public JPanel createContentPane() {

		totalGUI = new JPanel();
		totalGUI.setLayout(null);

		fullPanel = new JPanel();
		fullPanel.setLayout(null);
		fullPanel.setLocation(0, 0);
		fullPanel.setSize(400, 400);
		totalGUI.add(fullPanel);

		number = new JLabel("?");
		number.setLocation(150, 100);
		number.setSize(100, 100);
		number.setHorizontalAlignment(0);
		number.setForeground(Color.RED);
		Font font = new Font("Garamond", Font.BOLD | Font.ITALIC, 60);
		number.setFont(font);
		fullPanel.add(number);

		roll = new JButton("Roll!");
		roll.setLocation(175, 175);
		roll.setSize(50, 50);
		roll.addActionListener(this);
		fullPanel.add(roll);

		totalGUI.setOpaque(true);
		return totalGUI;
	}

	private int randomizeNumber() {
		Random random = new Random();
		int number = random.nextInt(6) + 1;
		return number;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == roll) {
			int currentRollNumber = randomizeNumber();
			fullPanel.setBackground(secondary[currentBackgroundColor]);
			currentBackgroundColor++;
			if (currentBackgroundColor == 3) {
				currentBackgroundColor = 0;
			}
			number.setForeground(primary[currentTextColor]);
			number.setText("" + currentRollNumber);
			currentTextColor++;
			if (currentTextColor == 3) {
				currentTextColor = 0;
			}
		}
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame();
		frame.setTitle("Dice!");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Dice demo = new Dice();
		frame.setContentPane(demo.createContentPane());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
