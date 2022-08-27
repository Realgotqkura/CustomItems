package Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin{



 	@Override
	public void onEnable() {

		this.getCommand("ItemStack").setExecutor(new TxtCommands());
		this.getCommand("ItemStack").setTabCompleter(new EnchantTabs());
	
	}

	@Override
	public void onDisable() {

		
	}
	
	
}
