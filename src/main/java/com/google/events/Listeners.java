package com.google.events;

import com.google.items.hoes.ReplantingHoe;
import com.google.items.hoes.TillingHoe;
import com.google.Main;
import com.google.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;

public class Listeners implements Listener {
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
    public void onPlayerHarvest(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();

        Material cropBlockMat = null;

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
        if (cropBlockMat != null && isFullyGrown(b)) {
            Material seed = getSeeds(cropBlockMat);
            if(isSeedInInv(p, cropBlockMat)){
                Location loc = b.getLocation();
                removeSeed(p, seed);
                replantCrop(loc, cropBlockMat);
            }
        }
    }

    public void replantCrop(Location loc, Material seed){
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            loc.getBlock().setType(seed);
        }, 20L);
    }

    public void removeSeed(Player p, Material seedMat){
        int seedIndexLocation = -1;
        ItemStack currentItems;
        PlayerInventory pInv = p.getInventory();

        for(int slotIndex = 0; slotIndex <= pInv.getSize(); slotIndex++){
            currentItems = pInv.getItem(slotIndex);
            if(currentItems != null){
                if(currentItems.getType() == seedMat){
                    seedIndexLocation =slotIndex;

                    slotIndex = pInv.getSize();
                }
            }
        }

        if(seedIndexLocation != -1){
            ItemStack seedItemStack = pInv.getItem(seedIndexLocation);
            if(seedItemStack != null){
                int seedAmt = seedItemStack.getAmount();
                seedItemStack.setAmount(seedAmt - 1);
            }
        }
    }
    public boolean isSeedInInv(Player p, Material mat){
        PlayerInventory pInv = p.getInventory();
        if (mat == Material.WHEAT) {
            return pInv.contains(Material.WHEAT_SEEDS);
        } else if (mat == Material.POTATOES) {
            return pInv.contains(Material.POTATO);
        } else if (mat == Material.CARROTS) {
            return pInv.contains(Material.CARROT);
        } else if (mat == Material.BEETROOTS) {
            return pInv.contains(Material.BEETROOT);
        } else if (mat == Material.NETHER_WART) {
            return pInv.contains(Material.NETHER_WART);
        }
        return false;
    }
    public Material getSeeds (Material mat) {
        if (mat == Material.WHEAT) {
            return Material.WHEAT_SEEDS;
        } else if (mat == Material.POTATOES) {
            return Material.POTATO;
        } else if (mat == Material.CARROTS) {
            return Material.CARROT;
        } else if (mat == Material.BEETROOTS) {
            return Material.BEETROOT;
        } else if (mat == Material.NETHER_WART) {
            return Material.NETHER_WART;
        }
            return null;
        }
    public boolean isFullyGrown(Block b) {
        Ageable ageable = (Ageable) b.getBlockData();
        int maxAge = ageable.getMaximumAge();

        return ageable.getAge() == maxAge;

    }
    //Just need to get the item for testing lmao. Will remove after i decide on a recipe :)
    @EventHandler
    public void onPlayerShift(PlayerToggleSneakEvent e){
        Player p = e.getPlayer();
        p.getInventory().addItem(ReplantingHoe.ReplantHoe);
        p.getInventory().addItem(TillingHoe.TillingHoe);
    }
}
