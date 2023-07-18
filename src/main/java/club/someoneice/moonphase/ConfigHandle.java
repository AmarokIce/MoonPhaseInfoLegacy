package club.someoneice.moonphase;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigHandle {
    public static int LOCATION = 0;

    public ConfigHandle() {
        Configuration config = MoonPhase.config;
        config.load();
        Property HudLocation = config.get("Int", "Hud Location", LOCATION);
        HudLocation.comment = "Set the location of the moon hud.Render on top-left if 0, render on top right if 1, render on bottom left if 2, render on bottom right if 3.";
        LOCATION = HudLocation.getInt(LOCATION);
        config.save();
    }
}
