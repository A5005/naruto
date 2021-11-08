package de.luke.naruto;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Calculator implements CommandExecutor {

	//Level 1 = 0xp
	//Level 2 = 200xp
	//Level 3 = 200xp+(3*100)
	//Level 4 = 500xp+(400)
	//Level 5 = 900xp +(500)
	

	
	 public static int level(int xp) {
		 int x = 200;
		 int Durchläufe = 0;
		 while (!(x > xp)) {
			 x = x + (Durchläufe + 3) * 100;
			 Durchläufe++;
		 }
		 
		 
		 
		 
		 return (Durchläufe + 1);
	 }

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			String playerName = player.getName();
		    File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Naruto").getDataFolder(), File.separator + "PlayerDatabase");
		    File f = new File(userdata, File.separator + playerName + ".yml");
		    FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			sender.sendMessage("§a§lLevel: "+ level(playerData.getInt("xplevel.balance")));
			
			
			
			
		} else sender.sendMessage("§cCommand only for Players!");
	
        
		return false;
	}
}
