package manager;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import scene.Epilogue;
import scene.GameOver;
import scene.MainMap;
import scene.MainWindow;
import scene.MiniGame;
import scene.PlayWindow;
import scene.Prologue;
import scene.Shop;

public class GameManager{
	public static void newGame() {
		Prologue prologue = new Prologue();
		MainWindow.repaintFrame(prologue);
		prologue.playPrologue();
		return;
	}
	public static void runGame(){
		MainMap mainMap = new MainMap();
		MainWindow.repaintFrame(mainMap);
		return;
	}
	public static void runMiniGame(){
		MiniGame miniGame = new MiniGame();
		MainWindow.repaintFrame(miniGame);
		return;
	}
	public static void playGame(String mode){
		PlayWindow playWindow = new PlayWindow(mode);
		MainWindow.repaintFrame(playWindow);
		playWindow.gameStart();
		return;
	}
	public static void gameOver(int total){
		GameOver gameOver = new GameOver(total);
		MainWindow.repaintFrame(gameOver);
		return;
	}
	public static JButton createButton(BufferedImage icon){
		JButton b = new JButton();
		b.setIcon(new ImageIcon(icon));
		b.setOpaque(false);
		b.setBorderPainted(false);
		b.setContentAreaFilled(false);
		return b;
	}
	public static void gotoShop(){
		Shop shop = new Shop();
		MainWindow.repaintFrame(shop);
		return;
	}
	public static void endGame(){
		Epilogue epilogue = new Epilogue();
		MainWindow.repaintFrame(epilogue);
		epilogue.playEpilogue();
		return;
	}
}
