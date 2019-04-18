package me.xtrm.LauncherAPI.utils;

public class Resource {
	
	private String name, path;
	
	public Resource(String name) {
		this.name = name;
		this.path = "/";
	}
	
	public Resource(String path, String name) {
		this.path = path;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPath() {
		return path;
	}
	
	public String getFullPath() {
		String p = path;
		
		if(!p.endsWith("/"))
			p = p + "/";
		
		if(!p.startsWith("/"))
			p = "/" + p;
		
		return p + name;
	}

}
