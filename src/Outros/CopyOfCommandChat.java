package Outros;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CopyOfCommandChat
  implements CommandExecutor
{
  public static boolean chat = true;
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    if (sender.hasPermission("kit.admin")) {
      if (args.length > 0)
      {
        if (args.length == 1)
        {
          Player[] arrayOfPlayer;
          int j;
          int i;
          if (args[0].equalsIgnoreCase("off"))
          {
            chat = false;
            Bukkit.getServer().broadcastMessage(ChatColor.RED.toString() + "O chat foi desativado");
            j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
            for (i = 0; i < j; i++)
            {
              Player p2 = arrayOfPlayer[i];
              if (p2.hasPermission("kit.admin")) {
                p2.sendMessage(ChatColor.GRAY + sender.getName() + " Desativou o chat.");
              }
            }
          }
          else if (args[0].equalsIgnoreCase("on"))
          {
            chat = true;
            Bukkit.getServer().broadcastMessage(ChatColor.GREEN.toString() + "O chat foi Ativado");
            j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
            for (i = 0; i < j; i++)
            {
              Player p2 = arrayOfPlayer[i];
              if (p2.hasPermission("kit.admin")) {
                p2.sendMessage(ChatColor.GRAY + sender.getName() + " ativou o chat.");
              }
            }
          }
        }
        else
        {
          sender.sendMessage(ChatColor.RED + "Use: /chat (on | off)");
        }
      }
      else {
        sender.sendMessage(ChatColor.RED + "Use: /chat (on | off)");
      }
    }
    return true;
  }
}
