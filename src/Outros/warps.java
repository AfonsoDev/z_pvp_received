package Outros;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import zPvP.Main;

public class warps
  implements Listener, CommandExecutor
{
  public static Main plugin;
  
  public warps(Main main)
  {
    plugin = main;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if ((cmd.getName().equalsIgnoreCase("setfps")) && 
      ((sender instanceof Player)))
    {
      if (!sender.hasPermission("kitpvp.setwarp"))
      {
        Player p = (Player)sender;
        p.sendMessage("§cVoce nao tem permissao!");
      }
      if (sender.hasPermission("kitpvp.setwarp"))
      {
        Player p = (Player)sender;
        plugin.getConfig().set("fps.x", Double.valueOf(p.getLocation().getX()));
        plugin.getConfig().set("fps.y", Double.valueOf(p.getLocation().getY()));
        plugin.getConfig().set("fps.z", Double.valueOf(p.getLocation().getZ()));
        plugin.getConfig().set("fps.pitch", Float.valueOf(p.getLocation().getPitch()));
        plugin.getConfig().set("fps.yaw", Float.valueOf(p.getLocation().getYaw()));
        plugin.getConfig().set("fps.world", p.getLocation().getWorld().getName());
        plugin.saveConfig();
        p.sendMessage("§a [!] Warp FPS setada com sucesso");
      }
      return true;
    }
    return false;
  }
}
