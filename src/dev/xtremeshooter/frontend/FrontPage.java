package dev.xtremeshooter.frontend;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrontPage  {
    public JFrame Menu = new JFrame("XtremeShooter");
    ImageIcon picture=new ImageIcon(getClass().getResource("/textures/mainmenu.gif"));
    JLabel imageLabel = new JLabel(picture);
    int WIDTH = 500;
    int HEIGHT =500;
    
     private ImageIcon icon;

	public FrontPage() { 
        Menu.setResizable(false);
        Menu.setSize(WIDTH, HEIGHT);
        Menu.setLayout(null);
        Menu.setLocationRelativeTo(null);
        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imageLabel.setSize(WIDTH, HEIGHT);
        imageLabel.setLayout(null);
       
        imageLabel.setVisible(true);
        Menu.setUndecorated( true );
        Menu.add(imageLabel);
        Menu.setVisible(true);
        Menu.getRootPane().setWindowDecorationStyle(1);
       
    }
      public void addicon()
    {
        icon=new ImageIcon(getClass().getResource("/textures/image.png"));
        Menu.setIconImage(icon.getImage());
    }
 
      
}