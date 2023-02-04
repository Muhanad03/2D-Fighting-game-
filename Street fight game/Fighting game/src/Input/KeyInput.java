package Input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	
	public static boolean UP,DOWN,LEFT,RIGHT,LSHIFT;
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) UP =true ;
		if(key == KeyEvent.VK_S) DOWN =true;
		if(key == KeyEvent.VK_A) LEFT =true;
		if(key == KeyEvent.VK_D) RIGHT =true;
		if(key == KeyEvent.VK_SHIFT) LSHIFT = true;
		
		
	}
	public void keyReleased(KeyEvent e) {
		
        int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) UP = false;
		if(key == KeyEvent.VK_S) DOWN = false;
		if(key == KeyEvent.VK_A) LEFT = false;
		if(key == KeyEvent.VK_D) RIGHT = false;
		if(key == KeyEvent.VK_SHIFT) LSHIFT = false;
		
	}
}
