package me.xtrm.LauncherAPI.handle;

import java.io.File;

import javax.swing.JComponent;
import javax.swing.JProgressBar;

import fr.theshark34.supdate.BarAPI;
import fr.theshark34.supdate.SUpdate;
import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.abstractcomponents.AbstractProgressBar;
import me.xtrm.LauncherAPI.utils.Logger;

/**
 * Handler in charge of Updating
 * (& ProgressBar if it exists)
 * @author xTrM_
 */
public class UpdateHandler {
	
	private String url;
	private File folder;
	private JComponent bar;
	
	/**
	 * Where first arg is DownloadedFiles,
	 * Second is TotalFiles
	 * And Third is Percentage
	 * Ex: "Downloading %s out of %s files (%s%%)"
	 *     "Downloading 5 out of 50 files (10%)"
	 */
	private String infoText;
	
	private Thread thread;
	
	public UpdateHandler(String url, File folder) {
		this.url = url;
		this.folder = folder;
	}
	
	public UpdateHandler(String url, File folder, JComponent bar, String infoText) {
		this.url = url;
		this.folder = folder;
		this.bar = bar;
		this.infoText = infoText;
	}
	
	public void update() throws Exception {
		Logger.info("[UpdateHandler] Initializing SUpdate...");
		SUpdate su = new SUpdate(url, folder);
		
		if(bar != null) {
			Logger.info("[UpdateHandler] Creating Bar Thread...");
			(thread = new Thread() {
				@Override
				public void run() {
					int val = 0;
					int max = 0;
					
					while(!this.isInterrupted()) {
						val = (int)(BarAPI.getNumberOfTotalDownloadedBytes() / 1000);
						max = (int)(BarAPI.getNumberOfTotalBytesToDownload() / 1000);
						
						if(bar instanceof JProgressBar) {
							((JProgressBar)bar).setMaximum(max);
							((JProgressBar)bar).setValue(val);
							((JProgressBar)bar).setStringPainted(true);
							((JProgressBar)bar).setString(String.format(infoText, BarAPI.getNumberOfDownloadedFiles(), BarAPI.getNumberOfFileToDownload(), Swinger.percentage(val, max)));
						} else if(bar instanceof AbstractProgressBar) {
							((AbstractProgressBar)bar).setMaximum(max);
							((AbstractProgressBar)bar).setValue(val);
							((AbstractProgressBar)bar).setStringPainted(true);
							((AbstractProgressBar)bar).setString(String.format(infoText, BarAPI.getNumberOfDownloadedFiles(), BarAPI.getNumberOfFileToDownload(), Swinger.percentage(val, max)));
						}
					}
				}
			}).run();
		}
		
		Logger.info("[UpdateHandler] Starting update...");
		su.start();
		Logger.info("[UpdateHandler] Update finished!");
		
		Logger.info("[UpdateHandler] Interrupting Thread...");
		thread.interrupt();
	}
	
	public void stop() {
		if(thread != null)
			thread.interrupt();
	}

}
