package player;

public class Player {
	private static String name;
	private static int score = 0;

	public static int getScore() {
		return score;
	}

	public static void addScore(int score) {
		Player.score += score;
	}
	
	public static String getPlayerName(){
		return name;
	}
	public static void setPlayerName(String name){
		Player.name = name;
	}
}
