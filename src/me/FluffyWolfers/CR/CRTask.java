package me.FluffyWolfers.CR;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class CRTask extends BukkitRunnable{
	
	public void run(){
		
		File dir = new File(CR.c.getDataFolder(), File.separator + "chests");
		
		if(dir != null){
			
			for(File child : dir.listFiles()){
				
				YamlConfiguration yaml = YamlConfiguration.loadConfiguration(child);
				
				int time = yaml.getInt("time");
				long timeLong = yaml.getLong("time-long");
				
				if(System.currentTimeMillis() < timeLong){
					
					int ammount = yaml.getInt("inv.amm");
					String worldStr = yaml.getString("coords.world");
					World world = Bukkit.getWorld(worldStr);
					String[] coords = yaml.getString("coords.coords").split(":");
					int x = Integer.parseInt(coords[0]);
					int y = Integer.parseInt(coords[1]);
					int z = Integer.parseInt(coords[2]);
					
					Location loc = new Location(world, x, y, z);
					Block b = world.getBlockAt(loc);
					
					if(b.getType().equals(Material.CHEST)||b.getType().equals(Material.TRAPPED_CHEST)){
						
						Chest chest = (Chest) b.getState();
						Inventory inv = chest.getInventory();
						
						if(CR.c.getConfig().getBoolean("clear-chest")){
							inv.clear();
						}
						
						for(int i = 0; i < ammount; i++){
							
							String c = String.valueOf(i + 1);
							ItemStack is = yaml.getItemStack("inv.slot" + c);
							
							inv.addItem(is);
							
						}
						
					}
					
					long newTime = System.currentTimeMillis() + (time * 1000);
					yaml.set("time-long", newTime);
					
				}
				
			}
			
		}
		
	}
	
}
