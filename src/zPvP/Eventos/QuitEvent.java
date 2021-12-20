package zPvP.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent
implements Listener
{
@EventHandler
public void Quit(PlayerQuitEvent e)
{
  Player p = e.getPlayer();
  
  e.setQuitMessage("§7[-] §c" + p.getName());
  p.getInventory().clear();
  p.teleport(p.getWorld().getSpawnLocation());
}
}
