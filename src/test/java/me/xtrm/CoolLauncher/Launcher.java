package me.xtrm.CoolLauncher;

import java.awt.Color;

import me.xtrm.LauncherAPI.LauncherAPI;
import me.xtrm.LauncherAPI.launcher.LBuilder;
import me.xtrm.LauncherAPI.launcher.LauncherInstance;
import me.xtrm.LauncherAPI.launcher.swing.FrameBuilder;
import me.xtrm.LauncherAPI.launcher.swing.components.text.TextField;
import me.xtrm.LauncherAPI.launcher.swing.frame.LFrame;
import me.xtrm.LauncherAPI.launcher.swing.panel.LPanel;
import me.xtrm.LauncherAPI.utils.Resource;

public class Launcher {
	
	private LauncherAPI api;
	
	public Launcher(LauncherAPI api) {
		this.api = api;
	}
	
	public void init() {
		LBuilder builder = api.launcherBuilder();
		builder.setName("Cool Launcher");
		builder.setVersion("1.7.10");
		builder.setUpdateUrl("https://example.com/link-to-s-update/");
		builder.usesForge(true);
		
		LauncherInstance launcher = builder.build();
		
		FrameBuilder fBuilder = api.frameBuilder();
		fBuilder.setName(launcher.getName());
		fBuilder.setSize(500, 200);
		fBuilder.setIcon(new Resource("icon.png"));
		fBuilder.setBackgroundImg(new Resource("background.png"));
		
		LFrame frame = fBuilder.build();
		
		LPanel panel = frame.getPanel();
		panel.addComponent(new TextField("Username", new int[] {20, 15, 200, 20}));
		panel.addComponent(new TextField("Test", 45, 15, 200, 20, Color.BLACK));
		
		frame.init();
		
	}

}
