package kelsi.kelsicasino.commands;


import kelsi.kelsicasino.KelsiCasino;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import kelsi.kelsicasino.guis.rollGui;
import org.bukkit.metadata.FixedMetadataValue;
import static kelsi.kelsicasino.guis.rollGui.inventory;

public class rollCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        rollGui.createItems();

        if (sender instanceof Player) {
            Player player = (Player) sender;

            rollGui.setItems();
            player.openInventory(inventory);
            player.setMetadata("OpenedMenu", new FixedMetadataValue(KelsiCasino.getInstance(),"/roll"));

            return true;

        } else {
            sender.sendMessage(ChatColor.RED + "Использовать эту команду можно только в игре!");

            return true;
        }

    }
}
