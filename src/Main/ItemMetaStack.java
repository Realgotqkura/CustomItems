package Main;

import java.util.Locale;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public class ItemMetaStack {

	private ItemStack stack;
	 public ItemMetaStack(final ItemStack stack) {
	        this.stack = stack.clone();
	    }
	 
	 @SuppressWarnings({ "deprecation", "unused" })
	public Enchantment getEnchantment(final String name) {
	        final Enchantment enchantment = Enchantments.getByName(name);
	        if (enchantment == null) {
	            return null;
	        }
	        final String enchantmentName = enchantment.getName().toLowerCase(Locale.ENGLISH);
	        return enchantment;
	    }
	 @SuppressWarnings("deprecation")
	public void addEnchantment(final CommandSender sender, final boolean allowUnsafe, final Enchantment enchantment, final int level) throws Exception {
	        if (enchantment == null) {
	            sender.sendMessage("§cThis Enchant doesnt exist!");
	        }
	        try {
	            if (stack.getType().equals(Material.ENCHANTED_BOOK)) {
	                final EnchantmentStorageMeta meta = (EnchantmentStorageMeta) stack.getItemMeta();
	                if (level == 0) {
	                    meta.removeStoredEnchant(enchantment);
	                } else {
	                    meta.addStoredEnchant(enchantment, level, allowUnsafe);
	                }
	                stack.setItemMeta(meta);
	            } else { // all other material types besides ENCHANTED_BOOK
	                if (level == 0) {
	                    stack.removeEnchantment(enchantment);
	                } else {
	                    if (allowUnsafe) {
	                        stack.addUnsafeEnchantment(enchantment, level);
	                    } else {
	                        stack.addEnchantment(enchantment, level);
	                    }
	                }
	            }
	        } catch (final Exception ex) {
	            throw new Exception("Enchantment " + enchantment.getName() + ": " + ex.getMessage(), ex);
	        }
	    }
	 
	 //Else
	 public ItemStack getItemStack() {
	        return stack;
	    }
}
