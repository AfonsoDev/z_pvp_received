package zPvP.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import zPvP.Eventos.ScoreServer;


public class PvP implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		Player p= (Player) sender;
		if(cmd.getLabel().equalsIgnoreCase("pvp")){
			if(!(p.hasPermission("kit.pvp"))){
				p.sendMessage(ChatColor.RED + "Voce Nao Pode Usar Esse kit ");
				return true;
				
			}
			if(ArrayL.used.contains(p.getName())){
			p.sendMessage(ChatColor.RED + "Voce Esta Usando Um Kit");
			ScoreServer.createScoreboard(p, "PvP");
		return true;
		}
			ArrayL.used.add(p.getName());
			ArrayL.pvp.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.GREEN +"Voce Escolheu O Kit " + ChatColor.BOLD + "PvP");
			p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
			KitManeger.darSopas(p);
		}	
		return false;
		
	    
	}
	
	
}
