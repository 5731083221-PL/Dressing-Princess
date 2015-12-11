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
	private JLabel pageRun;
	private BufferedImage page[];
	private int i = 1;

	public Prologue() {
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		this.setLayout(new BorderLayout());
		page = new BufferedImage[4];
		page[0] = Resource.getBackgroundImage("img/page0.png");
		page[1] = Resource.getBackgroundImage("img/page1.png");
		page[2] = Resource.getBackgroundImage("img/page2.png");
		page[3] = Resource.getBackgroundImage("img/page3.png");
		pageRun = new JLabel(new ImageIcon(page[0]));
		this.add(pageRun, BorderLayout.NORTH);
		if (Setting.isPlaySound) {
			Resource.playMainBGM();
		}
	}

	public void playPrologue() {
		synchronized (this) {
			Timer t = new Timer(2500, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (i < 4)
						pageRun.setIcon(new ImageIcon(page[i]));
					i++;
					if (i == 5) {
						((Timer) e.getSource()).stop();

						GameManager.runGame();
					}

				}
			});
			t.start();
		}
	}

}
