package me.xtrm.LauncherAPI.launcher.swing.frame;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.awt.AWTUtilities;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.animation.Animator;
import fr.theshark34.swinger.util.WindowMover;
import me.xtrm.LauncherAPI.launcher.swing.panel.LPanel;
import me.xtrm.LauncherAPI.utils.Logger;
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
		Logger.info("[LFrame] Initializing LFrame...");
		
		// User defined
		this.setTitle(name);
		this.setSize(size[0], size[1]);
		this.setIconImage(Swinger.getResource(logo.getFullPath()));
		
		// Constants
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		
		AWTUtilities.setWindowOpacity(this, 0f);
		
		WindowMover mover = new WindowMover(this);
		this.addMouseListener(mover);
		this.addMouseMotionListener(mover);
		
		panel.init();
		this.setContentPane(panel);
		
		this.setVisible(true);
		
		Animator.fadeInFrame(this, 2);
	}

	public void setFieldsState(boolean state) {
		for(JComponent jc : getPanel().getLComponents()) {
			if(getPanel().getLComponentName(jc).toLowerCase().contains("quit"))
				continue;
			if(getPanel().getLComponentName(jc).toLowerCase().contains("minimize"))
				continue;
			if(getPanel().getLComponentName(jc).toLowerCase().contains("hide"))
				continue;
			
			if(jc instanceof JTextField) 
				((JTextField)jc).setEnabled(state);
			if(jc instanceof JPasswordField) 
				((JPasswordField)jc).setEnabled(state);
			if(jc instanceof JButton)
				((JButton)jc).setEnabled(state);
		}
	}
	
	public void minimize() {
		this.setState(JFrame.ICONIFIED);
	}
	
	public LPanel getPanel() {
		return panel;
	}
	
}
