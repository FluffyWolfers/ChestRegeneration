package me.FluffyWolfers.CR;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class CR extends JavaPlugin{
	
	public static CR c;
	public static PluginDescriptionFile pdf;
	
	public void onEnable(){
		
		c = this;
		pdf = this.getDescription();
		
		Bukkit.getLogger().info("[ColorYourWolf v" + pdf.getVersion() + "] Starting up...");
		
		this.getCommand("chestregen").setExecutor(new CRCommand());
		this.getCommand("cr").setExecutor(new CRCommand());
		this.getCommand("chest").setExecutor(new CRCommand());
		this.getCommand("regen").setExecutor(new CRCommand());
		this.getCommand("regeneration").setExecutor(new CRCommand());
		this.getCommand("chestregeneration").setExecutor(new CRCommand());
		
		this.loadConfigs();
		
		new CRTask().runTaskTimer(this, 100, 50);
		
	}
	
	public void loadConfigs(){
		
		this.saveDefaultConfig();
		
	}
	
	public static String getPrefix(){
		return ChatColor.AQUA + "[" + ChatColor.DARK_AQUA + "ChestRegeneration" + ChatColor.AQUA + "] " + ChatColor.LIGHT_PURPLE;
	}
	
	public static String getLogPrefix(){
		return "[" + pdf.getName() + " v" + pdf.getVersion() + "]";
	}

}
