package scene;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import manager.Resource;
import manager.Setting;

public class Epilogue extends JPanel {
	private static final long serialVersionUID = 1L;
	private BufferedImage page[];
	private JLabel pageRun;
	private int i = 1;
	private AudioClip bgm;

	public Epilogue() {
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		this.setLayout(new BorderLayout());
		page = new BufferedImage[2];
		page[0] = Resource.getBackgroundImage("img/End1.png");
		page[1] = Resource.getBackgroundImage("img/End2.png");
		pageRun = new JLabel(new ImageIcon(page[0]));
		this.add(pageRun, BorderLayout.NORTH);
		if(Setting.isPlaySound){
			bgm = Resource.getAudio("sound/Wedding theme.wav");
			bgm.play();
		}
	}

	public void playEpilogue() {
		synchronized (this) {
			Timer t = new Timer(2000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (i < 2)
						pageRun.setIcon(new ImageIcon(page[i]));
					i++;
					if (i == 3) {
						((Timer) e.getSource()).stop();
						Resource.getAudio("sound/applause.wav").play();
						JOptionPane.showMessageDialog(MainWindow.mainWindow,
								"Congraturations !\nClick OK button to exit", "Ending", JOptionPane.CLOSED_OPTION);
						System.exit(0);
					}

				}
			});
			t.start();
		}
	}
}
