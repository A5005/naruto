package de.luke.naruto;

import org.bukkit.Material;

public class ItemData {

	public ItemData(Material material, int byteValue, String displayName) {
		_material = material;
		_byteValue = (byte) byteValue;
		_displayName = displayName;

	}

	private Material _material;
	private byte _byteValue;
	private String _displayName;

	/*
	 * public ItemStack GetItemStack() { return _itemStack;
	 */

}
