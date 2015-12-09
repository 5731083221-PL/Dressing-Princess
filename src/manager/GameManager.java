package manager;

import scene.GameOver;
import scene.MainMap;
import scene.MainWindow;
import scene.MiniGame;
import scene.PlayWindow;
import scene.Prologue;

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
}
