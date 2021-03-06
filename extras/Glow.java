package de.luke.naruto.extras;



import java.lang.reflect.Field;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;


public class Glow extends Enchantment implements Listener {

  public Glow(int id) {
      super(id);
  } //set to 120

  @Override
  public boolean canEnchantItem(ItemStack arg0) {
      return false;
  }

  @Override
  public boolean conflictsWith(Enchantment arg0) {
      return false;
  }

  @Override
  public EnchantmentTarget getItemTarget() {
      return null;
  }

  @Override
  public int getMaxLevel() {
      return 0;
  }

  @Override
  public String getName() {
      return null;
  }

  @Override
  public int getStartLevel() {
      return 0;
  }
  
  
  public static void registerGlow() {
      try {
          Field f = Enchantment.class.getDeclaredField("acceptingNew");
          f.setAccessible(true);
          f.set(null, true);
      }
      catch (Exception e) {
          e.printStackTrace();
      }
      try {
          Glow glow = new Glow(120);
          Enchantment.registerEnchantment(glow);
      }
      catch (IllegalArgumentException e){
      }
      catch(Exception e){
          e.printStackTrace();
      }
  }

	
	
}

	