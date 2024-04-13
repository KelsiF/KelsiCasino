package kelsi.kelsicasino.listeners;

import kelsi.kelsicasino.KelsiCasino;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Random;

public class guiListener implements Listener {

    int number = 0;
    int slot = 0;
    Random random = new Random();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        int randomNumber = random.nextInt(100 - 1)+1;

        if (player.hasMetadata("EnterNumber")) {
            player.removeMetadata("EnterNumber", KelsiCasino.getInstance());
            number = Integer.parseInt(event.getMessage());
            // random = (max - min)+min
            if (slot == 1) {
                if (randomNumber <= 95) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " + Math.round(number*1.1));
                } else {
                    player.setHealth(0.0);
                }
                Bukkit.getLogger().info("number: " + randomNumber);
            }
            else if (slot == 2) {
                if (randomNumber <= 80) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " + Math.round(number*1.5));
                } else {
                    player.setHealth(0.0);
                }
                Bukkit.getLogger().info("number: " + randomNumber);
            }
            else if (slot == 3) {
                if (randomNumber <= 75) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " + Math.round(number*1.75));
                } else {
                    player.setHealth(0.0);
                }
                Bukkit.getLogger().info("number: " + randomNumber);
            }
            else if (slot == 4) {
                if (randomNumber <= 50) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " + Math.round(number*2));
                } else {
                    player.setHealth(0.0);
                }
                Bukkit.getLogger().info("number: " + randomNumber);
            }
            else if (slot == 5) {
                if (randomNumber <= 25) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " + Math.round(number*3));
                } else {
                    player.setHealth(0.0);
                }
                Bukkit.getLogger().info("number: " + randomNumber);
            }
            else if (slot == 6) {
                if (randomNumber <= 10) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " + Math.round(number*3.5));
                } else {
                    player.setHealth(0.0);
                }
                Bukkit.getLogger().info("number: " + randomNumber);
            }
            else if (slot == 7) {
                if (randomNumber <= 1) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " + Math.round(number*5));
                } else {
                    player.setHealth(0.0);
                }
                Bukkit.getLogger().info("number: " + randomNumber);
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();


        if (player.hasMetadata("OpenedMenu")) {
            event.setCancelled(true);

            if (event.getSlot() == 1) {
                player.sendMessage("stone");
                player.closeInventory();
                player.setMetadata("EnterNumber", new FixedMetadataValue(KelsiCasino.getInstance(), "/roll"));
                player.sendMessage("\nВведите вашу ставку!\n");
            } else if (event.getSlot() == 2) {
                player.sendMessage("iron");
                player.closeInventory();
                player.setMetadata("EnterNumber", new FixedMetadataValue(KelsiCasino.getInstance(), "/roll"));
                player.sendMessage("\nВведите вашу ставку!\n");
            } else if (event.getSlot() == 3) {
                player.sendMessage("gold");
                player.closeInventory();
                player.setMetadata("EnterNumber", new FixedMetadataValue(KelsiCasino.getInstance(), "/roll"));
                player.sendMessage("\nВведите вашу ставку!\n");
            } else if (event.getSlot() == 4) {
                player.sendMessage("redstone");
                player.closeInventory();
                player.setMetadata("EnterNumber", new FixedMetadataValue(KelsiCasino.getInstance(), "/roll"));
                player.sendMessage("\nВведите вашу ставку!\n");
            } else if (event.getSlot() == 5) {
                player.sendMessage("diamond");
                player.closeInventory();
                player.setMetadata("EnterNumber", new FixedMetadataValue(KelsiCasino.getInstance(), "/roll"));
                player.sendMessage("\nВведите вашу ставку!\n");
            } else if (event.getSlot() == 6) {
                player.sendMessage("diamond3");
                player.closeInventory();
                player.setMetadata("EnterNumber", new FixedMetadataValue(KelsiCasino.getInstance(), "/roll"));
                player.sendMessage("\nВведите вашу ставку!\n");
            } else if (event.getSlot() == 7) {
                player.sendMessage("diamond5");
                player.closeInventory();
                player.setMetadata("EnterNumber", new FixedMetadataValue(KelsiCasino.getInstance(), "/roll"));
                player.sendMessage("\nВведите вашу ставку!\n");
            }
        }

    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();

        if (player.hasMetadata("OpenedMenu")) {
            player.removeMetadata("OpenedMenu", KelsiCasino.getInstance());
        }
    }

}
