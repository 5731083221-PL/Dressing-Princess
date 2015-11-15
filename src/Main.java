import java.awt.Dimension;

import javax.swing.JFrame;

import gameManager.Setting;
import scene.*;
public class Main {
	public static void main(String args[]){
		JFrame f = new JFrame("Dressing Princess");
		GameTitle gameTitle = new GameTitle();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		f.add(gameTitle);
		f.pack();
		f.setVisible(true);
	}
}
