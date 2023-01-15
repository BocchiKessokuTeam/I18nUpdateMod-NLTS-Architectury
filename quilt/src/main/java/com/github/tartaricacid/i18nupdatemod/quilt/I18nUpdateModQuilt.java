package com.github.tartaricacid.i18nupdatemod.quilt;

import com.github.tartaricacid.i18nupdatemod.I18nUpdateMod;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class I18nUpdateModQuilt implements ModInitializer {
    public I18nModConfigQuilt I18NCONFIGQUILT;
    public static final String DOWNLOADLINK = I18nModConfigQuilt.downloadLink + "/";
    public static final String TRANSPACKFILENAME = I18nModConfigQuilt.resourcePackName + ".zip";
    public static final String MD5FILENAME = I18nModConfigQuilt.md5Name + ".md5";
    @Override
    public void onInitialize(ModContainer mod) {
        I18NCONFIGQUILT = AutoConfig.register(I18nModConfigQuilt.class, Toml4jConfigSerializer::new).getConfig();
        I18nUpdateMod.init();
    }
}
