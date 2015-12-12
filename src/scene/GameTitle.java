package scene;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.Border;

import manager.GameManager;
import manager.Resource;
import manager.Setting;
import player.Player;

public class GameTitle extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField playerName;
	private JCheckBox playSound;
	private JButton startButton;
	private BufferedImage bg, button;
	private AudioClip bgm;

	public GameTitle() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		playerName = new JTextField() {
			private static final long serialVersionUID = 1L;

			@Override
			public void setBorder(Border border) {

			}
		};
		playerName.setFont(Setting.standardFont);
		playerName.setHorizontalAlignment(SwingConstants.CENTER);
		button = Resource.getBackgroundImage("img/Start Button.png");
		startButton = GameManager.createButton(button);
		startButton.setIcon(new ImageIcon(button));
		playSound = new JCheckBox("Play Sound", true);
		playSound.setFont(Setting.standardFont);
		bg = Resource.getBackgroundImage("img/GameTitle.png");
		bgm = Resource.getAudio("sound/bgm2.wav");
		bgm.play();
		playSound.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (playSound.isSelected()) {
					Setting.isPlaySound = true;
					bgm.play();
					
				} else {
					Setting.isPlaySound = false;
					bgm.stop();
				}

			}
		});

		this.add(playerName);
		playerName.setBounds(257, 550, 510, 30);
		playerName.setOpaque(false);
		this.add(startButton);
		startButton.setBounds(405, 620, button.getWidth(), button.getHeight());
		this.add(playSound);
		playSound.setBounds(10, 720, 130, 30);
		playSound.setOpaque(false);
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				startButton.setIcon(new ImageIcon(Resource.getBackgroundImage("img/Start Button (pressed).png")));
				if (playerName.getText().equals("")) {
					if(Setting.isPlaySound){
						Resource.getAudio("sound/wrong.wav").play();
					}
					JOptionPane.showMessageDialog(MainWindow.mainWindow, "Please enter your name", "Invalid name",
							JOptionPane.ERROR_MESSAGE);
					startButton.setIcon(new ImageIcon(button));
				} else {
					if(Setting.isPlaySound){
						bgm.stop();
						Resource.getAudio("sound/click.wav").play();
					}
					String in = playerName.getText();
					Player.setPlayerName(in);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					GameManager.newGame();
				}
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.clearRect(0, 0, 1024, 768);
		g.drawImage(bg, 0, 0, this);
	}

}
