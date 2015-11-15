package gameManager;

import java.applet.Applet;
import java.applet.AudioClip;

public class AudioUtility {
	private static ClassLoader loader = AudioUtility.class.getClassLoader();
	private static AudioClip bgm;
	private static AudioClip correct;
	private static AudioClip wrong;
	private static AudioClip timeOut;
	private static AudioClip changeScene;

	static {
		try {
			bgm = Applet.newAudioClip(loader.getResource("res/sound/bgm.wav"));
			correct = Applet.newAudioClip(loader.getResource("res/sound/correct.wav"));
			wrong = Applet.newAudioClip(loader.getResource("res/sound/wrong.wav"));
			timeOut = Applet.newAudioClip(loader.getResource("res/sound/timeOut.wav"));
			changeScene = Applet.newAudioClip(loader.getResource("res/sound/change.wav"));
		} catch (Exception e) {
			e.printStackTrace();
			bgm = null;
			correct = null;
			wrong = null;
			timeOut = null;
			changeScene = null;
		}

	}
	public static void playSound(String name){
		if(name.equalsIgnoreCase("bgm")){
			bgm.play();
		}
		else if(name.equalsIgnoreCase("correct")){
			correct.play();
		}else if(name.equalsIgnoreCase("wrong")){
			wrong.play();
		}else if(name.equalsIgnoreCase("timeOut")){
			timeOut.play();
		}else{
			changeScene.play();
		}
	}
	public static void stopSound(){
		bgm.stop();
	}
}
