package Client.mods.util;

import java.awt.Color;

import Client.Gui.hud.ScreenPosition;
import Client.mods.ModDraggable;
import net.minecraft.client.Minecraft;

public class ModFPS extends ModDraggable{

	public int FPS = mc.debugFPS;
	
	
	@Override
	public int getWidth() {

		return fr.getStringWidth("FPS: " + FPS);
	}

	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		
			fr.drawStringWithShadow("FPS §f" + mc.debugFPS, pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0x595959);
			
		
}
	
	@Override
	public void renderDummy(ScreenPosition pos) {
		FPS = mc.debugFPS;
		fr.drawStringWithShadow("FPS " + "§f100", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0x595959);
	
}
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return super.isEnabled();
	}

}
