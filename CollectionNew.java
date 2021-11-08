package de.luke.naruto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import de.luke.naruto.extras.Glow;
import de.luke.naruto.extras.TestDatabase;

public class CollectionNew implements Listener {

	static ItemStack commonMaterialGlow;
	static ItemStack commonMaterial;
	static ItemStack uncommonMaterial;
	static ItemStack uncommonMaterialGlow;
	static ItemStack rareMaterial;
	static ItemStack rareMaterialGlow;
	static ItemStack epicMaterial;
	static ItemStack epicMaterialGlow;
	static ItemStack commonWeapons;
	static ItemStack commonWeaponsGlow;
	static ItemStack uncommonWeapons;
	static ItemStack uncommonWeaponsGlow;
	static ItemStack rareWeapons;
	static ItemStack rareWeaponsGlow;
	static ItemStack legendaryWeapons;
	static ItemStack legendaryWeaponsGlow;
	static ItemStack exclusiveWeapons;
	static ItemStack exclusiveWeaponsGlow;
	static ItemStack glas;

	static ItemStack Stick;
	static ItemMeta Stickim;

	static ItemStack Woodbutton;
	static ItemMeta Woodbuttonim;

	static ItemStack Stonebutton;
	static ItemMeta Stonebuttonim;

	static ItemStack Woodpreasureplate;
	static ItemMeta Woodpreasureplateim;

	static ItemStack Stonepreasureplate;
	static ItemMeta Stonepreasureplateim;

	static ItemStack Feather;
	static ItemMeta Featherim;

	static ItemStack Leather;
	static ItemMeta Leatherim;

	static ItemStack Paper;
	static ItemMeta Paperim;

	static ItemStack Book;
	static ItemMeta Bookim;

	static List<String> arrowlore = new ArrayList<>();

	static ItemStack Arrow;
	static ItemMeta Arrowim;

	static ItemStack Arrowamount;
	static ItemMeta Arrowamountim;

	static List<String> workbenchlore = new ArrayList<>();

	static ItemStack Workbench;
	static ItemMeta Workbenchim;

	static ItemStack Wool;
	static ItemMeta Woolim;

