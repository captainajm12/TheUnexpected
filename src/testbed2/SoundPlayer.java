package testbed2;

/**
 It's important to note that most of this code was not written by me it was written by
 another user on Stack Overflow.
**/
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class SoundPlayer{
	   // Constructor for class
	   public SoundPlayer() {
		  JOptionPane.showMessageDialog(null, "It's not like there's some sort of Inquisition.","Message", JOptionPane.ERROR_MESSAGE);
		  //^displays an error box 
		  
	      // You could also get the sound file with a URL
	      File soundFile = new File("/home/anthonym/workspace/testbed2/TheSpanishInquisition.wav");
	      try ( // Open an audio input stream.            
	            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);            
	            // Get a sound clip resource.
	            Clip clip = AudioSystem.getClip()) {
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         clip.start();
	         
	         Thread.sleep(clip.getMicrosecondLength()/1000);
	         //So the sound has time to play
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      } catch (InterruptedException e) {
			e.printStackTrace();
		}
	   }
	}
