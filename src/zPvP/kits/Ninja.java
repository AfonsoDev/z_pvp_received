package zPvP.kits;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Ninja implements Listener, CommandExecutor {
	
  private static final Plugin plugin = null;
public static HashMap<Player, Player> a = new HashMap();
  public static HashMap<Player, Long> b = new HashMap();
  public static List<Player> cooldownbk = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (label.equalsIgnoreCase("ninja"))
    {
      if (!ArrayL.used.contains(p.getName()))
      {
        if (p.hasPermission("kit.ninja"))
        {
          p.sendMessage(" Ninja");
          p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0F, 4.0F);
          ArrayL.used.add(p.getName());
          ArrayL.ninja.add(sender.getName());
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
          p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Sem_Permisssaao_Kit")));
        }
      }
      else {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Um_Kit_Por_Vida")));
      }
      return true;
    }
    return false;
  }
  
  @EventHandler
  public void a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent)
  {
    if (((paramEntityDamageByEntityEvent.getDamager() instanceof Player)) && ((paramEntityDamageByEntityEvent.getEntity() instanceof Player)))
    {
      final Player localPlayer1 = (Player)paramEntityDamageByEntityEvent.getDamager();
      Player localPlayer2 = (Player)paramEntityDamageByEntityEvent.getEntity();
      if (ArrayL.ninja.contains(localPlayer1.getName()))
      {
        a.put(localPlayer1, localPlayer2);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
        {
          public void run()
          {
            Ninja.cooldownbk.remove(localPlayer1);
          }
        }, 200L);
      }
    }
  }
  
  @EventHandler
  public void a(PlayerToggleSneakEvent paramPlayerToggleSneakEvent)
  {
    Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
    if ((paramPlayerToggleSneakEvent.isSneaking()) && (ArrayL.ninja.contains(localPlayer1.getName())) && (a.containsKey(localPlayer1)))
    {
      Player localPlayer2 = (Player)a.get(localPlayer1);
      if ((localPlayer2 != null) && (!localPlayer2.isDead()))
      {
        String str = null;
        if (b.get(localPlayer1) != null)
        {
          long l = ((Long)b.get(localPlayer1)).longValue() - System.currentTimeMillis();
          DecimalFormat localDecimalFormat = new DecimalFormat("##");
          int i = (int)l / 1000;
          str = localDecimalFormat.format(i);
        }
        if ((b.get(localPlayer1) == null) || (((Long)b.get(localPlayer1)).longValue() < System.currentTimeMillis()))
        {
          if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0D)
          {
            localPlayer1.teleport(localPlayer2.getLocation());
            localPlayer1.sendMessage(ChatColor.GREEN + "Teleportado");
            b.put(localPlayer1, Long.valueOf(System.currentTimeMillis() + 10000L));
          }
          else
          {
            localPlayer1.sendMessage(ChatColor.RED + "O Ultimo jogador hitado esta muito longe!");
          }
        }
        else {
          localPlayer1.sendMessage("§c§lCooldown §f> §6" + str + " segundos!");
        }
      }
    }
  }
}
