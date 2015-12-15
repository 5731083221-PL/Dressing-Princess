package scene;

import javax.swing.*;

import manager.Resource;

public class MainWindow{
	public static volatile JPanel showObject = new JPanel();
	public static volatile JFrame mainWindow;
	public static void initial(){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
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
		});
		
	}
	public static void repaintFrame(JPanel newFrame){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				showObject.removeAll();
				showObject.add(newFrame);
				mainWindow.revalidate();
				mainWindow.repaint();
			}
		});
		
	}
	
}
