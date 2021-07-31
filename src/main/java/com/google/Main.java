package com.google;

import com.google.Events.FunTestListener;
import com.google.Items.Hoes.TillingHoe;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new FunTestListener(), this);
        TillingHoe.init();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
