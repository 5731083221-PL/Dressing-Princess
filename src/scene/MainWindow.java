package scene;
import java.awt.*;
import javax.swing.*;

import sun.tools.jar.resources.jar;
public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	public static JPanel showObject = new JPanel();
	public MainWindow(){
		GameTitle gameTitle = new GameTitle();
		showObject.add(gameTitle);
		this.add(showObject);
		this.pack();
		this.setVisible(true);
	}
	public static void repaintFrame(JPanel newFrame){
		showObject.removeAll();
		showObject.add(newFrame);
		showObject.repaint();
	}
}
