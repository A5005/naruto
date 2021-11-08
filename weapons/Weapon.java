package de.luke.naruto.weapons;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.luke.naruto.main.Main;

public abstract class Weapon {
	
	private Main plugin;
    private Material material;
    private long reloadTime;
    private ArrayList<String> shotWeapon;
    public static String playerName;
    private double damage;
    
    
	public Weapon(Main plugin, Material material, long reloadTime, double damage) {
		super();
		this.plugin = plugin;
		this.material = material;
		this.reloadTime = reloadTime;
		this.damage = damage;
		
		shotWeapon = new ArrayList<>();
	}
    
	public void shoot(Player player) {
		if(!shotWeapon.contains(player.getName())) {
			shotWeapon.add(player.getName());
			playerName = player.getName();
			shootEffects(player);
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					shotWeapon.remove(player.getName());
				} 
				
				
			}, reloadTime);
					} 
		
	}
	
	public abstract void shootEffects(Player player);

	public Material getMaterial() {
		return material;
	}

	public double getDamage() {
		return damage;
	}



	
	
	
}
