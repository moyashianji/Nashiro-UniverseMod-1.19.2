
package com.Systems.client.renderer;

import com.Systems.entity.VillegerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;


import com.mojang.blaze3d.vertex.PoseStack;

public class VillegerRenderer extends MobRenderer<VillegerEntity, VillagerModel<VillegerEntity>> {
	public VillegerRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
		this.addLayer(new EyesLayer<VillegerEntity, VillagerModel<VillegerEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("nashiro:textures/entities/sssss.png"));
			}
		});
	}

	@Override
	protected void scale(VillegerEntity villager, PoseStack poseStack, float f) {
		poseStack.scale(0.9375f, 0.9375f, 0.9375f);
	}

	@Override
	public ResourceLocation getTextureLocation(VillegerEntity entity) {
		return new ResourceLocation("nashiro:textures/entities/sssss.png");
	}
}
