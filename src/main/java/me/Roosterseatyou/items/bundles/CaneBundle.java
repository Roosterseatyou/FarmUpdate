package me.Roosterseatyou.items.bundles;

import me.Roosterseatyou.items.compacted.CompactedCane;
import me.Roosterseatyou.items.compacted.CompactedPotatoes;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CaneBundle {
    public static ItemStack CaneBundle;

    public static ItemStack init() {
        caneBundle();
        return null;
    }

    public static void caneBundle(){
        ItemStack item = new ItemStack(Material.SUGAR_CANE);
        ItemMeta meta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(Component.text("Bundle of Sugar Cane").color(TextColor.fromHexString("9606A5")));
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        lore.add(Component.text("Bundled form of Sugar Cane").decorate(TextDecoration.BOLD).color(TextColor.fromHexString("FF0000")));
        meta.lore(lore);
        item.setItemMeta(meta);
        CaneBundle = item;

        ShapedRecipe cb = new ShapedRecipe(NamespacedKey.minecraft("canebundle"), item);
        cb.shape("CCC", "CCC", "CCC");
        cb.setIngredient('C', Material.SUGAR_CANE);
        Bukkit.getServer().addRecipe(cb);

        ShapedRecipe cp = new ShapedRecipe(NamespacedKey.minecraft("compactcane"), CompactedCane.CompactedCane);
        cp.shape("BBB", "BBB", "BBB");
        cp.setIngredient('B', item);
        Bukkit.getServer().addRecipe(cp);
    }
}
