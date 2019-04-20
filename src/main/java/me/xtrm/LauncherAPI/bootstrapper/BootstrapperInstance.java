package me.xtrm.LauncherAPI.bootstrapper;

import java.io.File;

import me.xtrm.LauncherAPI.utils.Resource;

public class BootstrapperInstance {

	private String name, mainClass;
	private Resource splash;
	private boolean transparent;
	private File file;
	
	public BootstrapperInstance(String name, String mainClass, Resource splash, boolean transparent, File file) {
		this.name = name;
		this.mainClass = mainClass;
		this.splash = splash;
		this.transparent = transparent;
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public Resource getSplash() {
		return splash;
	}

	public boolean isTransparent() {
		return transparent;
	}

	public File getFile() {
		return file;
	}
	
	public LauncherInfos getLauncherInfos() {
		return new LauncherInfos(name, mainClass);
	}
	
}
