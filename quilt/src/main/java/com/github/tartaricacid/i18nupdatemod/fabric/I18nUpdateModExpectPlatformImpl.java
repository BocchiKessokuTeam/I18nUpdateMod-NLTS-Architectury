package com.github.tartaricacid.i18nupdatemod.fabric;

import com.github.tartaricacid.i18nupdatemod.I18nUpdateModExpectPlatform;
import com.github.tartaricacid.i18nupdatemod.quilt.I18nUpdateModQuilt;
import org.quiltmc.loader.api.QuiltLoader;

import java.nio.file.Path;

public class I18nUpdateModExpectPlatformImpl {
    /**
     * This is our actual method to {@link I18nUpdateModExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return QuiltLoader.getConfigDir();
    }
    public static String isDownloadLink(){
        return I18nUpdateModQuilt.DOWNLOADLINK;
    }
    public static String isMD5Name() {
        return I18nUpdateModQuilt.MD5FILENAME;
    }
    public static String isPackName() {
        return I18nUpdateModQuilt.TRANSPACKFILENAME;
    }
}
