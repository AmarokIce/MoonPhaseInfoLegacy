package club.someoneice.moonphase;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = MoonPhase.MODID, acceptableRemoteVersions = "*")
public class MoonPhase {
    public static final String MODID = "moon_phase";
    public static Configuration config;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RenderHUDEvent eventHud = new RenderHUDEvent();
        FMLCommonHandler.instance().bus().register(eventHud);
        MinecraftForge.EVENT_BUS.register(eventHud);
    }
}
