package zPvP.Eventos;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import zPvP.Eventos.ScoreServer;

public class Entrar implements Listener {

	public static ItemStack bau;
	public static ItemMeta baumeta;
	
	
	public static ItemStack warp;
	public static ItemMeta warpmeta;
	
	public static ItemStack loja;
	public static ItemMeta lojameta;
	
	
	@EventHandler
	public void onEntrar(PlayerJoinEvent e){
		e.setJoinMessage(null);
		Player p = e.getPlayer();
		String nome = p.getName();
		
		if (nome.length() > 16){
			nome = nome.substring(0, nome.length() -1);
		}
		p.setDisplayName(ChatColor.GRAY + nome);
		p.setPlayerListName(p.getDisplayName());
		
	    ItemStack vine = new ItemStack(Material.VINE);
	    ItemMeta vinew = vine.getItemMeta();
	    vinew.setDisplayName(ChatColor.RED + " ");
	    vine.setItemMeta(vinew);
	    
	    ItemStack as = new ItemStack(Material.IRON_FENCE);
	    ItemMeta ass = as.getItemMeta();
	    ass.setDisplayName(ChatColor.RED + " ");
	    as.setItemMeta(ass);
	    
		bau = new ItemStack(Material.CHEST);
		baumeta = bau.getItemMeta();
		baumeta.setDisplayName("§aKit Selector §7(Right click)");
		bau.setItemMeta(baumeta);
		 p.getInventory().setItem(4, bau);
		 
		    p.getInventory().setItem(0, as);
		    p.getInventory().setItem(1, vine);
		    p.getInventory().setItem(2, as);
		    p.getInventory().setItem(3, vine);
		    p.getInventory().setItem(4, bau);
		    p.getInventory().setItem(5, vine);
		    p.getInventory().setItem(6, as);
		    p.getInventory().setItem(7, vine);
		    p.getInventory().setItem(8, as);
		 
			warp = new ItemStack(Material.BOOK);
			warpmeta = warp.getItemMeta();
			warpmeta.setDisplayName("§aWarp Selector §7(Right click)");
			warp.setItemMeta(warpmeta);
			 p.getInventory().setItem(8, warp);
		 
		 
		
     	 
     	ScoreServer.createScoreboard(p, "None");
     	
     	
	}
}
