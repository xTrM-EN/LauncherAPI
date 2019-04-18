package me.xtrm.LauncherAPI.launcher;

import java.io.File;

import fr.theshark34.openlauncherlib.minecraft.GameInfos;
import fr.theshark34.openlauncherlib.minecraft.GameTweak;
import fr.theshark34.openlauncherlib.minecraft.GameType;
import fr.theshark34.openlauncherlib.minecraft.GameVersion;

public class LauncherInstance {

	private String name, version, updateUrl;
	private boolean forge, shaders, optifine;
	
	public LauncherInstance(String name, String version, String updateUrl, boolean forge, boolean shaders, boolean optifine) {
		this.name = name;
		this.version = version;
		this.updateUrl = updateUrl;
		this.forge = forge;
		this.shaders = shaders;
		this.optifine = optifine;
	}
	
	public String getName() {
		return name;
	}
	
	public String getVersion() {
		return version;
	}
	
	public String getUpdateUrl() {
		return updateUrl;
	}
	
	public boolean isVanilla() {
		return !forge && !shaders && !optifine;
	}
	
	public boolean usesForge() {
		return forge;
	}
	
	public boolean usesOptifine() {
		return optifine;
	}
	
	public boolean usesShaders() {
		return shaders;
	}
	
	public GameType getGameType() {
		int ver = Integer.parseInt(version.split(".")[1]);
		
		if(version == "1.7.10")
			return GameType.V1_7_10;
		
		if(ver >= 8)
			return GameType.V1_8_HIGHER;
		
		if(ver > 5)
			return GameType.V1_7_2_LOWER;
	
		if(ver <= 5)
			return GameType.V1_5_2_LOWER;
		
		return null;
	}
	
	public GameVersion getGameVersion() {
		return new GameVersion(version, getGameType());
	}
	
	public GameTweak[] getGameTweaks() {
		if(isVanilla())
			return null;
		
		if(forge)
			return new GameTweak[] {GameTweak.FORGE};
		
		if(optifine)
			if(shaders)
				return new GameTweak[] {GameTweak.OPTIFINE, GameTweak.SHADER};
			else
				return new GameTweak[] {GameTweak.OPTIFINE};
		
		if(shaders)
			return new GameTweak[] {GameTweak.SHADER};
		
		return null;
	}
	
	public GameInfos getGameInfos() {
		return new GameInfos(name, getGameVersion(), getGameTweaks());
	}
	
	public File getGameDir() {
		return getGameInfos().getGameDir();
	}
}
