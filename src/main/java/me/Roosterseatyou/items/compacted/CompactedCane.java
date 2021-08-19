package me.Roosterseatyou.items.compacted;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
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
    }
}
