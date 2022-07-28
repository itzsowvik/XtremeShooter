/*
 * In Game, I've to work with life
 */
package dev.xtremeshooter.game;

import java.awt.Graphics;
//import java.awt.RenderingHints.Key;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

import dev.xtremeshooter.asset.Player;
import dev.xtremeshooter.display.Display;
import dev.xtremeshooter.frontend.MainMenu;
import dev.xtremeshooter.gfx.ImageLoader;
import dev.xtremeshooter.handlers.CollisionHandler;
import dev.xtremeshooter.handlers.FileHandler;
import dev.xtremeshooter.handlers.OppentHandler;
import dev.xtremeshooter.handlers.PlayerHandler;
//import sun.util.resources.cldr.ts.CurrencyNames_ts;
import dev.xtremeshooter.handlers.*;

public class Game implements Runnable{
	public static final String Player = null;
	private String title;
	public static int width, height;
	public static Graphics g;
	private BufferStrategy bs;
	private Display display;
	public static Key key;
	private boolean running = false;
	public static BufferedImage Phero, Penemy, Phshot, Peshot, backGround, blast;
	public static Player player;
	public int w=0;
	OppentHandler oppentHandler;
	PlayerHandler playerHandler;
	CollisionHandler collisionHandler;
	FileHandler fileHandler;
	
	int tempX, tempY;
	
	int life = 4;
	
	static Thread thread;
	public Game(String title, int width, int height){
		this.title=title;
		this.width= width;
		this.height=height;
		Phero = ImageLoader.loadImage("/textures/playerImage.png");
		Penemy = ImageLoader.loadImage("/textures/enemy2.gif");
		Phshot = ImageLoader.loadImage("/textures/weapon.png");
		Peshot = ImageLoader.loadImage("/textures/enemyroc.png");
		backGround= ImageLoader.loadImage("/textures/back.png");
	}
	
	public void init(){
		key = new Key();
		display = new Display(title, width, height);
		display.getframe().addKeyListener(key);
		player = new Player();
		oppentHandler = new OppentHandler();
		playerHandler = new PlayerHandler();
		collisionHandler = new CollisionHandler(playerHandler, oppentHandler, player);
		fileHandler = new FileHandler();
		
	}
	
	void stopper() {
		 display.frame.dispose();
     	new MainMenu();
         //break;
	}
	
	void starter() {
		
		Game gm = new Game("Xtreme Shooter", 400, 400);
		
		gm.start();
		 
			life--;
		
		
	} 
	public void tick() {
		oppentHandler.tick();
		playerHandler.tick();
		
	}
	public void collision() {
		 w=collisionHandler.tick();
		 
	}
	public OppentHandler getOppentHandler() {
		return oppentHandler;
	}

	public PlayerHandler getPlayerHandler() {
		return playerHandler;
	}

	public void render() {
		bs = display.canvas.getBufferStrategy();
        if(bs == null)
        {
            display.canvas.createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        g.drawImage(backGround, 0, 0, width, height, null);
        playerHandler.render();
        oppentHandler.render();
		bs.show();
		g.dispose();	
	}
	public void run() {
		init();
		int fps=60;
        double timePerTick=1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer =0;
        int ticks = 0;
        int z=0;
		while(true) {
			now= System.nanoTime();
            delta+=(now-lastTime)/timePerTick;
            timer+=now-lastTime;
            lastTime= now;
            if(delta>=1) {
            	tick();
            	collision();
            	if(w==1)
            	{
                   //System.out.println(life);
            	int previoushighScore=fileHandler.readFile();
          
            	if(previoushighScore<fileHandler.currentScore)
            	{
            	    fileHandler.write(fileHandler.currentScore);
            	}
            	
            	
            	
            	if(life > 0) {
            		
            		//life--;
            		
            		starter();
            		
            		//System.out.println(life);
            		
            		break;
            	}
            	else { 
            		
            		stopper();
            		break;
            	}
            		
               
            }
            	render();
            	delta=0;
            }
		}
		
	}
	

	
	public synchronized void start() {
		if(running)
			return ;
		running = true;
		thread= new Thread(this);
		thread.start();
	}
	public  synchronized void stop() {
		if(!running)
			return;
		running = false;
		 
		display.exitFrame(); 
		new MainMenu();
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main Menu");
		
		
	}
	
	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}
	public Player getPlayer() {
		return this.player;
	}
	
}
