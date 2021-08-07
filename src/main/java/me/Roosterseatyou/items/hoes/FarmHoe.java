package me.Roosterseatyou.items.hoes;

import me.Roosterseatyou.items.compacted.CompactedCarrots;
import me.Roosterseatyou.items.compacted.CompactedWheat;
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

public class FarmHoe {
    public static ItemStack FarmHoe;

    public static ItemStack init() {
        farmHoe();
        return null;
    }

    public static void farmHoe(){
        ItemStack item = new ItemStack(Material.STONE_HOE);
        ItemMeta meta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(Component.text("Base Hoe").color(TextColor.fromHexString("9606A5")));
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        lore.add(Component.text("Combine this with 8 of your Compacted Crop of choice!").decorate(TextDecoration.BOLD).color(TextColor.fromHexString("FF0000")));
        meta.lore(lore);
        item.setItemMeta(meta);
        FarmHoe = item;

        ShapedRecipe wh = new ShapedRecipe(NamespacedKey.minecraft("wheathoe"), WheatHoe.WheatHoe);
        wh.shape("CCC", "CHC", "CCC");
        wh.setIngredient('C', CompactedWheat.CompactedWheat);
        wh.setIngredient('H', item);
        Bukkit.getServer().addRecipe(wh);


        ShapedRecipe ch = new ShapedRecipe(NamespacedKey.minecraft("carrothoe"), CarrotHoe.CarrotHoe);
        ch.shape("CCC", "CHC", "CCC");
        ch.setIngredient('C', CompactedCarrots.CompactedCarrots);
        ch.setIngredient('H', item);
        Bukkit.getServer().addRecipe(ch);


    }
}
