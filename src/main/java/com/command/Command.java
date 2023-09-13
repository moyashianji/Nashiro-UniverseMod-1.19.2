package com.command;

import com.Systems.ReplaceDiamond;
import com.Systems.entity.VillegerEntity;
import com.Systems.init.OriginalmodelModEntities;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.EntitySummonArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.loading.targets.FMLServerLaunchHandler;
import org.intellij.lang.annotations.Identifier;

import java.util.logging.Level;

import static com.main.reference.diamondflag;
import static com.main.reference.invisibleflag;

public class Command {

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        LiteralArgumentBuilder<CommandSourceStack> command = Commands.literal("nashiro")
                .then(Commands.literal("summon")
                        .then(Commands.literal("villager")
                                .executes(context -> spawnZombies(context.getSource()))
                        )
                )
                .then(Commands.literal("i")
                        .then(Commands.literal("t")
                                .executes(context -> trueinvisible(context.getSource()))
                        )
                        .then(Commands.literal("f")
                                .executes(context -> falseinvisible(context.getSource()))
                        )
                )
                .then(Commands.literal("diamond")
                        .then(Commands.literal("true")
                                .executes(context -> truediamond(context.getSource()))
                        )
                        .then(Commands.literal("false")
                                .executes(context -> falsediamond(context.getSource()))
                        )


                );



        dispatcher.register(command);
    }

    private static int truediamond(CommandSourceStack source) {
        if(diamondflag == true){
            System.out.println("Already TRUE");
        }else{
            diamondflag = true;
        }
        // Start your stopwatch logic here
        return 0;
    }

    private static int falsediamond(CommandSourceStack source) {
        if(diamondflag == false){
            System.out.println("Already FALSE");
        }else{
            diamondflag = false;
        }        // Pause your stopwatch logic here
        return 0;
    }
    private static int spawnZombies(CommandSourceStack source) {
        ServerLevel world = source.getLevel();
        Player player = source.getPlayer();
        for (int i = 0; i < 4; i++) {

            VillegerEntity entity = new VillegerEntity(OriginalmodelModEntities.VILLEGER,world);
            entity.setPos(player.getX()+i,player.getY()+i,player.getZ()+i);
            world.addFreshEntity(entity);


        }
        return 1;
    }
    private static int trueinvisible(CommandSourceStack source) {
        if(invisibleflag == true){
            System.out.println("Already TRUE");
        }else{
            invisibleflag = true;
            source.getPlayer().setInvisible(true);
        }
        // Start your stopwatch logic here
        return 0;
    }

    private static int falseinvisible(CommandSourceStack source) {
        if(invisibleflag == false){
            System.out.println("Already FALSE");
        }else{
            invisibleflag = false;
            source.getPlayer().setInvisible(false);

        }        // Pause your stopwatch logic here
        return 0;
    }
        public static void register() {
        MinecraftForge.EVENT_BUS.register(Command.class);
    }

}