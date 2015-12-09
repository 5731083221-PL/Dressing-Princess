package scene;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import manager.GameManager;
import manager.Setting;
import player.Player;

public class GameOver extends JPanel {

	private static final long serialVersionUID = 1L;
	private int scoreFromGame;
	private JPanel center, screenAdjust[];
	private JButton ok;
	private JLabel scoreLastGame,totalScore, banner;
	public GameOver(int score){
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		this.setLayout(new BorderLayout());
		scoreFromGame = score;
		center = new JPanel();
		center.setLayout(new GridLayout(3, 1));
		center.setPreferredSize(new Dimension(Setting.screenWidth /2, Setting.screenHeight /2));
		ok = new JButton("OK!");
		ok.setFont(Setting.bigFont);
		banner = new JLabel("Game Over",SwingConstants.CENTER);
		banner.setFont(Setting.bigFont);
		scoreLastGame = new JLabel("You got score = "+scoreFromGame,SwingConstants.CENTER);
		scoreLastGame.setFont(Setting.slimBigFont);
		totalScore = new JLabel("Your total score = "+Player.getScore(),SwingConstants.CENTER);
		totalScore.setFont(Setting.slimBigFont);
		center.add(scoreLastGame);
		center.add(totalScore);
		center.add(ok);
		screenAdjust = new JPanel[4];
		for (int i = 0; i < 4; i++) {
			screenAdjust[i] = new JPanel();
		}
		screenAdjust[0].setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight / 4));
		screenAdjust[0].add(banner);
		screenAdjust[1].setPreferredSize(new Dimension(Setting.screenWidth / 4, Setting.screenHeight  / 2));
		screenAdjust[2].setPreferredSize(new Dimension(Setting.screenWidth / 4, Setting.screenHeight  / 2));
		screenAdjust[3].setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight / 4));
		this.add(screenAdjust[0], BorderLayout.NORTH);
		this.add(screenAdjust[1], BorderLayout.WEST);
		this.add(screenAdjust[2], BorderLayout.EAST);
		this.add(screenAdjust[3], BorderLayout.SOUTH);
		this.add(center, BorderLayout.CENTER);
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.runGame();
				
			}
		});
	}

}
