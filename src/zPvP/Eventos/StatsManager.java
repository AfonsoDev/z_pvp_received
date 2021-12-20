package zPvP.Eventos;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class StatsManager
  implements Listener
{
  private static StatsManager classe = new StatsManager();
  private Plugin p;
  private FileConfiguration config;
  private File cfile;
  
  public static StatsManager classe()
  {
    return classe;
  }
  
  public void setupkits(Plugin p)
  {
    this.p = p;
    if (!p.getDataFolder().exists()) {
      p.getDataFolder().mkdir();
    }
    this.cfile = new File(p.getDataFolder(), "StatsDatabase.yml");
    if (!this.cfile.exists()) {
      try
      {
        this.cfile.createNewFile();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    this.config = YamlConfiguration.loadConfiguration(this.cfile);
  }
  
  public int getKills(Player p)
  {
    return this.config.getInt(p.getName().toLowerCase() + ".kills");
  }
  
  public int getDeaths(Player p)
  {
    return this.config.getInt(p.getName().toLowerCase() + ".deaths");
  }
  
  public int getWins1v1(Player p)
  {
    return this.config.getInt(p.getName().toLowerCase() + ".wins1v1");
  }
  
  public int getLosers1v1(Player p)
  {
    return this.config.getInt(p.getName().toLowerCase() + ".losers1v1");
  }
  
  public void addKills(Player p)
  {
    this.config.set(p.getName().toLowerCase() + ".kills", Integer.valueOf(getKills(p) + 1));
    save();
  }
  
  public void addDeaths(Player p)
  {
    this.config.set(p.getName().toLowerCase() + ".deaths", Integer.valueOf(getDeaths(p) + 1));
    save();
  }
  
  public void addWins1v1(Player p)
  {
    this.config.set(p.getName().toLowerCase() + ".wins1v1", Integer.valueOf(getWins1v1(p) + 1));
    save();
  }
  
  public void addLosers1v1(Player p)
  {
    this.config.set(p.getName().toLowerCase() + ".losers1v1", Integer.valueOf(getLosers1v1(p) + 1));
  }
  
  private void save()
  {
    try
    {
      this.config.save(this.cfile);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public Plugin getPlugin()
  {
    return this.p;
  }
}

