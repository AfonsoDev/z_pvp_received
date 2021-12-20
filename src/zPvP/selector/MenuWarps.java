package zPvP.selector;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import zPvP.Main;

public class MenuWarps
  implements Listener
{
  public static Main plugin;
  
  public MenuWarps(Main main)
  {
    plugin = main;
  }
  
  public static void menuYT(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 27, "§a§l -> Warps <-");
    
    ItemStack vidro = new ItemStack(Material.VINE);
    ItemMeta vidrometa = vidro.getItemMeta();
    vidrometa.setDisplayName(" ");
    vidro.setItemMeta(vidrometa);
    
    ItemStack vidro1 = new ItemStack(Material.IRON_FENCE);
    ItemMeta vidrometa1 = vidro1.getItemMeta();
    vidrometa1.setDisplayName(" ");
    vidro1.setItemMeta(vidrometa1);
    
    ItemStack folha = new ItemStack(Material.VINE);
    ItemMeta folhameta = folha.getItemMeta();
    folhameta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("NomeServer")));
    folha.setItemMeta(folhameta);
    
    ItemStack fornalha = new ItemStack(Material.FURNACE);
    ItemMeta fornalhameta = fornalha.getItemMeta();
    fornalhameta.setDisplayName("KitPvP");
    fornalha.setItemMeta(fornalhameta);
    
    ItemStack madeira = new ItemStack(Material.POTION);
    ItemMeta madeirameta = madeira.getItemMeta();
    madeirameta.setDisplayName("Main");
    madeira.setItemMeta(madeirameta);
    
    ItemStack bedrock = new ItemStack(Material.BLAZE_ROD);
    ItemMeta bedrockmeta = bedrock.getItemMeta();
    bedrockmeta.setDisplayName("1v1");
    bedrock.setItemMeta(bedrockmeta);
    
    ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
    ItemMeta lavameta = lava.getItemMeta();
    lavameta.setDisplayName("Challenge");
    lava.setItemMeta(lavameta);
    
    ItemStack lava1 = new ItemStack(Material.CAKE);
    ItemMeta lavameta1 = lava1.getItemMeta();
    lavameta1.setDisplayName(" RDM");
    lava1.setItemMeta(lavameta1);
    
    ItemStack fps = new ItemStack(Material.SPONGE);
    ItemMeta fpsmeta = fps.getItemMeta();
    fpsmeta.setDisplayName(" FPS");
    fps.setItemMeta(fpsmeta);
    
    ItemStack fps1 = new ItemStack(Material.DIAMOND_SWORD);
    ItemMeta fpsmeta1 = fps1.getItemMeta();
    fpsmeta1.setDisplayName("MDR");
    fps1.setItemMeta(fpsmeta1);
    
    ItemStack fps2 = new ItemStack(Material.WATER_BUCKET);
    ItemMeta fpsmeta2 = fps1.getItemMeta();
    fpsmeta2.setDisplayName(" MLG");
    fps2.setItemMeta(fpsmeta2);
    
    inv.setItem(0, folha);
    inv.setItem(1, vidro);
    inv.setItem(2, vidro);
    inv.setItem(3, vidro);
    inv.setItem(4, vidro1);
    inv.setItem(5, vidro);
    inv.setItem(6, vidro);
    inv.setItem(7, vidro);
    inv.setItem(8, folha);
    inv.setItem(9, vidro);
    inv.setItem(10, vidro);
    inv.setItem(11, madeira);
    inv.setItem(12, lava1);
    inv.setItem(13, lava);
    inv.setItem(14, fps1);
    inv.setItem(15, fps);
    inv.setItem(16, vidro);
    inv.setItem(17, vidro);
    inv.setItem(18, vidro);
    inv.setItem(19, vidro);
    inv.setItem(20, vidro);
    inv.setItem(21, fps2);
    inv.setItem(22, vidro);
    inv.setItem(23, vidro);
    inv.setItem(24, bedrock);
    inv.setItem(25, vidro);
    inv.setItem(26, vidro);
    
    p.openInventory(inv);
  }
  
  @EventHandler
  public void onPlayerCLickInventry1(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§a§l -> Warps <-")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getType() == Material.POTION)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.sendMessage("§cHabilidades removidas!");
        p.chat("/main");
        return;
      }
      if (e.getCurrentItem().getType() == Material.LAVA_BUCKET)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.sendMessage("§cHabilidades removidas!");
        p.chat("/challenge");
        return;
      }
      if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.sendMessage("§cHabilidades removidas!");
        p.chat("/mdr");
        return;
      }
      if (e.getCurrentItem().getType() == Material.CAKE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.sendMessage("§cHabilidades removidas!");
        p.chat("/rdm");
        return;
      }
      if (e.getCurrentItem().getType() == Material.SPONGE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.sendMessage("§cHabilidades removidas!");
        p.chat("/fps");
        return;
      }
      if (e.getCurrentItem().getType() == Material.BLAZE_ROD)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.sendMessage("§cHabilidades removidas!");
        p.getInventory().clear();
        p.getInventory().setBoots(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setHelmet(null);
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
        p.chat("/1v1");
        return;
      }
      if (e.getCurrentItem().getType() == Material.WATER_BUCKET)
      {
        e.setCancelled(true);
        p.sendMessage("§cHabilidades removidas!");
        p.getInventory().clear();
        p.getInventory().setBoots(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setHelmet(null);
        p.closeInventory();
        return;
      }
    }
  }
}
