package me.Roosterseatyou.items.bundles;

import me.Roosterseatyou.items.compacted.CompactedCarrots;
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

public class PotatoBundle {
    public static ItemStack PotatoBundle;

    public static ItemStack init() {
        potatoBundle();
        return null;
    }

    public static void potatoBundle(){
        ItemStack item = new ItemStack(Material.CARROT);
        ItemMeta meta = item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(Component.text("Bundle of Potatoes").color(TextColor.fromHexString("9606A5")));
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        lore.add(Component.text("Bundled form of Potatoes").decorate(TextDecoration.BOLD).color(TextColor.fromHexString("FF0000")));
        meta.lore(lore);
        item.setItemMeta(meta);
        PotatoBundle = item;

        ShapedRecipe pb = new ShapedRecipe(NamespacedKey.minecraft("potatobundle"), item);
        pb.shape("PPP", "PPP", "PPP");
        pb.setIngredient('P', Material.POTATO);
        Bukkit.getServer().addRecipe(pb);

        ShapedRecipe cp = new ShapedRecipe(NamespacedKey.minecraft("compactpotato"), CompactedPotatoes.CompactedPotato);
        cp.shape("BBB", "BBB", "BBB");
        cp.setIngredient('B', item);
        Bukkit.getServer().addRecipe(cp);
    }
}
