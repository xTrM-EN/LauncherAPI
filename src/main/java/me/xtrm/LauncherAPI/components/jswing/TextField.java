package me.xtrm.LauncherAPI.components.jswing;

import java.awt.Color;

import javax.swing.JTextField;

@SuppressWarnings("all")
public class TextField extends JTextField {

	private String baseText;
	private int[] bounds;
	private Color textColor;
	
	public TextField(String baseText, int x, int y, int width, int height) { this(baseText, new int[] {x, y, width, height}, Color.WHITE); }
	public TextField(String baseText, int x, int y, int width, int height, Color textColor) { this(baseText, new int[] {x, y, width, height}, textColor); }
	public TextField(String baseText, int[] bounds) { this(baseText, bounds, Color.WHITE); }
	public TextField(String baseText, int[] bounds, Color textColor) {
		this.baseText = baseText;
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
		this.setText(baseText);
		this.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		this.setCaretColor(textColor);
		this.setForeground(textColor);
	}
	
}
