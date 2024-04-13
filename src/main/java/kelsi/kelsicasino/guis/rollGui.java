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
        stoneMeta.setDisplayName("x1.25");
        stoneMeta.setLore(Collections.singletonList("Бонус: §61.25x\nШанс: §95%"));
        stone.setItemMeta(stoneMeta);

        iron = new ItemStack(Material.IRON_BLOCK);
        ItemMeta ironMeta = iron.getItemMeta();
        ironMeta.setDisplayName("x1.5");
        ironMeta.setLore(Collections.singletonList("Бонус: §61.5x\nШанс: §80%"));
        iron.setItemMeta(ironMeta);

        gold = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta goldMeta = gold.getItemMeta();
        goldMeta.setDisplayName("x1.75");
        goldMeta.setLore(Collections.singletonList("Бонус: §61.75x\nШанс: §75%"));
        gold.setItemMeta(goldMeta);

        redStone = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta redstoneMeta = redStone.getItemMeta();
        redstoneMeta.setDisplayName("x2");
        redstoneMeta.setLore(Collections.singletonList("Бонус: §62x\nШанс: §50%"));
        redStone.setItemMeta(redstoneMeta);

        diamond = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta diamondMeta = diamond.getItemMeta();
        diamondMeta.setDisplayName("x3");
        diamondMeta.setLore(Collections.singletonList("Бонус: §63x\nШанс: §25%"));
        diamond.setItemMeta(diamondMeta);

        diamondThree = new ItemStack(Material.DIAMOND_BLOCK); diamondThree.setAmount(3);
        ItemMeta diamondthreeMeta = diamondThree.getItemMeta();
        diamondthreeMeta.setDisplayName("x3.5");
        diamondthreeMeta.setLore(Collections.singletonList("Бонус: §63.5x\nШанс: §10%"));
        diamondThree.setItemMeta(diamondthreeMeta);

        diamondFive = new ItemStack(Material.DIAMOND_BLOCK); diamondFive.setAmount(5);
        ItemMeta diamondfiveMeta = diamondFive.getItemMeta();
        diamondfiveMeta.setDisplayName("x5");
        diamondfiveMeta.setLore(Collections.singletonList("Бонус: §65x\nШанс: §1%"));
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
