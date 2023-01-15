package com.github.tartaricacid.i18nupdatemod.fabric;

import com.github.tartaricacid.i18nupdatemod.I18nUpdateMod;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class I18nUpdateModFabric implements ModInitializer {
    public I18nModConfigFabric I18NCONFIGFABRIC;
    public static final String DOWNLOADLINK = I18nModConfigFabric.downloadLink + "/";
    public static final String TRANSPACKFILENAME = I18nModConfigFabric.resourcePackName + ".zip";
    public static final String MD5FILENAME = I18nModConfigFabric.md5Name + ".md5";
    @Override
    public void onInitialize() {
        I18NCONFIGFABRIC = AutoConfig.register(I18nModConfigFabric.class, Toml4jConfigSerializer::new).getConfig();
        I18nUpdateMod.init();
    }
}
