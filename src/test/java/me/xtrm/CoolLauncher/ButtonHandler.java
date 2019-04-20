package me.xtrm.CoolLauncher;

import me.xtrm.LauncherAPI.LauncherAPI;
import me.xtrm.LauncherAPI.components.jswing.PasswordField;
import me.xtrm.LauncherAPI.components.jswing.TextField;
import me.xtrm.LauncherAPI.launcher.handle.AButtonHandler;
import me.xtrm.LauncherAPI.launcher.swing.frame.LFrame;

public class ButtonHandler extends AButtonHandler {

	public ButtonHandler(LauncherAPI api, LFrame frame) {
		super(api, frame);
	}

	@Override
	public void onButtonClicked(String buttonName) {
		switch(buttonName) {
			case "quitButton":
				getAPI().exit();
				break;
			case "minimizeButton":
				getFrame().minimize();
				break;
			case "playButton":
				getFrame().setFieldsState(false);
				
				TextField username = (TextField)getFrame().getPanel().getLComponent("usernameField");
				PasswordField password = (PasswordField)getFrame().getPanel().getLComponent("passwordField");
				
				getAPI().updateLauncher();
				getAPI().handleAuth(username.getText(), password.getText());
				getAPI().launchMinecraft();
				break;
		}
	}

}
