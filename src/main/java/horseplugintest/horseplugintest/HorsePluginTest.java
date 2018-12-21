package horseplugintest.horseplugintest;

import com.github.zedd7.zhorse.ZHorse;
import horseplugintest.horseplugintest.Commands.Commands;
import horseplugintest.horseplugintest.Events.PlayerInteractEvent;
import org.bukkit.Bukkit;
import org.bukkit.inventory.HorseInventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class HorsePluginTest extends JavaPlugin {

    static HorsePluginTest plugin;
    private static final ZHorse zHorse = (ZHorse) Arrays.stream(Bukkit.getServer().getPluginManager().getPlugins()).filter(p -> p.getName().equalsIgnoreCase("ZHorse")).findFirst().orElse(null);
    public static ZHorse returnHorse() {
        return zHorse;
    }

    public HorsePluginTest() {
        plugin = this;
    }

    public static HorsePluginTest getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        getCommand("HorseInventory").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new PlayerInteractEvent(), this);
    }

}
