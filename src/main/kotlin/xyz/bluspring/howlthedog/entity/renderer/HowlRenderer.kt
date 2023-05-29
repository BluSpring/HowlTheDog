package xyz.bluspring.howlthedog.entity.renderer

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
}