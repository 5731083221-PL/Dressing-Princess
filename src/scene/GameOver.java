package scene;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.*;

import manager.GameManager;
import manager.Resource;
import manager.Setting;
import player.Player;

public class GameOver extends JPanel {

	private static final long serialVersionUID = 1L;
	private int scoreFromGame;
	private JButton ok;
	private BufferedImage bg, okButton;

	public GameOver(int score) {
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		this.setLayout(null);
		bg = Resource.getBackgroundImage("img/background.png");
		okButton = Resource.getBackgroundImage("img/OK Button.png");
		scoreFromGame = score;
		ok = GameManager.createButton(okButton);
		ok.setBounds((Setting.screenWidth - okButton.getWidth()) / 2, 400, okButton.getWidth(), okButton.getHeight());
		this.add(ok);
		if(Setting.isPlaySound){
			Resource.playMainBGM();
		}
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Setting.isPlaySound){
					Resource.getAudio("sound/click.png").play();
				}
				ok.setIcon(new ImageIcon(Resource.getBackgroundImage("img/OK Button (pressed).png")));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				GameManager.runGame();

			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, null);
		// draw Game Over message
		FontMetrics metrics = g.getFontMetrics(Setting.bigFont);
		Rectangle2D rect = metrics.getStringBounds("Game Over", g);
		int x = (Setting.screenWidth - (int) rect.getWidth()) / 2;
		int y = 60;
		g.setFont(Setting.bigFont);
		g.drawString("Game Over", x, y);
		// draw result
		g.setFont(Setting.slimBigFont);
		g.drawString("Your Scorll is : " + scoreFromGame, 362, 200);
		g.drawString("Total Score    : " + Player.getScore(), 362, 300);
	}

}
