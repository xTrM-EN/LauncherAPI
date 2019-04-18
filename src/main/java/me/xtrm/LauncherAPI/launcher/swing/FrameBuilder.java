package me.xtrm.LauncherAPI.launcher.swing;

import me.xtrm.LauncherAPI.launcher.swing.frame.LFrame;
import me.xtrm.LauncherAPI.launcher.swing.panel.LPanel;
import me.xtrm.LauncherAPI.utils.Resource;

public class FrameBuilder {
	
	private String name;
	private Resource icon, backgroundImg;
	private int[] size;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setIcon(Resource icon) {
		this.icon = icon;
	}
	
	public void setBackgroundImg(Resource backgroundImg) {
		this.backgroundImg = backgroundImg;
	}
	
	public void setSize(int[] size) {
		this.size = size;
	}
		
	public void setSize(int width, int height) {
		this.size = new int[] {width, height};
	}
	
	public LFrame build() {
		return new LFrame(name, size, icon, new LPanel(backgroundImg));
	}
}
