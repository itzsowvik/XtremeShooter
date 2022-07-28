package dev.xtremeshooter.handlers;
import java.util.ArrayList;

import dev.xtremeshooter.asset.Oppent;
import dev.xtremeshooter.asset.OppentWeapon;
import dev.xtremeshooter.game.Game;

public class OppentHandler{

	private Oppent oppent;
	private OppentWeapon oppentWeapon;
	private int newOppentCreate=0;
	ArrayList<Oppent> oppentList = new ArrayList<>();
	ArrayList<OppentWeapon> oppentWeaponList = new ArrayList<>();

	public void tick() {
		for(int i=0; i<oppentList.size(); i++) {
			oppentList.get(i).tick();
			if(oppentList.get(i).getPosy()>Game.height)
				oppentList.remove(i);
		}
		
		newOppentCreate++;
		if(newOppentCreate>=30) {
			createNewOppent();
			newOppentCreate=0;
		}
		
		for(int i=0; i<oppentWeaponList.size(); i++) {
			oppentWeaponList.get(i).tick();
			if(oppentWeaponList.get(i).getPosy()>Game.height)
				oppentWeaponList.remove(i);
		}
		
		for(int i=0; i<oppentList.size(); i++) {
			if(oppentList.get(i).getLast()>=100 && oppentList.get(i).getPosy()<Game.height-Oppent.oppentSize) {
				createNewOppentWeapon(oppentList.get(i).getPosx()+oppent.oppentSize/2-oppentWeapon.oppentWeaponSize/2, oppentList.get(i).getPosy()+oppent.oppentSize);
				oppentList.get(i).setLast(0);
				
			}
		}
		
	}
	
	public void render() {
		for(int i=0; i<oppentList.size(); i++)
			Game.g.drawImage(Game.Penemy,oppentList.get(i).getPosx(), oppentList.get(i).getPosy(), oppent.oppentSize, oppent.oppentSize, null);
		for(int i=0; i<oppentWeaponList.size(); i++) {
			Game.g.drawImage(Game.Peshot, oppentWeaponList.get(i).getPosx(), oppentWeaponList.get(i).getPosy(),oppentWeapon.oppentWeaponSize, oppentWeapon.oppentWeaponSize, null);
		}
	}
	
	private void createNewOppent() {
		oppent = new Oppent();
		oppentList.add(oppent);
	}
	private void createNewOppentWeapon(int newEnemyPosX, int newEnemyPosY) {
		oppentWeapon= new OppentWeapon(newEnemyPosX, newEnemyPosY);
		oppentWeaponList.add(oppentWeapon);
	}
}
