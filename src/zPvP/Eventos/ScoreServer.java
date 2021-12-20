package zPvP.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreServer {

	public static void createScoreboard(Player p, String kit){
		
		Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = s.registerNewObjective(p.getName(), "dummy");
		obj.setDisplayName("§f§lSheepKits");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		Score espaço = obj.getScore(Bukkit.getOfflinePlayer("  "));
		Score money = obj.getScore(Bukkit.getOfflinePlayer("§aMoney: "));
		Score moneytanto = obj.getScore(Bukkit.getOfflinePlayer("  "));
		Score espaço2 = obj.getScore(Bukkit.getOfflinePlayer("  "));
		Score kitdele = obj.getScore(Bukkit.getOfflinePlayer("§ckit:  "));
		Score kits = obj.getScore(Bukkit.getOfflinePlayer(kit));
		Score espaço3 = obj.getScore(Bukkit.getOfflinePlayer("   "));
		Score nome = obj.getScore(Bukkit.getOfflinePlayer("§bNick: "));
		Score nomedele = obj.getScore(Bukkit.getOfflinePlayer(p.getDisplayName()));
		
		espaço.setScore(15);
		money.setScore(14);
		moneytanto.setScore(13);
		espaço2.setScore(12);
		kitdele.setScore(11);
		kits.setScore(10);
		espaço3.setScore(9);
		nome.setScore(8);
		nomedele.setScore(7);
		
		p.setScoreboard(s);
		
	}
}
