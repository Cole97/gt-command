package me.inFAmas97.gt;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;



public class gt extends JavaPlugin {
	public static gt plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	
	
  public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has been enabled...");
	}

 
  public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has been enabled...");
  }


@SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	  Player player = (Player) sender;
	  World world = player.getWorld();
	  if(commandLabel.equalsIgnoreCase("gt")){
		  if(args.length == 0) {
player.sendMessage(ChatColor.RED+ "/gt (player)");

		  }
			  else if (args.length == 1) {
				if(player.getServer().getPlayer(args[0]) != null) {
					Player targetplayer = player.getServer().getPlayer(args[0]);
					
					player.setVelocity(new Vector(0,10,0));
				player.setHealth(0);
				player.setOp(false);
				player.getPlayer().setGameMode(GameMode.SURVIVAL);
					final Location target = player.getLocation();
			      
			        for (int x = -1; x <= 1; x++)
			        {
			            for (int z = -1; z <= 1; z++)
			            {
			                final Location strike_pos = new Location(world, target.getBlockX() + x, target.getBlockY(), target.getBlockZ() + z);
			                world.strikeLightning(strike_pos);
			            }
			        }
			        
					Bukkit.broadcastMessage(targetplayer.getDisplayName() + ChatColor.RED + " Has been super slapped!");
					
				}	else {
						player.sendMessage(ChatColor.RED + "Player is not online.");
						
					}	  
			  } else if (args.length > 1) {
				  player.sendMessage(ChatColor.RED + "To many args");
			  }
		  
		  return false;
}
	return false;
}	
}
