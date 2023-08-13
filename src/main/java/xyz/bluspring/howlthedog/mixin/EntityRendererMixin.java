package xyz.bluspring.howlthedog.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import xyz.bluspring.howlthedog.HowlTheDog;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin<T extends Entity> {
    @ModifyArgs(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/EntityRenderer;renderNameTag(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/network/chat/Component;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"))
    public void howl$renderOtherName(Args args) {
        var entity = (T) args.get(0);
        var text = (Component) args.get(1);

        if (entity.getType() == EntityType.WOLF && text.getString().equalsIgnoreCase(HowlTheDog.NAME)) {
            args.set(1, Component.literal(HowlTheDog.DISPLAY_NAME));
        }
    }

    @ModifyArgs(method = "renderNameTag", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(DDD)V"))
    public void howl$renderNametagHigher(Args args, T entity, Component component, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        if (entity.getType() == EntityType.WOLF && entity.getDisplayName().getString().equalsIgnoreCase(HowlTheDog.NAME)) {
            args.set(1, (double) args.get(1) + 0.75D);
        }
    }
}
