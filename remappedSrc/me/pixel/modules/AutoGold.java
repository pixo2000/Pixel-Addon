package me.pixel.modules;

import me.pixel.Pixel;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.IntSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import me.pixel.utils.Utils;

import static meteordevelopment.meteorclient.utils.player.InvUtils.findInHotbar;

public class AutoGold extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Integer> range = sgGeneral.add(new IntSetting.Builder()
            .name("range")
            .description("range to check for piglins")
            .defaultValue(56)
            .min(4)
            .sliderMax(60)
            .build());

    private final Setting<Boolean> onlyNether = sgGeneral.add(new BoolSetting.Builder()
            .name("only-nether")
            .description("for ohio")
            .defaultValue(false)
            .build());
    private final Setting<Integer> switchDelay = sgGeneral.add(new IntSetting.Builder()
            .name("switch-delay")
            .description("delay")
            .defaultValue(1)
            .range(1,5)
            .sliderMax(5)
            .build()
    );

    public int tick = 0;
    public AutoGold() {
        super(Pixel.CATEGORY, "Auto Gold", "Switches to gold armor or items when near piglins.");
    }


    @EventHandler
    private void onTick(TickEvent.Pre event) {
        tick++;
        for (Entity entity : mc.world.getEntities()) {
            if (entity.getType() == EntityType.PIGLIN && entity.getPos().isInRange(mc.player.getPos(), range.get())) {
                if (!Utils.goldArmor() && tick >= switchDelay.get()) {
                    tick = 0;
                    if (!findInHotbar(Items.GOLD_INGOT, Items.GOLD_BLOCK).isHotbar() && netherCheck()) {
                        Utils.switchToGold();
                    }
                    else {
                        Utils.switchToGold();
                    }
                }
            }
        }
    }


    private boolean netherCheck() {
        return !onlyNether.get() || Utils.isNether();
    }
}