	@SuppressWarnings("deprecation")
	public static void Build() {

		ArrayList<ItemData> itemDatas = new ArrayList<ItemData>();
		itemDatas.add(new ItemData(Material.WORKBENCH, 0, "§f§lCraft"));

		Workbench = new MaterialData(Material.WORKBENCH, (byte) 0).toItemStack(1);
		Workbenchim = Workbench.getItemMeta();
		Workbenchim.setDisplayName("§f§lCraft");

		Wool = new MaterialData(Material.WOOL, (byte) 5).toItemStack(1);
		Woolim = Wool.getItemMeta();
		Woolim.setDisplayName("§a§lClaim");
		Wool.setItemMeta(Woolim);

		Stick = new MaterialData(Material.STICK, (byte) 0).toItemStack(1);
		Stickim = Stick.getItemMeta();
		Stickim.setDisplayName("§f§lStick");

		Woodbutton = new MaterialData(Material.WOOD_BUTTON, (byte) 0).toItemStack(1);
		Woodbuttonim = Woodbutton.getItemMeta();
		Woodbuttonim.setDisplayName("§f§lWooden Button");

		Stonebutton = new MaterialData(Material.STONE_BUTTON, (byte) 0).toItemStack(1);
		Stonebuttonim = Stonebutton.getItemMeta();
		Stonebuttonim.setDisplayName("§f§lStone Button");

		Woodpreasureplate = new MaterialData(Material.WOOD_PLATE, (byte) 0).toItemStack(1);
		Woodpreasureplateim = Woodpreasureplate.getItemMeta();
		Woodpreasureplateim.setDisplayName("§f§lWooden Pressure Plate");

		Stonepreasureplate = new MaterialData(Material.STONE_PLATE, (byte) 0).toItemStack(1);
		Stonepreasureplateim = Stonepreasureplate.getItemMeta();
		Stonepreasureplateim.setDisplayName("§f§lStone Pressure Plate");

		Feather = new MaterialData(Material.FEATHER, (byte) 0).toItemStack(1);
		Featherim = Feather.getItemMeta();
		Featherim.setDisplayName("§f§lFeather");

		Leather = new MaterialData(Material.LEATHER, (byte) 0).toItemStack(1);
		Leatherim = Leather.getItemMeta();
		Leatherim.setDisplayName("§f§lLeather");

		Paper = new MaterialData(Material.PAPER, (byte) 0).toItemStack(1);
		Paperim = Paper.getItemMeta();
		Paperim.setDisplayName("§f§lPaper");

		Book = new MaterialData(Material.BOOK, (byte) 0).toItemStack(1);
		Bookim = Book.getItemMeta();
		Bookim.setDisplayName("§f§lBook");

		arrowlore.add("§7Click to open the menu!");

		Arrow = new MaterialData(Material.ARROW, (byte) 0).toItemStack(1);
		Arrowim = Arrow.getItemMeta();
		Arrowim.setDisplayName("§f§lThrowing Knife");
		Arrowim.setLore(arrowlore);
		Arrow.setItemMeta(Arrowim);

		Glow glow = new Glow(120); // 120 for custom enchant glow

		System.out.println("ItemStacks Builded!");
		commonMaterial = new MaterialData(Material.INK_SACK, (byte) 8).toItemStack(1);
		ItemMeta commonMaterialim = commonMaterial.getItemMeta();
		commonMaterialim.setDisplayName("§7§lCommon Materials");
		commonMaterial.setItemMeta(commonMaterialim);

		commonMaterialGlow = new MaterialData(Material.INK_SACK, (byte) 8).toItemStack(1);
		ItemMeta commonMaterialGlowim = commonMaterialGlow.getItemMeta();
		commonMaterialGlowim.setDisplayName("§7§lCommon Materials");
		commonMaterialGlowim.addEnchant(glow, 1, true);
		commonMaterialGlow.setItemMeta(commonMaterialGlowim);

		uncommonMaterial = new MaterialData(Material.INK_SACK, (byte) 10).toItemStack(1);
		ItemMeta uncommonMaterialim = uncommonMaterial.getItemMeta();
		uncommonMaterialim.setDisplayName("§a§lUncommon Materials");
		uncommonMaterial.setItemMeta(uncommonMaterialim);

		uncommonMaterialGlow = new MaterialData(Material.INK_SACK, (byte) 10).toItemStack(1);
		ItemMeta uncommonMaterialGlowim = uncommonMaterialGlow.getItemMeta();
		uncommonMaterialGlowim.addEnchant(glow, 1, true);
		uncommonMaterialGlowim.setDisplayName("§a§lUncommon Materials");
		uncommonMaterialGlow.setItemMeta(uncommonMaterialGlowim);

		rareMaterial = new MaterialData(Material.INK_SACK, (byte) 12).toItemStack(1);
		ItemMeta rareMaterialim = rareMaterial.getItemMeta();
		rareMaterialim.setDisplayName("§3§lRare Materials");
		rareMaterial.setItemMeta(rareMaterialim);

		rareMaterialGlow = new MaterialData(Material.INK_SACK, (byte) 12).toItemStack(1);
		ItemMeta rareMaterialGlowim = rareMaterialGlow.getItemMeta();
		rareMaterialGlowim.addEnchant(glow, 1, true);
		rareMaterialGlowim.setDisplayName("§3§lRare Materials");
		rareMaterialGlow.setItemMeta(rareMaterialGlowim);

		epicMaterial = new MaterialData(Material.INK_SACK, (byte) 5).toItemStack(1);
		ItemMeta epicMaterialim = epicMaterial.getItemMeta();
		epicMaterialim.setDisplayName("§5§lEpic Materials");
		epicMaterial.setItemMeta(epicMaterialim);

		epicMaterialGlow = new MaterialData(Material.INK_SACK, (byte) 5).toItemStack(1);
		ItemMeta epicMaterialGlowim = epicMaterialGlow.getItemMeta();
		epicMaterialGlowim.addEnchant(glow, 1, true);
		epicMaterialGlowim.setDisplayName("§5§lEpic Materials");
		epicMaterialGlow.setItemMeta(epicMaterialGlowim);

		commonWeapons = new MaterialData(Material.INK_SACK, (byte) 15).toItemStack(1);
		ItemMeta commonWeaponsim = commonWeapons.getItemMeta();
		commonWeaponsim.setDisplayName("§f§lCommon Weapons");
		commonWeapons.setItemMeta(commonWeaponsim);

		commonWeaponsGlow = new MaterialData(Material.INK_SACK, (byte) 15).toItemStack(1);
		ItemMeta commonWeaponsGlowim = commonWeaponsGlow.getItemMeta();
		commonWeaponsGlowim.addEnchant(glow, 1, true);
		commonWeaponsGlowim.setDisplayName("§f§lCommon Weapons");
		commonWeaponsGlow.setItemMeta(commonWeaponsGlowim);

		uncommonWeapons = new MaterialData(Material.INK_SACK, (byte) 2).toItemStack(1);
		ItemMeta uncommonWeaponsim = uncommonWeapons.getItemMeta();
		uncommonWeaponsim.setDisplayName("§2§lUncommon Weapons");
		uncommonWeapons.setItemMeta(uncommonWeaponsim);

		uncommonWeaponsGlow = new MaterialData(Material.INK_SACK, (byte) 2).toItemStack(1);
		ItemMeta uncommonWeaponsGlowim = uncommonWeaponsGlow.getItemMeta();
		uncommonWeaponsGlowim.addEnchant(glow, 1, true);
		uncommonWeaponsGlowim.setDisplayName("§2§lUncommon Weapons");
		uncommonWeaponsGlow.setItemMeta(uncommonWeaponsGlowim);

		rareWeapons = new MaterialData(Material.INK_SACK, (byte) 4).toItemStack(1);
		ItemMeta rareWeaponsim = rareWeapons.getItemMeta();
		rareWeaponsim.setDisplayName("§1§lRare Weapons");
		rareWeapons.setItemMeta(rareWeaponsim);

		rareWeaponsGlow = new MaterialData(Material.INK_SACK, (byte) 4).toItemStack(1);
		ItemMeta rareWeaponsGlowim = rareWeaponsGlow.getItemMeta();
		rareWeaponsGlowim.addEnchant(glow, 1, true);
		rareWeaponsGlowim.setDisplayName("§1§lRare Weapons");
		rareWeaponsGlow.setItemMeta(rareWeaponsGlowim);

		legendaryWeapons = new MaterialData(Material.INK_SACK, (byte) 11).toItemStack(1);
		ItemMeta legendaryWeaponsim = legendaryWeapons.getItemMeta();
		legendaryWeaponsim.setDisplayName("§e§lLegendary Weapons");
		legendaryWeapons.setItemMeta(legendaryWeaponsim);

		legendaryWeaponsGlow = new MaterialData(Material.INK_SACK, (byte) 11).toItemStack(1);
		ItemMeta legendaryWeaponsGlowim = legendaryWeaponsGlow.getItemMeta();
		legendaryWeaponsGlowim.addEnchant(glow, 1, true);
		legendaryWeaponsGlowim.setDisplayName("§e§lLegendary Weapons");
		legendaryWeaponsGlow.setItemMeta(legendaryWeaponsGlowim);

		exclusiveWeapons = new MaterialData(Material.INK_SACK, (byte) 1).toItemStack(1);
		ItemMeta exclusiveWeaponsim = exclusiveWeapons.getItemMeta();
		exclusiveWeaponsim.setDisplayName("§4§lExclusive Weapons");
		exclusiveWeapons.setItemMeta(exclusiveWeaponsim);

		exclusiveWeaponsGlow = new MaterialData(Material.INK_SACK, (byte) 1).toItemStack(1);
		ItemMeta exclusiveWeaponsGlowim = exclusiveWeaponsGlow.getItemMeta();
		exclusiveWeaponsGlowim.addEnchant(glow, 1, true);
		exclusiveWeaponsGlowim.setDisplayName("§4§lExclusive Weapons");
		exclusiveWeaponsGlow.setItemMeta(exclusiveWeaponsGlowim);

		glas = new MaterialData(Material.STAINED_GLASS_PANE, (byte) 15).toItemStack(1);
		ItemMeta glasim = glas.getItemMeta();
		glasim.setDisplayName(" ");
		glas.setItemMeta(glasim);

	}

