package net.potionstudios.biomeswevegone.client.renderer.entity.pumpkinwarden;

import net.minecraft.resources.ResourceLocation;
import net.potionstudios.biomeswevegone.BiomesWeveGone;
import net.potionstudios.biomeswevegone.world.entity.pumpkinwarden.PumpkinWarden;
import software.bernie.geckolib.animatable.processing.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * Pumpkin Warden Model
 * @see GeoModel
 * @author YaBoiChips
 */
class PumpkinWardenModel<T extends PumpkinWarden> extends GeoModel<T> {

    @Override
    public ResourceLocation getModelResource(GeoRenderState renderState) {
        return BiomesWeveGone.id("geo/pumpkinwarden.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeoRenderState renderState) {
        PumpkinWardenRenderState pumpkinWardenRenderState = ((PumpkinWardenRenderState) renderState);
        return pumpkinWardenRenderState.hiding ? BiomesWeveGone.id("textures/entity/pumpkin_warden/" + pumpkinWardenRenderState.variant.getName() + "_hiding.png") : BiomesWeveGone.id("textures/entity/pumpkin_warden/" + pumpkinWardenRenderState.variant.getName() + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(T pumpkinWarden) {
        return BiomesWeveGone.id("animations/pumpkinwarden.animation.json");
    }

    @Override
    public void setCustomAnimations(AnimationState<T> animationState) {
        super.setCustomAnimations(animationState);
        GeoBone head = this.getAnimationProcessor().getBone("Head");
        //EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);
        //head.setPivotX(extraData.headPitch() * ((float) Math.PI / 180F));
        //head.setPivotY(extraData.netHeadYaw() * ((float) Math.PI / 180F));
    }
}