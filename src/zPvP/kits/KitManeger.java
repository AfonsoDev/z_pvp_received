package zPvP.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class KitManeger implements Listener {
	
	public static void darSopas(Player p) {
		  for (int x = 0; x < 35; x++) {
		    p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
		  }
	}
}
