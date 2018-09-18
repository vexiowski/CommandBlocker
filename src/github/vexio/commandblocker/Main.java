package github.vexio.commandblocker;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import github.vexio.commandblocker.listeners.CommandListener;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	
	public static Main getPlugin() {
		return plugin;
	}
	
	public void onEnable() {
		plugin = this;
		saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(new CommandListener(), this);
	}

}
