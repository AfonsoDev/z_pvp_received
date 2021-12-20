package zPvP.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import zPvP.Main;

public class Report implements CommandExecutor,Listener {
  public Main plugin;
  
  public Report(Main main)
  {
    this.plugin = main;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("report"))
    {
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "[!] Use: " + ChatColor.AQUA + "/report (Nick ) (Denuncia)");
      }
      if (args.length > 0)
      {
        sender.sendMessage(ChatColor.BLUE + "Seu Report Foi Enviado!");
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
          if (staff.hasPermission("kitpvp.report"))
          {
            staff.sendMessage(ChatColor.AQUA + "========================");
            staff.sendMessage("§4§l[Report ] §a(§f" + sender.getName() + "§a) " + ChatColor.DARK_PURPLE + mensagem);
            staff.sendMessage(ChatColor.AQUA + "========================");
          }
        }
      }
    }
    return false;
  }
}
