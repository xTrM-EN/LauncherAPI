package me.xtrm.CoolLauncher;

import me.xtrm.LauncherAPI.LauncherAPI;

public class Main {

	public static void main(String[] args) {
		LauncherAPI api = new LauncherAPI();
		
		Launcher l = new Launcher(api);
		l.init();
	}
	
}