	private static void defaultinventory(Inventory inventory) {
		inventory.setItem(0, new ItemStack(commonMaterial));
		inventory.setItem(1, new ItemStack(uncommonMaterial));
		inventory.setItem(2, new ItemStack(rareMaterial));
		inventory.setItem(3, new ItemStack(epicMaterial));
		inventory.setItem(4, new ItemStack(commonWeapons));
		inventory.setItem(5, new ItemStack(uncommonWeapons));
		inventory.setItem(6, new ItemStack(rareWeapons));
		inventory.setItem(7, new ItemStack(legendaryWeapons));
		inventory.setItem(8, new ItemStack(exclusiveWeapons));
		inventory.setItem(9, new ItemStack(glas));
		inventory.setItem(10, new ItemStack(glas));
		inventory.setItem(11, new ItemStack(glas));
		inventory.setItem(12, new ItemStack(glas));
		inventory.setItem(13, new ItemStack(glas));
		inventory.setItem(14, new ItemStack(glas));
		inventory.setItem(15, new ItemStack(glas));
		inventory.setItem(16, new ItemStack(glas));
		inventory.setItem(17, new ItemStack(glas));
		inventory.setItem(27, new ItemStack(glas));
		inventory.setItem(28, new ItemStack(glas));
		inventory.setItem(29, new ItemStack(glas));
		inventory.setItem(30, new ItemStack(glas));
		inventory.setItem(31, new ItemStack(glas));
		inventory.setItem(32, new ItemStack(glas));
		inventory.setItem(33, new ItemStack(glas));
		inventory.setItem(34, new ItemStack(glas));
		inventory.setItem(35, new ItemStack(glas));
	}

