package me.xtrm.LauncherAPI.launcher.handle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import me.xtrm.LauncherAPI.LauncherAPI;
import me.xtrm.LauncherAPI.launcher.swing.frame.LFrame;
import me.xtrm.LauncherAPI.launcher.swing.panel.LPanel;

public abstract class AButtonHandler implements SwingerEventListener, ActionListener {
	
	private LauncherAPI api;
	private LFrame frame;
	
	public AButtonHandler(LauncherAPI api, LFrame frame) {
		this.api = api;
		this.frame = frame;
	}
	
	@Override
	public void onEvent(SwingerEvent event) {
		if(event.getType() == SwingerEvent.BUTTON_CLICKED_EVENT) {
			if(event.getSource() instanceof JComponent) {
				String name = frame.getPanel().getLComponentName((JComponent)event.getSource());
				if(name != null)
					onButtonClicked(name);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() instanceof JComponent) {
			String name = frame.getPanel().getLComponentName((JComponent)event.getSource());
			if(name != null)
				onButtonClicked(name);
		}
	}
	
	public abstract void onButtonClicked(String buttonName);
	
	public LauncherAPI getAPI() {
		return api;
	}
	
	public LFrame getFrame() {
		return frame;
	}

}
