package me.xtrm.LauncherAPI.components.jswing;

import javax.swing.JButton;

import fr.theshark34.swinger.Swinger;
import me.xtrm.LauncherAPI.utils.Resource;

@SuppressWarnings("all")
public class Button extends JButton {
	
	private String text;
	private int[] bounds;
		
	public Button(String text, int x, int y, int width, int height) { this(text, new int[] {x, y, width, height}); }	
	public Button(String text, int[] bounds) {
		this.text = text;
		this.bounds = bounds;
		
		init();
	}
	
	public void init() {
		this.setText(text);
		this.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
	}

}
