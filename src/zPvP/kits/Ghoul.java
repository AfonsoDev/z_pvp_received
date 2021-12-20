package zPvP.kits;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Ghoul implements CommandExecutor, Listener {
  public static HashMap<String, Long> cooldown = new HashMap();
  
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (label.equalsIgnoreCase("ghoul"))
    {
      if (!ArrayL.used.contains(p.getName()))
      {
        if (p.hasPermission("kit.ghoul"))
        {
          p.sendMessage(" Ghoul");
          p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0F, 4.0F);
          ArrayL.used.add(p.getName());
          ArrayL.ghoul.add(sender.getName());
          p.getInventory().clear();
          ItemStack espada = new ItemStack(Material.WOOD_SWORD);
          ItemMeta espadameta = espada.getItemMeta();
          espadameta.setDisplayName("§cSword");
          espada.addEnchantment(Enchantment.DURABILITY, 3);
          p.getInventory().addItem(new ItemStack[] { espada });
          p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.REDSTONE) });
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
  public void interact(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (ArrayL.ghoul.contains(p.getName())) && 
      (p.getItemInHand().getType() == Material.REDSTONE))
    {
      if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
      {
        e.setCancelled(true);
        p.updateInventory();
        
        p.sendMessage(ChatColor.RED + "§lMinha fome nao pode ser saciada!");
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 500, 3));
        p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 500, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 500, 2));
        p.playSound(p.getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
        cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L)));
        return;
      }
      p.sendMessage(ChatColor.RED + "Faltam " + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - System.currentTimeMillis()) + " segundos para poder usar novamente.");
    }
  }
}
