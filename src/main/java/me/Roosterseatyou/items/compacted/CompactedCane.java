package me.Roosterseatyou.items.compacted;

import me.Roosterseatyou.items.armor.SugarCane.SpeedBoots;
import me.Roosterseatyou.items.armor.SugarCane.SpeedChest;
import me.Roosterseatyou.items.armor.SugarCane.SpeedHelm;
import me.Roosterseatyou.items.armor.SugarCane.SpeedLegs;
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

public class CompactedCane {
    public static ItemStack CompactedCane;

    public static ItemStack init() {
        compactCane();
        return null;
    }

    public static void compactCane(){
        ItemStack item = new ItemStack(Material.SUGAR_CANE);
        ItemMeta meta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(Component.text("Compacted Cane").color(TextColor.fromHexString("9606A5")));
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        lore.add(Component.text("The compact form of Cane").decorate(TextDecoration.BOLD).color(TextColor.fromHexString("FF0000")));
        meta.lore(lore);
        item.setItemMeta(meta);
        CompactedCane = item;

        ShapedRecipe sh = new ShapedRecipe(NamespacedKey.minecraft("speedhelm"), SpeedHelm.SpeedHelm);
        sh.shape("CCC", "C C", "   ");
        sh.setIngredient('C', item);
        Bukkit.addRecipe(sh);

        ShapedRecipe sc = new ShapedRecipe(NamespacedKey.minecraft("speedchest"), SpeedChest.SpeedChest);
        sc.shape("C C", "CCC", "CCC");
        sc.setIngredient('C', item);
        Bukkit.addRecipe(sc);

        ShapedRecipe sl = new ShapedRecipe(NamespacedKey.minecraft("speedlegs"), SpeedLegs.SpeedLegs);
        sl.shape("CCC", "C C", "C C");
        sl.setIngredient('C', item);
        Bukkit.addRecipe(sl);

        ShapedRecipe sb = new ShapedRecipe(NamespacedKey.minecraft("speedboots"), SpeedBoots.SpeedBoots);
        sb.shape("C C", "C C", "   ");
        sb.setIngredient('C', item);
        Bukkit.addRecipe(sb);
    }
}
