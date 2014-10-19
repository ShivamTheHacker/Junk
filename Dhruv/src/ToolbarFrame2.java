import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolbarFrame2 extends Frame {
  JButton cutButton, copyButton, pasteButton;

  JButton javaButton, macButton, motifButton, winButton;

  public ToolbarFrame2() {
    setSize(450, 250);
    
    ActionListener printListener = new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.getActionCommand());
      }
    };

    // JPanel works similarly to Panel, so we'll use it
    JPanel toolbar = new JPanel();
    toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));

    cutButton = new JButton("Cut");
    cutButton.addActionListener(printListener);
    toolbar.add(cutButton);

    copyButton = new JButton("Copy");
    copyButton.addActionListener(printListener);
    toolbar.add(copyButton);

    pasteButton = new JButton("Paste");
    pasteButton.addActionListener(printListener);
    toolbar.add(pasteButton);

    add(toolbar, BorderLayout.NORTH); // The new BorderLayout add

    JPanel lnfPanel = new JPanel();
    macButton = new JButton("Mac");
    macButton.addActionListener(printListener);
    lnfPanel.add(macButton);
    javaButton = new JButton("Metal");
    javaButton.addActionListener(printListener);
    lnfPanel.add(javaButton);
    motifButton = new JButton("Motif");
    motifButton.addActionListener(printListener);
    lnfPanel.add(motifButton);
    winButton = new JButton("Windows");
    winButton.addActionListener(printListener);
    lnfPanel.add(winButton);
    add(lnfPanel, BorderLayout.SOUTH);
  }

  public static void main(String args[]) {
    ToolbarFrame2 tf2 = new ToolbarFrame2();
    tf2.setVisible(true);
  }
}