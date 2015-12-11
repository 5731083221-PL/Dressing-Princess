package manager;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

import java.applet.*;

public class Resource {
	private static BufferedImage bg;
	private static AudioClip sound;
	private static AudioClip mainBGM;
	private static ClassLoader cl = Resource.class.getClassLoader();
	public static BufferedImage getBackgroundImage(String directory){
		try{
			bg = ImageIO.read(cl.getResource(directory));
		}catch(IOException e){
			bg = null;
			e.printStackTrace();
		}
		return bg;
	}
	public static AudioClip getAudio(String directory){
		try {
			sound = Applet.newAudioClip(cl.getResource(directory).toURI().toURL());
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sound = null;
		}
		return sound;
	}
	
	public static void playMainBGM(){
		try {
			mainBGM = Applet.newAudioClip(cl.getResource("sound/bgm1.wav").toURI().toURL());
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mainBGM = null;
		}
		mainBGM.play();
	}
	public static void stopMainBGM(){
		mainBGM.stop();
	}
	
}
