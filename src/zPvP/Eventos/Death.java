package zPvP.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		if(!(e.getEntity()instanceof Player)){
			return;
		}
		Player vitima = e.getEntity();
		if((e.getEntity().getKiller() instanceof Player)){
			Player matador = e.getEntity().getKiller();
			if(matador != vitima){
				matador.sendMessage("§aVoce Matou o: §f" + vitima.getName());
				vitima.sendMessage("§aVoce Morreu Para o: §f " + matador.getName());
				
			}
		} else{
			vitima.sendMessage("§cVoce Morreu '-' ");
			return;
		}
	}
}

