package manager;

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
	}
	public static void runGame(){
		MainMap mainMap = new MainMap();
		MainWindow.repaintFrame(mainMap);
	}
	public static void runMiniGame(){
		MiniGame miniGame = new MiniGame();
		MainWindow.repaintFrame(miniGame);
	}
	public static void playGame(String mode){
		PlayWindow playWindow = new PlayWindow(mode);
		MainWindow.repaintFrame(playWindow);
	}
}
