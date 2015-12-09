package scene;

import java.awt.*;
import javax.swing.*;

import manager.Setting;
import player.Player;

public class PlayWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	private MiniGameLogic logic;
	private JLabel question, banner, scorebar;
	private JButton answer;
	private JTextField answerArea;
	private JPanel north, center, south, screenAdjust[];
	private String scoreStatus;

	public PlayWindow(String mode) {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		logic = new MiniGameLogic(mode);
		banner = new JLabel("Answer The Question", SwingConstants.CENTER);
		banner.setFont(Setting.bigFont);
		question = new JLabel();
		question.setFont(Setting.standardFont);
		answer = new JButton("Answer");
		answer.setFont(Setting.standardFont);
		answer.setPreferredSize(new Dimension(100, 50));
		scoreStatus = "     score : " + Player.getScore();
		scorebar = new JLabel(scoreStatus);
		scorebar.setFont(Setting.standardFont);
		answerArea = new JTextField();
		answerArea.setFont(Setting.standardFont);
		answerArea.setHorizontalAlignment(SwingConstants.CENTER);
		north = new JPanel();
		north.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight / 8));
		north.add(banner);
		center = new JPanel();
		center.setLayout(new GridLayout(2, 1));
		((GridLayout) center.getLayout()).setHgap(200);
		((GridLayout) center.getLayout()).setVgap(100);
		center.setPreferredSize(new Dimension(Setting.screenWidth * 6 / 8, Setting.screenHeight * 6 / 8-128));
		center.add(question);
		center.add(answerArea);
		screenAdjust = new JPanel[2];
		screenAdjust[0] = new JPanel();
		screenAdjust[1] = new JPanel();
		screenAdjust[0].setPreferredSize(new Dimension(Setting.screenWidth / 8, Setting.screenHeight * 6 / 8-128));
		screenAdjust[1].setPreferredSize(new Dimension(Setting.screenWidth / 8, Setting.screenHeight * 6 / 8-128));
		south = new JPanel();
		south.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight / 8+128));
		south.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 5.0;
		south.add(scorebar,gbc);
		gbc.weightx = 1.0;
		south.add(answer,gbc);
		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(screenAdjust[0], BorderLayout.WEST);
		this.add(screenAdjust[1], BorderLayout.EAST);
		this.add(south,BorderLayout.SOUTH);
	}

}
