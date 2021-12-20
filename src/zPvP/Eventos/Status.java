package zPvP.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import zPvP.Main;

public class Status
  implements Listener
  {
	@EventHandler
	void aoEntrar(PlayerJoinEvent evento)
	{
	    Player Jogador = evento.getPlayer();
	    {
	    	if(Main.plugin.getConfig().get("status." + Jogador.getName().toLowerCase() + ".Kills") == null)
	    	{
	    		Main.plugin.getConfig().set("status." + Jogador.getName().toLowerCase() + ".Kills", Integer.valueOf(0));
	    		Main.plugin.saveConfig();
    	}
	    	if(Main.plugin.getConfig().get("status." + Jogador.getName().toLowerCase() + ".mortes") == null)
	    	{
	    		Main.plugin.getConfig().set("status." + Jogador.getName().toLowerCase() + ".mortes", Integer.valueOf(0));
	    		Main.plugin.saveConfig();
	    	}
	    }
	}

	@EventHandler
	void aoMatar(PlayerDeathEvent evento)
	{
		if((evento.getEntity().getKiller() instanceof Player))
		{
			Player Jogador = evento.getEntity().getKiller();
			
			int kills = Main.plugin.getConfig().getInt("status." + Jogador.getName().toLowerCase() + ".Kills");
    		Main.plugin.getConfig().set("status." + Jogador.getName().toLowerCase() + ".Kills", Integer.valueOf(kills +1));
    		Main.plugin.saveConfig();
		}
	}

	@EventHandler
	void aoMorrer(PlayerDeathEvent evento)
	{
		if((evento.getEntity().getKiller() instanceof Player))
		{
			Player Jogador = evento.getEntity();
			
			int mortes = Main.plugin.getConfig().getInt("status." + Jogador.getName().toLowerCase() + ".mortes");
    		Main.plugin.getConfig().set("status." + Jogador.getName().toLowerCase() + ".mortes", Integer.valueOf(mortes +1));
    		Main.plugin.saveConfig();
		}
	}
}
