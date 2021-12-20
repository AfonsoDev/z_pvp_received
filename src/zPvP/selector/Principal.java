package zPvP.selector;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.MemorySection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Principal  implements Listener{
	
	public Principal() {
		
	}
	public void gui(Player p){
		Inventory inv = Bukkit.createInventory(null, 54,"Kits");
		
		  ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
		    ItemMeta metav = vidro.getItemMeta();
		    metav.setDisplayName("§7Slot");
		    vidro.setItemMeta(metav);
		
	  if (p.hasPermission("kit.pvp"))
	  {
	      ItemStack pyro = new ItemStack(Material.STONE_SWORD);
	   ItemMeta metapyro = pyro.getItemMeta();
	   metapyro.setDisplayName(ChatColor.AQUA + "PvP");
	   ArrayList descpyro = new ArrayList();
	   descpyro.add("§f§l Habilidade §b§l>> §7pvp carai!");
	   metapyro.setLore(descpyro);
	   pyro.setItemMeta(metapyro);
	   inv.addItem(new ItemStack[] { pyro });
	  }
	  
	  if (p.hasPermission("kit.specialist"))
	  {
	      ItemStack pyro = new ItemStack(Material.BOOK);
	   ItemMeta metapyro = pyro.getItemMeta();
	   metapyro.setDisplayName(ChatColor.AQUA + "Specialist");
	   ArrayList descpyro = new ArrayList();
	   descpyro.add("§f§l Habilidade §b§l>> §7enchant!");
	   metapyro.setLore(descpyro);
	   pyro.setItemMeta(metapyro);
	   inv.addItem(new ItemStack[] { pyro });
	  }
	  
	  if (p.hasPermission("kit.urgal"))
	  {
	      ItemStack pyro = new ItemStack(Material.DIAMOND_SWORD);
	   ItemMeta metapyro = pyro.getItemMeta();
	   metapyro.setDisplayName(ChatColor.AQUA + "urgal");
	   ArrayList descpyro = new ArrayList();
	   descpyro.add("§f§l Habilidade §b§l>> §7Dano!");
	   metapyro.setLore(descpyro);
	   pyro.setItemMeta(metapyro);
	   inv.addItem(new ItemStack[] { pyro });
	  }
	  
	  if (p.hasPermission("kit.kangaroo"))
	  {
	      ItemStack pyro = new ItemStack(Material.FIREWORK);
	   ItemMeta metapyro = pyro.getItemMeta();
	   metapyro.setDisplayName(ChatColor.AQUA + "kangaroo");
	   ArrayList descpyro = new ArrayList();
	   descpyro.add("§f§l Habilidade §b§l>> §7Pule Como Um kangaroo!");
	   metapyro.setLore(descpyro);
	   pyro.setItemMeta(metapyro);
	   inv.addItem(new ItemStack[] { pyro });
	  }
	  
	  if (p.hasPermission("kit.archer"))
	  {
	      ItemStack pyro = new ItemStack(Material.BOW);
	   ItemMeta metapyro = pyro.getItemMeta();
	   metapyro.setDisplayName(ChatColor.AQUA + "Archer");
	   ArrayList descpyro = new ArrayList();
	   descpyro.add("§f§l Habilidade §b§l>> §7Archer!");
	   metapyro.setLore(descpyro);
	   pyro.setItemMeta(metapyro);
	   inv.addItem(new ItemStack[] { pyro });
	  }
	  
	  if (p.hasPermission("kit.poseidon"))
	  {
	      ItemStack pyro = new ItemStack(Material.DIAMOND_AXE);
	   ItemMeta metapyro = pyro.getItemMeta();
	   metapyro.setDisplayName(ChatColor.AQUA + "Poseidon");
	   ArrayList descpyro = new ArrayList();
	   descpyro.add("§f§l Habilidade §b§l>> §7Poseidon!");
	   metapyro.setLore(descpyro);
	   pyro.setItemMeta(metapyro);
	   inv.addItem(new ItemStack[] { pyro });
	  }
	  
	  if (p.hasPermission("kit.ninja"))
	  {
	      ItemStack pyro = new ItemStack(Material.COAL);
	   ItemMeta metapyro = pyro.getItemMeta();
	   metapyro.setDisplayName(ChatColor.AQUA + "Nija");
	   ArrayList descpyro = new ArrayList();
	   descpyro.add("§f§l Habilidade §b§l>> §7Ninja!");
	   metapyro.setLore(descpyro);
	   pyro.setItemMeta(metapyro);
	   inv.addItem(new ItemStack[] { pyro });
	  }
	  
	  if (p.hasPermission("kit.ghoul"))
	  {
	      ItemStack pyro = new ItemStack(Material.STONE);
	   ItemMeta metapyro = pyro.getItemMeta();
	   metapyro.setDisplayName(ChatColor.AQUA + "Ghoul");
	   ArrayList descpyro = new ArrayList();
	   descpyro.add("§f§l Habilidade §b§l>> §7Ghoul!");
	   metapyro.setLore(descpyro);
	   pyro.setItemMeta(metapyro);
	   inv.addItem(new ItemStack[] { pyro });
	   
		 
		
		 ItemStack[] arrayOfItemStack;
		    int descpyro1 = (arrayOfItemStack = inv.getContents()).length;
		    for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
		    {
		      ItemStack item = arrayOfItemStack[metapyro1];
		      if (item == null) {
		        inv.setItem(inv.firstEmpty(), vidro);
		      }
		 
		    }
		 
		p.openInventory(inv);
	  }
		
	}
	@EventHandler
	public void onChest(PlayerInteractEvent e){
		if(e.getItem().getType() == Material.CHEST){
			gui(e.getPlayer());
		}
	}
	@EventHandler
	public void onInteract(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("Kits")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType()== Material.STONE_SWORD){
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/pvp");
			}
			if(e.getCurrentItem().getType()== Material.BOOK){
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/specialist");
			}
			if(e.getCurrentItem().getType()== Material.DIAMOND_SWORD){
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/urgal");
			}
			if(e.getCurrentItem().getType()== Material.FIREWORK){
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kangaroo");
			}
			if(e.getCurrentItem().getType()== Material.BOW){
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/archer");
			}
		}
		if(e.getCurrentItem().getType()== Material.DIAMOND_AXE){
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/poseidon");
		}
		if(e.getCurrentItem().getType()== Material.COAL){
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/ninja");
		}
	if(e.getCurrentItem().getType()== Material.STONE){
		e.setCancelled(true);
		p.closeInventory();
		p.chat("/ghoul");
	}
			
		}
	public MemorySection getConfig() {
		return null;
	}
}