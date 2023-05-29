package xyz.bluspring.howlthedog.entity.renderer

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.client.renderer.entity.MobRenderer
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.animal.Wolf
import xyz.bluspring.howlthedog.client.HowlTheDogClient
import xyz.bluspring.howlthedog.entity.model.HowlModel

class HowlRenderer(context: EntityRendererProvider.Context) : MobRenderer<Wolf, HowlModel<Wolf>>(context, HowlModel(context.bakeLayer(HowlTheDogClient.HOWL_LAYER)), 0.5F) {
    override fun getTextureLocation(entity: Wolf): ResourceLocation {
        return ResourceLocation("howlthedog", "textures/entity/howl.png")
    }

    override fun render(wolf: Wolf, f: Float, g: Float, poseStack: PoseStack, multiBufferSource: MultiBufferSource, i: Int) {
        if (wolf.isWet) {
            val h = wolf.getWetShade(g)
            this.model.setColor(h, h, h)
        }
        super.render(wolf, f, g, poseStack, multiBufferSource, i)
        if (wolf.isWet) {
            this.model.setColor(1F, 1F, 1F)
        }
    }
}