package Sound;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundHandler {
	
	
	

	static FloatControl gainControl;
	static Clip clip;
	
	
	public static void RunMusic(String path) {
		
		
		
		try {
			
			AudioInputStream inputstream = AudioSystem.getAudioInputStream(new File(path));
			clip = AudioSystem.getClip();
			clip.open(inputstream);
			clip.start();
			clip.loop(1);
			 gainControl = 
				    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(-20f);
			
			
		}catch(UnsupportedAudioFileException e) {
			
			e.printStackTrace();
			
		}catch(IOException e) {
			
			
			e.printStackTrace();
		}catch(LineUnavailableException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void setVolume(float volume) {
		
		 gainControl = 
				    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(volume);
		
	}

}
