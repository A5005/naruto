package de.luke.naruto.commands;



import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
if ((sender instanceof ConsoleCommandSender) || (sender instanceof Player) ) {
	
	int i= 0;
	while (i < 50) {
			Bukkit.broadcastMessage("");
			i++;}
	

			

			
} else sender.sendMessage("§cCommand only for Console and Player!");
		return false;
	}
}
