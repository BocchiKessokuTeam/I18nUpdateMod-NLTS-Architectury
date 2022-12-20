package com.github.tartaricacid.i18nupdatemod.forge;

import me.shedaniel.architectury.platform.forge.EventBuses;
import com.github.tartaricacid.i18nupdatemod.I18nUpdateMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(I18nUpdateMod.MOD_ID)
public class I18nUpdateModForge {
    public I18nUpdateModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(I18nUpdateMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        I18nUpdateMod.init();
    }
}
