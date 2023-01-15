package com.github.tartaricacid.i18nupdatemod.fabric;

import com.github.tartaricacid.i18nupdatemod.I18nUpdateMod;
import com.github.tartaricacid.i18nupdatemod.I18nUpdateModExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class I18nUpdateModExpectPlatformImpl {
    /**
     * This is our actual method to {@link I18nUpdateModExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
    public static String isDownloadLink(){
        return I18nUpdateModFabric.DOWNLOADLINK;
    }
    public static String isMD5Name() {
        return I18nUpdateModFabric.MD5FILENAME;
    }
    public static String isPackName() {
        return I18nUpdateModFabric.TRANSPACKFILENAME;
    }
}
