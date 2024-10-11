package me.pixel;

import com.mojang.datafixers.types.templates.Check;
import com.mojang.logging.LogUtils;
import me.pixel.commands.*;
import me.pixel.modules.*;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Command;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;

public class Pixel extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("Pixel");
    public static final HudGroup HUD_GROUP = new HudGroup("Pixel");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Meteor Pixel Addon");

        // Modules
        Modules.get().add(new AntiSpawnpoint());
        Modules.get().add(new AutoChunkBan());
        Modules.get().add(new AutoGold());
        Modules.get().add(new AutoSnowball());
        Modules.get().add(new AutoTrade());
        Modules.get().add(new GhostMode());
        Modules.get().add(new Girlboss());
        Modules.get().add(new Groupmessage());
        Modules.get().add(new MinecartAura());
        Modules.get().add(new MinecartSpeed());
        Modules.get().add(new MinecartAura());
        Modules.get().add(new NoSwing());
        Modules.get().add(new PacketLogger());
        Modules.get().add(new SitModule());
        Modules.get().add(new WorldGuardBypass());
        Modules.get().add(new TanukiEgapFinder());
        Modules.get().add(new LogOutSpots());


        // Commands
        Commands.add((new CheckCMD()));
        Commands.add((new ClearInventoryCommand()));
        Commands.add((new Crash()));
        Commands.add((new Ping()));
        Commands.add((new ReloadCapes()));
        Commands.add((new Title()));
        Commands.add((new TrashCommand()));
        Commands.add((new Tts()));

        // HUD
        //Hud.get().register(HudExample.INFO);
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "me.pixel";
    }
}
