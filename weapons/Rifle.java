package de.luke.naruto.weapons;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;

import de.luke.naruto.main.Main;

public class Rifle extends Weapon {

	public Rifle(Main plugin, Material material, long reloadTime, double damage) {
		super(plugin, material, reloadTime, damage);
		
	}

	@Override
	public void shootEffects(Player player) {
		Snowball projectile = player.launchProjectile(Snowball.class);
		projectile.setVelocity(projectile.getVelocity().multiply(7));
		
	}

}
