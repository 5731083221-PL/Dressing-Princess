package scene;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import manager.GameManager;
import manager.Resource;
import manager.Setting;
import player.Player;
public class Shop extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton buy,back;
	private BufferedImage buyButton,backButton, bg,afterpress;
	public Shop(){
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		this.setLayout(null);
		bg = Resource.getBackgroundImage("img/Shop.png");
		backButton = Resource.getBackgroundImage("img/Back.png");
		buyButton = Resource.getBackgroundImage("img/Buy Button.png");
		afterpress = Resource.getBackgroundImage("img/AfterBuy Button.png");
		buy = GameManager.createButton(buyButton);
		buy.setBounds(540, 420, buyButton.getWidth(), buyButton.getHeight());
		this.add(buy);
		back = GameManager.createButton(backButton);
		back.setBounds(10, 650, backButton.getWidth(), backButton.getHeight());
		this.add(back);
		buy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buy.setIcon(new ImageIcon(afterpress));
				if(Player.getScore()<400){
					JOptionPane.showMessageDialog(MainWindow.mainWindow, "You need more score to buy it", "Cannot Buy", JOptionPane.INFORMATION_MESSAGE);
					buy.setIcon(new ImageIcon(buyButton));
				}else{
					JOptionPane.showMessageDialog(MainWindow.mainWindow, "Let Go Married", "Congraturation", JOptionPane.INFORMATION_MESSAGE);
					GameManager.endGame();
				}
				
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
	}
}
