package net.potionstudios.biomeswevegone.client.renderer.entity.oddion;

import net.minecraft.resources.ResourceLocation;
import net.potionstudios.biomeswevegone.BiomesWeveGone;
import net.potionstudios.biomeswevegone.world.entity.oddion.Oddion;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * Oddion Model
 * @see GeoModel
 * @author YaBoiChips, Joseph T. McQuigg
 */
class OddionModel extends GeoModel<Oddion> {

    @Override
    public ResourceLocation getModelResource(GeoRenderState renderState) {
        return BiomesWeveGone.id("geo/oddion.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeoRenderState renderState) {
        OddionRenderState oddionRenderState = (OddionRenderState) renderState;
        return BiomesWeveGone.id("textures/entity/oddion/" + oddionRenderState.variant.getName() + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(Oddion animatable) {
        return BiomesWeveGone.id("animations/oddion.animation.json");
    }
}