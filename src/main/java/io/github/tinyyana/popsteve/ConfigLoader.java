package io.github.tinyyana.popsteve;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigLoader {
    private File file;
    private FileConfiguration configuration;

    private final String fileName;
    private final PluginMain plugin = PluginMain.getPlugin();

    public ConfigLoader (String fileName) {
        this.fileName = fileName;
        this.load();
    }

    public void load () {
        this.file = new File(plugin.getDataFolder().getPath(), File.separator + this.fileName + ".yml");
        this.configuration = new YamlConfiguration();

        if (! file.exists()) {
            try {
                plugin.saveResource(this.fileName + ".yml", false);
            }
            catch (IllegalArgumentException e) {
                System.out.println("檔案取得失敗:[" + this.fileName + ".yml]");
            }
        }

        try {
            this.configuration = YamlConfiguration.loadConfiguration(this.file);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("檔案加載失敗:[" + this.fileName + ".yml]");
        }
    }

    public boolean save () {
        try {
            this.configuration.save(file);
        }
        catch (Exception e) {
            System.out.println("檔案儲存失敗:[ " + this.fileName + ".yml]");
            return false;
        }
        return true;
    }

    public FileConfiguration get () {
        return this.configuration;
    }
}
