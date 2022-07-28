package dev.xtremeshooter.handlers;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HighScore{
	JFrame hFrame;
	JLabel hLabel;
	Thread thread;
	public void createHighScore() {
		FileHandler fileHandler= new FileHandler();
		hFrame = new JFrame("HIGH SCORE");
		hFrame.setSize(225, 100);
		hFrame.setVisible(true);
		hFrame.setLocationRelativeTo(null);
		hLabel = new JLabel();
		hLabel.setBounds(120, 30, 150, 40);
		hLabel.setText("                  HIGH SCORE : "+ fileHandler.readFile());
		hFrame.add(hLabel);
	}
}
