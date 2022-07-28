package dev.xtremeshooter.asset;

public class OppentWeapon{
	private int posx, posy;
	public static final int oppentWeaponSize=10;
	public OppentWeapon(int posx, int posy){
		this.posx=posx;
		this.posy=posy;
	}
	
	public void tick() {
		posy+=2;
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
	