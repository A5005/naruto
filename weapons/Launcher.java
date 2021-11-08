package de.luke.naruto.weapons;

import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

import de.luke.naruto.main.Main;

public class Launcher extends Weapon {

	public Launcher(Main plugin, Material material, long reloadTime, double damage) {
		super(plugin, material, reloadTime, damage);
		
	}

	@Override
	public void shootEffects(Player player) {
		Fireball projectile = player.launchProjectile(Fireball.class); //projectile nur ein Name kann auch z.B Ball heiﬂen
		projectile.setIsIncendiary(false);
		projectile.setYield(0f);
		projectile.setVelocity(projectile.getVelocity().multiply(2));
	
		
	}

}
