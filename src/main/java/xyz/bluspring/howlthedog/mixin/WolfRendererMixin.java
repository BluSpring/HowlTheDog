package xyz.bluspring.howlthedog.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Wolf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.bluspring.howlthedog.entity.renderer.HowlRenderer;

@Mixin(WolfRenderer.class)
public class WolfRendererMixin {
    private HowlRenderer howlRenderer;

    @Inject(method = "<init>", at = @At("TAIL"))
    public void addDeferredRenderer(EntityRendererProvider.Context context, CallbackInfo ci) {
        this.howlRenderer = new HowlRenderer(context);
    }

    @Inject(method = "render(Lnet/minecraft/world/entity/animal/Wolf;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At("HEAD"), cancellable = true)
    public void deferRenderIfNeeded(Wolf wolf, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, CallbackInfo ci) {
        if (wolf.hasCustomName() && wolf.getCustomName().getString().equalsIgnoreCase("howl")) {
            ci.cancel();
            this.howlRenderer.render(wolf, f, g, poseStack, multiBufferSource, i);
        }
    }

    @Inject(method = "getTextureLocation(Lnet/minecraft/world/entity/animal/Wolf;)Lnet/minecraft/resources/ResourceLocation;", at = @At("HEAD"), cancellable = true)
    public void deferTextureLocationIfNeeded(Wolf wolf, CallbackInfoReturnable<ResourceLocation> cir) {
        if (wolf.hasCustomName() && wolf.getCustomName().getString().equalsIgnoreCase("howl")) {
            cir.setReturnValue(this.howlRenderer.getTextureLocation(wolf));
        }
    }
}
