package com.github.tartaricacid.i18nupdatemod;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.platform.Platform;

import java.nio.file.Path;

public class I18nUpdateModExpectPlatform {
    /**
     * We can use {@link Platform#getConfigFolder()} but this is just an example of {@link ExpectPlatform}.
     * <p>
     * This must be a <b>public static</b> method. The platform-implemented solution must be placed under a
     * platform sub-package, with its class suffixed with {@code Impl}.
     * <p>
     * Example:
     * Expect: com.github.tartaricacid.i18nupdatemod.I18nUpdateModExpectPlatform#getConfigDirectory()
     * Actual Fabric: com.github.tartaricacid.i18nupdatemod.fabric.I18nUpdateModExpectPlatformImpl#getConfigDirectory()
     * Actual Forge: com.github.tartaricacid.i18nupdatemod.forge.I18nUpdateModExpectPlatformImpl#getConfigDirectory()
     * <p>
     * <a href="https://plugins.jetbrains.com/plugin/16210-architectury">You should also get the IntelliJ plugin to help with @ExpectPlatform.</a>
     */
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
    public static String isMD5Link(){
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }
    @ExpectPlatform
    public static String isMD5Path(){
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }
    @ExpectPlatform
    public static String isPackName(){
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }
}
