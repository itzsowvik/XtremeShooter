package dev.xtremeshooter.frontend;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dev.xtremeshooter.game.Game;
import dev.xtremeshooter.handlers.FileHandler;
import dev.xtremeshooter.handlers.HighScore;

public class MainMenu  {
    public static JFrame Menu = new JFrame("Xtreme Shooter");
    JButton Start=new JButton("Start");
    JButton Exit = new JButton("Exit");
    JButton score = new JButton("SCORE");
    ImageIcon picture=new ImageIcon(getClass().getResource("/textures/mainmenu.gif"));
    JLabel imageLabel = new JLabel(picture);
    int menuWidth = 100;
    int menuHeight = 70;
    int WIDTH = 400;
    int HEIGHT = 400;
    private ImageIcon icon,icons,icone,iconesc;
    
    public static Game game;
 
	public static Game getGame() {
		return game;
	}

	public static void setGame() {
		game.stop();
	}

	public MainMenu() {
          
    	FileHandler.currentScore=0;
        Menu.setResizable(false);
        Menu.setSize(WIDTH, HEIGHT);
        Menu.setLayout(null);
        Menu.setLocationRelativeTo(null);
        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        icons=new ImageIcon(getClass().getResource("/textures/playbut.jpg"));  
        icone=new ImageIcon(getClass().getResource("/textures/exitbutton.png"));
        iconesc=new ImageIcon(getClass().getResource("/textures/trophy.png"));
        Start=new JButton(icons);
        Exit=new JButton(icone);
        score=new JButton(iconesc);
        Start.setSize(menuWidth,menuHeight);
        Start.setLocation(50,50);
        Menu.add(Start);
        Start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
                                //sound();
				game = new Game("Xtreme Shooter",400,400);
				game.start();
				Menu.setVisible(false);
			}
        	
        });	
        
        score.setSize(menuWidth,menuHeight);
        score.setLocation(50,170);
        Menu.add(score);
        score.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {                           
                 HighScore highScore= new HighScore();
                 highScore.createHighScore();                      
			}
        });
        Exit.setSize(menuWidth,menuHeight);
        Exit.setLocation(50,290);
        Menu.add(Exit);
        Exit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
	        System.exit(0);
		}
        });
        
        imageLabel.setSize(WIDTH, HEIGHT);
        imageLabel.setLayout(null);
        imageLabel.setVisible(true);
        Menu.add(imageLabel);
        Menu.setVisible(true);
       
    }

}