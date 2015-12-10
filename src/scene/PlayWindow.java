package scene;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import manager.GameManager;
import manager.Setting;
import player.Player;

public class PlayWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	private MiniGameLogic logic;
	private JLabel question, banner, scorebar, timebar;
	private JButton answer;
	private JTextField answerArea;
	private JPanel north, center, south, screenAdjust[];
	private String scoreStatus, timeStatus;
	private int timeleft, thisScore;
	private boolean result;
	private static final int MAXTIME = 60;

	public PlayWindow(String mode) {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		logic = new MiniGameLogic(mode);
		banner = new JLabel("Answer The Question", SwingConstants.CENTER);
		banner.setFont(Setting.bigFont);
		question = new JLabel();
		question.setFont(Setting.bigFont);
		question.setHorizontalAlignment(SwingConstants.CENTER);
		answer = new JButton("Answer");
		answer.setFont(Setting.standardFont);
		answer.setPreferredSize(new Dimension(100, 50));
		thisScore = 0;
		scoreStatus = "     Score : " + thisScore;
		scorebar = new JLabel(scoreStatus);
		scorebar.setFont(Setting.standardFont);
		timeleft = MAXTIME;
		timeStatus = "Time Left : " + timeleft;
		timebar = new JLabel(timeStatus);
		timebar.setFont(Setting.standardFont);
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
		center.setPreferredSize(new Dimension(Setting.screenWidth * 6 / 8, Setting.screenHeight * 6 / 8 - 128));
		center.add(question);
		center.add(answerArea);
		screenAdjust = new JPanel[2];
		screenAdjust[0] = new JPanel();
		screenAdjust[1] = new JPanel();
		screenAdjust[0].setPreferredSize(new Dimension(Setting.screenWidth / 8, Setting.screenHeight * 6 / 8 - 128));
		screenAdjust[1].setPreferredSize(new Dimension(Setting.screenWidth / 8, Setting.screenHeight * 6 / 8 - 128));
		south = new JPanel();
		south.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight / 8 + 128));
		south.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 5.0;
		south.add(scorebar, gbc);
		south.add(timebar, gbc);
		gbc.weightx = 1.0;
		south.add(answer, gbc);
		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(screenAdjust[0], BorderLayout.WEST);
		this.add(screenAdjust[1], BorderLayout.EAST);
		this.add(south, BorderLayout.SOUTH);
	}

	public void gameStart() {
		Timer t1 = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeleft--;
				timeStatus = "Time Left : " + timeleft;
				timebar.setText(timeStatus);
				south.repaint();
				MainWindow.mainWindow.revalidate();
				MainWindow.mainWindow.repaint();
				if (timeleft == 0) {
					((Timer) e.getSource()).stop();
					Player.addScore(thisScore);
					GameManager.gameOver(thisScore);
					return;
				}
			}
		});
		t1.start();
		question.setText(logic.getEquation());
		answer.requestFocus();
		answer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					int sentAnswer = Integer.parseInt(answerArea.getText());
					result = logic.checkAnswer(sentAnswer);
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(MainWindow.mainWindow, "Answer must be integer", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (result) {
					thisScore += logic.rewardScore();
					scoreStatus = "     Score : " + thisScore;
					scorebar.setText(scoreStatus);
					south.repaint();
					MainWindow.mainWindow.revalidate();
					MainWindow.mainWindow.repaint();
				}
				logic.resetParameter();
				question.setText(logic.getEquation());
				answerArea.setText("");
				center.repaint();
				MainWindow.mainWindow.revalidate();
				MainWindow.mainWindow.repaint();
			}
		});

	}
}
