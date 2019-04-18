package me.xtrm.LauncherAPI.launcher.swing.components.buttons;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.textured.STexturedButton;
import me.xtrm.LauncherAPI.utils.Resource;

@SuppressWarnings("all")
public class CustomButton extends STexturedButton {

	public CustomButton(Resource texture) {
		super(Swinger.getResource(texture.getFullPath()));
	}
	
	public CustomButton(Resource texture, Resource hoveredTexture) {
		super(Swinger.getResource(texture.getFullPath()));
	}
	
	public CustomButton(Resource texture, Resource hoveredTexture, Resource disabledTexture) {
		super(Swinger.getResource(texture.getFullPath()));
	}
	
	public void init() {
		
	}

}
