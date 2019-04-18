package me.xtrm.LauncherAPI.launcher.swing.components.text;

import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("all")
public class Label extends JLabel {
	
	private String text;
	private int[] bounds;
	private Color textColor;
	
	public Label(String baseText, int x, int y, int width, int height) {
		this(baseText, new int[] {x, y, width, height}, Color.WHITE);
	}
	
	public Label(String baseText, int[] bounds) {
		this(baseText, bounds, Color.WHITE);
	}
	
	public Label(String baseText, int[] bounds, Color textColor) {
		this.text = baseText;
		this.bounds = bounds;
		this.textColor = textColor;
		
		init();
	}
	
	public void init() {
		// Constants
		this.setFont(this.getFont().deriveFont(20f));
		this.setOpaque(false);
		this.setBorder(null);
		
		// User defined
		this.setText(text);
		this.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		this.setForeground(textColor);
	}

}
