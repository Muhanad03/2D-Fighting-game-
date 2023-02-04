package GameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	

	protected int x,y;
	protected ID id;
	protected int VelX,VelY;
	
	
	public GameObject(int x ,int y,ID id) {
		
		this.x = x;
		this.y=y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
	public abstract Rectangle getBounds();
	

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public ID getId() {
		return id;
	}


	public void setId(ID id) {
		this.id = id;
	}


	public int getVelX() {
		return VelX;
	}


	public void setVelX(int velX) {
		VelX = velX;
	}


	public int getVelY() {
		return VelY;
	}


	public void setVelY(int velY) {
		VelY = velY;
	}


}
