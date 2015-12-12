package player;

public class Player {
	private static String name;
	private static int score = 0;

	public static int getScore() {
		return score;
	}

	public static void addScore(int add) {
		score += add;
	}
	
	public static String getPlayerName(){
		return name;
	}
	public static void setPlayerName(String playerName){
		name = playerName;
	}
}
