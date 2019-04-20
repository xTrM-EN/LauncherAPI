package me.xtrm.LauncherAPI.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
	
	public static void log(String msg) { log(msg, Level.INFO, "LauncherAPI"); }
	public static void log(String msg, Level level) { log(msg, level, "LauncherAPI"); }
	
	public static void log(String msg, Level level, String process) {
		String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		String txt = "[" + time + "] [" + process + "/" + level + "]: " + msg;
		
		switch(level) {
			case ERROR:
			case FATAL:
				System.err.println(txt);
				break;
			default:
				System.out.println(txt);
				break;
		}
	}
	
	public static void info(String msg)  { log(msg, Level.INFO,  "LauncherAPI"); }
	public static void warn(String msg)  { log(msg, Level.WARN,  "LauncherAPI"); }
	public static void error(String msg) { log(msg, Level.ERROR, "LauncherAPI"); }
	public static void fatal(String msg) { log(msg, Level.FATAL, "LauncherAPI"); }
	public static void debug(String msg) { log(msg, Level.DEBUG, "LauncherAPI"); }

	public enum Level {
		INFO, WARN, ERROR, FATAL, DEBUG;
	}
	
}
