package GameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Input.KeyInput;
import Sound.SoundHandler;
import SpriteTools.BufferedImageLoader;
import SpriteTools.SpriteSheet;

public class Player extends GameObject {

	public static int ammo;
	public static int speed = 5;
	private  SpriteSheet WalkingSpriteSheet = new SpriteSheet(new BufferedImageLoader().Load("/Sprites/GIRL_WALKING.png"));
	private  SpriteSheet RunningSpriteSheet = new SpriteSheet(new BufferedImageLoader().Load("/Sprites/GIRL_RUNNING.png"));
	private  SpriteSheet IdleSpriteSheet = new SpriteSheet(new BufferedImageLoader().Load("/Sprites/GIRL_IDLE.png"));
	private int spriteCounter = 0;
	private int spriteNo = 1;
	private String Direction = "DOWN";


	public Player(int x, int y, ID id) {
		super(x,y,id);
		

		
	}


	@Override
	public void tick() {
		
		x+=VelX;
		y+=VelY;
		
		
		
		
		if(KeyInput.UP == true && !KeyInput.RIGHT && !KeyInput.LEFT) {VelY = -speed; Direction = "UP";}
		else if(!KeyInput.DOWN == true) {VelY = 0;}
		if(KeyInput.DOWN == true && !KeyInput.RIGHT && !KeyInput.LEFT) {VelY = speed; Direction = "DOWN";}
		else if(!KeyInput.UP == true) {VelY = 0;}
		if(KeyInput.LEFT == true &&!KeyInput.RIGHT) {VelX = -speed;Direction = "LEFT";}
		else if(!KeyInput.RIGHT == true) {VelX = 0;}
		if(KeyInput.RIGHT == true &&!KeyInput.LEFT) {VelX = speed;Direction = "RIGHT";}
		else if(!KeyInput.LEFT == true) {VelX = 0;}
		
		
		spriteCounter++;
		
		if(spriteCounter >6) {
			
			if(spriteNo<10) {
				spriteNo++;
				
			}
			else if(spriteNo == 10) {
				
				spriteNo = 1;
				
			}
			
			if(spriteNo2<8) {
				
				spriteNo2++;
			}
			
			else if(spriteNo2 == 8) {
				
				spriteNo2 = 1;
				
			}
			
			
			spriteCounter =0;
			
		}
		
	
	
	
		
	}
	
	SpriteSheet current = IdleSpriteSheet;
	int Col = 1;
	int Row =1;
	int spriteNo2 = 1;
	
	

	@Override
	public void render(Graphics g) {
		
		
		
	//Slow walking animation	
		if(!KeyInput.LSHIFT) {
			
			speed =5;
			if(KeyInput.DOWN && !KeyInput.RIGHT && !KeyInput.LEFT) {
				
				current = WalkingSpriteSheet;
				
				Col =1;
				
				Row = 2*spriteNo - 1;
				
			}
			 if(KeyInput.LEFT&&!KeyInput.RIGHT) {
				current = WalkingSpriteSheet;
				
				Col =5;
				
				Row = 2*spriteNo - 1;
				
			}
			 if(KeyInput.RIGHT&&!KeyInput.LEFT) {
				current = WalkingSpriteSheet;
				
				Col =9;
				
				Row = 2*spriteNo - 1;
				
			}
			 if(KeyInput.UP && !KeyInput.RIGHT && !KeyInput.LEFT) {
				current = WalkingSpriteSheet;
				Col =13;
				
				Row = 2*spriteNo - 1;
				
			}
			
		}
		
		
		if(KeyInput.LSHIFT) {
			
			
			speed = 10;
			current = RunningSpriteSheet;
			
					
			
			if(KeyInput.DOWN && !KeyInput.RIGHT && !KeyInput.LEFT) {
				
				
				
				if(spriteNo2<8) {
					 
					 Col = 1;
					 Row = 2*spriteNo2 - 1;
				 }
				
			}
			 if(KeyInput.LEFT&&!KeyInput.RIGHT) {
				
				
				 if(spriteNo2<8) {
					 
					 Col = 5;
					 Row = 2*spriteNo2 - 1;
				 }
				
			}
			 if(KeyInput.RIGHT&&!KeyInput.LEFT) {
				
				
				 if(spriteNo2<8) {
					 
					 Col = 9;
					 Row = 2*spriteNo2 - 1;
				 }
				
			}
			 if(KeyInput.UP && !KeyInput.RIGHT && !KeyInput.LEFT) {
				
				 if(spriteNo2<8) {
					 
					 Col = 13;
					 Row = 2*spriteNo2 - 1;
				 }
			}
			
			
			
		}
		
		
		
		/////////////////////////////
		 
		
		 if(!KeyInput.DOWN&&!KeyInput.UP&&!KeyInput.LEFT&&!KeyInput.RIGHT) {
			 
			 current = IdleSpriteSheet;
			
			 if (Direction == "DOWN") {
				 
				 
				 if(spriteNo2<8) {
					 
					 Col = 1;
					 Row = 2*spriteNo2 - 1;
				 }
				 
				 
			 }
			 else if (Direction == "LEFT") {
				 
				 
				 if(spriteNo2<8) {
					 
					 Col = 5;
					 Row = 2*spriteNo2 - 1;
				 }
				 
				 
			 }
			 else if (Direction == "RIGHT") {
				 
				 
				 if(spriteNo2<8) {
					 
					 Col = 9;
					 Row = 2*spriteNo2 - 1;
				 }
				 
				 
			 }
			 else if (Direction == "UP") {
				 
				 
				 if(spriteNo2<8) {
					 
					 Col = 13;
					 Row = 2*spriteNo2 - 1;
				 }
				 
				 
			 }
			 
			 
			 
		 }
		 
		 

		 
		
		
		Graphics2D g2d = (Graphics2D)g;
		
		try {
			
			g2d.drawImage(current.grabImage(Row, Col, 64, 128),x,y,128,256,null);
		}catch(Exception e) {
			
			
			e.printStackTrace();
			
		}
		
		
		
		
		
	}

	@Override
	public Rectangle getBounds() {
		
		return null;
	}

}
