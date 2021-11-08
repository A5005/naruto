package de.luke.naruto;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerList implements Listener {
	
	

        
	
	
	
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();	
		player.sendMessage("§aWilkommen");
	String playerName = player.getName();
    File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Naruto").getDataFolder(), File.separator + "PlayerDatabase");
    File f = new File(userdata, File.separator + playerName + ".yml");
    FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
   
    int x = playerData.getInt("stats.totalLogins") + 1;
    playerData.set("stats.totalLogins", x);
    
    if (playerData.getInt("xplevel.balance") < 100) {
    	playerData.set("xplevel.balance", 100);
    }
    
    if (playerData.getInt("force") < 1) {
    	playerData.set("force", 1);
  
    	
    }
    
    try {
		playerData.save(f);
	} catch (IOException e) {
		
		e.printStackTrace();
	}



}
	
}
