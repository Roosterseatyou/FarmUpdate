package me.Roosterseatyou.items.compacted;

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

public class CompactedWheat {
    public static ItemStack CompactedWheat;

    public static ItemStack init() {
        compactWheat();
        return null;
    }

    public static void compactWheat(){
        ItemStack item = new ItemStack(Material.WHEAT);
        ItemMeta meta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(Component.text("Compacted Wheat").color(TextColor.fromHexString("9606A5")));
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        lore.add(Component.text("The compact form of Wheat.").decorate(TextDecoration.BOLD).color(TextColor.fromHexString("FF0000")));
        meta.lore(lore);
        item.setItemMeta(meta);
        CompactedWheat = item;

        ShapedRecipe cw = new ShapedRecipe(NamespacedKey.minecraft("compactwheat"), CompactedWheat);
        cw.shape("WWW", "WWW", "WWW");
        cw.setIngredient('W', Material.HAY_BLOCK);
        Bukkit.getServer().addRecipe(cw);
    }
}
