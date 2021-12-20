package zPvP.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import zPvP.Main;

public class Placas implements Listener {
  String servername = "[Sopas]";
  

  

public Placas(Main main) {

}


@EventHandler
  public void criar(SignChangeEvent e)
  {
    Player p = e.getPlayer();
    if (e.getLine(0).equalsIgnoreCase("[Sopas]"))
    {
      if (!p.hasPermission("uk.placas"))
      {
        e.getBlock().breakNaturally();
        p.sendMessage(ChatColor.RED + "Voce nao tem permissao.");
        return;
      }
      if (e.getLine(1).equalsIgnoreCase("sopas"))
      {
        e.setLine(0, ChatColor.DARK_AQUA + "[Sopas]");
        e.setLine(1, ChatColor.GOLD + "Gratis");
      }
      else if (e.getLine(1).equalsIgnoreCase("potes"))
      {
        e.setLine(0, ChatColor.DARK_GREEN + "[Potes]");
        e.setLine(1, ChatColor.GOLD + "Gratis");
      }
      else if (e.getLine(1).equalsIgnoreCase("cogumelos"))
      {
        e.setLine(0, ChatColor.DARK_RED + "[Cogumelos]");
        e.setLine(1, ChatColor.GOLD + "Gratis");
      }
      else if (e.getLine(1).equalsIgnoreCase("reparar"))
      {
        e.setLine(0, ChatColor.DARK_PURPLE + "[Reparar]");
        e.setLine(1, ChatColor.GOLD + "Tudo");
      }
    }
  }
  
  @EventHandler
  public void clicar(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (
      (e.getClickedBlock().getType() == Material.SIGN_POST) || (e.getClickedBlock().getType() == Material.WALL_SIGN)))
    {
      Sign s = (Sign)e.getClickedBlock().getState();
      if ((!s.getLine(0).equalsIgnoreCase(ChatColor.DARK_AQUA + "[Sopas]")) || 
        (ChatColor.stripColor(s.getLine(1)).equalsIgnoreCase("Gratis")))
      {
        Inventory sop = Bukkit.createInventory(p, 54, ChatColor.BLUE + "Sopas Gratis");
        for (int i = 0; i < sop.getSize(); i++) {
          sop.setItem(i, new ItemStack(Material.MUSHROOM_SOUP));
        }
        p.openInventory(sop);
      }
    }
  }
}
