package Main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class TabCompleterModifier implements TabCompleter{

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			List<String> at = new ArrayList<String>();
			at.add("damage");
			at.add("health");
			at.add("speed");
			at.add("luck");
			at.add("knockback_res");
			at.add("knockback_power");
			at.add("armor");
			at.add("armor_tough");
			at.add("attack_speed");
			return at;
			
		}
		if(args.length == 3) {
			List<String> at = new ArrayList<String>();
			at.add("hand");
			at.add("off_hand");
			at.add("chestplate");
			at.add("helmet");
			at.add("boots");
			at.add("leggings");
			return at;
		}
		return null;
	}

}
