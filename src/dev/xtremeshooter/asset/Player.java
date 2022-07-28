package dev.xtremeshooter.asset;

import dev.xtremeshooter.game.Game;

public class Player{

	private int position;
	public static final int playerSize=30;
	public Player(){
		position= Game.width/2-Player.playerSize/2;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position += position;
		if(this.position<0) 
			this.position=0;
		if(this.position>Game.width-Player.playerSize) 
			this.position=Game.width-Player.playerSize;
	}
}
