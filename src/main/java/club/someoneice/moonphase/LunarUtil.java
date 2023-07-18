package club.someoneice.moonphase;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;

/**
 * Love from MoonlightWithWolf 's LunarUtil.java. But this is the world from Client not Server.
 **/
public class LunarUtil {
    public static WorldClient clientWorld() {
        return Minecraft.getMinecraft().theWorld;
    }

    public static boolean isNight() {
        return getTimes() > 13500 || getTimes() < 1500;
    }

    public static float getMoon() {
        if(isNight()) return clientWorld().getCurrentMoonPhaseFactor();
        else return 0.0F;
    }

    public static int getDayOfMoonPhase() {
        return getDays() % 8;
    }

    public static float getMoonPhase() {
        return clientWorld().getCurrentMoonPhaseFactorBody();
    }

    public static long getTimes() {
        long getTime = clientWorld().getWorldTime();
        return getTime % 24000;
    }

    public static int getDays() {
        long getTime = clientWorld().getWorldTime();
        return ((int) getTime / 24000);
    }
}
