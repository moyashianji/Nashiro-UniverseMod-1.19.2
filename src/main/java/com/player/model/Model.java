package com.player.model;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Model {
    @OnlyIn(Dist.CLIENT)
    public class SmallSlimeModel extends PlayerModel<AbstractClientPlayer> {
        private final ModelPart root;

        public SmallSlimeModel(ModelPart parent) {
            super(parent, false);
            this.root = parent;

        }

        public static LayerDefinition createHat() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();
            partdefinition.addOrReplaceChild("hat", CubeListBuilder.create()
                            .texOffs(32, 0)
                            .addBox(-4.0F, 17.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE),
                    PartPose.ZERO);
            return LayerDefinition.create(meshdefinition, 64, 32);
        }

        public static LayerDefinition createHead() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();
            partdefinition.addOrReplaceChild("cube", CubeListBuilder.create()
                    .texOffs(0, 16)
                    .addBox(-3.0F, 17.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.ZERO);
            partdefinition.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(32, 0).addBox(-3.25F, 18.0F, -3.5F, 2.0F, 2.0F, 2.0F), PartPose.ZERO);
            partdefinition.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(32, 4).addBox(1.25F, 18.0F, -3.5F, 2.0F, 2.0F, 2.0F), PartPose.ZERO);
            partdefinition.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(32, 8).addBox(0.0F, 21.0F, -3.5F, 1.0F, 1.0F, 1.0F), PartPose.ZERO);
            return LayerDefinition.create(meshdefinition, 64, 32);
        }

        public static LayerDefinition createBody() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();
            partdefinition.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 16.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);
            return LayerDefinition.create(meshdefinition, 64, 32);
        }

        public ModelPart root() {
            return this.root;
        }
    }
}
