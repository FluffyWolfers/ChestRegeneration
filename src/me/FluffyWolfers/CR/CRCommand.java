package me.FluffyWolfers.CR;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CRCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(sender instanceof Player){
			
			Player p = (Player) sender;
			//String name = p.getName();
			
			if(args.length == 0){
				
				p.sendMessage(CR.getPreifx() + "Version: " + ChatColor.GREEN + "v" + CR.pdf.getVersion());
				p.sendMessage(CR.getPreifx() + "Creator: " + ChatColor.GREEN + "FluffyWolfers");
				p.sendMessage(CR.getPreifx() + "Type /cr help");
				
			}
			
		}
		
		return false;
	}

}
