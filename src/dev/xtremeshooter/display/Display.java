package dev.xtremeshooter.display;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dev.xtremeshooter.handlers.FileHandler;

public class Display {
	private String title;
	private int width, height;
	public static JFrame frame;
	public static Canvas canvas;
	public static JLabel Scorecard=new JLabel("SCORE : "+FileHandler.currentScore);
	
	public Display(String title, int width, int height){
		this.title=title;
		this.width=width;
		this.height=height;
		createDisplay();
	}
	public void createDisplay() {
		frame= new JFrame(title);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		Scorecard.setBounds(0, 0, 100, 20);
		frame.add(Scorecard);
		frame.add(canvas);
		frame.pack();
	}
	public Canvas getCanvas() {
		return canvas;
	}
	public JFrame getframe() {
		return frame;
	}
	public void exitFrame()
	{
		frame.setVisible(false);
	}
}
