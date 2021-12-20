package zPvP.kits;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import zPvP.Main;

public class Archer implements Listener, CommandExecutor {
	
  public static Main plugin;
  
  public Archer(Main main)
  {
    plugin = main;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (label.equalsIgnoreCase("archer"))
    {
      if (!ArrayL.used.contains(p.getName()))
      {
        if (p.hasPermission("kit.archer"))
        {
          p.sendMessage("Archer");
          p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0F, 4.0F);
          ArrayL.used.add(p.getName());
          ArrayL.Archer.add(sender.getName());
          p.getInventory().clear();
          ItemStack espada = new ItemStack(Material.STONE_SWORD);
          ItemMeta espadameta = espada.getItemMeta();
          espadameta.setDisplayName("§cSword");
          
          p.getInventory().addItem(new ItemStack[] { espada });
          Nodus.Api.Main.itemencatado(p, 1, new ItemStack(Material.BOW), Enchantment.ARROW_INFINITE, 1, "§cArquinho Do Satanas", true);
          
          ItemStack bow1 = new ItemStack(Material.ARROW);
          p.getInventory().setItem(2, bow1);
		  KitManeger.darSopas(p);
        }
        else
        {
          Nodus.Api.Main.mandarmsg(p, "§cSem Permissao Iz");
        }
      }
      else {
    	  Nodus.Api.Main.mandarmsg(p, "§cUm  kit por vida");
      }
      return true;
    }
    return false;
  }
}
