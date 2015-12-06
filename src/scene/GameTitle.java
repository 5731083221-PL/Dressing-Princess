package scene;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import manager.GameManager;
import manager.Setting;
import sun.tools.jar.resources.jar;

public class GameTitle extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField playerName;
	private JCheckBox playSound;
	private JButton startButton;
	private JPanel centerPanel, adjustingPanel[];

	public GameTitle() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		playerName = new JTextField("Enter your name here");
		playerName.setFont(Setting.standardFont);
		playerName.setHorizontalAlignment(SwingConstants.CENTER);
		startButton = new JButton("Start");
		startButton.setFont(Setting.bigFont);
		playSound = new JCheckBox("Play Sound", true);
		playSound.setFont(Setting.standardFont);
		playerName.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (playerName.getText().equalsIgnoreCase("Enter your name here")) {
					playerName.setText("");
				}

			}
		});
		playSound.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (playSound.isSelected()) {
					Setting.isPlaySound = true;
				} else {
					Setting.isPlaySound = false;
				}

			}
		});
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 1));
		((GridLayout) centerPanel.getLayout()).setVgap(50);
		centerPanel.add(playerName);
		centerPanel.add(startButton);
		centerPanel.add(playSound);
		adjustingPanel = new JPanel[4];
		for (int i = 0; i < 4; i++) {
			adjustingPanel[i] = new JPanel();
		}
		adjustingPanel[0].setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight / 4));
		adjustingPanel[1].setPreferredSize(new Dimension(Setting.screenWidth / 4, Setting.screenHeight / 2));
		adjustingPanel[2].setPreferredSize(new Dimension(Setting.screenWidth / 4, Setting.screenHeight / 2));
		adjustingPanel[3].setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight / 4));
		this.add(adjustingPanel[0], BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(adjustingPanel[1], BorderLayout.WEST);
		this.add(adjustingPanel[2], BorderLayout.EAST);
		this.add(adjustingPanel[3], BorderLayout.SOUTH);
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.newGame();
				
			}
		});
	}
	
}
