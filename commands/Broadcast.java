package de.luke.naruto.commands;



import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
if(sender instanceof Player) {
	Player player = (Player) sender;
	
	
	if (player.isOp() == true) {
		if ((args.length > 0) && (args.length < 9) ) {
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			
			if (args.length == 1 ) {	
			Bukkit.broadcastMessage("§f§l" + args[0]);}
		if (args.length == 2 ) {
			Bukkit.broadcastMessage("§f§l" + args[0] +" "+ args[1]);}
		if (args.length == 3 ) {
			Bukkit.broadcastMessage("§f§l" + args[0] +" "+ args[1] + " "+args[2]);}
		if (args.length == 4 ) {
			Bukkit.broadcastMessage("§f§l" + args[0] +" "+ args[1] +" "+ args[2] + " "+args[3]);}
		if (args.length == 5 ) {
			Bukkit.broadcastMessage("§f§l" + args[0] + " "+args[1] + " "+args[2] +" "+ args[3] + " "+args[4]);}
		if (args.length == 6 ) {
			Bukkit.broadcastMessage("§f§l" + args[0] + " "+args[1] +" "+ args[2] + " "+args[3] + " "+args[4] +" "+ args[5]);}
		if (args.length == 7 ) {
			Bukkit.broadcastMessage("§f§l" + args[0] + " "+args[1] + " "+args[2] + " "+args[3] +" "+ args[4] + " "+args[5] + " "+args[6]);}
		if (args.length == 8 ) {
			Bukkit.broadcastMessage("§f§l" + args[0] + " "+args[1] + " "+args[2] +" "+ args[3] + " "+args[4] + " "+args[5] +" "+ args[6] +" "+ args[7]);}

		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage(" ");
		} else player.sendMessage("§f§lUse /Broadcast [Message (Max 8 Words)]");
	} else sender.sendMessage("§c§lInsufficent Permissions");
	

	

			

			
} else sender.sendMessage("§cCommand only for Console and Player!");
		return false;
	}
}
