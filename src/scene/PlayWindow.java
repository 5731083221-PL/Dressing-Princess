package scene;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.Border;

import manager.GameManager;
import manager.Resource;
import manager.Setting;
import player.Player;

public class PlayWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	private MiniGameLogic logic;
	private JButton answer;
	private JTextField answerArea;
	private String scoreStatus, timeStatus,question;
	private int timeleft, thisScore;
	private boolean result;
	private static final int MAXTIME = 60;
	private BufferedImage bg,answerButton;

	public PlayWindow(String mode) {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		bg = Resource.getBackgroundImage("img/Background.png");
		answerButton = Resource.getBackgroundImage("img/Answer Button.png");
		logic = new MiniGameLogic(mode);
		question = logic.getEquation();
		answer = new JButton();
		answer.setIcon(new ImageIcon(answerButton));
		answer.setOpaque(false);
		answer.setContentAreaFilled(false);
		answer.setBorderPainted(false);
		answer.setBounds((Setting.screenWidth-answerButton.getWidth())/2, 500, answerButton.getWidth(), answerButton.getHeight());
		this.add(answer);
		thisScore = 0;
		scoreStatus = "     Score : " + thisScore;	
		timeleft = MAXTIME;
		timeStatus = "Time Left : " + timeleft;
		answerArea = new JTextField(){
			private static final long serialVersionUID = 1L;

			@Override
			public void setBorder(Border border) {

			}
		};
		answerArea.setFont(Setting.standardFont);
		answerArea.setHorizontalAlignment(SwingConstants.CENTER);
		answerArea.setBounds(312, 350, 400, 80);
		answerArea.setText("Answer here");
		this.add(answerArea);
		answerArea.addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				answerArea.setText("");
				
			}
		});
	}

	public void gameStart() {
		Timer t1 = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeleft--;
				timeStatus = "Time Left : " + timeleft;
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
		question = logic.getEquation();
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
					scoreStatus = "Score : " + thisScore;
					MainWindow.mainWindow.revalidate();
					MainWindow.mainWindow.repaint();
				}
				logic.resetParameter();
				question = logic.getEquation();
				answerArea.setText("Answer here");
				MainWindow.mainWindow.revalidate();
				MainWindow.mainWindow.repaint();
			}
		});

	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, null);
		//draw banner
		FontMetrics metrics = g.getFontMetrics(Setting.bigFont);
		Rectangle2D rect = metrics.getStringBounds("Answer The Question", g);
		int x = (Setting.screenWidth - (int) rect.getWidth()) / 2;
		int y = 60;
		g.setFont(Setting.bigFont);
		g.drawString("Answer The Question", x,y );
		//draw question
		metrics = g.getFontMetrics(Setting.slimBigFont);
		rect = metrics.getStringBounds(question, g);
		x = (Setting.screenWidth - (int) rect.getWidth()) / 2;
		y = 200;
		g.setColor(Color.WHITE);
		g.fillRect(312, 150, 400, 80);
		g.setFont(Setting.slimBigFont);
		g.setColor(Color.BLACK);
		g.drawString(question, x,y );
		//draw score bar
		x = 20;
		y = 740;
		g.drawString(scoreStatus, x,y );
		//draw time bar
		rect = metrics.getStringBounds(timeStatus, g);
		x = (Setting.screenWidth - (int) rect.getWidth()) / 2;
		y = 740;
		g.drawString(timeStatus, x,y );
	}
}
