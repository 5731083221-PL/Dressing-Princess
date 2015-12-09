package scene;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import manager.GameManager;
import manager.Setting;

public class MiniGame extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton mode[];
	private JLabel banner;
	private JPanel center, screenAdjust[];

	public MiniGame() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		banner = new JLabel("Choose Playing Mode", SwingConstants.CENTER);
		banner.setFont(Setting.bigFont);
		mode = new JButton[3];
		mode[0] = new JButton("Easy");
		mode[1] = new JButton("Medium");
		mode[2] = new JButton("Hard");
		screenAdjust = new JPanel[4];
		for (int i = 0; i < 4; i++) {
			screenAdjust[i] = new JPanel();
		}
		screenAdjust[0].setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight / 8));
		screenAdjust[1].setPreferredSize(new Dimension(Setting.screenWidth / 8, Setting.screenHeight * 6 / 8));
		screenAdjust[2].setPreferredSize(new Dimension(Setting.screenWidth / 8, Setting.screenHeight * 6 / 8));
		screenAdjust[3].setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight / 8));
		center = new JPanel();
		center.setLayout(new GridLayout(3, 1));
		center.setPreferredSize(new Dimension(Setting.screenWidth * 6 / 8, Setting.screenHeight * 6 / 8));
		((GridLayout) center.getLayout()).setVgap(50);
		for (int i = 0; i < 3; i++) {
			mode[i].setFont(Setting.standardFont);
			center.add(mode[i]);
		}
		screenAdjust[0].add(banner);
		this.add(screenAdjust[0], BorderLayout.NORTH);
		this.add(screenAdjust[1], BorderLayout.WEST);
		this.add(screenAdjust[2], BorderLayout.EAST);
		this.add(screenAdjust[3], BorderLayout.SOUTH);
		this.add(center, BorderLayout.CENTER);
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
	}
}
