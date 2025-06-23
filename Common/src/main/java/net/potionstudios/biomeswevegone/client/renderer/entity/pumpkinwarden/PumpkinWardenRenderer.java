package net.potionstudios.biomeswevegone.client.renderer.entity.pumpkinwarden;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.item.ItemDisplayContext;
import net.potionstudios.biomeswevegone.world.entity.pumpkinwarden.PumpkinWarden;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

/**
 * Pumpkin Warden Entity Renderer
 * @see GeoEntityRenderer
 * @author YaBoiChips
 */
public class PumpkinWardenRenderer extends GeoEntityRenderer<PumpkinWarden, PumpkinWardenRenderState> {
    public PumpkinWardenRenderer(EntityRendererProvider.Context context) {
        super(context, new PumpkinWardenModel<>());
    }

    @Override
    public void preRender(PumpkinWardenRenderState renderState, PoseStack poseStack, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, int packedLight, int packedOverlay, int renderColor) {
        poseStack.scale(0.5f, 0.5f, 0.5f);
        super.preRender(renderState, poseStack, model, bufferSource, buffer, isReRender, packedLight, packedOverlay, renderColor);
    }

    @Override
    public void renderRecursively(PumpkinWardenRenderState renderState, PoseStack poseStack, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, int packedLight, int packedOverlay, int renderColor) {
        if (bone.getName().equals("RightArm")) {
            poseStack.pushPose();
            poseStack.mulPose(Axis.XP.rotationDegrees(15));
            poseStack.mulPose(Axis.YP.rotationDegrees(0));
            poseStack.mulPose(Axis.ZP.rotationDegrees(3.5f));
            poseStack.translate(0.05D, 0.2D, -1D);
            poseStack.scale(2f, 2f, 2f);
            Minecraft.getInstance().getItemRenderer().renderStatic(renderState.itemStack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, packedOverlay, poseStack, bufferSource, Minecraft.getInstance().level, 1);
            poseStack.popPose();
            buffer = bufferSource.getBuffer(RenderType.entityTranslucent(getTextureLocation(renderState)));
        }
        super.renderRecursively(renderState, poseStack, bone, renderType, bufferSource, buffer, isReRender, packedLight, packedOverlay, renderColor);
    }

    @Override
    protected float getShadowRadius(@NotNull PumpkinWardenRenderState renderState) {
        return renderState.hiding ? 0.0f : 0.6f;
    }

    @Override
    public void extractRenderState(@NotNull PumpkinWarden entity, @NotNull PumpkinWardenRenderState entityRenderState, float partialTick) {
        super.extractRenderState(entity, entityRenderState, partialTick);
        entityRenderState.variant = entity.getVariant();
        entityRenderState.hiding = entity.isHiding();
        entityRenderState.itemStack = entity.getMainHandItem();
    }
}
