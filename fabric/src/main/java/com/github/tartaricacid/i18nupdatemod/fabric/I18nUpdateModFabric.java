package com.github.tartaricacid.i18nupdatemod.fabric;

import com.github.tartaricacid.i18nupdatemod.I18nUpdateMod;
import net.fabricmc.api.ModInitializer;

public class I18nUpdateModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        I18nUpdateMod.init();
    }
}
