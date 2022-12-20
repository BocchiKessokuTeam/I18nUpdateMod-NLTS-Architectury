/*
Credits:https://github.com/RPMTW/RPMTW-Platform-Mod/tree/1.17-deprecated
*/

package com.github.tartaricacid.i18nupdatemod.fabric.mixin;

import com.github.tartaricacid.i18nupdatemod.I18nUpdateMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vazkii.patchouli.client.book.BookContentExternalLoader;
import vazkii.patchouli.common.book.Book;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;

@Mixin(BookContentExternalLoader.class)
public class MixinContentExternalLoader {
    @Inject(at = @At("HEAD"), method = "loadJson", cancellable = true, remap = false)
    private void loadJson(Book book, Identifier resloc, @Nullable Identifier fallback, CallbackInfoReturnable<InputStream> cir) {
        I18nUpdateMod.LOGGER.debug("loading json from {}.", resloc);
        try {
            cir.setReturnValue(MinecraftClient.getInstance().getResourceManager().getResource(resloc).getInputStream());
        } catch (IOException e) {
            //no-op
        }
    }
}
