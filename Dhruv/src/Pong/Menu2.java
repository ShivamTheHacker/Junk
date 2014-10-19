package Pong;

import java.awt.event.ActionEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu2 extends JMenuBar {

	public static JMenuBar makeMenu() {
		JMenuBar jmb = new JMenuBar();
		JMenu jmFile = new JMenu("File");
		JMenuItem jmiOpen = new JMenuItem("Open");
		JMenuItem jmiClose = new JMenuItem("Close");
		JMenuItem jmiSave = new JMenuItem("Save");
		JMenuItem jmiExit = new JMenuItem("Exit");
		jmFile.add(jmiOpen);
		jmFile.add(jmiClose);
		jmFile.add(jmiSave);
		jmFile.addSeparator();
		jmFile.add(jmiExit);
		jmb.add(jmFile);
		return jmb;
		
		// JMenuBar menu = Menu.makeMenu();
		// frame.setJMenuBar(menu); // HEIGHT + 22
	}

	public void actionPerformed(ActionEvent e) {
      System.out.println("HI");
    }

}