	public static void openGUIcommonMaterials(Player player) throws SQLException {

		Inventory inventory = Bukkit.createInventory(null, 9 * 4, "§7§lMaterials");
		defaultinventory(inventory);
		inventory.setItem(0, new ItemStack(commonMaterialGlow));

		PreparedStatement all = TestDatabase.mysql.getConnection().prepareStatement(
				"Select `sticknumber`,`woodbuttonnumber`,`stonebuttonnumber`,`woodpreasureplatenumber`,`stonepreasureplatenumber`,`feathernumber`,`leathernumber`,`papernumber`,`booknumber` FROM `Materialnumber` WHERE  `uuid` = \""
						+ player.getUniqueId().toString() + "\"");
		ResultSet rs = all.executeQuery();
		rs.next();

		String StickNumber = Integer.toString(rs.getInt("sticknumber"));
		String WoodbuttonNumber = Integer.toString(rs.getInt("woodbuttonnumber"));
		String StonebuttonNumber = Integer.toString(rs.getInt("stonebuttonnumber"));
		String WoodpreasureplateNumber = Integer.toString(rs.getInt("woodpreasureplatenumber"));
		String StonepreasureplateNumber = Integer.toString(rs.getInt("stonepreasureplatenumber"));
		String FeatherNumber = Integer.toString(rs.getInt("feathernumber"));
		String LeatherNumber = Integer.toString(rs.getInt("leathernumber"));
		String PaperNumber = Integer.toString(rs.getInt("papernumber"));
		String BookNumber = Integer.toString(rs.getInt("booknumber"));

		List<String> one = new ArrayList<>();
		one.add("§7§lYou have: §f§l" + StickNumber);
		Stickim.setLore(one);
		Stick.setItemMeta(Stickim);
		inventory.setItem(18, new ItemStack(Stick));

		List<String> two = new ArrayList<>();
		two.add("§7§lYou have: §f§l" + WoodbuttonNumber);
		Woodbuttonim.setLore(two);
		Woodbutton.setItemMeta(Woodbuttonim);
		inventory.setItem(19, new ItemStack(Woodbutton));

		List<String> three = new ArrayList<>();
		three.add("§7§lYou have: §f§l" + StonebuttonNumber);
		Stonebuttonim.setLore(three);
		Stonebutton.setItemMeta(Stonebuttonim);
		inventory.setItem(20, new ItemStack(Stonebutton));

		List<String> four = new ArrayList<>();
		four.add("§7§lYou have: §f§l" + WoodpreasureplateNumber);
		Woodpreasureplateim.setLore(four);
		Woodpreasureplate.setItemMeta(Woodpreasureplateim);
		inventory.setItem(21, new ItemStack(Woodpreasureplate));

		List<String> five = new ArrayList<>();
		five.add("§7§lYou have: §f§l" + StonepreasureplateNumber);
		Stonepreasureplateim.setLore(five);
		Stonepreasureplate.setItemMeta(Stonepreasureplateim);
		inventory.setItem(22, new ItemStack(Stonepreasureplate));

		List<String> six = new ArrayList<>();
		six.add("§7§lYou have: §f§l" + FeatherNumber);
		Featherim.setLore(six);
		Feather.setItemMeta(Featherim);
		inventory.setItem(23, new ItemStack(Feather));

		List<String> seven = new ArrayList<>();
		seven.add("§7§lYou have: §f§l" + LeatherNumber);
		Leatherim.setLore(seven);
		Leather.setItemMeta(Leatherim);
		inventory.setItem(24, new ItemStack(Leather));

		List<String> eight = new ArrayList<>();
		eight.add("§7§lYou have: §f§l" + PaperNumber);
		Paperim.setLore(eight);
		Paper.setItemMeta(Paperim);
		inventory.setItem(25, new ItemStack(Paper));

		List<String> nine = new ArrayList<>();
		nine.add("§7§lYou have: §f§l" + BookNumber);
		Bookim.setLore(nine);
		Book.setItemMeta(Bookim);
		inventory.setItem(26, new ItemStack(Book));

		player.openInventory(inventory);

	}

