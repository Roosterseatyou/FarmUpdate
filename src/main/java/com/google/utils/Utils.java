package com.google.utils;

import com.google.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.BlockIterator;

import java.util.Collection;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Utils {
    public Utils() {
    }

    public static void delay(int ms) {
        try {
            TimeUnit.MILLISECONDS.sleep((long)ms);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }
    public static Block getTargetBlock(Player player, int range) {
        BlockIterator iter = new BlockIterator(player, range);
        Block lastBlock = iter.next();
        while (iter.hasNext()) {
            lastBlock = iter.next();
            if (lastBlock.getType() == Material.AIR) {
                continue;
            }
            break;
        }
        return lastBlock;
    }
    public static <T> T randomFromCollection(Collection<T> coll) {
        int num = (int) (Math.random() * coll.size());
        for(T t: coll) if (--num < 0) return t;
        throw new AssertionError();
    }

    public static String chooseSubstring (String text, int length, Random rand)
    {
        int randomNum = rand.nextInt(length);
        String answer = text.substring(randomNum);
        return answer;
    }

    public static Integer randomInteger(int min, int max){
        int range = (max - min)+1;
        return (int) (Math.random()*range)+min;
    }
    public static boolean itemInHandEquals(Player p, ItemStack item){
        ItemStack mainHand = p.getInventory().getItemInMainHand();
        return Objects.equals(mainHand, item);
    }
    public static void replantCrop(Location loc, Material seed){
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            loc.getBlock().setType(seed);
        }, 20L);
    }

    public static void removeSeed(Player p, Material seedMat){
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
    public static boolean isSeedInInv(Player p, Material mat){
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
    public static Material getSeeds(Material mat) {
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
    public static boolean isFullyGrown(Block b) {
        Ageable ageable = (Ageable) b.getBlockData();
        int maxAge = ageable.getMaximumAge();

        return ageable.getAge() == maxAge;

    }
}
