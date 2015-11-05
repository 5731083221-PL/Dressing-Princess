
public class Setting {
	private int width,height;
	private boolean playSound;
	public Setting(){
		width = 640;
		height = 480;
		playSound = true;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isPlaySound() {
		return playSound;
	}
	public void setPlaySound(boolean playSound) {
		this.playSound = playSound;
	}
	
}
