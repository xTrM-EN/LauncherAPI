package me.xtrm.LauncherAPI.components.swinger;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.textured.STexturedButton;
import me.xtrm.LauncherAPI.utils.Resource;

@SuppressWarnings("all")
public class TexturedButton extends STexturedButton {

	private int[] bounds;
	
	public TexturedButton(Resource texture, int x, int y, int width, int height) { this(texture, new int[] {x, y, width, height}); }
	public TexturedButton(Resource texture, int[] bounds) {
		super(Swinger.getResource(texture.getFullPath()));
		this.bounds = bounds;
		
		init();
	}
	
	public TexturedButton(Resource texture, Resource hoveredTexture, int x, int y, int width, int height) { this(texture, hoveredTexture, new int[] {x, y, width, height}); }
	public TexturedButton(Resource texture, Resource hoveredTexture, int[] bounds) {
		super(Swinger.getResource(texture.getFullPath()), 
				Swinger.getResource(hoveredTexture.getFullPath()));
		this.bounds = bounds;
		
		init();
	}
	
	public TexturedButton(Resource texture, Resource hoveredTexture, Resource disabledTexture, int x, int y, int width, int height) { this(texture, hoveredTexture, disabledTexture, new int[] {x, y, width, height}); }
	public TexturedButton(Resource texture, Resource hoveredTexture, Resource disabledTexture, int[] bounds) {
		super(Swinger.getResource(texture.getFullPath()), 
				Swinger.getResource(hoveredTexture.getFullPath()), 
				Swinger.getResource(disabledTexture.getFullPath()));
		this.bounds = bounds;
		
		init();
	}
	
	public void init() {
		this.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
	}
	
}
