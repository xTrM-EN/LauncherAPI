package me.xtrm.LauncherAPI.bootstrapper;

import me.xtrm.LauncherAPI.utils.Resource;

public class BBuilder {
	
	private String name;
	private Resource splash;
	private boolean transparent;

	public void setName(String name) {
		this.name = name;
	}
	
	public void setSplash(Resource res) {
		this.splash = res;
	}
	
	public void setTransparent(boolean state) {
		this.transparent = state;
	}
	
	public BootstrapperInstance build() {
		return new BootstrapperInstance(name, splash, transparent);
	}
	
}
