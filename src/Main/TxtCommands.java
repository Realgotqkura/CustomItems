package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class TxtCommands implements CommandExecutor
{

	
   private List<String> arglist = new ArrayList<String>();
   private List<String> itemlist = new ArrayList<String>();
  
   public void HeadMSG(Player player) {
	   player.sendMessage("§6--------§cHeadInfo§6--------");
	   player.sendMessage("§bUsername argument: " + ChatColor.DARK_GRAY + "Put a minecraft username. Like your own!");
	   player.sendMessage("§bbase64 argument: " + ChatColor.DARK_GRAY + "Put a base64 string in this argument. You can easily get one from minecraft_heads.com. By the way this method gets you heads from hypixel skyblock (without the actual use)!");
	   player.sendMessage("§bURL argument: " + ChatColor.DARK_GRAY + "This is a better version of using the base64 method. It uses less character space and works on all versions!");
	  
	   player.sendMessage("§6--------§cHeadInfo§6--------");
	   
   }

   public void InfoMsg(Player player) {
	   player.sendMessage("§6--------§cInfo§6--------");
	   player.sendMessage("§bHIDE_ENCHANTS" + ChatColor.DARK_GRAY + " hides the enchants of your items (doesnt remove them)");
	   player.sendMessage("§bHIDE_ATTRIBUTES" + ChatColor.DARK_GRAY + " hides the attributes of your items (doesnt remove them)");
	   player.sendMessage("§bHIDE_DYE" + ChatColor.DARK_GRAY + " hides the dye of your leather armor");
	   player.sendMessage("§bHIDE_UNBREAKABLE" + ChatColor.DARK_GRAY + " hides the 'unbreakable' mark on your item");
	   player.sendMessage("§bHIDE_DESTROYS" + ChatColor.DARK_GRAY + " hides what the item can break/destroy");
	   player.sendMessage("§bHIDE_ENCHANTS" + ChatColor.DARK_GRAY + " hides the enchants of your items (doesnt remove them)");
	   player.sendMessage("§bHIDE_PLACED_ON" + ChatColor.DARK_GRAY + " hides what the item can be placed on");
	   player.sendMessage("§bHIDE_POTION_EFFECTS" + ChatColor.DARK_GRAY + " hides the potion effects of your item");
	   player.sendMessage("§6--------§cInfo§6--------");
	   
   }
   
	public void addArray() {
		arglist.add("dev");
		arglist.add("help");
		arglist.add("name");
		arglist.add("lore");
		arglist.add("enchant");
		arglist.add("unbreakable");
		arglist.add("itemflag");
		arglist.add("head");
		arglist.add("amount");
		
		itemlist.add("amount");
		itemlist.add("enchant");
		itemlist.add("unbreakable");
		itemlist.add("itemflag");
		itemlist.add("name");
		itemlist.add("lore");
	}
	
	public void HelpMsg(Player player) {
		player.sendMessage("§6----------§cHelp§6---------");
		player.sendMessage("§b/itemstack dev " + ChatColor.DARK_GRAY + "shows the plugin developer");
		player.sendMessage("§b/itemstack name <item name> " + ChatColor.DARK_GRAY + "changes the name of the item in your hand");
		player.sendMessage("§b/itemstack lore <add/replace/clear> <line *if replace*> <message> " + ChatColor.DARK_GRAY + "changes the lore of the item in your hand");
		player.sendMessage("§b/itemstack enchant <enchant> <level> " + ChatColor.DARK_GRAY + "enchants the item in your hand");
		player.sendMessage("§b/itemstack unbreakable <true/false> " + ChatColor.DARK_GRAY + "makes the item unbreakable or not");
		player.sendMessage("§b/itemstack itemflag <itemflag> <true/false> " + ChatColor.DARK_GRAY + "add different itemflags for info type /itemstack itemflag info");
		player.sendMessage("§b/itemstack head <base64,URL,Username> <the base64 string, the Username, the URL> " + ChatColor.DARK_GRAY + "gives you player heads depending on the given value.");
		//player.sendMessage("§b/itemstack_modifier <modifier> <level> <Slot>" + ChatColor.DARK_GRAY + "Adds an attribute modifier");
		player.sendMessage("§b/itemstack amount <number>" + ChatColor.DARK_GRAY + " Sets the item in your hand to a specific amount");
		
		
		
		//end line
		player.sendMessage("§6----------§cHelp§6---------");
	}
	

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("This command is only for players!");
			return true;
		}
	    Player player = (Player)sender;
	

		ItemStack hand = player.getInventory().getItemInHand();
		ItemMeta handmeta = hand.getItemMeta();
		if(label.equalsIgnoreCase("ItemStack")) {
			addArray();
			if(player.hasPermission("ItemStack.use")) {
				if(args.length == 0) {
					HelpMsg(player);
					return true;
				}
				if(args[0].equalsIgnoreCase("dev")) {
					player.sendMessage("§b§lDev: Realgotqkura");
					player.sendMessage("§b§lReport bugs: gotqpie@gmail.com");
					return true;
				}
				else if(args[0].equalsIgnoreCase("help")) {
					HelpMsg(player);
					return true;
				}
				else if(args[0].equalsIgnoreCase("head")) {
		    		if(args.length == 1) {
		    			player.sendMessage("§cUsage: /itemstack head <Username,base64,info> <the Username, the base64>");
		    			player.sendMessage("");
		    			player.sendMessage("§cExample: /itemstack head Username MinecraftPro");
		    			player.sendMessage("");
		    			player.sendMessage("§cExample 2: /itemstack head URL e21e59e0592270f4215fa3148bcc4fe25fabb8ee968fb584e437ee9c0a071");
		    			player.sendMessage("");
		    			player.sendMessage("§cExample 3: /itemstack head base64 <base64 from minecraft_heads.com>");
		    			return true;
		    		}
		    		if(args.length == 2) {
		    			if(args[1].equalsIgnoreCase("Username")) {
		    				player.sendMessage("§cPut a username value. Example: MinecraftPro");
		    				return true;
		    			}
		    			if(args[1].equalsIgnoreCase("base64")) {
		    				player.sendMessage("§cput a base64 value. You can get a base64 value from minecraft-heads.com");
		    				player.sendMessage("§c *gives custom skulls like skulls from Hypixel skyblock!*");
		    				return true;
		    			}
		    			if(args[1].equalsIgnoreCase("URL")) {
		    				player.sendMessage("§cPut a URL in the argument. Although not a regular URL i modified it");
		    				player.sendMessage("§cSo it can fit in all versions. just put the value bellow on minecraft_heads.com");
		    				return true;
		    			}
		    			if(args[1].equalsIgnoreCase("info")) {
		    				HeadMSG(player);
		    				return true;
		    			}
		    			player.sendMessage("§cThis argument doesn't exist!");
		    			return true;
		    		}
		    		//Stuff
		    		if(args[1].equalsIgnoreCase("Username")) {
		    			try {
		    				player.getInventory().addItem(SkullCreator.itemFromName(args[2]));
		    				player.sendMessage("§aSuccessfully added a head to your inventory!");
		    			}catch(Exception e) {
		    				player.sendMessage("§cThis username doesn't exist!");
		    			}
		    			return true;
		    		}
		    		else if(args[1].equalsIgnoreCase("base64")) {
		    			try {
		    				if(!(args[2].contains("="))) {
		    					player.sendMessage("§cSorry, you are probably running an older version of MC.");
		    					player.sendMessage("§cSo the full base64 string cant fit. But don't worry!");
		    					player.sendMessage("§cjust use /itemstack head URL <url from minecraft_heads.com>");
		    					return true;
		    				}
		    				player.getInventory().addItem(SkullCreator.itemFromBase64(args[2]));
		    				player.sendMessage("§aSuccessfully added a head to your inventory!");
		    			}catch(Exception e) {
		    				player.sendMessage("§cThis is not a base64 string!");
		    			}
		    			return true;
		    		}
		    		else if(args[1].equalsIgnoreCase("URL")) {
		    			try {
		    				if(args[2].contains("http://textures.minecraft.net/texture/")) {
		    					player.sendMessage("§cYou dont need the 'http://textures.minecraft.net/texture/' part in the URL so");
		    					player.sendMessage("§cit can fit on all MC versions!");
		    					return true;
		    				}
		    				player.getInventory().addItem(SkullCreator.itemFromUrl(args[2]));
		    				player.sendMessage("§aSuccessfully added a head to your inventory!");
		    				return true;
		    			}catch(Exception e) {
		    				player.sendMessage("§cThis URL doesnt exist!");
		    				return true;
		    			}
		    		}
		    	}
				
				
				//Actual commands
			    if(!(hand.getType() == Material.AIR)) {
			    	if(args[0].equalsIgnoreCase("name")) {
						if(args.length == 1) {
							player.sendMessage("§cCorrect Usage: /ItemStack name <Name of the item>");
							return true;
						}
						String msg = "";

						for(int i = 1; i < args.length; i++){ 
						    String arg = args[i] + " "; 
						    msg = msg + arg;
						}
						handmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', msg.trim()));
						hand.setItemMeta(handmeta);
						player.sendMessage("§aSuccessfully renamed the item!");
						
						return true;
					}
			    	if(args[0].equalsIgnoreCase("removeenchant")){
						if(args.length == 1) {
							player.sendMessage("§cCorrect Usage: /ItemStack enchant <enchantment>");
							return true;
						}
						else{
							final Set<String> usableEnchants = new TreeSet<>();
							for (final Map.Entry<String, Enchantment> entry : Enchantments.entrySet()) {
								usableEnchants.add(entry.getKey());
							}
							final ItemMetaStack metaStack = new ItemMetaStack(hand);

							final Enchantment enchantment = metaStack.getEnchantment(args[1]);
							try {
								hand.removeEnchantment(enchantment);
							} catch (Exception e) {
								player.sendMessage(ChatColor.RED + "Your item doesn't have this enchant!");
							}
						}

					}

			    	if(args[0].equalsIgnoreCase("enchant")) {
			    		if(args.length == 1) {
			    			player.sendMessage("§cCorrect Usage: /ItemStack enchant <enchantment> <level>");
			    			return true;
			    		}
			    		if(args.length == 2) {
			    			player.sendMessage("§cPlease select a level of enchantment!");
			    			return true;
			    		}
			    		if(args.length >= 3) {
			    		int num = Integer.parseInt(args[2]);
			    		 final Set<String> usableEnchants = new TreeSet<>();
			             for (final Map.Entry<String, Enchantment> entry : Enchantments.entrySet()) {
			                     usableEnchants.add(entry.getKey());
			             }
			             final ItemMetaStack metaStack = new ItemMetaStack(hand);
			            
							final Enchantment enchantment = metaStack.getEnchantment(args[1]);
							try {
								metaStack.addEnchantment(player, true, enchantment, num);
							} catch (Exception e) {
							
								e.printStackTrace();
							}
						player.getInventory().setItemInHand(metaStack.getItemStack());
						player.sendMessage("§aSuccessfully enchanted the item!");
			    	}
			    	}
			    	if(args[0].equalsIgnoreCase("unbreakable")) {
			    		if(args.length >= 2) {
			    		if(args[1].equalsIgnoreCase("true")) {
			    			handmeta.setUnbreakable(true);
			    			player.sendMessage("§aYour tool is now unbreakable!");
			    			hand.setItemMeta(handmeta);
			    		}
			    		else if(args[1].equalsIgnoreCase("false")) {
			    			handmeta.setUnbreakable(false);
			    			player.sendMessage("§aYour tool is now breakable!");
			    			hand.setItemMeta(handmeta);
			    		}
			    		return true;
			    	}
			    	}
			    	if(args[0].equalsIgnoreCase("itemflag")) {
			    		if(args.length == 2) {
			    			if(args[1].equalsIgnoreCase("info")) {
			    				InfoMsg(player);
			    				return true;
			    			}
			    			player.sendMessage("§cCorrect Usage: /itemstack itemflag <flag> <true/false>");
			    			return true;
			    		}
			    		if(args.length >= 3) {
			    			if(args[1].equalsIgnoreCase("hide_enchants")) {
			    				if(args[2].equalsIgnoreCase("true")) {
			    				handmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			    				hand.setItemMeta(handmeta);
			    				player.sendMessage("§aSuccessfully added the item flag!");
			    				}
			    				if(args[2].equalsIgnoreCase("false")) {
				    				handmeta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
				    				hand.setItemMeta(handmeta);
				    				player.sendMessage("§aSiccessfully removed the item flag!");
				    				}
			    				
			    				
			    				return true;
			    			}
			    			if(args[1].equalsIgnoreCase("hide_unbreakable")) {
			    				if(args[2].equalsIgnoreCase("true")) {
			    				handmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
			    				hand.setItemMeta(handmeta);
			    				player.sendMessage("§aSuccessfully added the item flag!");
			    				}
			    				if(args[2].equalsIgnoreCase("false")) {
				    				handmeta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				    				hand.setItemMeta(handmeta);
				    				player.sendMessage("§aSiccessfully removed the item flag!");
				    				}
			    				
			    				
			    				return true;
			    			}
			    			if(args[1].equalsIgnoreCase("hide_destroys")) {
			    				if(args[2].equalsIgnoreCase("true")) {
			    				handmeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
			    				hand.setItemMeta(handmeta);
			    				player.sendMessage("§aSuccessfully added the item flag!");
			    				}
			    				if(args[2].equalsIgnoreCase("false")) {
				    				handmeta.removeItemFlags(ItemFlag.HIDE_DESTROYS);
				    				hand.setItemMeta(handmeta);
				    				player.sendMessage("§aSiccessfully removed the item flag!");
				    				}
			    				
			    				
			    				return true;
			    			}
			    			if(args[1].equalsIgnoreCase("hide_attributes")) {
			    				if(args[2].equalsIgnoreCase("true")) {
			    				handmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			    				hand.setItemMeta(handmeta);
			    				player.sendMessage("§aSuccessfully added the item flag!");
			    				}
			    				if(args[2].equalsIgnoreCase("false")) {
				    				handmeta.removeItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				    				hand.setItemMeta(handmeta);
				    				player.sendMessage("§aSiccessfully removed the item flag!");
				    				}
			    				
			    				
			    				return true;
			    			}
			    			if(args[1].equalsIgnoreCase("hide_dye")) {
			    				if(args[2].equalsIgnoreCase("true")) {
			    				handmeta.addItemFlags(ItemFlag.HIDE_DYE);
			    				hand.setItemMeta(handmeta);
			    				player.sendMessage("§aSuccessfully added the item flag!");
			    				}
			    				if(args[2].equalsIgnoreCase("false")) {
				    				handmeta.removeItemFlags(ItemFlag.HIDE_DYE);
				    				hand.setItemMeta(handmeta);
				    				player.sendMessage("§aSiccessfully removed the item flag!");
				    				}
			    				
			    				
			    				return true;
			    			}
			    			if(args[1].equalsIgnoreCase("hide_placed_on")) {
			    				if(args[2].equalsIgnoreCase("true")) {
			    				handmeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
			    				hand.setItemMeta(handmeta);
			    				player.sendMessage("§aSuccessfully added the item flag!");
			    				}
			    				if(args[2].equalsIgnoreCase("false")) {
				    				handmeta.removeItemFlags(ItemFlag.HIDE_PLACED_ON);
				    				hand.setItemMeta(handmeta);
				    				player.sendMessage("§aSiccessfully removed the item flag!");
				    				}
			    				
			    				
			    				return true;
			    			}
			    			if(args[1].equalsIgnoreCase("hide_potion_effects")) {
			    				if(args[2].equalsIgnoreCase("true")) {
			    				handmeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			    				hand.setItemMeta(handmeta);
			    				player.sendMessage("§aSuccessfully added the item flag!");
			    				}
			    				if(args[2].equalsIgnoreCase("false")) {
				    				handmeta.removeItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
				    				hand.setItemMeta(handmeta);
				    				player.sendMessage("§aSiccessfully removed the item flag!");
				    				}
			    				
			    				
			    				return true;
			    			}
			    			
			    			
			    		}
			    	}
			    	if(args[0].equalsIgnoreCase("amount")) {
			    		if(args.length == 1) {
			    			player.sendMessage("§cUsage: /itemstack amount <number>");
			    			return true;
			    		}
			    		if(args.length >= 2) {
			    		try {
			    			if(Integer.parseInt(args[1]) > 64) {
			    				player.sendMessage("§cYou can go up to only 64!");
			    				return true;
			    			}
			    			hand.setAmount(Integer.parseInt(args[1]));
			    			player.getInventory().removeItem(hand);
				    		player.getInventory().addItem(hand);
				    		player.sendMessage("§aSuccessfully set a specific amount!");
			    			return true;
			    		}catch(Exception e){			    		
			    			player.sendMessage("§cMake sure the second argument is a number!");
			    			return true;
			    		}
			    		
			    	}
			    		return true;
			    	}

			    	if(args[0].equalsIgnoreCase("lore")) {
						if(args.length == 1) {
							player.sendMessage("§cCorrect Usage: /ItemStack lore <add/clear> <message *if adding*>");
							return true;
						}
						if(args.length == 2 || args.length > 2) {
							if(args[1].equalsIgnoreCase("clear")) {
						        List<String> clearlore = new ArrayList<String>();
						        handmeta.setLore(clearlore);
						        hand.setItemMeta(handmeta);
						        player.sendMessage("§aSuccessfully cleared the lore of the item!");
								return true;
							}
							else if(args[1].equalsIgnoreCase("add")) {
								 final List<String> lore = handmeta.hasLore() ? handmeta.getLore() : new ArrayList<>();
									String myString = ""; //we're going to store the arguments here   
									for(int i = 2; i < args.length; i++){ //loop threw all the arguments
									    String arg = args[i] + " "; //get the argument, and add a space so that the words get spaced out
									    myString = myString + arg; //add the argument to myString
									}
									lore.add(ChatColor.translateAlternateColorCodes('&', myString));
									handmeta.setLore(lore);
									hand.setItemMeta(handmeta);
									player.sendMessage("§aSuccessfully added a new line of lore!");
									return true;
							}
							else if(args[1].equalsIgnoreCase("replace")) {
								final List<String> lore = handmeta.getLore();
								try {
								if(args.length == 2) {
									player.sendMessage("§cCorrect Usage: /ItemStack lore replace <line> <message>");
									return true;
								}
								if(args.length == 3) {
									player.sendMessage("§cCorrect Usage: /ItemStack lore replace <line> <message>");
									return true;
								}
								String myString = ""; //we're going to store the arguments here    
								for(int i = 3; i < args.length; i++){ //loop threw all the arguments
								    String arg = args[i] + " "; //get the argument, and add a space so that the words get spaced out
								    myString = myString + arg; //add the argument to myString
								}
								int line = Integer.parseInt(args[2]);
								int size = lore.size();
								//int arg = line + 1; //use this in if statement only
								int used = line - 1;
							    if(line == 0) {
							    	used = 0;
							    }
							    else if(line == 1) {
							    	used = 0;
							    }
 
								
								if(used < size) {
									lore.set(used, ChatColor.translateAlternateColorCodes('&', myString));
									handmeta.setLore(lore);
									hand.setItemMeta(handmeta);
									player.sendMessage("§aSuccessfully replaced the line!");
									return true;
								}
								player.sendMessage("§cThis line doesn't exist in the lore!");
								return true;
								}catch(Exception e) {
									player.sendMessage("§cthis item doesnt have any lore!");
								}
							}
							return true;
						}
					}
			    	
			    	
			    	
			    }
			    if(arglist.contains(args[0])) {
			    	if(itemlist.contains(args[0])) {
			    		if(hand.getType() == Material.AIR) {
			    	      player.sendMessage("§cYou dont have an item in your hand!");
			    	      
			    		}
			    	return true;
			    	}
			    	HelpMsg(player);
			    	return true;
			    }
			    	HelpMsg(player);
				return true;
			}
			player.sendMessage("§cYou dont have permission to use this command!");
			return true;
		}
		return false;
	}
}
