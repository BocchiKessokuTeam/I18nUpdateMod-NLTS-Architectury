package com.github.tartaricacid.i18nupdatemod;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

public class I18nUpdateModExpectPlatform {
    @ExpectPlatform
    public static Path getConfigDirectory() {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }
    @ExpectPlatform
    public static String isDownloadLink(){
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }
    @ExpectPlatform
    public static String isMD5Name(){
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }
    @ExpectPlatform
    public static String isPackName(){
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }
}
