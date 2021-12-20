package zPvP.kits;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Poseidon
  implements Listener, CommandExecutor
{
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (label.equalsIgnoreCase("poseidon"))
    {
      if (!ArrayL.used.contains(p.getName()))
      {
        if (p.hasPermission("kit.Poseidon"))
        {
          p.sendMessage(" Poseidon");
          p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0F, 4.0F);
          ArrayL.used.add(p.getName());
          ArrayL.poseidon.add(sender.getName());
          p.getInventory().clear();
          ItemStack espada = new ItemStack(Material.WOOD_SWORD);
          ItemMeta espadameta = espada.getItemMeta();
          espadameta.setDisplayName("§cSword");
          espada.addEnchantment(Enchantment.DURABILITY, 3);
          p.getInventory().addItem(new ItemStack[] { espada });
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
  
  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event)
  {
    Player player = event.getPlayer();
    if ((ArrayL.poseidon.contains(player.getName())) && (
      (player.getLocation().getBlock().getType() == Material.WATER) || (player.getLocation().getBlock().getType() == Material.STATIONARY_WATER)))
    {
      player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 65, 0));
      player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 65, 0));
    }
  }
}