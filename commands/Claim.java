package de.luke.naruto.commands;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.luke.naruto.extras.TestDatabase;

public class Claim implements CommandExecutor {
	
	PreparedStatement st;
		ItemStack item1 = new ItemStack(Material.STICK);

		
		ItemStack item2 = new ItemStack(Material.WOOD_BUTTON);

		
		ItemStack item3 = new ItemStack(Material.STONE_BUTTON);

		
		ItemStack item4 = new ItemStack(Material.WOOD_PLATE);

		
		ItemStack item5 = new ItemStack(Material.STONE_PLATE);

		
		ItemStack item6 = new ItemStack(Material.FEATHER);

		
		ItemStack item7 = new ItemStack(Material.LEATHER);

		
		ItemStack item8 = new ItemStack(Material.PAPER);

		
		ItemStack item9 = new ItemStack(Material.BOOK);

	

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) {
				

				
				    ItemStack itemamount1 = new ItemStack(Material.STICK, getAmount(player, item1));
				    ItemStack itemamount2 = new ItemStack(Material.WOOD_BUTTON, getAmount(player, item2));    
					ItemStack itemamount3 = new ItemStack(Material.STONE_BUTTON, getAmount(player, item3));
				    ItemStack itemamount4 = new ItemStack(Material.WOOD_PLATE, getAmount(player, item4));
				    ItemStack itemamount5 = new ItemStack(Material.STONE_PLATE, getAmount(player, item5));    
					ItemStack itemamount6 = new ItemStack(Material.FEATHER, getAmount(player, item6));
				    ItemStack itemamount7 = new ItemStack(Material.LEATHER, getAmount(player, item7));
				    ItemStack itemamount8 = new ItemStack(Material.PAPER, getAmount(player, item8));    
					ItemStack itemamount9 = new ItemStack(Material.BOOK, getAmount(player, item9));

				try {
					st = TestDatabase.mysql.getConnection().prepareStatement("UPDATE `Materialnumber` SET `sticknumber` = ("+getAmount(player, item1)+"+(Select `sticknumber` WHERE `uuid` = \""+player.getUniqueId().toString()+"\")),`woodbuttonnumber` = ("+getAmount(player, item2)+"+(Select `woodbuttonnumber` WHERE `uuid` = \""+player.getUniqueId().toString()+"\")),`stonebuttonnumber` = ("+getAmount(player, item3)+"+(Select `stonebuttonnumber` WHERE `uuid` = \""+player.getUniqueId().toString()+"\")), `woodpreasureplatenumber` = ("+getAmount(player, item4)+"+(Select `woodpreasureplatenumber` WHERE `uuid` = \""+player.getUniqueId().toString()+"\")), `stonepreasureplatenumber` = ("+getAmount(player, item5)+"+(Select `stonepreasureplatenumber` WHERE `uuid` = \""+player.getUniqueId().toString()+"\")),  `feathernumber` = ("+getAmount(player, item6)+"+(Select `feathernumber` WHERE `uuid` = \""+player.getUniqueId().toString()+"\")), `leathernumber` = ("+getAmount(player, item7)+"+(Select `leathernumber` WHERE `uuid` = \""+player.getUniqueId().toString()+"\")),  `papernumber` = ("+getAmount(player, item8)+"+(Select `papernumber` WHERE `uuid` = \""+player.getUniqueId().toString()+"\")),  `booknumber` = ("+getAmount(player, item9)+"+(Select `booknumber` WHERE `uuid` = \""+player.getUniqueId().toString()+"\")) WHERE `uuid` = \""+player.getUniqueId().toString()+"\""); 
					st.execute();

					
				} catch (SQLException e) {
					player.sendMessage("§cDatabank error please contact an Admin");
					System.out.println("§cDatabank error Player:" + player.getName());
					e.printStackTrace();
					
				}
				
				player.getInventory().removeItem(itemamount1);
				player.getInventory().removeItem(itemamount2);
				player.getInventory().removeItem(itemamount3);
			    player.getInventory().removeItem(itemamount4);
				player.getInventory().removeItem(itemamount5);
				player.getInventory().removeItem(itemamount6);
				player.getInventory().removeItem(itemamount7);
				player.getInventory().removeItem(itemamount8);
				player.getInventory().removeItem(itemamount9);
				
				
				
				

 player.sendMessage("§F§lYou used your /Claim! Materials from your inventory were added to your §4§lCollection!");
					
					//TODO else Cooldown
				
				
			} else sender.sendMessage("Please Use /claim");
			
} else sender.sendMessage("§cCommand only for Players!");
		return false;
	}



public static int getAmount(Player player, ItemStack item) {
	if (item == null)
		return 0;
    int amount = 0;
    for (int i = 0; i < 36; i++) {
        ItemStack slot = player.getInventory().getItem(i);
        if (slot == null || !slot.isSimilar(item))
            continue;
        amount += slot.getAmount();
    }
    return amount;
}
}
