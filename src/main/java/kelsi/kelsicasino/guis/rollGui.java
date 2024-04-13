package kelsi.kelsicasino.guis;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class rollGui {
    public static Inventory inventory;
    public static ItemStack stone;
    public static ItemStack iron;
    public static ItemStack gold;
    public static ItemStack redStone;
    public static ItemStack diamond;
    public static ItemStack diamondThree;
    public static ItemStack diamondFive;
    public static void createItems() {
        stone = new ItemStack(Material.STONE);
        ItemMeta stoneMeta = stone.getItemMeta();
        stoneMeta.setDisplayName("§6x1.25 §f(95%)");
        stone.setItemMeta(stoneMeta);

        iron = new ItemStack(Material.IRON_BLOCK);
        ItemMeta ironMeta = iron.getItemMeta();
        ironMeta.setDisplayName("§61.5 §f(80%)");
        iron.setItemMeta(ironMeta);

        gold = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta goldMeta = gold.getItemMeta();
        goldMeta.setDisplayName("§6x1.75 §f(75%)");
        gold.setItemMeta(goldMeta);

        redStone = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta redstoneMeta = redStone.getItemMeta();
        redstoneMeta.setDisplayName("§6x2 §f(50%)");
        redStone.setItemMeta(redstoneMeta);

        diamond = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta diamondMeta = diamond.getItemMeta();
        diamondMeta.setDisplayName("§6x3 §f(25%)");
        diamond.setItemMeta(diamondMeta);

        diamondThree = new ItemStack(Material.DIAMOND_BLOCK); diamondThree.setAmount(3);
        ItemMeta diamondthreeMeta = diamondThree.getItemMeta();
        diamondthreeMeta.setDisplayName("§6x3.5 §f(10%)");
        diamondThree.setItemMeta(diamondthreeMeta);

        diamondFive = new ItemStack(Material.DIAMOND_BLOCK); diamondFive.setAmount(5);
        ItemMeta diamondfiveMeta = diamondFive.getItemMeta();
        diamondfiveMeta.setDisplayName("§6x5 §f(1%)");
        diamondFive.setItemMeta(diamondfiveMeta);
    }

    public static void createInventory() {
        inventory = Bukkit.createInventory(null,  9, "/roll");
    }

    public static void setItems() {
        createInventory();
        inventory.setItem(1, stone);
        inventory.setItem(2, iron);
        inventory.setItem(3, gold);
        inventory.setItem(4, redStone);
        inventory.setItem(5, diamond);
        inventory.setItem(6, diamondThree);
        inventory.setItem(7, diamondFive);
    }
}
