package de.luke.naruto.extras;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CreateGlow implements Listener {
	
	ItemStack item = new ItemStack(Material.STICK);
	ItemMeta itemMeta = item.getItemMeta();


	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Glow glow = new Glow(120);
		itemMeta.addEnchant(glow, 1, true);
		item.setItemMeta(itemMeta);
		
		player.getInventory().addItem(item);
		player.updateInventory();
	}
	
	
}
