package me.Roosterseatyou.items.hoes;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PotatoHoe {
    public static ItemStack PotatoHoe;

    public static ItemStack init() {
        potatoHoe();
        return null;
    }

    public static void potatoHoe(){
        ItemStack item = new ItemStack(Material.GOLDEN_HOE);
        ItemMeta meta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(Component.text("Potato Hoe").color(TextColor.fromHexString("9606A5")));
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        lore.add(Component.text("Abitity:").decorate(TextDecoration.BOLD).color(TextColor.fromHexString("FF0000")));
        lore.add(Component.text("Extra harvest from Potatoes").decorate(TextDecoration.BOLD).color(TextColor.fromHexString("FF0000")));
        meta.lore(lore);
        item.setItemMeta(meta);
        PotatoHoe = item;
    }
}