	public boolean DeadMeta(int clickedslot, String GUI_NAME) {
		int Deadslot = 0;
		if (GUI_NAME == "§7§lMaterials") {
			Deadslot = 0;
		}
		if (GUI_NAME == "§a§lMaterials") {
			Deadslot = 1;
		}
		if (GUI_NAME == "§3§lMaterials") {
			Deadslot = 2;
		}
		if (GUI_NAME == "§5§lMaterials") {
			Deadslot = 3;
		}
		if (GUI_NAME == "§f§lWeapons") {
			Deadslot = 4;
		}
		if (GUI_NAME == "§2§lWeapons") {
			Deadslot = 5;
		}
		if (GUI_NAME == "§1§lWeapons") {
			Deadslot = 6;
		}
		if (GUI_NAME == "§e§lWeapons") {
			Deadslot = 7;
		}
		if (GUI_NAME == "§4§lWeapons") {
			Deadslot = 8;
		}

		if (clickedslot == Deadslot) {
			return true;
		}

		return false;

	}

	@EventHandler
	public void handleNavigatorGUIClickTop(InventoryClickEvent event) throws SQLException {

		if (!(event.getWhoClicked() instanceof Player))
			return;

		if (event.getClickedInventory() == null)
			return;

		Player player = (Player) event.getWhoClicked();

		if (!((event.getClickedInventory().getTitle().contains("Material")
				|| (event.getClickedInventory().getTitle().contains("Weapons")))))
			return;

		if (DeadMeta(event.getSlot(), event.getClickedInventory().getTitle()) == true)
			return;

		if (event.getCurrentItem().getType() == Material.INK_SACK) {

			if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Uncommon Material")) {

				Inventory inventory = Bukkit.createInventory(null, 9 * 4, "§a§lMaterials");

				defaultinventory(inventory);
				inventory.setItem(1, new ItemStack(uncommonMaterialGlow));
				player.openInventory(inventory);

				return;
			}

			if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§7§lCommon Material")) {

				openGUIcommonMaterials(player);

				return;
			}

