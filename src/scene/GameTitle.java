package scene;

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
				if (playerName.getText().equals("") || playerName.getText().equalsIgnoreCase("Enter your name here")) {
					JOptionPane.showMessageDialog(MainWindow.mainWindow, "Please enter your name", "Invalid name",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Player.setPlayerName(playerName.getText());
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
