package de.luke.naruto.commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Force implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			String playerName = player.getName();
		    File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Naruto").getDataFolder(), File.separator + "PlayerDatabase");
		    File f = new File(userdata, File.separator + playerName + ".yml");
		    FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
			sender.sendMessage("§c§lForce: "+ (playerData.getInt("force")));
			
} else sender.sendMessage("§cCommand only for Players!");
		return false;
	}
}
