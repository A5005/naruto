package de.luke.naruto.main;


import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.luke.naruto.BindItems;
import de.luke.naruto.Calculator;
import de.luke.naruto.Collection;
import de.luke.naruto.Level;
import de.luke.naruto.PlayerList;
import de.luke.naruto.commands.Broadcast;
import de.luke.naruto.commands.Bypass;
import de.luke.naruto.commands.Claim;
import de.luke.naruto.commands.ClearChat;
import de.luke.naruto.commands.Force;
import de.luke.naruto.commands.ThrowingAxe;
import de.luke.naruto.extras.CreateGlow;
import de.luke.naruto.extras.Glow;
import de.luke.naruto.extras.TestDatabase;
import de.luke.naruto.weapons.WeaponHandler;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	public void onEnable() {
		plugin = this;
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new WeaponHandler(this), this);
		System.out.println("Ninja Plugin Enabled");
		getServer().getPluginManager().registerEvents(new PlayerList(), this);
		getServer().getPluginManager().registerEvents(new Level(), this);
		getServer().getPluginManager().registerEvents(new BindItems(), this);
		getServer().getPluginManager().registerEvents(new Collection(), this);
		getServer().getPluginManager().registerEvents(new CreateGlow(), this);
		
		getCommand("level").setExecutor(new Calculator());
		getCommand("force").setExecutor(new Force());
		getCommand("bypass").setExecutor(new Bypass());
		getCommand("clearchat").setExecutor(new ClearChat());
		getCommand("cc").setExecutor(new ClearChat());
		getCommand("broadcast").setExecutor(new Broadcast());
		getCommand("bc").setExecutor(new Broadcast());
		getCommand("claim").setExecutor(new Claim());
		getCommand("givethrowingaxe").setExecutor(new ThrowingAxe());
		
		Collection.Build();
		
		
		Glow.registerGlow();
		TestDatabase.loadMySQL();

	}
	
	//Broadcast Welcome Message in BindItems
       
		
	

	public static Main getPlugin() {
		return plugin;
		
		
	}


	

}
