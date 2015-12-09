package scene;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import manager.GameManager;
import manager.Setting;
import player.Player;

public class MainMap extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton shop, game;
	private JLabel playerStatus;
	private JPanel center, screenAdjust[];
	public MainMap() {
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		this.setLayout(new BorderLayout());
		center = new JPanel();
		center.setLayout(new GridLayout(1, 2));
		center.setPreferredSize(new Dimension(Setting.screenWidth*6/8, Setting.screenHeight*6/8));
		screenAdjust = new JPanel[4];
		for(int i=0;i<4;i++){
			screenAdjust[i] = new JPanel();		
		}
		screenAdjust[0].setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight/8));
		screenAdjust[1].setPreferredSize(new Dimension(Setting.screenWidth/8, Setting.screenHeight*6/8));
		screenAdjust[2].setPreferredSize(new Dimension(Setting.screenWidth/8, Setting.screenHeight*6/8));
		screenAdjust[3].setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight/8));
		game = new JButton("Let's Play");
		game.setFont(Setting.bigFont);
		shop = new JButton("Shop");
		shop.setFont(Setting.bigFont);
		playerStatus = new JLabel("Hello "+Player.getPlayerName()+", Your score is "+Player.getScore(),SwingConstants.CENTER);
		playerStatus.setFont(Setting.standardFont);
		screenAdjust[0].add(playerStatus);
		center.add(game);
		center.add(shop);
		this.add(screenAdjust[0], BorderLayout.NORTH);
		this.add(screenAdjust[1], BorderLayout.WEST);
		this.add(screenAdjust[2], BorderLayout.EAST);
		this.add(screenAdjust[3], BorderLayout.SOUTH);
		this.add(center, BorderLayout.CENTER);
		game.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.runMiniGame();
				
			}
		});
		
	}
}
