package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import GameObjects.Handler;
import GameObjects.ID;
import GameObjects.Player;
import Input.Camera;
import Input.KeyInput;

public class Game extends Canvas implements Runnable{
	
	
	public static final int WIDTH = 1024,HEIGHT = WIDTH/12*9;
	private Thread thread;
	private boolean running = false;
	public static Handler handler = new Handler();
	private Camera camera  = new Camera(0,0);
	public static int Frames = 0;
	
	
	
	public Game() {
		
		new Window(WIDTH,HEIGHT,"Window",this);
		this.addKeyListener(new KeyInput());
		handler.AddObject(new Player(0,0,ID.Player));
	
		

		
		
		
	}
	
	
	public static void main(String[] args) {
		
		new Game();
		
	}

	@Override
	public void run() {
		
		long LastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double delta = 0;
		long timer = System.currentTimeMillis();
		double ns = 1000000000/amountOfTicks;
		int frames = 0;
		
		
		
		while(running == true) {
			
			
			
			long now = System.nanoTime();
			
			delta+=(now-LastTime)/ns;
			
			LastTime = now;
			
			while(delta>=1) {
				
				
				tick();
				delta --;
				
			}
			
			if(running == true) {
				
				render();
				frames++;
			}
			
			
			try {
				
				
				thread.sleep((int)(delta*1000/60),0);
				
			}catch(Exception e) {
				
				e.printStackTrace();
			
			}
			
			
			
			if(System.currentTimeMillis()-timer>1000) {
				
				
				timer+=1000;
				System.out.println("FPS: "+frames);
				Frames = frames;
				frames = 0;
				
			}
		}
		
		Stop();
		
		
	}
	
	
	public synchronized void Start() {
		
		thread = new Thread(this);
		thread.start();
		running = true;
	
		
	}
	
	
	public synchronized void Stop() {
		
		try {
			
			thread.join();
			running = false;
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	private void tick() {
		
		
		handler.tick();
		
		
	}
	private void render() {
		
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			
			this.createBufferStrategy(3);
			return;
			
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.translate(-camera.getX(), -camera.getY());
		
	
		
		handler.render(g);
		g2d.setColor(Color.white);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
		g2d.drawString("FPS: "+Integer.toString(Frames), 0, 30);
		
		
		//level.renderTiles(g);
		
		g2d.translate(camera.getX(), camera.getY());
		
		g.dispose();
		bs.show();
		
		
		
	}
	
	
	
	
	
	

}
