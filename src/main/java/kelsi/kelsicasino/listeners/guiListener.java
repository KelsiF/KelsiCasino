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

import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;

public class guiListener implements Listener {

    ConcurrentHashMap<Player, Integer> playerSlotNumberMap = new ConcurrentHashMap<>();
    Random random = new Random();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        int randomNumber = random.nextInt(100) + 1;

        if (player.hasMetadata("EnterNumber")) {
            int number = Integer.parseInt(event.getMessage());
            event.setCancelled(true);

            Integer slot = playerSlotNumberMap.get(player);
            if (slot != null && slot >= 1 && slot <= 7) {
                double[] multipliers = {1.1, 1.5, 1.75, 2, 3, 3.5, 5};
                int[] chances = {95, 80, 75, 50, 25, 10, 1};

                if (randomNumber <= chances[slot - 1]) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " " + Math.round(number * multipliers[slot - 1]));
                } else {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco take " + player.getName() + " " + number);
                }
                Bukkit.getLogger().info(String.format("num: %d", randomNumber));
            }

            player.removeMetadata("EnterNumber", KelsiCasino.getInstance());
            playerSlotNumberMap.remove(player);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (player.hasMetadata("OpenedMenu")) {
            event.setCancelled(true);

            String[] items = {"stone", "iron", "gold", "redstone", "diamond", "diamond3", "diamond5"};
            if (event.getSlot() >= 1 && event.getSlot() <= 7) {
                String item = items[event.getSlot() - 1];
                player.sendMessage(item);
                player.closeInventory();
                player.setMetadata("EnterNumber", new FixedMetadataValue(KelsiCasino.getInstance(), "/roll"));
                player.sendMessage("\nВведите вашу ставку!\n");
                playerSlotNumberMap.put(player, event.getSlot());
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