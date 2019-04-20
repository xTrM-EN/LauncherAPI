package me.xtrm.LauncherAPI.components.swinger;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.textured.STexturedProgressBar;
import me.xtrm.LauncherAPI.utils.Resource;

@SuppressWarnings("all")
public class TexturedProgressBar extends STexturedProgressBar {

	private String text;
	private int[] bounds;
	
	public TexturedProgressBar(Resource background, Resource foreground, int x, int y, int width, int height) { this(background, foreground, new int[] {x, y, width, height}, null); }
	public TexturedProgressBar(Resource background, Resource foreground, int[] bounds) { this(background, foreground, bounds, null); }
	public TexturedProgressBar(Resource background, Resource foreground, int x, int y, int width, int height, String text) { this(background, foreground, new int[] {x, y, width, height}, text); }
	public TexturedProgressBar(Resource background, Resource foreground, int[] bounds, String text) {
		super(Swinger.getResource(background.getFullPath()), Swinger.getResource(foreground.getFullPath()));
		
		this.text = text;
		this.bounds = bounds;
		
		init();
	}
	
	public void init() {
		if(text != null) {
			this.setStringPainted(true);
			this.setString(text);
		}
		this.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
	}

}
