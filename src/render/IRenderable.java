package render;

import java.awt.Graphics;

public interface IRenderable {
	public void draw(Graphics g);
	public boolean isVisible();
	public int getZ();
}
