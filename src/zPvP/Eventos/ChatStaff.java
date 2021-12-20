package zPvP.Eventos;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import zPvP.Main;

public class ChatStaff
  implements CommandExecutor, Listener
{
  public Main plugin;
  
  public ChatStaff(Main main)
  {
    this.plugin = main;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("staffchat"))
    {
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Use: " + ChatColor.GOLD + "/staffchat <mensagem>");
      }
      if (args.length > 0)
      {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
          string.append(args[i] + " ");
        }
        String mensagem = string.toString();
        Player[] arrayOfPlayer;
        int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
        for (int i = 0; i < j; i++)
        {
          Player staff = arrayOfPlayer[i];
          if (staff.hasPermission("kitpvp.chatstaff")) {
            staff.sendMessage("§4[StaffChat]§3" + sender.getName() + ":" + ChatColor.DARK_PURPLE + mensagem);
          } else {
            sender.sendMessage(ChatColor.RED + "Voce nao tem permissao de falar no chat da staff!");
          }
        }
      }
    }
    return false;
  }
}
