package player;

public class Player {
	private String name;
	private int score;
	public Player(String name){
		this.name = name;
		score = 0;
	}
	public int getScore(){
		return this.score;
	}
	public void addScore(int score){
		this.score += score;
	}
}
