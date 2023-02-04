package SpriteTools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	
	private BufferedImage image;
	
	
	public BufferedImage Load(String path) {
		
		
		try {
			
			image = ImageIO.read(getClass().getResource(path));
			
			
		}catch(IOException e) {
			
			e.printStackTrace();
		
		
		}
		
		
		return image;
		
	}


	

}
