package me.xtrm.LauncherAPI.launcher.swing.panel;

import java.awt.Graphics;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

import fr.theshark34.swinger.Swinger;
import me.xtrm.LauncherAPI.utils.Logger;
import me.xtrm.LauncherAPI.utils.Resource;

@SuppressWarnings("all")
public class LPanel extends JPanel {
	
	private Resource background;
	private Map<String, JComponent> components;
	
	public LPanel(Resource backgroundImg) {
		this.background = backgroundImg;
		this.components = new HashMap<String, JComponent>();
	}
	
	public void init() {
		Logger.info("[LPanel] Initializing LPanel...");
		
		this.setLayout(null);
		
		for(JComponent comp : components.values()) {
			this.add(comp);
		}
	}
	
	public JComponent getLComponent(String internalName) {
		if(components.containsKey(internalName))
			return components.get(internalName);
		return null;
	}
	
	public void addLComponent(String internalName, JComponent comp) {
		this.components.put(internalName, comp);
	}
	
	public Collection<JComponent> getLComponents(){
		return components.values();
	}
	
	public String getLComponentName(JComponent comp) {
		if(components.containsValue(comp)) {
			for(String s : components.keySet()) {
				if(components.get(s) == comp) {
					return s;
				}
			}
		}
		return null;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Swinger.drawFullsizedImage(g, this, Swinger.getResource(background.getFullPath()));
	}

}
