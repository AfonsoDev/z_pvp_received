package zPvP.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Urgal implements CommandExecutor, Listener{

	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		Player p= (Player) sender;
		if(cmd.getLabel().equalsIgnoreCase("urgal")){
			if(!(p.hasPermission("kit.urgal"))){
				p.sendMessage(ChatColor.RED + "Voce Nao Pode Usar Esse kit ");
				return true;
				
			}
			if(ArrayL.used.contains(p.getName())){
			p.sendMessage(ChatColor.RED + "Voce Esta Usando Um Kit");
		return true;
		}
			ArrayL.used.add(p.getName());
			ArrayL.urgal.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.GREEN +"Voce Escolheu O Kit " + ChatColor.BOLD + "PvP");
			p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
			 ItemStack bow = new ItemStack(Material.POTION, 1, (short)8201);
	          ItemMeta bowmeta = bow.getItemMeta();
	          bowmeta.setDisplayName("§6Urgal Potion");
	          bow.setAmount(2);
	          bow.setItemMeta(bowmeta);
	          p.getInventory().addItem(new ItemStack[] { bow });
			KitManeger.darSopas(p);
		}	
		return false;
		
	    
	}
	
	
}