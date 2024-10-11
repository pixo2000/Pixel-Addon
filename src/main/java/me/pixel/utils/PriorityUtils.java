package me.pixel.utils;

import me.pixel.modules.*;

/**
 * @author OLEPOSSU
 */

public class PriorityUtils {
    // Tell me a better way to do this pls
    public static int get(Object module) {
        if (module instanceof AutoPearl) return 6;

        return 100;
    }
}
