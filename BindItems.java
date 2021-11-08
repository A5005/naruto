package de.luke.naruto;

import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.luke.naruto.commands.Bypass;
import de.luke.naruto.extras.TestDatabase;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class BindItems implements Listener {

	@EventHandler
	public void onPlayerFirstJoin(PlayerJoinEvent event) throws SQLException {
		Player p = event.getPlayer();

		if (!p.hasPlayedBefore()) {
			ItemStack arrow = new ItemStack(Material.ARROW);
			ItemMeta arrowim = arrow.getItemMeta();
			arrowim.setDisplayName("§f§lKunai");
			arrow.setItemMeta(arrowim);

			p.getInventory().setItem(8, new ItemStack(arrow));

			p.updateInventory();

			ItemStack chest = new ItemStack(Material.ENDER_CHEST);
			ItemMeta chestim = chest.getItemMeta();
			chestim.setDisplayName("§c§lCollection");
			chest.setItemMeta(chestim);
			p.getInventory().setItem(17, new ItemStack(chest));

			p.updateInventory();
			Bukkit.broadcastMessage("§bWelcome §a" + p.getName() + " §bto the Server!");

			PreparedStatement st = null;

			st = TestDatabase.mysql.getConnection().prepareStatement(
					"INSERT INTO `Materialnumber`(`uuid`,`sticknumber`,`woodbuttonnumber`,`stonebuttonnumber`,`woodpreasureplatenumber`,`stonepreasureplatenumber`,`feathernumber`,`leathernumber`,`papernumber`,`booknumber`,`stringnumber`,`bonenumber`,`bricknumber`,`netherbricknumber`,`claynumber`,`coalnumber`,`flintnumber`,`gunpowdernumber`,`fireworkstarnumber`,`spidereggnumber`,`glowstonenumber`,`quartznumber`,`magmacreamnumber`,`ironnumber`,`goldnumber`,`prismarineshardnumber`,`prismarinecrystalnumber`,`compassnumber`,`ghasttearnumber`,`blazepowdernumber`,`slimeballnumber`,`eyeofendernumber`,`diamondnumber`,`emeraldnumber`,`bottleofenchantingnumber`,`netherstarnumber`,`endcrystalnumber`) VALUES (\""
							+ p.getUniqueId().toString()
							+ "\",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
			st.execute();
			
			st = TestDatabase.mysql.getConnection()
					.prepareStatement("INSERT INTO `Arrow`(`uuid`, `number`, `hasblueprint`, `level`) VALUES (\""
							+ p.getUniqueId() + "\",0,true,1)");
			st.execute();
		}

	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent event) {
		Player p = event.getPlayer();
		ItemStack arrow = new ItemStack(Material.ARROW);
		ItemMeta arrowim = arrow.getItemMeta();
		arrowim.setDisplayName("§f§lKunai");
		arrow.setItemMeta(arrowim);

		p.getInventory().setItem(8, new ItemStack(arrow));

		p.updateInventory();

		ItemStack chest = new ItemStack(Material.ENDER_CHEST);
		ItemMeta chestim = chest.getItemMeta();
		chestim.setDisplayName("§c§lCollection");
		chest.setItemMeta(chestim);
		p.getInventory().setItem(17, new ItemStack(chest));

		p.updateInventory();

	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent event) throws SQLException {
		Player player = event.getPlayer();
		if (Bypass.isBypassed(player.getUniqueId().toString()) == false) {
			event.setCancelled(true);
		}

	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) throws SQLException {

		if (event.getWhoClicked() instanceof Player) {
			if (event.getClickedInventory() == null)
				return;
			if ((event.getCurrentItem().getType() == Material.ENDER_CHEST)) {
				Collection.openGUIcommonMaterials((Player) event.getWhoClicked());
				event.setCancelled(true);
				return;
			}

			if ((event.getWhoClicked().getOpenInventory().getTopInventory().getName().toString().contains("Material"))
					|| (event.getWhoClicked().getOpenInventory().getTopInventory().getName().toString()
							.contains("Weapons"))) {

				event.setCancelled(true);
			}

		} else
			event.setCancelled(true);

	}

	@EventHandler
	public void onSetAttempt(PlayerInteractEvent event) throws SQLException {
		// check if the action is left click or an attempt to break a block AND the
		// block is bedrock
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Player player = event.getPlayer();
			if (Bypass.isBypassed(player.getUniqueId().toString()) == false) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onBreakAttempt(PlayerInteractEvent event) throws SQLException {
		// check if the action is left click or an attempt to break a block AND the
		// block is bedrock
		if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
			Player player = event.getPlayer();
			if (Bypass.isBypassed(player.getUniqueId().toString()) == false) {
				event.setCancelled(true);
			}
		}
	}

	// Hunger loss
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}

}
