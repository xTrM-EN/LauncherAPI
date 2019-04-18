package me.xtrm.LauncherAPI.launcher.swing.frame;

import javax.swing.JFrame;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.util.WindowMover;
import me.xtrm.LauncherAPI.launcher.swing.panel.LPanel;
import me.xtrm.LauncherAPI.utils.Resource;

@SuppressWarnings("all")
public class LFrame extends JFrame {
	
	private String name;
	private int[] size;
	private Resource logo;
	
	private LPanel panel;
	
	public LFrame(String name, int[] size, Resource logo, LPanel panel) {
		this.name = name;
		this.size = size;
		this.logo = logo;
		this.panel = panel;
	}
	
	public void init() {
		// User defined
		this.setTitle(name);
		this.setSize(size[0], size[1]);
		this.setIconImage(Swinger.getResource(logo.getFullPath()));
		
		// Constants
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		
		WindowMover mover = new WindowMover(this);
		this.addMouseListener(mover);
		this.addMouseMotionListener(mover);
		
		panel.init();
		this.setContentPane(panel);
		
		this.setVisible(true);
	}

	public LPanel getPanel() {
		return panel;
	}
	
}
