package github.vexio.commandblocker.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import github.vexio.commandblocker.Main;

public class CommandListener implements Listener {
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void commandBlocker(PlayerCommandPreprocessEvent event) {
		for (int i = 0; i < Main.getPlugin().getConfig().getStringList("blocker.commands").size(); i++) {
			if (event.getMessage().equalsIgnoreCase("/" + Main.getPlugin().getConfig().getStringList("blocker.commands").get(i)) 
					|| event.getMessage().toLowerCase().startsWith("/" + Main.getPlugin().getConfig().getStringList("blocker.commands").get(i) + " ")) {
				event.setCancelled(true);
				event.getPlayer().sendMessage(Main.getPlugin().getConfig().getString("blocker.message").replace("&", "§").replace("{COMMAND}" , event.getMessage()));
			}
		}
	}

}
