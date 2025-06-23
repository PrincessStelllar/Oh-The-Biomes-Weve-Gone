package net.potionstudios.biomeswevegone.client.renderer.entity.oddion;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.potionstudios.biomeswevegone.world.entity.oddion.Oddion;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


/**
 * Oddion Entity Renderer
 * @see GeoEntityRenderer
 * @author YaBoiChips
 */
public class OddionRenderer extends GeoEntityRenderer<Oddion, OddionRenderState> {

    public OddionRenderer(EntityRendererProvider.Context context) {
        super(context, new OddionModel());
    }

    @Override
    protected float getShadowRadius(@NotNull OddionRenderState renderState) {
        return 0.4F;
    }
}
