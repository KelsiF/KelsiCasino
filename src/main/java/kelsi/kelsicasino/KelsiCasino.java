package kelsi.kelsicasino;

import kelsi.kelsicasino.commands.rollCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class KelsiCasino extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("roll").setExecutor(new rollCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
