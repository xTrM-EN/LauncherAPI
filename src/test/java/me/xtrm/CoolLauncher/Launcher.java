package me.xtrm.CoolLauncher;

import java.awt.Color;

import me.xtrm.LauncherAPI.LauncherAPI;
import me.xtrm.LauncherAPI.components.jswing.Button;
import me.xtrm.LauncherAPI.components.jswing.Label;
import me.xtrm.LauncherAPI.components.jswing.PasswordField;
import me.xtrm.LauncherAPI.components.jswing.TextField;
import me.xtrm.LauncherAPI.launcher.LBuilder;
import me.xtrm.LauncherAPI.launcher.LauncherInstance;
import me.xtrm.LauncherAPI.launcher.swing.FrameBuilder;
import me.xtrm.LauncherAPI.launcher.swing.frame.LFrame;
import me.xtrm.LauncherAPI.launcher.swing.panel.LPanel;
import me.xtrm.LauncherAPI.utils.Resource;

public class Launcher {
	
	private static Launcher INSTANCE;
	private LauncherAPI api;
	
	public Launcher(LauncherAPI api) {
		INSTANCE = this;
		
		this.api = api;
	}
	
	public void init() {		
		LBuilder builder = api.launcherBuilder();
		builder.setName("LauncherAPIDemo");
		builder.setVersion("1.7.10");
		builder.setUpdateUrl("https://example.com/link-to-s-update/");
		builder.usesForge(true);
		
		LauncherInstance launcher = builder.build();
		api.setLauncherInstance(launcher);
		
		FrameBuilder fBuilder = api.frameBuilder();
		fBuilder.setName("Launcher API Demo");
		fBuilder.setSize(500, 200);
		fBuilder.setIcon(new Resource("icon.png"));
		fBuilder.setBackgroundImg(new Resource("background.png"));
		
		LFrame frame = fBuilder.build();
		
		LPanel panel = frame.getPanel();
		panel.addLComponent("usernameField", new TextField(api.getSaver().get("username"), new int[] {20, 15, 200, 20}, Color.BLACK));
		panel.addLComponent("passwordField", new PasswordField("", 20, 40, 200, 20, Color.BLACK));
		
		panel.addLComponent("playButton", new Button("Connect", 250, 70, 120, 20));
		
		Label label = new Label("Text is cool", 250, 15, 225, 20, Color.BLUE);
		label.setToolTipText("Text is really cool");
		panel.add("coolLabel", label);
		
		frame.init();
		
		api.setFrame(frame);
		
		api.registerButtonHandler(new ButtonHandler(api, frame));
	}
	
	public static Launcher getInstance() {
		return INSTANCE;
	}

}
