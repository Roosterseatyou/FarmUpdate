package com.google.Events;

import com.google.Items.Hoes.TillingHoe;
import com.google.Utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.ArrayList;
import java.util.List;

public class FunTestListener implements Listener {
    @EventHandler
    public void onPlayerTill(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(Utils.itemInHandEquals(p, TillingHoe.TillingHoe)){
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
                Block b = (org.bukkit.block.Block) e.getClickedBlock();
                if(b.getType() == Material.DIRT || b.getType() == Material.GRASS_BLOCK) {
                    Location loc = (Location) b.getLocation();
                    BlockFace north = BlockFace.NORTH;
                    BlockFace northWest = BlockFace.NORTH_WEST;
                    BlockFace northEast = BlockFace.NORTH_EAST;
                    BlockFace east = BlockFace.EAST;
                    BlockFace west = BlockFace.WEST;
                    BlockFace south = BlockFace.SOUTH;
                    BlockFace southWest= BlockFace.SOUTH_WEST;
                    BlockFace southEast = BlockFace.SOUTH_EAST;
                    List<BlockFace> bfList = new ArrayList<>();
                    bfList.add(north);
                    bfList.add(east);
                    bfList.add(south);
                    bfList.add(west);
                    bfList.add(northEast);
                    bfList.add(northWest);
                    bfList.add(southEast);
                    bfList.add(southWest);
                    for(BlockFace bf : bfList){
                        if(b.getRelative(bf).getType() == Material.GRASS_BLOCK || b.getRelative(bf).getType() == Material.DIRT){
                            b.getRelative(bf).setType(Material.FARMLAND);
                        }
                    }
                }
            }
        }
    }
    @EventHandler
    public void onPlayerShift(PlayerToggleSneakEvent e){
        Player p = e.getPlayer();
        p.getInventory().addItem(TillingHoe.TillingHoe);
    }
}
