package zPvP.Eventos;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import zPvP.Main;

public class Admin implements CommandExecutor,Listener {
  private Main plugin;
  
  
  ArrayList<Player> vanished = new ArrayList();
  


public Admin(Main main) {
	// TODO Auto-generated constructor stub
}



public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("admin")) && 
      (p.hasPermission("kitpvp.admin")))
    {
      Player[] arrayOfPlayer;
      int j;
      int i;
      if (!this.vanished.contains(p))
      {
        j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
        for (i = 0; i < j; i++)
        {
          Player pl = arrayOfPlayer[i];
          pl.hidePlayer(p);
        }
        this.vanished.add(p);
        p.setGameMode(GameMode.CREATIVE);
        p.getInventory().clear();
        p.sendMessage(ChatColor.RED + "[!] Voce Entrou no Modo Admin");
        p.sendMessage(ChatColor.RED + "--> Esta Invisivel para Todos os Jogadores!");
      }
      else
      {
        j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
        for (i = 0; i < j; i++)
        {
          Player pl = arrayOfPlayer[i];
          pl.showPlayer(p);
        }
        this.vanished.remove(p);
        p.setGameMode(GameMode.SURVIVAL);
        p.sendMessage(ChatColor.GREEN + "[!] Voce Saiu no Modo Admin");
        p.sendMessage(ChatColor.GREEN + " --> Esta Visivel para Todos os Jogadores!");
        ItemStack chest = new ItemStack(Material.CHEST);
        ItemMeta chestmeta = chest.getItemMeta();
            
      }
    }
    return false;
  }
}
