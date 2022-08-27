package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;

import com.google.common.collect.Lists;

public class EnchantTabs implements TabCompleter {
	
	
    
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			List<String> cmdArg = new ArrayList<String>();
			cmdArg.add("lore");
			cmdArg.add("name");
			cmdArg.add("enchant");
			cmdArg.add("dev");
			cmdArg.add("help");
			cmdArg.add("unbreakable");
			cmdArg.add("itemflag");
			cmdArg.add("head");
			cmdArg.add("amount");
			return cmdArg;
		}
		if(args[0].equalsIgnoreCase("enchant")) {
		 if (args.length == 2) {
	            return new ArrayList<>(Enchantments.keySet());
	        } else if (args.length == 3) {
	            final Enchantment enchantment = Enchantments.getByName(args[1]);
	            if (enchantment == null) {
	                return Collections.emptyList();
	            }
	            final int min = enchantment.getStartLevel();
	            final int max = enchantment.getMaxLevel();
	            final List<String> options = Lists.newArrayList();
	            for (int i = min; i <= max; i++) {
	                options.add(Integer.toString(i));
	            }
	            return options;
	        }
			} else if(args[0].equalsIgnoreCase("unbreakable")) {
				if(args.length == 2) {
					List<String> unbr = new ArrayList<String>();
					unbr.add("true");
					unbr.add("false");
					return unbr;
				}
			}
			else if(args[0].equalsIgnoreCase("itemflag")) {
				List<String> flags = new ArrayList<String>();
				List<String> result = new ArrayList<String>();
		
				List<String> r2 = new ArrayList<String>();
				flags.add("hide_enchants");
				flags.add("hide_unbreakable");
				flags.add("hide_destroys");
				flags.add("hide_attributes");
				flags.add("hide_potion_effects");
				flags.add("hide_placed_on");
				flags.add("hide_dye");
				flags.add("info");
				r2.add("false");
				r2.add("true");
				if(args.length == 2) {
					
					for(String a : flags) {
						if(a.toLowerCase().startsWith(args[1].toLowerCase())) {
							result.add(a);
						}
						
					}
					return result;
				}
				else if(args.length == 3) {
					return r2;
				}
			}
			else if(args[0].equalsIgnoreCase("lore")) {
				List<String> acr = new ArrayList<String>();
				List<String> result = new ArrayList<String>();
				acr.add("add");
				acr.add("replace");
				acr.add("clear");
				if(args.length == 2) {
					for(String a : acr) {
						if(a.toLowerCase().startsWith(args[1].toLowerCase())) {
							result.add(a);
						}
						
					}
					return result;
				}
			}
			else if(args[0].equalsIgnoreCase("head")) {
				List<String> headArgs = new ArrayList<String>();
				List<String> result = new ArrayList<String>();
				headArgs.add("base64");
				headArgs.add("Username");
				headArgs.add("info");
				headArgs.add("URL");
				if(args.length == 2) {
				for(String a : headArgs) {
					if(a.toLowerCase().startsWith(args[1].toLowerCase())) {
						result.add(a);
					}
				}
				return result;
				}
			}
		else {
	            return Collections.emptyList();
	        }
	
		return null;
	}

}
