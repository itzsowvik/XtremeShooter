package dev.xtremeshooter.handlers;
import dev.xtremeshooter.asset.*;
import dev.xtremeshooter.display.Display;
import dev.xtremeshooter.game.Game;
import dev.xtremeshooter.*;

public class CollisionHandler{
	PlayerHandler playerHandler;
	OppentHandler oppentHandler;
	Player player;
	Game game;
	private int playerWeaponPosX, playerWeaponPosY, playerWeaponSize, playerPosX, playerPosY, playerSize, 
				oppentSize, oppentPosX, oppentPosY, oppentWeaponPosX, oppentWeaponPosY, oppentWeaponSize, life = 4;
	public CollisionHandler(PlayerHandler playerHandler, OppentHandler oppentHandler, Player player){
		this.playerHandler= playerHandler;
		this.oppentHandler= oppentHandler;
		this.player= player;
		playerSize=Player.playerSize;
		oppentSize=Oppent.oppentSize;
		playerWeaponSize=PlayerWeapon.playerWeaponSize;
		oppentWeaponSize=OppentWeapon.oppentWeaponSize;
	 }
	public int tick() {
		for(int i=0; i<playerHandler.playerWeaponList.size(); i++) {
			for(int j=0; j<oppentHandler.oppentList.size(); j++) {
				playerWeaponPosX=playerHandler.playerWeaponList.get(i).getPosx();
				playerWeaponPosY=playerHandler.playerWeaponList.get(i).getPosy();
				oppentPosX=oppentHandler.oppentList.get(j).getPosx();
				oppentPosY=oppentHandler.oppentList.get(j).getPosy();
				
				if(playerWeaponPosX+playerWeaponSize>oppentPosX && oppentWeaponPosX<oppentPosX+oppentSize && oppentWeaponPosY<oppentPosY+oppentSize) {
					
					playerHandler.playerWeaponList.remove(i);
					
					oppentHandler.oppentList.remove(j);
					
					FileHandler.currentScore+=1;
					Display.Scorecard.setText("Score : "+FileHandler.currentScore);
					
						break;
					
					
				}
			}
		}
		
		playerPosX=player.getPosition();
		playerPosY=Game.height-player.playerSize;
		for(int i=0; i<oppentHandler.oppentWeaponList.size(); i++) {
			oppentWeaponPosX=oppentHandler.oppentWeaponList.get(i).getPosx();
			oppentWeaponPosY=oppentHandler.oppentWeaponList.get(i).getPosy();
			if(oppentWeaponPosX+oppentWeaponSize>playerPosX+6 && oppentWeaponPosX+6<playerPosX+playerSize && oppentWeaponPosY+oppentWeaponSize>playerPosY+6) {
					return 1;
		}
	}
		
		for(int i=0; i<oppentHandler.oppentList.size(); i++)
		{
			oppentPosX=oppentHandler.oppentList.get(i).getPosx();
			oppentPosY= oppentHandler.oppentList.get(i).getPosy();
			if(oppentPosY+oppentSize+6>playerPosY && oppentPosX+oppentSize>=playerPosX+6 && oppentPosX <=playerPosX+playerSize-6 ) {
				return 1;
			}
			
		}
		return 0;
	}
}
