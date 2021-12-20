package zPvP.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import zPvP.Main;

public class Scoreboards {
	
	public static void scoreboard(Player Jogador)
	{
	  Scoreboard score = Main.plugin.getServer().getScoreboardManager().getNewScoreboard();
	  Objective objetivo = score.registerNewObjective("pvp", "sheepkits");
	  objetivo.setDisplayName("§b§fSheep§9§fKits");
	  objetivo.setDisplaySlot(DisplaySlot.SIDEBAR);
	  
	  Score a16 = objetivo.getScore(Bukkit.getOfflinePlayer("§0    "));
	  a16.setScore(16);
	  
	  Score a15 = objetivo.getScore(Bukkit.getOfflinePlayer("§cKills:"));
	  a15.setScore(15);
	  
	  Score a14 = objetivo.getScore(Bukkit.getOfflinePlayer("§a" + Main.plugin.getConfig().getInt("status." + Jogador.getName().toLowerCase() + ".kills")));
	  a14.setScore(14);
	  
	  Score a13 = objetivo.getScore(Bukkit.getOfflinePlayer("§1    "));
	  a13.setScore(13);
	  
	  Score a12 = objetivo.getScore(Bukkit.getOfflinePlayer("Deaths:"));
	  a12.setScore(12);
	  
	  Score a11 = objetivo.getScore(Bukkit.getOfflinePlayer("§c" + Main.plugin.getConfig().getInt("status." + Jogador.getName().toLowerCase() + ".mortes")));
	  a11.setScore(11);
	  
	  Score a10 = objetivo.getScore(Bukkit.getOfflinePlayer("§2    "));
	  a10.setScore(10);
	  

	  
	  
	  

}
}
