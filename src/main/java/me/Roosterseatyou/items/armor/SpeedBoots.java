package me.Roosterseatyou.items.armor;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SpeedBoots {
    public static ItemStack SpeedBoots;

    public static ItemStack init() {
        speedBoots();
        return null;
    }

    public static void speedBoots(){
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        List<Component> lore = new ArrayList<>();
        meta.displayName(Component.text("Sugar Cane Boots").color(TextColor.fromHexString("9606A5")));
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        lore.add(Component.text("Ability:").decorate(TextDecoration.BOLD).color(TextColor.fromHexString("FF0000")));
        lore.add(Component.text("Gives permanent a permanent speed boost").decorate(TextDecoration.BOLD).color(TextColor.fromHexString("FF0000")));
        meta.setColor(Color.LIME);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "gen_armor", 0.078, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
        lore.add(Component.text("Server ID: SUGAR_BOOTS").color(NamedTextColor.DARK_GRAY));
        meta.lore(lore);
        item.setItemMeta(meta);
        SpeedBoots = item;
    }
}
