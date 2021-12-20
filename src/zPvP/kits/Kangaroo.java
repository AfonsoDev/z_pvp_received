package zPvP.kits;


import zPvP.selector.Principal;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class Kangaroo implements Listener, CommandExecutor{
	
  public static ArrayList<Player> kangaroo = new ArrayList();
  public static Principal plugin;
  
  public Kangaroo(Principal main)
  {
    plugin = main;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (label.equalsIgnoreCase("kangaroo"))
    {
      if (!ArrayL.used.contains(p.getName()))
      {
        if (p.hasPermission("kit.kangaroo"))
        {
          p.sendMessage("Kangaroo GG!");
          p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0F, 4.0F);
          ArrayL.used.add(p.getName());
          ArrayL.Kangaroo.add(sender.getName());
          p.getInventory().clear();
          ItemStack espada = new ItemStack(Material.STONE_SWORD);
          ItemMeta espadameta = espada.getItemMeta();
          espadameta.setDisplayName("§cSword");
          
          p.getInventory().addItem(new ItemStack[] { espada });
          ItemStack bow = new ItemStack(Material.FIREWORK);
          ItemMeta bowmeta = bow.getItemMeta();
          bowmeta.setDisplayName("§cKangaroo Rocket");
          bow.setItemMeta(bowmeta);
          p.getInventory().addItem(new ItemStack[] { bow });
          KitManeger.darSopas(p);
          p.getPlayer().playSound(p.getLocation(), Sound.ZOMBIE_REMEDY, 5.0F, 5.0F);
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
  public void onInteract(PlayerInteractEvent event)
  {
    Player p = event.getPlayer();
    if (p.getItemInHand().getType() == Material.FIREWORK)
    {
      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
        (event.getAction() == Action.RIGHT_CLICK_AIR)) {
        event.setCancelled(true);
      }
      if ((ArrayL.Kangaroo.contains(p.getName())) && 
        (!kangaroo.contains(p)))
      {
        if (!p.isSneaking())
        {
          p.getPlayer().getWorld().playSound(p.getPlayer().getLocation(), Sound.ENDERDRAGON_WINGS, 5.0F, 5.0F);
          p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.MOBSPAWNER_FLAMES, 5);
          p.setFallDistance(-5.0F);
          Vector vector = p.getEyeLocation().getDirection();
          vector.multiply(0.6F);
          vector.setY(1.2F);
          p.setVelocity(vector);
        }
        else
        {
          p.getPlayer().getWorld().playSound(p.getPlayer().getLocation(), Sound.ENDERDRAGON_HIT, 5.0F, 5.0F);
          p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.MOBSPAWNER_FLAMES, 5);
          p.setFallDistance(-5.0F);
          Vector vector = p.getEyeLocation().getDirection();
          vector.multiply(1.2F);
          vector.setY(0.8D);
          p.setVelocity(vector);
        }
        kangaroo.add(p);
      }
    }
  }
  
  @EventHandler
  public void onMove(PlayerMoveEvent event)
  {
    Player p = event.getPlayer();
    if (kangaroo.contains(p))
    {
      Block b = p.getLocation().getBlock();
      if ((b.getType() != Material.AIR) || 
        (b.getRelative(BlockFace.DOWN).getType() != Material.AIR))
      {
        kangaroo.remove(p);
        
        return;
      }
    }
  }
  
  @EventHandler
  public void onDamage(EntityDamageEvent event)
  {
    Entity e = event.getEntity();
    if ((e instanceof Player))
    {
      Player player = (Player)e;
      if (((event.getEntity() instanceof Player)) && 
        (event.getCause() == EntityDamageEvent.DamageCause.FALL) && 
        (player.getInventory().contains(Material.FIREWORK)) && 
        (event.getDamage() >= 7.0D)) {
        event.setDamage(7.0D);
      }
    }
  }
}
