//Sowvik

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import dev.xtremeshooter.game.Game;

public class Oppent {
	private int posx, posy;
	public static final int oppentSize=30;
	private int last;
	private Random rand = new Random();

	
	public Oppent(){
		posy=-oppentSize;
		posx= rand.nextInt(Game.width-oppentSize+1);
		last=50;
	}
	public void tick() {
		posy+=1;
		last++;
		
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getPosx() {
		return posx;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	public int getPosy() {
		return posy;
	}
	public void setPosy(int posy) {
		this.posy = posy;
	}
}