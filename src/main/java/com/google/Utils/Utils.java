package com.google.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BlockIterator;

import java.awt.*;
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
}
