package GameObjects;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class Handler {
	
	
	public List<GameObject>objects = new LinkedList<GameObject>();
	
	
	
	
	public void tick() {
		
		for(int i = 0;i<objects.size();i++) {
			
			GameObject temp = objects.get(i);
			temp.tick();
		}
		
	}
	
	
    public void render(Graphics g) {
		
		for(int i = 0;i<objects.size();i++) {
			
			GameObject temp = objects.get(i);
			temp.render(g);
		}
		
	}
    
    
    public void AddObject(GameObject g) {
    	
    	
    	objects.add(g);
    }
    
    public void RemoveObject(GameObject g) {
    	
    	
    	objects.remove(g);
    }


}
