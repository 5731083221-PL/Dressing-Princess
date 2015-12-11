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

public class MainMap extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton shop, game;
	private String playerStatus;
	private BufferedImage bg,playButton,shopButton;
	
	public MainMap() {
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		this.setLayout(null);
		bg = Resource.getBackgroundImage("img/Background.png");
		playButton = Resource.getBackgroundImage("img/Play Button.png");
		shopButton = Resource.getBackgroundImage("img/Shop Button.png");
		game = new JButton();
		game.setIcon(new ImageIcon(playButton));
		game.setFont(Setting.bigFont);
		game.setOpaque(false);
		game.setContentAreaFilled(false);
		game.setBorderPainted(false);
		game.setBounds(229,103 , playButton.getWidth(), playButton.getHeight());
		shop = new JButton();
		shop.setIcon(new ImageIcon(shopButton));
		shop.setFont(Setting.bigFont);
		shop.setOpaque(false);
		shop.setContentAreaFilled(false);
		shop.setBorderPainted(false);
		shop.setBounds(512,103 , shopButton.getWidth(), shopButton.getHeight());
		playerStatus = "Hello "+Player.getPlayerName()+", Your score is "+Player.getScore();
		this.add(game);
		this.add(shop);
		
		game.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.runMiniGame();
				
			}
		});
		
	}
	@Override
	public void paintComponent(Graphics g){
		FontMetrics metrics = g.getFontMetrics(Setting.slimBigFont);
		Rectangle2D rect = metrics.getStringBounds(playerStatus, g);
		int x = (Setting.screenWidth - (int) rect.getWidth()) / 2;
		int y = 60;
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, null);
		g.setFont(Setting.slimBigFont);
		g.drawString(playerStatus, x,y );
	}
}
