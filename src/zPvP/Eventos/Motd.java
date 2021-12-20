package zPvP.Eventos;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class Motd implements Listener  {
	
	@EventHandler
	public void onMotd(ServerListPingEvent e){
		e.setMotd("§f§lSheep§9§lKits §6§l>> Treine Seu PvP Aqui\n§c§lServidor 100%Brasileiro");
	}
	

}
