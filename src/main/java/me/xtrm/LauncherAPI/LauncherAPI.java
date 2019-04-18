package me.xtrm.LauncherAPI;

import fr.theshark34.swinger.Swinger;
import me.xtrm.LauncherAPI.bootstrapper.BBuilder;
import me.xtrm.LauncherAPI.launcher.LBuilder;
import me.xtrm.LauncherAPI.launcher.handler.ButtonHandler;
import me.xtrm.LauncherAPI.launcher.swing.FrameBuilder;

/**
 * Main Class of the API
 * @author xTrM_
 */
public class LauncherAPI {
	
	public LauncherAPI() {
			
	}
	
	public void setup() {
		Swinger.setSystemLookNFeel();
		Swinger.setResourcePath("/assets");
	}
	
	public void registerButtonHandler(ButtonHandler handler) {
		
	}
	
	/**
	 *   > > > Bootstrapper > > >
	 */
	
	public BBuilder bootstrapperBuilder() {
		return new BBuilder();
	}
	
	/**
	 *   > > > Launcher > > >
	 */
	
	public LBuilder launcherBuilder() {
		return new LBuilder();
	}
	
	public FrameBuilder frameBuilder() {
		return new FrameBuilder();
	}

}
