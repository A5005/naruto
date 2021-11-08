package de.luke.naruto; //TODO Mehrere Level Gleichzeitig hoch


import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class Level implements Listener{
	
	
//public void PlayerJoin(PlayerLoginEvent event) {
//	Player p = event.getPlayer();
//	if(!p.hasPlayedBefore()) {
		
//	}
//}
	
	
	
	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		Entity entity = e.getEntity();
		Entity killer = e.getEntity().getKiller();
		
		
		if (killer instanceof Player) {
			
			
			String playerName = killer.getName();
			 File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Naruto").getDataFolder(), File.separator + "PlayerDatabase");
			 File f = new File(userdata, File.separator + playerName + ".yml");
			FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			
			int before = Calculator.level(playerData.getInt("xplevel.balance"));
			
			if (entity.getType() == EntityType.ZOMBIE);
		    int x = playerData.getInt("xplevel.balance") + 10;

		    playerData.set("xplevel.balance", x);
		    
		    int after = Calculator.level(playerData.getInt("xplevel.balance"));
		    
		    if (before != after) {
		    	killer.sendMessage("§a§lCongratulations! You leveld up " + before + " §a§l--> " + after);
		    	if (after < 26) {
		    		int y = playerData.getInt("force") + 1;
		    		playerData.set("force", y);
		    		killer.sendMessage("§c§lForce + 1");
		    		
		    		
		    	} else
		    	     if (after < 101) {
		    		int y1 = playerData.getInt("force") + 2;
		    		playerData.set("force", y1);
		    		killer.sendMessage("§c§lForce + 2");
		    	}
		    	     else {
				    		int y2 = playerData.getInt("force") + 3;
				    		playerData.set("force", y2);
				    		killer.sendMessage("§c§lForce + 3");
		    	     }
				    		
		    }
		    
		    

		    try {
				playerData.save(f);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			

				
				
				
			}
		}
		

	
		
			        
			
		}
		
		
	
