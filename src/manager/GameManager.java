package manager;

import scene.MainWindow;
import scene.Prologue;

public class GameManager {
	public static void newGame() {
		Prologue prologue = new Prologue();
		MainWindow.repaintFrame(prologue);
	}
}
