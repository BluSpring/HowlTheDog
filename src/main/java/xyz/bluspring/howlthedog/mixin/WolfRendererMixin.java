package xyz.bluspring.howlthedog.mixin;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WolfRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WolfRenderer.class)
public class WolfRendererMixin {


    @Inject(method = "<init>", at = @At("TAIL"))
    public void addDeferredRenderer(EntityRendererProvider.Context context, CallbackInfo ci) {

    }
}
