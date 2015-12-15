package scene;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

import manager.GameManager;
import manager.Resource;
import manager.Setting;

public class Prologue extends JPanel {
	private static final long serialVersionUID = 1L;
	private BufferedImage page[];
	private volatile int i = 0;
	public Prologue() {
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		this.setLayout(new BorderLayout());
		page = new BufferedImage[4];
		page[0] = Resource.getBackgroundImage("img/Page0.png");
		page[1] = Resource.getBackgroundImage("img/Page1.png");
		page[2] = Resource.getBackgroundImage("img/Page2.png");
		page[3] = Resource.getBackgroundImage("img/Page3.png");
		
		if (Setting.isPlaySound) {
			Resource.playMainBGM();
		}
	}

	public synchronized void playPrologue() {
		Timer t = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				i++;
				if (i < 4) {
					repaint();
				}
				if (i == 4) {
					((Timer) e.getSource()).stop();
					GameManager.runGame();
				}

			}
		});
		t.start();
	}

	@Override
	public void paint(Graphics g) {
		update(g);
	}

	@Override
	public void update(Graphics g) {
		if (i < 4){
			g.drawImage(page[i], 0, 0, this);
		}
	}

}
