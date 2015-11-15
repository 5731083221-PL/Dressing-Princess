package render;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	private ArrayList<IRenderable> scenes;

	public RenderableHolder() {
		scenes = new ArrayList<IRenderable>();
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public void add(IRenderable entity) {
		scenes.add(entity);
		Collections.sort(scenes, new Comparator<IRenderable>() {
			@Override
			public int compare(IRenderable o1, IRenderable o2) {
				if (o1.getZ() > o2.getZ())
					return 1;
				return -1;
			}
		});
	}

	public ArrayList<IRenderable> getRenderableList() {
		return scenes;
	}
}