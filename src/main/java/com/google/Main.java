package com.google;

import com.google.Events.FunTestListener;
import com.google.Items.Hoes.ReplantingHoe;
import com.google.Items.Hoes.TillingHoe;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Plugin instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new FunTestListener(), this);
        TillingHoe.init();
        ReplantingHoe.init();
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
