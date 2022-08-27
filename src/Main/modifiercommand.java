package Main;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class modifiercommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("This command is only for players!");
        }
        Player player = (Player) sender;
        ItemStack hand = player.getInventory().getItemInMainHand();
        ItemMeta meta = hand.getItemMeta();
        hand.setItemMeta(meta);
        if(label.equalsIgnoreCase("itemstack_modifier")) {
        	if(!player.hasPermission("itemstack_modifier.use")) {
        		player.sendMessage("§cYou don't have permission to use this command!");
        		return true;
        	}
        	if(args.length == 1) {
        		player.sendMessage("§cUsage: /itemstack_modifier <modifier> <Value> <Slot>");
        		return true;
        	}
        	if(args.length == 2) {
        		player.sendMessage("§cUsage: /itemstack_modifier <modifier> <Value> <Slot>");
        		return true;
        	}
        	if(args.length >= 3) {
        		if(!(hand.getType() == Material.AIR)) {
            		String atmod = "";
            		switch(args[0]) {
            		case "damage":
            			atmod = "generic.attackDamage";
            			player.sendMessage("§aSuccessfully Added the damage Attribute!");     			
            			break;
            		case "health":
            			atmod = "generic.max_health";
            			player.sendMessage("§aSuccessfully Added the health Attribute!");        			
            			break;
            		case "knockback_res":
            			atmod = "generic.knockback_resistance";
            			player.sendMessage("§aSuccessfully Added the knockback resistance Attribute!");
            			break;
            		case "speed":
            			atmod = "generic.movement_speed";
            			player.sendMessage("§aSuccessfully Added the speed Attribute!");
            			break;
            		case "armor":
            			atmod = "generic.armor";
            			player.sendMessage("§aSuccessfully Added the Defense Attribute!");
            			break;
            		case "armor_tough":
            			atmod = "generic.armor_toughness";
            			player.sendMessage("§aSuccessfully Added the toughness Attribute!");
            			break;
            		case "knockback_power":
            		    atmod = "generic.attack_knockback";
            		    player.sendMessage("§aSuccessfully Added the Knockback Attribute!");
            		    break;
            		case "attack_speed":
            			atmod = "generic.attack_speed";
            			player.sendMessage("§aSuccessfully Added the Attack speed Attribute!");
            			break;
            		case "luck":
            			atmod = "generic.luck";
            			player.sendMessage("§aSuccessfully added the Luck Attribute!");
            			break;
            		    default:
            		    	player.sendMessage("§cThis is not a modifier!");
            		    	break;
            			
            		}
            		switch(args[0]) {
            		case "damage":
            			try {
            				switch(args[2]) {
            				case "hand":
            					AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
                				break;
            				case "off_hand":
            					AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);
                				break;
            				case "helmet":
            					AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier2);
                				break;
            				case "chestplate":
            					AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier3);
                				break;
            				case "boots":
            					AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.FEET);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier4);
                				break;
            				case "leggings":
            					AttributeModifier modifier5 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier5);
                				break;
                				default:
                					player.sendMessage("§cThis Equipment slot doesn't exist!");
                					break;
            				}
            				hand.setItemMeta(meta);
            			}catch(Exception e) {
            				player.sendMessage("§cOne of the arguments is wrong!");
            				player.sendMessage("§cMake sure you are using the required arguments!");
            			}
            			break;
            		case "health":
            			try {
            				switch(args[2]) {
            				case "hand":
            					AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
                				break;
            				case "off_hand":
            					AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier1);
                				break;
            				case "helmet":
            					AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                				meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier2);
                				break;
            				case "chestplate":
            					AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                				meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier3);
                				break;
            				case "boots":
            					AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.FEET);
                				meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier4);
                				break;
            				case "leggings":
            					AttributeModifier modifier5 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier5);
                				break;
                				default:
                					player.sendMessage("§cThis Equipment slot doesn't exist!");
                					break;
            				}
            				hand.setItemMeta(meta);
            			}catch(Exception e) {
            				player.sendMessage("§cOne of the arguments is wrong!");
            				player.sendMessage("§cMake sure you are using the required arguments!");
            			}		
            			break;
            		case "knockback_res":
            			try {
            				switch(args[2]) {
            				case "hand":
            					AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier);
                				break;
            				case "off_hand":
            					AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier1);
                				break;
            				case "helmet":
            					AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                				meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier2);
                				break;
            				case "chestplate":
            					AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                				meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier3);
                				break;
            				case "boots":
            					AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.FEET);
                				meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier4);
                				break;
            				case "leggings":
            					AttributeModifier modifier5 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier5);
                				break;
                				default:
                					player.sendMessage("§cThis Equipment slot doesn't exist!");
                					break;
            				}
            				hand.setItemMeta(meta);
            			}catch(Exception e) {
            				player.sendMessage("§cOne of the arguments is wrong!");
            				player.sendMessage("§cMake sure you are using the required arguments!");
            			}
            			break;
            		case "speed":
            			try {
            				switch(args[2]) {
            				case "hand":
            					AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);
                				break;
            				case "off_hand":
            					AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier1);
                				break;
            				case "helmet":
            					AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                				meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier2);
                				break;
            				case "chestplate":
            					AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                				meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier3);
                				break;
            				case "boots":
            					AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.FEET);
                				meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier4);
                				break;
            				case "leggings":
            					AttributeModifier modifier5 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier5);
                				break;
                				default:
                					player.sendMessage("§cThis Equipment slot doesn't exist!");
                					break;
            				}
            				hand.setItemMeta(meta);
            			}catch(Exception e) {
            				player.sendMessage("§cOne of the arguments is wrong!");
            				player.sendMessage("§cMake sure you are using the required arguments!");
            			}
            			break;
            		case "armor":
            			try {
            				switch(args[2]) {
            				case "hand":
            					AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
                				break;
            				case "off_hand":
            					AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier1);
                				break;
            				case "helmet":
            					AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                				meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier2);
                				break;
            				case "chestplate":
            					AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                				meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier3);
                				break;
            				case "boots":
            					AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.FEET);
                				meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier4);
                				break;
            				case "leggings":
            					AttributeModifier modifier5 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier5);
                				break;
                				default:
                					player.sendMessage("§cThis Equipment slot doesn't exist!");
                					break;
            				}
            				hand.setItemMeta(meta);
            			}catch(Exception e) {
            				player.sendMessage("§cOne of the arguments is wrong!");
            				player.sendMessage("§cMake sure you are using the required arguments!");
            			}
            			break;
            		case "armor_tough":
            			try {
            				switch(args[2]) {
            				case "hand":
            					AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier);
                				break;
            				case "off_hand":
            					AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier1);
                				break;
            				case "helmet":
            					AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                				meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier2);
                				break;
            				case "chestplate":
            					AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                				meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier3);
                				break;
            				case "boots":
            					AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.FEET);
                				meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier4);
                				break;
            				case "leggings":
            					AttributeModifier modifier5 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier5);
                				break;
                				default:
                					player.sendMessage("§cThis Equipment slot doesn't exist!");
                					break;
            				}
            				hand.setItemMeta(meta);
            			}catch(Exception e) {
            				player.sendMessage("§cOne of the arguments is wrong!");
            				player.sendMessage("§cMake sure you are using the required arguments!");
            			}
            			break;
            		case "knockback_power":
            			try {
            				switch(args[2]) {
            				case "hand":
            					AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier);
                				break;
            				case "off_hand":
            					AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier1);
                				break;
            				case "helmet":
            					AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier2);
                				break;
            				case "chestplate":
            					AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier3);
                				break;
            				case "boots":
            					AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.FEET);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier4);
                				break;
            				case "leggings":
            					AttributeModifier modifier5 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier5);
                				break;
                				default:
                					player.sendMessage("§cThis Equipment slot doesn't exist!");
                					break;
            				}
            				hand.setItemMeta(meta);
            			}catch(Exception e) {
            				player.sendMessage("§cOne of the arguments is wrong!");
            				player.sendMessage("§cMake sure you are using the required arguments!");
            			}
            		    break;
            		case "attack_speed":
            			try {
            				switch(args[2]) {
            				case "hand":
            					AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
                				break;
            				case "off_hand":
            					AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier1);
                				break;
            				case "helmet":
            					AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier2);
                				break;
            				case "chestplate":
            					AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier3);
                				break;
            				case "boots":
            					AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.FEET);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier4);
                				break;
            				case "leggings":
            					AttributeModifier modifier5 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier5);
                				break;
                				default:
                					player.sendMessage("§cThis Equipment slot doesn't exist!");
                					break;
            				}
            				hand.setItemMeta(meta);
            			}catch(Exception e) {
            				player.sendMessage("§cOne of the arguments is wrong!");
            				player.sendMessage("§cMake sure you are using the required arguments!");
            			}
            			break;
            		case "luck":
            			try {
            				switch(args[2]) {
            				case "hand":
            					AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_LUCK, modifier);
                				break;
            				case "off_hand":
            					AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_LUCK, modifier1);
                				break;
            				case "helmet":
            					AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                				meta.addAttributeModifier(Attribute.GENERIC_LUCK, modifier2);
                				break;
            				case "chestplate":
            					AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                				meta.addAttributeModifier(Attribute.GENERIC_LUCK, modifier3);
                				break;
            				case "boots":
            					AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.FEET);
                				meta.addAttributeModifier(Attribute.GENERIC_LUCK, modifier4);
                				break;
            				case "leggings":
            					AttributeModifier modifier5 = new AttributeModifier(UUID.randomUUID(), atmod, Integer.parseInt(args[1]), Operation.ADD_NUMBER, EquipmentSlot.HAND);
                				meta.addAttributeModifier(Attribute.GENERIC_LUCK, modifier5);
                				break;
                				default:
                					player.sendMessage("§cThis Equipment slot doesn't exist!");
                					break;
            				}
            				hand.setItemMeta(meta);
            			}catch(Exception e) {
            				player.sendMessage("§cOne of the arguments is wrong!");
            				player.sendMessage("§cMake sure you are using the required arguments!");
            			}
            		  
            			
            		}
            		return true;
            	}
            		if(hand.getType() == Material.AIR) {
            			player.sendMessage("§cYou must have an item in your hand!");
            			return true;
            		}
            		try {
            			
            		}catch(Exception e) {
            			
            		}
        	}
        	
        	return true;
        }

		return false;
	}

}
