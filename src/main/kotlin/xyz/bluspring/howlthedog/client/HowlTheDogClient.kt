package xyz.bluspring.howlthedog.client

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.minecraft.client.model.geom.ModelLayerLocation
import net.minecraft.resources.ResourceLocation
import xyz.bluspring.howlthedog.entity.model.HowlModel

class HowlTheDogClient : ClientModInitializer {
    override fun onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(HOWL_LAYER) {
            HowlModel.createBodyLayer()
        }
    }

    companion object {
        val HOWL_LAYER = ModelLayerLocation(ResourceLocation("howlthedog", "howl"), "main")
    }
}