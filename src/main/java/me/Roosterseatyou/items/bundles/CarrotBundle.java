package me.Roosterseatyou.items.bundles;

import me.Roosterseatyou.items.compacted.CompactedCarrots;
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

public class CarrotBundle {
    public static ItemStack CarrotBundle;

    public static ItemStack init() {
        carrotBundle();
        return null;
    }

    public static void carrotBundle(){
        ItemStack item = new ItemStack(Material.CARROT);
        ItemMeta meta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(Component.text("Bundle of Carrots").color(TextColor.fromHexString("9606A5")));
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        lore.add(Component.text("Bundled form of Carrots").decorate(TextDecoration.BOLD).color(TextColor.fromHexString("FF0000")));
        meta.lore(lore);
        item.setItemMeta(meta);
        CarrotBundle = item;

        ShapedRecipe bc = new ShapedRecipe(NamespacedKey.minecraft("carrotbundle"), item);
        bc.shape("CCC", "CCC", "CCC");
        bc.setIngredient('C', Material.CARROT);
        Bukkit.getServer().addRecipe(bc);

        ShapedRecipe cc = new ShapedRecipe(NamespacedKey.minecraft("compactcarrots"), CompactedCarrots.CompactedCarrots);
        cc.shape("CCC", "CCC", "CCC");
        cc.setIngredient('C', item);
        Bukkit.getServer().addRecipe(cc);
    }
}
