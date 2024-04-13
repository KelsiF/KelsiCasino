package kelsi.kelsicasino.commands;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import kelsi.kelsicasino.guis.rollGui;

public class rollCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        rollGui.createItems();

        if (sender instanceof Player) {
            Player player = (Player) sender;

            rollGui.setItems();
            player.openInventory(rollGui.inventory);

            return true;

        } else {
            sender.sendMessage(ChatColor.RED + "Использовать эту команду можно только в игре!");

            return true;
        }

    }
}
