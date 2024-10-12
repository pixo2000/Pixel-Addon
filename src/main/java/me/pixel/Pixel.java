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

    public static final Category PIXEL = new Category("PIXEL");
    public static final Category SETTINGS = new Category("Settings");
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("Pixel");
    public static final HudGroup HUD_GROUP = new HudGroup("Pixel");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Meteor Pixel Addon");

        // Modules
        Modules.get().add(new AutoDoors());
        Modules.get().add(new BookTools());
        Modules.get().add(new MineESP());
        Modules.get().add(new PagePirate());
        Modules.get().add(new BannerData());
        Modules.get().add(new RocketMan());
        Modules.get().add(new AxolotlTools());
        Modules.get().add(new TreasureESP());
        Modules.get().add(new Updraft());
//        Modules.get().add(new AutoPearl());


        // Commands
        Commands.add((new Tts()));
        Commands.add(new Panorama());

        // HUD
        //Hud.get().register(HudExample.INFO);
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
        Modules.registerCategory(SETTINGS);
    }

    @Override
    public String getPackage() {
        return "me.pixel";
    }
}
