package me.xtrm.LauncherAPI.launcher;

public class LBuilder {
	
	private String name, version, updateUrl;
	private boolean forge, shaders, optifine;
	
	public LBuilder() {
		this.forge = this.shaders = this.optifine = false;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}
	
	public void usesForge(boolean forge) {
		this.forge = forge;
	}
	
	public void usesShaders(boolean shaders) {
		this.shaders = shaders;
	}
	
	public void usesOptifine(boolean optifine) {
		this.optifine = optifine;
	}
	
	public LauncherInstance build() {
		return new LauncherInstance(name, version, updateUrl, forge, shaders, optifine);
	}

}
