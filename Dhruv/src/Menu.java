

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener{
	
	public JButton button = new JButton("HI");
	public boolean menuUp = true;
	
	public JPanel createPanel() {
		
		JPanel panel = new JPanel();
		panel.setLocation(380, 380);
		panel.setSize(500, 800);
		button.setSize(20, 20);
		button.addActionListener((ActionListener) this);
		panel.add(button);
		return panel;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			menuUp = false;
		}
		
	}
	
}
