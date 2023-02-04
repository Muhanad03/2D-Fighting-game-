package Main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	
	
	
	public Window(int Width,int Height,String Title, Game game) {
		
		
		
		JFrame frame = new JFrame(Title);
		frame.setMaximumSize(new Dimension(Width,Height));
		frame.setMinimumSize(new Dimension(Width,Height));
		
		
		frame.add(game);
		frame.setResizable(false);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//frame.setUndecorated(true);
		frame.setVisible(true);
		
		frame.requestFocus();
		
		game.Start();
		
		
		
		
		
	}

}
