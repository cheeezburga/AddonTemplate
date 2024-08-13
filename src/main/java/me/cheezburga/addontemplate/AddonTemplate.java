package me.cheezburga.addontemplate;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import me.cheezburga.addontemplate.api.utils.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

@SuppressWarnings("deprecation")
public final class AddonTemplate extends JavaPlugin {

    private static AddonTemplate instance;
    private SkriptAddon skriptAddon;

    @Override
    public void onEnable() {
        instance = this;

        try {
            // Trying to register the addon and load the syntax elements
            skriptAddon = Skript.registerAddon(this).setLanguageFileDirectory("lang");
            skriptAddon.loadClasses("me.cheezburga.addontemplate.elements");
        } catch (IOException e) {
            // Throw an error if any of that fails
            throw new RuntimeException("Failed to load AddonTemplate: " + e.getMessage());
        }

        loadMetrics(); // Load bStats metrics
        checkUpdate(getDescription().getVersion()); // Check for updates
    }

    private void loadMetrics() {
        Metrics metrics = new Metrics(this, 12345); // TODO: Replace this with your bStats service ID
        metrics.addCustomChart(new Metrics.SimplePie("skriptVersion", () -> Skript.getVersion().toString()));
    }

    private void checkUpdate(String version) {
        UpdateChecker.checkForUpdate(version);
    }

    public static AddonTemplate getInstance() {
        return instance;
    }

    public SkriptAddon getAddonInstance() {
        return skriptAddon;
    }

}
