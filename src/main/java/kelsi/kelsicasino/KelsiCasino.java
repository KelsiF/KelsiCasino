package kelsi.kelsicasino;

import kelsi.kelsicasino.commands.rollCommand;
import kelsi.kelsicasino.listeners.guiListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class KelsiCasino extends JavaPlugin implements Listener {

    private static KelsiCasino instance;
    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new guiListener(), this);
        getCommand("roll").setExecutor(new rollCommand());

        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    
    public static KelsiCasino getInstance() {
        return instance;
    }
}