			if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§3§lRare Material")) {

				Inventory inventory = Bukkit.createInventory(null, 9 * 4, "§3§lMaterials");

				defaultinventory(inventory);
				inventory.setItem(2, new ItemStack(rareMaterialGlow));
				player.openInventory(inventory);

				return;
			}

			if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§5§lEpic Material")) {

				Inventory inventory = Bukkit.createInventory(null, 9 * 4, "§5§lMaterials");

				defaultinventory(inventory);
				inventory.setItem(3, new ItemStack(epicMaterialGlow));
				player.openInventory(inventory);

				return;
			}

			if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lCommon Weapons")) {

				Inventory inventory = Bukkit.createInventory(null, 9 * 4, "§f§lWeapons");

				defaultinventory(inventory);

				inventory.setItem(18, new ItemStack(Arrow));
				inventory.setItem(4, new ItemStack(commonWeaponsGlow));
				player.openInventory(inventory);

				return;
			}

			if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§2§lUncommon Weapons")) {

				Inventory inventory = Bukkit.createInventory(null, 9 * 4, "§2§lWeapons");

				defaultinventory(inventory);
				inventory.setItem(5, new ItemStack(uncommonWeaponsGlow));
				player.openInventory(inventory);

				return;
			}

			if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§1§lRare Weapons")) {

				Inventory inventory = Bukkit.createInventory(null, 9 * 4, "§1§lWeapons");

				defaultinventory(inventory);
				inventory.setItem(6, new ItemStack(rareWeaponsGlow));
				player.openInventory(inventory);

				return;
			}

			if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§e§lLegendary Weapons")) {

				Inventory inventory = Bukkit.createInventory(null, 9 * 4, "§e§lWeapons");

				defaultinventory(inventory);
				inventory.setItem(7, new ItemStack(legendaryWeaponsGlow));
				player.openInventory(inventory);

				return;
			}

			if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lExclusive Weapons")) {

				Inventory inventory = Bukkit.createInventory(null, 9 * 4, "§4§lWeapons");

				defaultinventory(inventory);
				inventory.setItem(8, new ItemStack(exclusiveWeaponsGlow));
				player.openInventory(inventory);

				return;
			}

		}

		if (event.getCurrentItem().getItemMeta() == null)
			return;

		if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Throwing Knife")) {
			ArrowInventory(player);
			return;
		}

		if ((event.getCurrentItem().getItemMeta().getDisplayName().contains("Craft"))
				&& (event.getClickedInventory().getName().contains("Throwing Knife"))) {
			ArrowCraft(player);
			return;
		}

		if ((event.getCurrentItem().getItemMeta().getDisplayName().contains("Claim"))
				&& (event.getClickedInventory().getName().contains("Throwing Knife")))
			Claim(player);

	}

	private void Claim(Player player) throws SQLException {
		int arrownumber;
		PreparedStatement st;
		st = TestDatabase.mysql.getConnection()
				.prepareStatement("SELECT `number` FROM `Arrow` WHERE uuid = \"" + player.getUniqueId() + "\"");

		ResultSet rs = st.executeQuery();
		rs.next();
		arrownumber = rs.getInt("number");
		if (arrownumber < 1)
			return;

		int arrowslot = getArrowSlot(player);

		if (arrowslot == -1)
			return;

		player.getInventory().addItem(Arrow);
		st = TestDatabase.mysql.getConnection()
				.prepareStatement("UPDATE `Arrow` SET `number` = ((Select `number` WHERE uuid =\""
						+ player.getUniqueId() + "\")-1) WHERE uuid = \"" + player.getUniqueId() + "\"");
		st.execute();
		ArrowInventory(player);

	}

	private void ArrowCraft(Player player) throws SQLException {
		int sticknumber;
		PreparedStatement st;
		st = TestDatabase.mysql.getConnection().prepareStatement(
				"SELECT `sticknumber` FROM `Materialnumber` WHERE uuid = \"" + player.getUniqueId() + "\"");

		ResultSet rs = st.executeQuery();
		rs.next();
		sticknumber = rs.getInt("sticknumber");

		if (sticknumber < 2) {
			return;
		}
		sticknumber = sticknumber - 2;

		st = TestDatabase.mysql.getConnection().prepareStatement("UPDATE `Materialnumber` SET `sticknumber` = \""
				+ sticknumber + "\" WHERE uuid = \"" + player.getUniqueId() + "\"");

		st.execute();

		st = TestDatabase.mysql.getConnection()
				.prepareStatement("UPDATE `Arrow` SET `number` = ((Select `number` WHERE uuid =\""
						+ player.getUniqueId() + "\")+1) WHERE uuid = \"" + player.getUniqueId() + "\"");
		st.execute();

		ArrowInventory(player);
	}

	private void ArrowInventory(Player player) throws SQLException {
		Inventory inventory = Bukkit.createInventory(null, 9 * 4, "§f§lWeapons > Throwing Knife");

		PreparedStatement all = TestDatabase.mysql.getConnection()
				.prepareStatement("SELECT number FROM `Arrow` WHERE uuid = \"" + player.getUniqueId() + "\"");
		ResultSet rs = all.executeQuery();
		rs.next();

		PreparedStatement allmaterials = TestDatabase.mysql.getConnection().prepareStatement(
				"SELECT `sticknumber` FROM `Materialnumber` WHERE uuid = \"" + player.getUniqueId() + "\"");
		ResultSet rs2 = allmaterials.executeQuery();
		rs2.next();

		int sticknumber = rs2.getInt("sticknumber");
		int arrownumber = rs.getInt("number");

		arrowlore.removeAll(arrowlore);
		arrowlore.add("§7You have: §f" + arrownumber);
		Arrowim.setLore(arrowlore);
		Arrow.setItemMeta(Arrowim);

		inventory.setItem(4, new ItemStack(Arrow));

		workbenchlore.removeAll(workbenchlore);
		workbenchlore.add("§72x §lStick §7(§e" + sticknumber + "§7)");
		Workbenchim.setLore(workbenchlore);
		Workbench.setItemMeta(Workbenchim);
		inventory.setItem(20, new ItemStack(Workbench));

		inventory.setItem(31, new ItemStack(Wool));

		player.openInventory(inventory);

		arrowlore.removeAll(arrowlore);
		arrowlore.add("§7Click to open the menu!");
		Arrowim.setLore(arrowlore);
		Arrow.setItemMeta(Arrowim);

	}

	public static int getArrowSlot(Player player) {
		for (int i = 0; i < 36; i++) {
			ItemStack slot = player.getInventory().getItem(i);
			if (slot.getType() != Material.AIR || (slot.getType() != Material.ARROW && slot.getAmount() < 64))
				return i;
		}
		return -1;
	}
}
