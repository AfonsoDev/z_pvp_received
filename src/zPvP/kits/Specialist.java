package zPvP.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Specialist implements CommandExecutor, Listener {
	

	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		Player p= (Player) sender;
		if(cmd.getLabel().equalsIgnoreCase("specialist")){
			if(!(p.hasPermission("kit.specialist"))){
				p.sendMessage(ChatColor.RED + "Voce Nao Pode Usar Esse kit ");
				return true;
				
			}
			if(ArrayL.used.contains(p.getName())){
			p.sendMessage(ChatColor.RED + "Voce Esta Usando Um Kit");
		return true;
		}
			ArrayL.used.add(p.getName());
			ArrayL.specialist.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.GREEN +"Voce Escolheu O Kit " + ChatColor.BOLD + "specialist");
			p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
			p.getInventory().addItem(new ItemStack(Material.BOOK));
			KitManeger.darSopas(p);
		}	
		return false;
	}
	
	@EventHandler
	public void onSpecialistClick(PlayerInteractEvent e){
		Player p = (Player) e.getPlayer();
		if(ArrayL.specialist.contains(p.getName())){
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
				if(e.getItem().getType()== Material.BOOK){
					p.openEnchanting(p.getLocation(), true);
				}
			}
		}
	}
	
	@EventHandler
	public void onSpecialistkill(PlayerDeathEvent e){
		Player p = (Player) e.getEntity();
		Player k = (Player) p.getKiller();
		if(p instanceof Player && k instanceof Player){
			if(ArrayL.specialist.contains(k.getName())){
				k.sendMessage(ChatColor.GOLD + "Voce Ganhou Um Pote De EXP!");
				k.getInventory().setItem(8, new ItemStack(Material.EXP_BOTTLE));
				
			}
		}
	}
	
  }    
