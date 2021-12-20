package zPvP.Eventos;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class Config
  implements Listener
{
  static Config instance = new Config();
  Plugin p;
  static FileConfiguration config;
  static File cfile;
  static FileConfiguration data;
  static File dfile;
  static FileConfiguration kill;
  static File sfile;
  static FileConfiguration kills;
  static File filed;
  
  public static Config getInstance()
  {
    return instance;
  }
  
  public void setup(Plugin p)
  {
    cfile = new File(p.getDataFolder(), "config.yml");
    config = p.getConfig();
    if (!p.getDataFolder().exists()) {
      p.getDataFolder().mkdir();
    }
    dfile = new File(p.getDataFolder(), "data.yml");
    if (!dfile.exists()) {
      try
      {
        dfile.createNewFile();
      }
      catch (IOException e)
      {
        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Nao foi possivel criar a pasta data.yml");
      }
    }
    data = YamlConfiguration.loadConfiguration(dfile);
    
    sfile = new File(p.getDataFolder(), "kill.yml");
    if (!sfile.exists()) {
      try
      {
        sfile.createNewFile();
      }
      catch (IOException e)
      {
        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Nao foi possivel criar a pasta kill.yml!");
      }
    }
    kill = YamlConfiguration.loadConfiguration(sfile);
    
    filed = new File(p.getDataFolder(), "config.yml");
    if (!filed.exists()) {
      try
      {
        filed.createNewFile();
      }
      catch (IOException e)
      {
        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Nao foi possivel criar a pasta config.yml!");
      }
    }
    config = YamlConfiguration.loadConfiguration(filed);
  }
  
  public FileConfiguration getkills()
  {
    return config;
  }
  
  public void savekills()
  {
    try
    {
      config.save(filed);
    }
    catch (IOException e)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Nao foi possivel salvar config.yml!");
    }
  }
  
  public void saveip()
  {
    try
    {
      kill.save(sfile);
    }
    catch (IOException e)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Nao foi possivel salvar kill.yml!");
    }
  }
  
  public void reloadip()
  {
    kill = YamlConfiguration.loadConfiguration(sfile);
  }
  
  public FileConfiguration getData()
  {
    return data;
  }
  
  public void saveData()
  {
    try
    {
      data.save(dfile);
    }
    catch (IOException e)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Nao foi possivel salvar data.yml!");
    }
  }
  
  public void reloadData()
  {
    data = YamlConfiguration.loadConfiguration(dfile);
  }
  
  public FileConfiguration getConfig()
  {
    return config;
  }
  
  public void saveConfig()
  {
    try
    {
      config.save(cfile);
    }
    catch (IOException e)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Nao foi possivel salvar config.yml!");
    }
  }
  
  public static int getKills(Player p)
  {
    return config.getInt(p.getName().toLowerCase() + ".kills");
  }
  
  public static int getDeaths(Player p)
  {
    return config.getInt(p.getName().toLowerCase() + ".deaths");
  }
  
  public static void addKills(Player p)
  {
    config.set(p.getName().toLowerCase() + ".kills", Integer.valueOf(getKills(p) + 1));
    save();
  }
  
  public static void addDeaths(Player p)
  {
    config.set(p.getName().toLowerCase() + ".deaths", Integer.valueOf(getDeaths(p) + 1));
    save();
  }
  
  private static void save()
  {
    try
    {
      config.save(cfile);
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
  
  public Config getNewConfig(String string)
  {
    return null;
  }
}