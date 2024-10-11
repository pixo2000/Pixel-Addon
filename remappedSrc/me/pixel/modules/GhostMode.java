/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package me.pixel.modules;
import me.pixel.Pixel;
import meteordevelopment.meteorclient.events.game.OpenScreenEvent;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.gui.screen.DeathScreen;

public class GhostMode extends Module {

    public GhostMode() {
        super(Pixel.CATEGORY, "ghost-mode", "Explore the world after dying.");
    }

    @Override
    public void onDeactivate() {
        mc.player.requestRespawn();
        info("Respawn request has been sent to the server.");
    }

    @EventHandler
    private void onTick(TickEvent.Pre event) {
        if (mc.player.getHealth() <= 0) {
            mc.player.setHealth(20f);
            mc.player.getHungerManager().setFoodLevel(20);
        }
    }

    @EventHandler
    private void onOpenScreen(OpenScreenEvent event) {
        if (event.screen instanceof DeathScreen) {
            event.cancel();

            info("Ghost mode active. ");
        }
    }
}
