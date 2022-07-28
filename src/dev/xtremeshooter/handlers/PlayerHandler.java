package dev.xtremeshooter.handlers;

import java.util.ArrayList;

import dev.xtremeshooter.asset.Player;
import dev.xtremeshooter.asset.PlayerWeapon;
import dev.xtremeshooter.game.Game;

public class PlayerHandler{
	
	private Player player;
	private PlayerWeapon playerWeapon;
	private int newPlayerWeaponCreate=0;

	ArrayList<PlayerWeapon> playerWeaponList = new ArrayList<>();
	
	public void tick() {
		for(int i=0; i<playerWeaponList.size(); i++) {
			playerWeaponList.get(i).tick();
			if(playerWeaponList.get(i).getPosy()<-4)
				playerWeaponList.remove(i);
		}
		newPlayerWeaponCreate++;
		Game.key.tick();
		if(Game.key.left) Game.player.setPosition(-3);
		if(Game.key.right) Game.player.setPosition(3);
		if(newPlayerWeaponCreate>=10) {
			createOppnetWeapon(Game.player.getPosition()+player.playerSize/2-playerWeapon.playerWeaponSize/2, Game.height-player.playerSize);
			newPlayerWeaponCreate=0;
		}
	}
	public void render() {
		Game.g.drawImage(Game.Phero, Game.player.getPosition(), Game.height-Player.playerSize,Player.playerSize ,Player.playerSize,null);
		for(int i=0; i<playerWeaponList.size(); i++)
			Game.g.drawImage(Game.Phshot, playerWeaponList.get(i).getPosx(), playerWeaponList.get(i).getPosy(), playerWeapon.playerWeaponSize, playerWeapon.playerWeaponSize, null);
	}
	
	private void createOppnetWeapon(int posx, int posy) {
		playerWeapon = new PlayerWeapon(posx, posy);
		playerWeaponList.add(playerWeapon);
	}
}
