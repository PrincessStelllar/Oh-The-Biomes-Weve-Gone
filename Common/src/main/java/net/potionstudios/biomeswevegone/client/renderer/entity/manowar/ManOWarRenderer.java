package net.potionstudios.biomeswevegone.client.renderer.entity.manowar;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.potionstudios.biomeswevegone.world.entity.manowar.ManOWar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

/**
 * ManOWar Entity Renderer
 * @see GeoEntityRenderer
 * @author YaBoiChips
 */
public class ManOWarRenderer<T extends ManOWar> extends GeoEntityRenderer<T, ManOWarRenderState> {

    public ManOWarRenderer(EntityRendererProvider.Context context) {
        super(context, new ManOWarModel<>());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    @Override
    public void preRender(ManOWarRenderState renderState, PoseStack poseStack, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, int packedLight, int packedOverlay, int renderColor) {
        if (renderState.baby) poseStack.scale(0.5f, 0.5f, 0.5f);
        super.preRender(renderState, poseStack, model, bufferSource, buffer, isReRender, packedLight, packedOverlay, renderColor);
    }

    @Override
    protected void applyRotations(ManOWarRenderState renderState, PoseStack poseStack, float nativeScale) {
        super.applyRotations(renderState, poseStack, nativeScale);
    }
/*
    @Override
    protected void applyRotations(T animatable, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick, float nativeScale) {
        float i = Mth.lerp(partialTick, animatable.xBodyRotO, animatable.xBodyRot);
        float j = Mth.lerp(partialTick, animatable.zBodyRotO, animatable.zBodyRot);
        poseStack.translate(0.0D, 0.5D, 0.0D);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - rotationYaw));
        poseStack.mulPose(Axis.XP.rotationDegrees(i));
        poseStack.mulPose(Axis.YP.rotationDegrees(j));
        poseStack.translate(0.0D, -1.2000000476837158D, 0.0D);
    }*/

    @Override
    protected float getShadowRadius(@NotNull ManOWarRenderState renderState) {
        return renderState.baby ? 0.5f : 0.8f;
    }

    @Override
    public void extractRenderState(@NotNull T entity, @NotNull ManOWarRenderState entityRenderState, float partialTick) {
        super.extractRenderState(entity, entityRenderState, partialTick);
        entityRenderState.baby = entity.isBaby();
        entityRenderState.color = entity.getColor();
    }
}
