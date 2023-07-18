package club.someoneice.moonphase;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import java.awt.*;

public class RenderHUDEvent {
    public static Minecraft mc = Minecraft.getMinecraft();
    private static ResourceLocation moon_info = new ResourceLocation(MoonPhase.MODID, "textures/gui/lunar_info.png");

    @SubscribeEvent @SideOnly(Side.CLIENT)
    public void renderBar(RenderGameOverlayEvent event) {
        int rawWidth = event.resolution.getScaledWidth();
        int rawHeight = event.resolution.getScaledHeight();

        if (LunarUtil.isNight()) {
            float moonPhase = LunarUtil.getMoonPhase();
            int day = LunarUtil.getDayOfMoonPhase();

            int width = 10;
            int height = 10;

            if (ConfigHandle.LOCATION == 1) {
                width = rawWidth - 60;
            } else if (ConfigHandle.LOCATION == 2) {
                height = rawHeight - 36;
            } else if (ConfigHandle.LOCATION == 3) {
                width = rawWidth - 60;
                height = rawHeight - 36;
            }

            boolean flag = day < 4;
            int moon = ((int) (moonPhase * 100)) / 25;
            int w = moon == 4 ? 0 : moon * 32;
            int h = flag ? 0 : 32;

            GuiIngame ingameGUI = mc.ingameGUI;
            Minecraft.getMinecraft().getTextureManager().bindTexture(moon_info);
            ingameGUI.drawTexturedModalRect(width, height, w, h, 32, 32);
            ingameGUI.drawString(mc.fontRenderer, ((char) 167 + "l") + ((int) (moonPhase * 100)) + "%", width + 40, height + 10, Color.YELLOW.getRGB());
        }
    }
}
