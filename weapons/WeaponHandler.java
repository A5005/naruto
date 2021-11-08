package de.luke.naruto.weapons;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import de.luke.naruto.main.Main;


public class WeaponHandler implements Listener {
	
	private ArrayList<Weapon> weapons;
	
	public WeaponHandler(Main plugin) {

		weapons = new ArrayList<>();
		weapons.add(new Rifle(plugin, Material.IRON_HOE, 10, 2.0));
		weapons.add(new Launcher(plugin, Material.GOLD_HOE, 20*5, 10));
		weapons.add(new Test(plugin, Material.ARROW, 20, 10));
		
		
	}
	
	
	@EventHandler
	public void handleWeaponShot(PlayerInteractEvent event) {
		if(event.getAction() != Action.RIGHT_CLICK_AIR) return;
		Weapon weapon = checkWeaponMaterial(event.getItem().getType());
		if(weapon != null) {
			weapon.shoot(event.getPlayer());
			
		}


	}
	
	@EventHandler
	public void handleWeaponDamage(EntityDamageByEntityEvent event) {
		
		if(!(event.getDamager() instanceof Projectile)) return;
		Projectile projectile = (Projectile) event.getDamager();
		if(!(projectile.getShooter() instanceof Player)) return;
		Player player = (Player) projectile.getShooter();
		Weapon weapon = checkWeaponMaterial(player.getItemInHand().getType());
		
		if(weapon!= null) {
			
	        String playerName = Weapon.playerName;
		    File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Naruto").getDataFolder(), File.separator + "PlayerDatabase");
		    File f = new File(userdata, File.separator + playerName + ".yml");
		    FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		    
			event.setDamage(weapon.getDamage() + 1 *(playerData.getInt("force")) / 10);
		}
		
	}
	
	private Weapon checkWeaponMaterial(Material material) {
		for(Weapon current : weapons) {
			if(current.getMaterial() == material) {
				return current;
			}
				
			
		} return null;
		
		
	}
	@EventHandler
	public void onArrowHit(ProjectileHitEvent event){
		  if(event.getEntity() instanceof Arrow){
		    Arrow arrow = (Arrow) event.getEntity();
		    arrow.remove();
		  }
		}

}
