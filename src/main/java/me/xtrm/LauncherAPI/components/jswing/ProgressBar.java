package me.xtrm.LauncherAPI.components.jswing;

import javax.swing.JProgressBar;

@SuppressWarnings("all")
public class ProgressBar extends JProgressBar {
	
	private String text;
	private int[] bounds;
		
	public ProgressBar(int x, int y, int width, int height) { this(new int[] {x, y, width, height}, null); }
	public ProgressBar(int[] bounds) { this(bounds, null); }
	public ProgressBar(int x, int y, int width, int height, String text) { this(new int[] {x, y, width, height}, text); }
	public ProgressBar(int[] bounds, String text) {
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
