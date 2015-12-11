package manager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

import java.applet.*;

public class Resource {
	private static BufferedImage bg;
	private static AudioClip bgm;
	private static AudioClip correct;
	private static AudioClip wrong;
	private static AudioClip click;
	private static ClassLoader cl = Resource.class.getClassLoader();
	/*static{
		try {
			bgm = Applet.newAudioClip((cl.getResource("bgm.wav")).toURI().toURL());
			correct = Applet.newAudioClip((cl.getResource("correrct.wav")).toURI().toURL());
			wrong = Applet.newAudioClip((cl.getResource("wrong.wav")).toURI().toURL());
			click = Applet.newAudioClip((cl.getResource("click.wav")).toURI().toURL());
		} catch (MalformedURLException | URISyntaxException e) {
			e.printStackTrace();
		}

	}*/
	public static BufferedImage getBackgroundImage(String directory){
		try{
			bg = ImageIO.read(cl.getResource(directory));
		}catch(IOException e){
			bg = null;
			e.printStackTrace();
		}
		return bg;
	}
	public static void playAudio(String name){
		if(name.equals("bgm")){
			bgm.loop();
		}
		else if(name.equals("correct")){
			correct.play();
		}
		else if(name.equals("wrong")){
			wrong.play();
		}
		else if(name.equals("click")){
			click.play();
		}
	}
	public static void stopAudio(String name){
		if(name.equals("bgm")){
			bgm.stop();
		}
		else if(name.equals("correct")){
			correct.stop();
		}
		else if(name.equals("wrong")){
			wrong.stop();
		}
		else if(name.equals("click")){
			click.stop();
		}
	}
}
