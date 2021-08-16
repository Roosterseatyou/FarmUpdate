package me.Roosterseatyou;

import me.Roosterseatyou.events.HoeListeners;
import me.Roosterseatyou.items.armor.SpeedBoots;
import me.Roosterseatyou.items.bundles.CarrotBundle;
import me.Roosterseatyou.items.bundles.PotatoBundle;
import me.Roosterseatyou.items.compacted.CompactedCarrots;
import me.Roosterseatyou.items.compacted.CompactedPotatoes;
import me.Roosterseatyou.items.compacted.CompactedWheat;
import me.Roosterseatyou.items.hoes.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Plugin instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new HoeListeners(), this);
        TillingHoe.init();
        CompactedCarrots.init();
        ReplantingHoe.init();
        WheatHoe.init();
        PotatoHoe.init();
        CarrotHoe.init();
        SpeedBoots.init();
        CompactedWheat.init();
        FarmHoe.init();
        CarrotBundle.init();
        PotatoBundle.init();
        CompactedPotatoes.init();
        instance = this;

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE+"Happy Farming!");
        // Plugin shutdown logic
    }

    public static Plugin getInstance(){
        return instance;
    }
}
