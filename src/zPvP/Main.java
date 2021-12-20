package zPvP;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Jumps.Diamante;
import Jumps.Esmeralda;
import Jumps.Ferro;
import Jumps.Redstone;
import Outros.CopyOfCommandChat;
import Outros.warps;
import zPvP.Eventos.Admin;
import zPvP.Eventos.ChatStaff;
import zPvP.Eventos.Death;
import zPvP.Eventos.Entrar;
import zPvP.Eventos.Menu;
import zPvP.Eventos.Motd;
import zPvP.Eventos.Placas;
import zPvP.Eventos.QuitEvent;
import zPvP.Eventos.Report;
import zPvP.Eventos.Sopa;
import zPvP.kits.Archer;
import zPvP.kits.ArrayL;
import zPvP.kits.Ghoul;
import zPvP.kits.Kangaroo;
import zPvP.kits.Ninja;
import zPvP.kits.Poseidon;
import zPvP.kits.PvP;
import zPvP.kits.Specialist;
import zPvP.kits.Urgal;
import zPvP.selector.MenuWarps;
import zPvP.selector.Principal;

public class Main  extends JavaPlugin{

	public static Plugin plugin;

	public void onEnable(){
		
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Entrar(), this);
		pm.registerEvents(new Motd(), this);
		pm.registerEvents(new Death(), this);
		pm.registerEvents(new ArrayL(), this);
		pm.registerEvents(new Principal(), this);
		pm.registerEvents(new Sopa(), this);
		pm.registerEvents(new Specialist(), this);
		pm.registerEvents(new Kangaroo(null), this);
		pm.registerEvents(new Archer(null), this);
		pm.registerEvents(new Urgal(), this);
		pm.registerEvents(new Poseidon(), this);
		pm.registerEvents(new Ghoul(), this );
		pm.registerEvents(new Ninja(), this);
		pm.registerEvents(new MenuWarps(this), this);
		
		getCommand("staffchat").setExecutor(new ChatStaff(this));
		getServer().getPluginManager().registerEvents(new QuitEvent(), this);
		getServer().getPluginManager().registerEvents(new Menu(), this);
		getServer().getPluginManager().registerEvents(new Placas(this), this);
		getServer().getPluginManager().registerEvents(new Report(this), this);
	    getServer().getPluginManager().registerEvents(new Admin(this), this);
	    getServer().getPluginManager().registerEvents(new Ferro(this), this);
	    getServer().getPluginManager().registerEvents(new Esmeralda(this), this);
	    getServer().getPluginManager().registerEvents(new Diamante(this), this);
	    getServer().getPluginManager().registerEvents(new Redstone(this), this);
		getCommand("poseidon").setExecutor(new Poseidon());
		getCommand("urgal").setExecutor(new Urgal());
		getCommand("setfps").setExecutor(new warps(this));
		getCommand("archer").setExecutor(new Archer(null));
		getCommand("kangaroo").setExecutor(new Kangaroo (null));
		getCommand("specialist").setExecutor(new Specialist ());
		getCommand("pvp").setExecutor(new PvP ());
		getCommand("chat").setExecutor(new CopyOfCommandChat());
		getCommand("ninja").setExecutor(new Ninja());
		getCommand("ghoul").setExecutor(new Ghoul());
		getCommand("report").setExecutor(new Report(this));
		getCommand("admin").setExecutor(new Admin(this));
	}
     
	public void onDisable(){
		
	}
}
