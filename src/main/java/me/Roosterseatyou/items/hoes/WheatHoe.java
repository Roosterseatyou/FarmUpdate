package me.Roosterseatyou.items.hoes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class WheatHoe {
    public static ItemStack WheatHoe;

    public static ItemStack init() {
        wheatHoe();
        return null;
    }

    public static void wheatHoe(){
        ItemStack item = new ItemStack(Material.IRON_HOE);
        ItemMeta meta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(Component.text("Wheat Hoe").color(TextColor.fromHexString("9606A5")));
        lore.add(Component.text("Abitity:").decorate(TextDecoration.BOLD).color(TextColor.fromHexString("FF0000")));
        lore.add(Component.text("Extra harvest from Wheat").decorate(TextDecoration.BOLD).color(TextColor.fromHexString("FF0000")));
        meta.lore(lore);
        meta.isUnbreakable();
        item.setItemMeta(meta);
        WheatHoe = item;
    }
}
