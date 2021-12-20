package zPvP.kits;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class ArrayL implements Listener {
	
	public static ArrayList<String> used = new ArrayList<String>();
	public static ArrayList<String> pvp = new ArrayList<String>();
	public static ArrayList<String> specialist = new ArrayList<String>();
	public static ArrayList<String> urgal = new ArrayList<String>();
	public static ArrayList<String> Kangaroo = new ArrayList<String>();
	public static ArrayList<String> Archer = new ArrayList<String>();
	public static ArrayList<String> poseidon = new ArrayList<String>();
	public static ArrayList<String> ninja = new ArrayList<String>();
	public static ArrayList<String> ghoul = new ArrayList<String>();
	public static ArrayList<String> thor = new ArrayList<String>();
	public static ArrayList<String> cooldown = new ArrayList<String>();
	public static ArrayList<String> ryu = new ArrayList<String>();
	public static ArrayList<String> plugin = new ArrayList<String>();


   public void remove (Player p){
	used.remove(p.getName());
	pvp.remove(p.getName());
	poseidon.remove(p.getName());
	ghoul.remove(p.getName());
	ninja.remove(p.getName());
	plugin.remove(p.getName());
	ryu.remove(p.getName());
	Kangaroo.remove(p.getName());
	cooldown.remove(p.getName());
	Archer.remove(p.getName());
	specialist.remove(p.getName());
	urgal.remove(p.getName());
	thor.remove(p.getName());
    }
   
   @EventHandler
   public void Death(PlayerDeathEvent e){
	   Player p = (Player) e.getEntity();
	   remove(p);
   }

public static void removeAbility(Player p) {
	used.remove(p.getName());
	
	
}
}
