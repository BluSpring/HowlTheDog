package xyz.bluspring.howlthedog.entity.renderer.layers

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.entity.RenderLayerParent
import net.minecraft.client.renderer.entity.layers.RenderLayer
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.animal.Wolf
import xyz.bluspring.howlthedog.entity.model.HowlModel

class HowlCollarLayer(renderLayerParent: RenderLayerParent<Wolf, HowlModel<Wolf>>) : RenderLayer<Wolf, HowlModel<Wolf>>(renderLayerParent) {
    override fun render(poseStack: PoseStack, multiBufferSource: MultiBufferSource, i: Int, wolf: Wolf,
        f: Float, g: Float, h: Float,
        j: Float, k: Float, l: Float
    ) {
        if (wolf.isTame && !wolf.isInvisible) {
            val fs: FloatArray = wolf.collarColor.textureDiffuseColors
            renderColoredCutoutModel(
                this.parentModel, WOLF_COLLAR_LOCATION, poseStack, multiBufferSource, i, wolf,
                fs[0],
                fs[1],
                fs[2]
            )
        }
    }

    companion object {
        private val WOLF_COLLAR_LOCATION = ResourceLocation("howlthedog", "textures/entity/howl_collar.png")
    }
}