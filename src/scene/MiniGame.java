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
	private JButton mode[], back;
	private BufferedImage modeButton[], bg, backButton;
	public MiniGame() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		modeButton = new BufferedImage[3];
		modeButton[0] = Resource.getBackgroundImage("img/Easy Button.png");
		modeButton[1] = Resource.getBackgroundImage("img/Medium Button.png");
		modeButton[2] = Resource.getBackgroundImage("img/Hard Button.png");
		bg = Resource.getBackgroundImage("img/Background.png");
		backButton = Resource.getBackgroundImage("img/Back.png");
		back = GameManager.createButton(backButton);
		back.setBounds(10, 650, backButton.getWidth(), backButton.getHeight());
		this.add(back);
		mode = new JButton[3];
		for (int i = 0; i < 3; i++) {
			mode[i] = GameManager.createButton(modeButton[i]);
			this.add(mode[i]);
		}
		mode[0].setBounds(273, 100, modeButton[0].getWidth(), modeButton[0].getHeight());
		mode[1].setBounds(273, 323, modeButton[1].getWidth(), modeButton[1].getHeight());
		mode[2].setBounds(273, 546, modeButton[2].getWidth(), modeButton[2].getHeight());
		mode[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Setting.isPlaySound){
					Resource.getAudio("sound/click.wav").play();
					Resource.stopMainBGM();
				}
				mode[0].setIcon(new ImageIcon(Resource.getBackgroundImage("img/Easy Button (pressed).png")));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				GameManager.playGame("easy");

			}
		});
		mode[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Setting.isPlaySound){
					Resource.getAudio("sound/click.wav").play();
					Resource.stopMainBGM();
				}
				mode[1].setIcon(new ImageIcon(Resource.getBackgroundImage("img/Medium Button (pressed).png")));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				GameManager.playGame("medium");

			}
		});
		mode[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Setting.isPlaySound){
					Resource.getAudio("sound/click.wav").play();
					Resource.stopMainBGM();
				}
				mode[2].setIcon(new ImageIcon(Resource.getBackgroundImage("img/Hard Button (pressed).png")));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				GameManager.playGame("hard");

			}
		});
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Thread.sleep(100);
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
		FontMetrics metrics = g.getFontMetrics(Setting.bigFont);
		Rectangle2D rect = metrics.getStringBounds("Choose Playing Mode", g);
		int x = (Setting.screenWidth - (int) rect.getWidth()) / 2;
		int y = 60;
		g.setFont(Setting.bigFont);
		g.drawString("Choose Playing Mode", x, y);
	}
}
