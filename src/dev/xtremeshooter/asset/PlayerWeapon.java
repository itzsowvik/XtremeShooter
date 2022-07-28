package dev.xtremeshooter.asset;

public class PlayerWeapon {
	private int posx, posy;
	public static final int playerWeaponSize=10;
	
	
	public PlayerWeapon(int posx, int posy){
		
		this.posx=posx;
		this.posy=posy;
	}
	
	public void tick() {
		posy-=4;
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