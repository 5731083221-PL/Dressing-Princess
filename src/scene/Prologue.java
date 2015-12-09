package scene;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import manager.GameManager;
import manager.Setting;

public class Prologue extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel l = new JLabel("Test");
	int i=0;
	public Prologue() {
		this.setPreferredSize(new Dimension(Setting.screenWidth, Setting.screenHeight));
		this.setLayout(new BorderLayout());
		this.add(l,BorderLayout.NORTH);
	}
	public void playPrologue(){
		Timer t = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				i++;
				l.setText("hello"+i);
				if(i==10){
					((Timer)e.getSource()).stop();
					GameManager.runGame();
				}
				
			}
		});
		t.start();
		
	}
}
