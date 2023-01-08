package com.github.tartaricacid.i18nupdatemod;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MinecraftOptionsUtils {
    private static final String DEFAULT_LANG = "lang:zh_cn";
    private static final String INIT_OPTIONS = DEFAULT_LANG;


    public static void createInitFile(File optionsFile) throws IOException {
        if (!optionsFile.exists()) {
            FileUtils.write(optionsFile, INIT_OPTIONS, StandardCharsets.UTF_8);
        }
    }

    public static void changeFile(File optionsFile) throws IOException {
        List<String> options = FileUtils.readLines(optionsFile, StandardCharsets.UTF_8);
        List<String> output = Lists.newArrayList();
        boolean hasLang = false;

        for (String line : options) {
            if (line.startsWith("lang:")) {
                line = DEFAULT_LANG;
                hasLang = true;
            }
            output.add(line);
        }

        if (!hasLang) {
            output.add(DEFAULT_LANG);
        }

        FileUtils.writeLines(optionsFile, StandardCharsets.UTF_8.name(), output, "\n");
    }
}
