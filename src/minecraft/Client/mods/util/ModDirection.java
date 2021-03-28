package Client.mods.util;

import java.awt.Color;

import Client.Gui.hud.ScreenPosition;
import Client.mods.ModDraggable;
import net.minecraft.client.Minecraft;

public class ModDirection extends ModDraggable{

	
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("Direction: west");
	}

	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		
			fr.drawStringWithShadow("Direction §f" + mc.thePlayer.getHorizontalFacing(), pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0x595959);
}
	
	@Override
	public void renderDummy(ScreenPosition pos) {
	
		fr.drawStringWithShadow("Direction " + "§fwest", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1,0x595959);
	
}
	

}
