package me.Roosterseatyou.events;

import me.Roosterseatyou.items.hoes.PotatoHoe;
import me.Roosterseatyou.items.hoes.ReplantingHoe;
import me.Roosterseatyou.items.hoes.TillingHoe;
import me.Roosterseatyou.items.hoes.WheatHoe;
import me.Roosterseatyou.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Listeners implements Listener {
    @EventHandler
    public void onPlayerTill(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (Utils.itemInHandEquals(p, TillingHoe.TillingHoe)) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block b = e.getClickedBlock();
                if (b != null && b.getType() != Material.AIR) {
                    if (b.getType() == Material.DIRT || b.getType() == Material.GRASS_BLOCK) {
                        BlockFace north = BlockFace.NORTH;
                        BlockFace northWest = BlockFace.NORTH_WEST;
                        BlockFace northEast = BlockFace.NORTH_EAST;
                        BlockFace east = BlockFace.EAST;
                        BlockFace west = BlockFace.WEST;
                        BlockFace south = BlockFace.SOUTH;
                        BlockFace southWest = BlockFace.SOUTH_WEST;
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
                        for (BlockFace bf : bfList) {
                            if (b.getRelative(bf).getType() == Material.GRASS_BLOCK || b.getRelative(bf).getType() == Material.DIRT) {
                                b.getRelative(bf).setType(Material.FARMLAND);
                            }
                        }
                    }
                }
            }
        }
    }
        @EventHandler
        public void onPlayerHarvest(BlockBreakEvent e) {
            Player p = e.getPlayer();
            Block b = e.getBlock();

            Material cropBlockMat = null;
            if(Utils.itemInHandEquals(p, ReplantingHoe.ReplantHoe)) {

                if (b.getType() == Material.WHEAT) {
                    cropBlockMat = Material.WHEAT;
                } else if (b.getType() == Material.POTATOES) {
                    cropBlockMat = Material.POTATOES;
                } else if (b.getType() == Material.CARROTS) {
                    cropBlockMat = Material.CARROTS;
                } else if (b.getType() == Material.BEETROOTS) {
                    cropBlockMat = Material.BEETROOTS;
                } else if (b.getType() == Material.NETHER_WART) {
                    cropBlockMat = Material.NETHER_WART;
                }
                if (cropBlockMat != null && Utils.isFullyGrown(b)) {
                    Material seed = Utils.getSeeds(cropBlockMat);
                    if (Utils.isSeedInInv(p, cropBlockMat)) {
                        Location loc = b.getLocation();
                        Utils.removeSeed(p, seed);
                        Utils.replantCrop(loc, cropBlockMat);
                    }
                }
            }
        }
    @EventHandler
    public void onPlayerHarvestWheat(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();
        int rIntWheat = Utils.randomInteger(3, 8);
        int rIntSeeds = Utils.randomInteger(2, 5);
        ItemStack wheat = new ItemStack(Material.WHEAT, rIntWheat);
        ItemStack seeds = new ItemStack(Material.WHEAT_SEEDS, rIntSeeds);
        if(Utils.itemInHandEquals(p, WheatHoe.WheatHoe)) {
            if (b.getType() == Material.WHEAT) {
                if (p.getInventory().firstEmpty() != -1) {
                    p.getInventory().addItem(wheat);
                    p.getInventory().addItem(seeds);
                } else {
                    Location loc = b.getLocation();
                    loc.getWorld().dropItemNaturally(loc, wheat);
                    loc.getWorld().dropItemNaturally(loc, seeds);
                }
            }
        }
    }
    @EventHandler
    public void onPlayerHarvestPotatoes(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();
        int rIntProduct = Utils.randomInteger(5, 10);
        ItemStack wheat = new ItemStack(Material.POTATO, rIntProduct);
        if(Utils.itemInHandEquals(p, PotatoHoe.PotatoHoe)) {
            if (b.getType() == Material.POTATOES) {
                if (p.getInventory().firstEmpty() != -1) {
                    p.getInventory().addItem(wheat);
                } else {
                    Location loc = b.getLocation();
                    loc.getWorld().dropItemNaturally(loc, wheat);
                }
            }
        }
    }

    //Just need to get the item for testing lmao. Will remove after i decide on a recipe :)
    @EventHandler
    public void onPlayerShift(PlayerToggleSneakEvent e){
        Player p = e.getPlayer();
        if(p.isSneaking()) {
            p.getInventory().addItem(ReplantingHoe.ReplantHoe);
            p.getInventory().addItem(TillingHoe.TillingHoe);
            p.getInventory().addItem(WheatHoe.WheatHoe);
            p.getInventory().addItem(PotatoHoe.PotatoHoe);
        }
    }
}
