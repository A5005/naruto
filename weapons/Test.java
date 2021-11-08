package de.luke.naruto.weapons;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;

import de.luke.naruto.main.Main;

public class Test extends Weapon {

	public Test(Main plugin, Material material, long reloadTime, double damage) {
		super(plugin, material, reloadTime, damage);
		
	}

	@Override
	public void shootEffects(Player player) {
		Arrow projectile = player.launchProjectile(Arrow.class);
		projectile.setVelocity(projectile.getVelocity().multiply(1.5));
		
	}

}