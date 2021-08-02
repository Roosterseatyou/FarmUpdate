package me.Roosterseatyou;

import me.Roosterseatyou.events.Listeners;
import me.Roosterseatyou.items.hoes.PotatoHoe;
import me.Roosterseatyou.items.hoes.ReplantingHoe;
import me.Roosterseatyou.items.hoes.TillingHoe;
import me.Roosterseatyou.items.hoes.WheatHoe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Plugin instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        TillingHoe.init();
        ReplantingHoe.init();
        WheatHoe.init();
        PotatoHoe.init();
        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstance(){
        return instance;
    }
}
