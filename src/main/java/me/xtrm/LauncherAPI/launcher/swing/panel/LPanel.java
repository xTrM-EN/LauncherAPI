package me.xtrm.LauncherAPI.launcher.swing.panel;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;

import fr.theshark34.swinger.Swinger;
import me.xtrm.LauncherAPI.utils.Resource;

@SuppressWarnings("all")
public class LPanel extends JPanel {
	
	private Resource background;
	
	public LPanel(Resource backgroundImg) {
		this.background = backgroundImg;
	}
	
	public void init() {
		this.setLayout(null);
	}
	
	public void addComponent(Component comp) {
		this.add(comp);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(Swinger.getResource(background.getFullPath()), 0, 0, this.getWidth(), this.getHeight(), this);
	}

}
