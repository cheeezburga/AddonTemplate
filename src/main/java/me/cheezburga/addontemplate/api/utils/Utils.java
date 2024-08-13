package me.cheezburga.addontemplate.api.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

import java.util.regex.Matcher;

public class Utils {

    @SuppressWarnings("deprecation")
    public static final String PLUGIN_PREFIX = ChatColor.of("#00FFFF") + "[addon-template]" + ChatColor.RESET;
    private static final java.util.regex.Pattern HEX_PATTERN = java.util.regex.Pattern.compile("<#([A-Fa-f\\d]){6}>");
    private static final boolean SKRIPT_EXISTS = Bukkit.getPluginManager().getPlugin("Skript") != null;

    /**
     * Method to get a coloured string from a string.
     * <p>
     *     This method is copied from SkBee.
     *     <a href="https://github.com/ShaneBeee/SkBee/blob/f6f85e3d9d9da0cd772b58e59fc288f7d1ec21f8/src/main/java/com/shanebeestudios/skbee/api/util/Util.java#L35">getColString(string)</a>
     * </p>
     *
     * @author ShaneBee
     *
     * @param string The string to convert to it's coloured version.
     * @return The coloured string.
     */
    @SuppressWarnings("deprecation") // Paper deprecation
    public static String getColouredString(String string) {
        Matcher matcher = HEX_PATTERN.matcher(string);
        if (SKRIPT_EXISTS) {
            while (matcher.find()) {
                ChatColor hexColor = ChatColor.of(matcher.group().substring(1, matcher.group().length() - 1));
                String before = string.substring(0, matcher.start());
                String after = string.substring(matcher.end());
                string = before + hexColor + after;
                matcher = HEX_PATTERN.matcher(string);
            }
        } else {
            string = HEX_PATTERN.matcher(string).replaceAll("");
        }
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    /**
     * Method to log a coloured message to the console.
     * <p>
     *     This method is copied from SkBee.
     *     <a href="https://github.com/ShaneBeee/SkBee/blob/f6f85e3d9d9da0cd772b58e59fc288f7d1ec21f8/src/main/java/com/shanebeestudios/skbee/api/util/Util.java#L55">log(format, objects)</a>
     * </p>
     *
     * @author ShaneBee
     *
     * @param format The format for the log.
     * @param objects The arguments for the log.
     */
    public static void log(String format, Object... objects) {
        String log = String.format(format, objects);
        Bukkit.getConsoleSender().sendMessage(getColouredString(PLUGIN_PREFIX + " " + log));
    }

}
