package me.xtrm.LauncherAPI;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JComponent;

import fr.litarvan.openauth.AuthPoints;
import fr.litarvan.openauth.AuthenticationException;
import fr.litarvan.openauth.Authenticator;
import fr.litarvan.openauth.model.AuthAgent;
import fr.litarvan.openauth.model.response.AuthResponse;
import fr.theshark34.openlauncherlib.LaunchException;
import fr.theshark34.openlauncherlib.external.ExternalLaunchProfile;
import fr.theshark34.openlauncherlib.internal.InternalLaunchProfile;
import fr.theshark34.openlauncherlib.internal.InternalLauncher;
import fr.theshark34.openlauncherlib.minecraft.AuthInfos;
import fr.theshark34.openlauncherlib.minecraft.GameFolder;
import fr.theshark34.openlauncherlib.minecraft.MinecraftLauncher;
import fr.theshark34.openlauncherlib.util.CrashReporter;
import fr.theshark34.openlauncherlib.util.Saver;
import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.animation.Animator;
import me.xtrm.LauncherAPI.bootstrapper.BBuilder;
import me.xtrm.LauncherAPI.bootstrapper.BootstrapperInstance;
import me.xtrm.LauncherAPI.handle.UpdateHandler;
import me.xtrm.LauncherAPI.launcher.LBuilder;
import me.xtrm.LauncherAPI.launcher.LauncherInstance;
import me.xtrm.LauncherAPI.launcher.handle.AButtonHandler;
import me.xtrm.LauncherAPI.launcher.swing.FrameBuilder;
import me.xtrm.LauncherAPI.launcher.swing.frame.LFrame;
import me.xtrm.LauncherAPI.utils.Logger;

/**
 * Main Class of the API
 * @author xTrM_
 */
public class LauncherAPI {
	
	private final String VER = "1.00",
					  AUTHOR = "xTrM_";
	
	private LauncherInstance launcherInstance;
	private BootstrapperInstance bootstrapperInstance;
	
	private LFrame lFrame;
	
	public LauncherAPI() {
		Logger.info(String.format("Initialized LauncherAPI v%s by %s", VER, AUTHOR));
		
		Logger.info("Setting up...");
		Swinger.setSystemLookNFeel();
		Swinger.setResourcePath("/assets");
	}
	
	/**
	 *   > > > Bootstrapper > > >
	 */
	
	public BBuilder bootstrapperBuilder() {
		return new BBuilder();
	}
	
	public void updateBootstrapper() {
		Logger.info("[Bootstrapper] Preparing Update.");
		
		Logger.info("[Bootstrapper] Initializing UpdateHandler...");
		UpdateHandler handler = new UpdateHandler(bootstrapperInstance.getUpdateUrl(), bootstrapperInstance.getDir());
		try {
			handler.update();
		} catch (Exception e) {			
			crashReporter.catchError(e, "Error while updating: " + e.getMessage());
			lFrame.setFieldsState(true);
			e.printStackTrace();
		}
		handler.stop();
	}
	
	public void launchLauncher() {
		ExternalLaunchProfile elp = new ExternalLaunchProfile(bootstrapperInstance., classPath)
	}
	
	public void setBootstrapperInstance(BootstrapperInstance bootstrapperInstance) {
		this.bootstrapperInstance = bootstrapperInstance;
		
		errorHandler(bootstrapperInstance.getTitle());
	}
	
	/**
	 *   > > > Launcher > > >
	 */
	
	private CrashReporter crashReporter;
	private AuthInfos authInfos;
	private Saver saver;
	
	public LBuilder launcherBuilder() {
		Logger.info("[Launcher] Initializing LauncherBuilder...");
		return new LBuilder();
	}
	
	public FrameBuilder frameBuilder() {
		Logger.info("[Launcher] Initializing FrameBuilder...");
		return new FrameBuilder();
	}
	
	public void registerButtonHandler(AButtonHandler handler) {
		Logger.info("[Launcher] Registering ButtonHandler...");
		for(JComponent comp : handler.getFrame().getPanel().getLComponents()) {
			if(comp instanceof JButton)
				((JButton)comp).addActionListener(handler);
		}
	}
	
	public void updateLauncher() {
		Logger.info("[Launcher] Preparing Update.");
		
		Logger.info("[Launcher] Initializing UpdateHandler...");
		UpdateHandler handler = new UpdateHandler(launcherInstance.getUpdateUrl(), launcherInstance.getGameDir());
		try {
			handler.update();
		} catch (Exception e) {			
			crashReporter.catchError(e, "Error while updating: " + e.getMessage());
			lFrame.setFieldsState(true);
			e.printStackTrace();
		}
		handler.stop();
	}
	
	public void handleAuth(String username, String password) {
		getSaver().set("username", username);
		
		try {
			Authenticator auth = new Authenticator(Authenticator.MOJANG_AUTH_URL, AuthPoints.NORMAL_AUTH_POINTS);
			AuthResponse response = auth.authenticate(AuthAgent.MINECRAFT, username, password, "");
			authInfos = new AuthInfos(response.getSelectedProfile().getName(), response.getAccessToken(), response.getSelectedProfile().getId());
		} catch (AuthenticationException e) {
			crashReporter.catchError(e, "Error while connecting.");
			lFrame.setFieldsState(true);
			return;
		}
	}
	
	public void launchMinecraft() {
		// Depreacted because of Java 9 Compatibility, but who uses Java 9...
		try {
			InternalLaunchProfile profile = MinecraftLauncher.createInternalProfile(launcherInstance.getGameInfos(), GameFolder.BASIC, authInfos);
			InternalLauncher launcher = new InternalLauncher(profile);

			lFrame.setVisible(false);
			
			launcher.launch();
		} catch(LaunchException e) {
			e.printStackTrace();
			crashReporter.catchError(e, "Couldn't launch Minecraft.");
		}
		
		System.exit(0);
	}
	
	public Saver getSaver() {
		if(saver == null)
			saver = new Saver(new File(launcherInstance.getGameDir(), "launcher.properties"));		
		return saver;
	}
	
	public void setLauncherInstance(LauncherInstance launcherInstance) {
		this.launcherInstance = launcherInstance;
		
		errorHandler(launcherInstance.getName());
	}
	
	public void setFrame(LFrame lFrame) {
		this.lFrame = lFrame;
	}
	
	/**
	 *   > > > Global Utility > > >
	 */
	
	public void errorHandler(String name) {
		File f = new File(launcherInstance.getGameDir(), "crashes");
		if(!f.exists())
			f.mkdir();
		crashReporter = new CrashReporter(name, f);
	}
	
	public void exit() {
		Logger.info("[Launcher] Quitting...");
		Animator.fadeOutFrame(lFrame, 3, new Runnable() {
			@Override
			public void run() {
				System.exit(0);
			}
		});
	}

}
