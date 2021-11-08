package de.luke.naruto.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import customweapons.ItemManager;

public class ThrowingAxe implements CommandExecutor {
	



	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arg1) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if (player.isOp()) {
				if(command.getName().equalsIgnoreCase("givethrowingaxe")) {
					player.getInventory().addItem(ItemManager.ThrowingAxe);
				}
			}
			
		} else {
			sender.sendMessage("§cOnly Players can use this command");
		}
		return true;
	}
	
}


