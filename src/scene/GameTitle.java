package scene;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import gameManager.AudioUtility;
import gameManager.Setting;

public class GameTitle extends JPanel {
	private JPanel center, north, beauty0, beauty1, beauty2;
	private JButton start;
	private JCheckBox isPlaySound;
	private JTextField playerName;
	private JLabel title = new JLabel("Dressing Princess", SwingConstants.CENTER);
	private GridLayout g = new GridLayout(3, 1);

	public GameTitle() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		start = new JButton("Start");
		start.setFont(Setting.bigFont);
		title.setFont(Setting.bigFont);
		title.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight / 4));
		north = new JPanel();
		north.setLayout(new BorderLayout());
		north.add(title, BorderLayout.CENTER);
		playerName = new JTextField();
		playerName.setFont(Setting.inputFont);
		playerName.setText("Enter your name here");
		playerName.setHorizontalAlignment(JTextField.CENTER);
		isPlaySound = new JCheckBox("Play Sound");
		isPlaySound.setSelected(true);
		isPlaySound.setFont(Setting.storyFont);
		center = new JPanel();
		g.setVgap(50);
		center.setLayout(g);
		center.setPreferredSize(new Dimension(Setting.screenWidth/2, Setting.screenHeight/2));
		center.add(playerName);
		center.add(start);
		center.add(isPlaySound);
		this.add(title, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		beauty0 = new JPanel();
		beauty0.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight/4));
		this.add(beauty0, BorderLayout.SOUTH);
		beauty1 = new JPanel();
		beauty1.setPreferredSize(new Dimension(256, 384));
		this.add(beauty1, BorderLayout.WEST);
		beauty2 = new JPanel();
		beauty2.setPreferredSize(new Dimension(256, 384));
		this.add(beauty2, BorderLayout.EAST);
		AudioUtility.playSound("bgm");
		isPlaySound.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isPlaySound.isSelected()){
					Setting.setPlaySound(true);
					AudioUtility.playSound("bgm");
				}
				else{
					Setting.setPlaySound(false);
					AudioUtility.stopSound();
				}
				
			}
		});
	}
}
