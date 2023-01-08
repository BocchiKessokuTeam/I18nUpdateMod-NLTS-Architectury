package com.github.tartaricacid.i18nupdatemod;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class I18nUpdateMod {
    public static final String MOD_ID = "i18nupdatemod";
    public static final Path CACHE_DIR = Paths.get(System.getProperty("user.home"), "." + MOD_ID, "1.18");
    public static final Path RESOURCE_FOLDER = Paths.get(MinecraftClient.getInstance().getResourcePackDir().toURI());
    public static final String LANG_PACK_FILE_NAME = I18nUpdateModExpectPlatform.isPackName();
    public static final Path LOCAL_LANGUAGE_PACK = RESOURCE_FOLDER.resolve(LANG_PACK_FILE_NAME);
    public static final Path LANGUAGE_PACK = CACHE_DIR.resolve(LANG_PACK_FILE_NAME);
    public static final Path LANGUAGE_MD5 = I18nUpdateModExpectPlatform.isMD5Path();
    public static final String LINK = I18nUpdateModExpectPlatform.isDownloadLink();
    public static final String MD5 = I18nUpdateModExpectPlatform.isMD5Link();
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static String MD5String = "";
    //public static final Path OPTIONS_FILE = Paths.get(MinecraftClient.getInstance().runDirectory.toString(), "options.txt");

    public static void init() {
        
        //System.out.println(I18nUpdateModExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());

        MinecraftClient.getInstance().options.language="zh_cn";

        // 检查主资源包目录是否存在
        if (!Files.isDirectory(CACHE_DIR)) {
            try {
                Files.createDirectories(CACHE_DIR);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        // 检查游戏下资源包目录
        if (!Files.isDirectory(RESOURCE_FOLDER)) {
            try {
                Files.createDirectories(RESOURCE_FOLDER);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        // 尝试加载 MD5 文件
        try {
            FileUtils.copyURLToFile(new URL(MD5), LANGUAGE_MD5.toFile());
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Download MD5 failed.");
            setResourcesRepository();
            return;
        }
        try {
            StringBuilder stringBuffer = new StringBuilder();
            List<String> lines = Files.readAllLines(LANGUAGE_MD5);
            for (String line : lines) {
                stringBuffer.append(line);
                MD5String = stringBuffer.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            setResourcesRepository();
            return;
        }

        if (Files.exists(LANGUAGE_PACK)) {
            String md5;

            try {
                InputStream stream = Files.newInputStream(LANGUAGE_PACK);
                md5 = DigestUtils.md5Hex(stream).toUpperCase();
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.error("Error when compute md5.");
                setResourcesRepository();
                return;
            }

            try {
                if (!md5.equals(MD5String)) {
                    // TODO：已在 log 输出提示，但是否加入弹窗提示？
                    LOGGER.info("Downloading Chinese language Resource Pack.");
                    FileUtils.copyURLToFile(new URL(LINK), LANGUAGE_PACK.toFile());
                    InputStream stream = Files.newInputStream(LANGUAGE_PACK);
                    md5 = DigestUtils.md5Hex(stream).toUpperCase();
                    // 说明有可能下载损坏，就不要复制后加载了
                    if (!md5.equals(MD5String)) {
                        LOGGER.error("Error when compute md5.");
                        setResourcesRepository();
                        return;
                    }
                    if (Files.exists(LOCAL_LANGUAGE_PACK)) {
                        Files.delete(LOCAL_LANGUAGE_PACK);
                    }
                    Files.copy(LANGUAGE_PACK, LOCAL_LANGUAGE_PACK);
                }
            } catch (MalformedURLException e) {
                LOGGER.error("Download Chinese language Resource Pack failed.");
                e.printStackTrace();
                setResourcesRepository();
                return;
            } catch (IOException e) {
                LOGGER.error("Error when copy file.");
                e.printStackTrace();
                setResourcesRepository();
                return;
            }
        } else {
            try {
                FileUtils.copyURLToFile(new URL(LINK), LANGUAGE_PACK.toFile());
                Files.copy(LANGUAGE_PACK, LOCAL_LANGUAGE_PACK);
            } catch (IOException e) {
                LOGGER.error("Download Chinese language Resource Pack failed.");
                e.printStackTrace();
                return;
            }
        }

        if (!Files.exists(LOCAL_LANGUAGE_PACK)) {
            try {
                Files.copy(LANGUAGE_PACK, LOCAL_LANGUAGE_PACK);
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.error("Error when copy file.");
                return;
            }
        }

        if (Files.exists(LOCAL_LANGUAGE_PACK)) {
            try {
                String md5;
                try {
                    InputStream is = Files.newInputStream(LOCAL_LANGUAGE_PACK);
                    md5 = DigestUtils.md5Hex(is).toUpperCase();
                } catch (IOException e) {
                    e.printStackTrace();
                    LOGGER.error("Error when compute md5.");
                    return;
                }
                if (!md5.equals(MD5String)) {
                    Files.delete(LOCAL_LANGUAGE_PACK);
                    Files.copy(LANGUAGE_PACK, LOCAL_LANGUAGE_PACK);
                }
                setResourcesRepository();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void setResourcesRepository() {
        MinecraftClient mc = MinecraftClient.getInstance();
        GameOptions gameSettings = mc.options;
        // 在 gameSetting 中加载资源包
        if (!gameSettings.resourcePacks.contains(LANG_PACK_FILE_NAME)) {
            mc.options.resourcePacks.add(LANG_PACK_FILE_NAME);
        } else {
            List<String> packs = new ArrayList<>(10);
            // 资源包的 index 越小优先级越低（在资源包 GUI 中置于更低层）
            packs.add(LANG_PACK_FILE_NAME);
            packs.addAll(gameSettings.resourcePacks);
            gameSettings.resourcePacks = packs;
        }
        //并不需要在此重载资源包，因为构造mod在加载mod资源包之前，之后minecraft会自己重载资源包。
    }
}
