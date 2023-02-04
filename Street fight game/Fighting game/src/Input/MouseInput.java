package Input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GameObjects.GameObject;
import GameObjects.Handler;
import GameObjects.ID;
import GameObjects.Player;

public class MouseInput extends MouseAdapter {
	
	
	private Handler handler;
	private Camera camera;
	public MouseInput(Camera camera,Handler handler) {
		
		this.camera = camera;
		this.handler = handler;
		
	}
	
	public void mousePressed(MouseEvent e) {
		
		
	
		
	}

}
