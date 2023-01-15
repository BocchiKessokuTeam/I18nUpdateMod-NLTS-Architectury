package com.github.tartaricacid.i18nupdatemod.forge;

import me.shedaniel.architectury.platform.forge.EventBuses;
import com.github.tartaricacid.i18nupdatemod.I18nUpdateMod;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(I18nUpdateMod.MOD_ID)
public class I18nUpdateModForge {
    public I18nModConfigForge I18NCONFIGFORGE;
    public static final String DOWNLOADLINK = I18nModConfigForge.downloadLink + "/";
    public static final String TRANSPACKFILENAME = I18nModConfigForge.resourcePackName + ".zip";
    public static final String MD5FILENAME = I18nModConfigForge.md5Name + ".md5";
    public I18nUpdateModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(I18nUpdateMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onInitializeClient);
        I18nUpdateMod.init();
    }
    private void onInitializeClient(final FMLClientSetupEvent event) {
        I18NCONFIGFORGE = AutoConfig.register(I18nModConfigForge.class, Toml4jConfigSerializer::new).getConfig();
    }
}
