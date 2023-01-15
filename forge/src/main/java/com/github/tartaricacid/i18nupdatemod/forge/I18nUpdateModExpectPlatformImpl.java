package com.github.tartaricacid.i18nupdatemod.forge;

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
    public static String isDownloadLink(){
        return I18nUpdateModForge.DOWNLOADLINK;
    }
    public static String isMD5Name() {
        return I18nUpdateModForge.MD5FILENAME;
    }
    public static String isPackName() {
        return I18nUpdateModForge.TRANSPACKFILENAME;
    }
}
