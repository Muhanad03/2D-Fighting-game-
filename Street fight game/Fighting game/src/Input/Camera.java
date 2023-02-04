package Input;

import GameObjects.GameObject;
import GameObjects.ID;
import Main.Game;

public class Camera {
	
	
	private float x,y;
	
	

	public Camera(float x, float y) {
		
		this.x= x;
		this.y=y;
		
	}
	
	// Camera focus in an object such as player
	public void Focus(GameObject object) {
		
		x+= ((object.getX()-x)-700/2)*0.05f;
		y+= ((object.getY()-y)-563/2)*0.05f;
		
		int temp = 900;
		int temp2 = 1136;
		
		if(x<=0) x =0;
		if(x>=Game.WIDTH+ temp2) x =Game.WIDTH+temp2;
		if(y<=0) y=0;
		
		
		if(y>=Game.HEIGHT+temp) y = Game.HEIGHT+temp;
		
		
	}
	
	public void tick() {
		
		for(int i = 0;i<Game.handler.objects.size();i++) {
			
			
			GameObject temp = Game.handler.objects.get(i);
			
			if(temp.getId() == ID.Player) {
				
				Focus(temp);
			}
		}
		
		
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}


}
