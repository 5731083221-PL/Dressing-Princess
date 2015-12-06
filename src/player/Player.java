package player;

public class Player {
	private String name;
	private int score;

	public Player(String name) {
		this.name = name;
		this.score = 0;
	}

	public int getScore() {
		return this.score;
	}

	public void addScore(int score) {
		this.score += score;
	}

	public boolean subtractScore(int score) {
		if (this.score - score < 0)
			return false;
		this.score -= score;
		return true;

	}
	public String getPlayerName(){
		return this.name;
	}
}
