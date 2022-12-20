package com.github.tartaricacid.i18nupdatemod.forge;

import com.github.tartaricacid.i18nupdatemod.I18nUpdateMod;
import com.github.tartaricacid.i18nupdatemod.I18nUpdateModExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class I18nUpdateModExpectPlatformImpl {
    /**
     * This is our actual method to {@link I18nUpdateModExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
    public static String isDownloadLink() {
        return "http://downloader1.meitangdehulu.com:22943/Minecraft-Mod-Language-Modpack-1-16.zip";
    }
    public static String isMD5Link() {
        return "http://downloader1.meitangdehulu.com:22943/1.16.md5";
    }
    public static Path isMD5Path() {
        return I18nUpdateMod.CACHE_DIR.resolve("1.16.md5");
    }
    public static String isPackName() {
        return "Minecraft-Mod-Language-Modpack-1-16.zip";
    }
}
