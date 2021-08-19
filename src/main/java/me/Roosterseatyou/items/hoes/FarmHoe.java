package me.Roosterseatyou.items.hoes;

import me.Roosterseatyou.items.compacted.CompactedCane;
import me.Roosterseatyou.items.compacted.CompactedCarrots;
import me.Roosterseatyou.items.compacted.CompactedPotatoes;
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

        ShapedRecipe ph = new ShapedRecipe(NamespacedKey.minecraft("potatohoe"), PotatoHoe.PotatoHoe);
        ph.shape("PPP", "PHP", "PPP");
        ph.setIngredient('P', CompactedPotatoes.CompactedPotato);
        ph.setIngredient('H', item);
        Bukkit.getServer().addRecipe(ph);

        ShapedRecipe cah = new ShapedRecipe(NamespacedKey.minecraft("canehoe"), CaneHoe.CaneHoe);
        cah.shape("CCC", "CHC", "CCC");
        cah.setIngredient('C', CompactedCane.CompactedCane);
        cah.setIngredient('H', item);
        Bukkit.getServer().addRecipe(cah);

        ShapedRecipe th = new ShapedRecipe(NamespacedKey.minecraft("tillinghoe"), TillingHoe.TillingHoe);
        th.shape("HHH", "HFH", "HHH");
        th.setIngredient('H', Material.DIAMOND_HOE);
        th.setIngredient('F', item);
        Bukkit.getServer().addRecipe(th);

        ShapedRecipe rh = new ShapedRecipe(NamespacedKey.minecraft("replanthoe"), ReplantingHoe.ReplantHoe);
        rh.shape("CWP", "PFP", "CWP");
        rh.setIngredient('C', CompactedCarrots.CompactedCarrots);
        rh.setIngredient('W', CompactedWheat.CompactedWheat);
        rh.setIngredient('P', CompactedPotatoes.CompactedPotato);
        rh.setIngredient('F', item);
        Bukkit.getServer().addRecipe(rh);

        ShapedRecipe fh = new ShapedRecipe(NamespacedKey.minecraft("farmhoe"), item);
        fh.shape("CWP", "SHS", "CWP");
        fh.setIngredient('C', CompactedCarrots.CompactedCarrots);
        fh.setIngredient('W', CompactedWheat.CompactedWheat);
        fh.setIngredient('S', CompactedCane.CompactedCane);
        fh.setIngredient('P', CompactedPotatoes.CompactedPotato);
        fh.setIngredient('H', Material.STONE_HOE);
        Bukkit.getServer().addRecipe(fh);


    }
}
