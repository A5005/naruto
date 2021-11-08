package de.luke.naruto.commands;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.luke.naruto.extras.TestDatabase;

public class Bypass implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("bypass.*")) {
				if(args.length == 0) {
				    try {
						if ((isInDatabase(player.getUniqueId().toString()))) { //Update in isInDatabase
							
							if (isBypassed(player.getUniqueId().toString()) == true) {

						try {
							setBypass(player.getUniqueId().toString(), false);
							sender.sendMessage("§cNot Bypassing permissions anymore.");

						} catch (SQLException e) {
							e.printStackTrace();
							sender.sendMessage("§cDatabank Error");
						}
						
							} else {
							  sender.sendMessage("§aBypassing permissions now.");
							
							try {
								setBypass(player.getUniqueId().toString(), true);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							}
						
						} else {
						  sender.sendMessage("§aBypassing permissions now.");
						  System.out.println("New Databank Player bypass listing");
						
						try {
							setBypass(player.getUniqueId().toString(), true);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
						}
						
						
					} catch (SQLException e1) {
						System.out.println("§fDatabank Error");
						e1.printStackTrace();
					}
				    
				    

					
				} else player.sendMessage("§cUse /Bypass");
				
				
			} else sender.sendMessage("§cYou can not perform this command");

} else sender.sendMessage("§cCommand only for Players!");
		return false;
	}
	
	public static void setBypass(String uuid, boolean bypassenabled) throws SQLException {
		PreparedStatement st = null;
		if (isInDatabase(uuid)) { //Update in isInDatabase
			st = TestDatabase.mysql.getSafeConnection().prepareStatement("UPDATE `BypassInfo` SET `bypassenabled` = ? WHERE `uuid` = ?");
			st.setBoolean(1, bypassenabled);
			st.setString(2, uuid);
			st.execute();
		} else {
			st = TestDatabase.mysql.getConnection().prepareStatement("INSERT INTO `BypassInfo`(`uuid`,`bypassenabled`) VALUES (?,?)");
			st.setString(1, uuid);
			st.setBoolean(2, bypassenabled);
			st.execute();
		}
			
		}
			
	
		
	
	
	public static boolean isInDatabase(String uuid) throws SQLException {   
		PreparedStatement st = TestDatabase.mysql.getConnection().prepareStatement("Select `uuid` FROM `BypassInfo` WHERE `uuid` = ?");
		st.setString(1, uuid);
		ResultSet rs = st.executeQuery();

		
		while(rs.next()) {
		return true;
	} 
	return false;

	

	
}
	
	public static boolean isBypassed(String uuid) throws SQLException {
		boolean isbypassed = false;
		if (isInDatabase(uuid)) {
		PreparedStatement st = TestDatabase.mysql.getSafeConnection().prepareStatement("Select `bypassenabled` FROM `BypassInfo` WHERE `uuid` = ?");
		st.setString(1, uuid);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			isbypassed = rs.getBoolean("bypassenabled");
		
		
	}
		}
		return isbypassed;
}
}
