package me.xtrm.LauncherAPI.components.swinger;

import java.awt.Color;

import fr.theshark34.swinger.colored.SColoredBar;

@SuppressWarnings("all")
public class ColoredBar extends SColoredBar {

	private int[] bounds;
	
	public ColoredBar(Color background, Color foreground, int x, int y, int width, int height) { super(background, foreground); this.bounds = new int[] {x, y, width, height}; }
	public ColoredBar(Color background, Color foreground, int[] bounds) { super(background, foreground); this.bounds = bounds; }
    public ColoredBar(Color background, int x, int y, int width, int height) { super(background); this.bounds = new int[] {x, y, width, height}; }
	public ColoredBar(Color background, int[] bounds) {
		super(background);
		this.bounds = bounds;
	}

	public void init() {
		this.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
	}
	
}
