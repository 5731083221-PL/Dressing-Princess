package gameManager;

import java.awt.Font;

public class Setting {
	public static final int screenWidth = 1024;
	public static final int screenHeight = 768;
	public static boolean isPlaySound;
	public static final Font bigFont = new Font("Tahoma", Font.BOLD, 40);
	public static final Font storyFont = new Font("Tahoma", Font.PLAIN, 25);
	public static final Font inputFont = new Font("Tahoma", Font.PLAIN,20);
	public Setting(){
		isPlaySound = true;
	}
	public static boolean isPlaySound(){
		return isPlaySound;
	}public static void setPlaySound(boolean ans){
		isPlaySound = ans;
	}
}
