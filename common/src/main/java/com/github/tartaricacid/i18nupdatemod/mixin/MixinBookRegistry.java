/*
Credit: https://github.com/StarskyXIII/PRP-Fabric
*/
package com.github.tartaricacid.i18nupdatemod.mixin;

import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.patchouli.client.book.ClientBookRegistry;
import vazkii.patchouli.common.base.PatchouliConfig;
import vazkii.patchouli.common.book.Book;
import vazkii.patchouli.common.book.BookRegistry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Mixin(value = {BookRegistry.class}, remap = false)
public class MixinBookRegistry {
    @Final
    @Shadow
    public final Map<Identifier, Book> books = new HashMap<>();
    @Shadow
    private boolean loaded = false;

    public MixinBookRegistry() {
    }

    @Inject(method = {"reloadContents"}, at = {@At("HEAD")}, cancellable = true)
    public void reloadContents(boolean resourcePackBooksOnly, CallbackInfo ci) {
        PatchouliConfig.reloadBuiltinFlags();
        Iterator var3 = this.books.values().iterator();

        while(var3.hasNext()) {
            Book book = (Book)var3.next();
            book.reloadContents(false);
        }

        ClientBookRegistry.INSTANCE.reloadLocks(false);
        this.loaded = true;
        ci.cancel();
    }
}
