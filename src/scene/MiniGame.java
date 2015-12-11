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

public class MiniGame extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton mode[],back;
	private BufferedImage modeButton[],bg,backButton;

	public MiniGame() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		modeButton = new BufferedImage[3];
		modeButton[0] = Resource.getBackgroundImage("img/Easy Button.png");
		modeButton[1] = Resource.getBackgroundImage("img/Medium Button.png");
		modeButton[2] = Resource.getBackgroundImage("img/Hard Button.png");
		bg = Resource.getBackgroundImage("img/Background.png");
		backButton = Resource.getBackgroundImage("img/Back.png");
		back = new JButton();
		back.setIcon(new ImageIcon(backButton));
		back.setOpaque(false);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setBounds(10, 650, backButton.getWidth(), backButton.getHeight());
		this.add(back);
		mode = new JButton[3];
		mode[0] = new JButton();
		mode[1] = new JButton();
		mode[2] = new JButton();
		mode[0].setBounds(273, 100, modeButton[0].getWidth(), modeButton[0].getHeight());
		mode[1].setBounds(273, 323, modeButton[1].getWidth(), modeButton[1].getHeight());
		mode[2].setBounds(273, 546, modeButton[2].getWidth(), modeButton[2].getHeight());
		for(int i=0;i<3;i++){
			mode[i].setIcon(new ImageIcon(modeButton[i]));
			mode[i].setOpaque(false);
			mode[i].setContentAreaFilled(false);
			mode[i].setBorderPainted(false);
			this.add(mode[i]);
		}
		
		mode[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.playGame("easy");

			}
		});
		mode[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.playGame("medium");

			}
		});
		mode[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.playGame("hard");

			}
		});
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.runGame();
				
			}
		});
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, null);
		FontMetrics metrics = g.getFontMetrics(Setting.bigFont);
		Rectangle2D rect = metrics.getStringBounds("Choose Playing Mode", g);
		int x = (Setting.screenWidth - (int) rect.getWidth()) / 2;
		int y = 60;
		g.setFont(Setting.bigFont);
		g.drawString("Choose Playing Mode", x,y );
	}
}
