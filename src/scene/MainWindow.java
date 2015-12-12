package scene;

import javax.swing.*;

import manager.Resource;

public class MainWindow{
	public static JPanel showObject = new JPanel();
	public static JFrame mainWindow;
	public static void main(String[] args){
		mainWindow = new JFrame("Dressing Princess");
		mainWindow.setIconImage(Resource.getBackgroundImage("img/logo.png"));
		GameTitle gameTitle = new GameTitle();
		showObject.add(gameTitle);
		mainWindow.add(showObject);		
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.pack();
		mainWindow.setVisible(true);
	}
	public static void repaintFrame(JPanel newFrame){
		showObject.removeAll();
		showObject.add(newFrame);
		mainWindow.revalidate();
		mainWindow.repaint();
	}
	
}
