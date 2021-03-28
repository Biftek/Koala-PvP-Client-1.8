package Client.mods.util;

import java.awt.Color;

import Client.Gui.hud.ScreenPosition;
import Client.mods.ModDraggable;
import net.minecraft.client.Minecraft;

public class ModCoordinates extends ModDraggable{

	int X;
	int Y;
	int Z;
	
	
	@Override
	public int getWidth() {
		X = mc.thePlayer.getPosition().getX();
		Y = mc.thePlayer.getPosition().getY();
		Z = mc.thePlayer.getPosition().getZ();
		return fr.getStringWidth("Xddd");
	}

	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT + 18;
	}

	@Override
	public void render(ScreenPosition pos) {
		X = mc.thePlayer.getPosition().getX();
		Y = mc.thePlayer.getPosition().getY();
		Z = mc.thePlayer.getPosition().getZ();
		
			fr.drawStringWithShadow("X" + " §f" + X, pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0x595959);
			fr.drawStringWithShadow("Y" + " §f" + Y, pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 10, 0x595959);
			fr.drawStringWithShadow("Z" + " §f" + Z, pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 20,0x595959);

		
		
	
}
	
	@Override
	public void renderDummy(ScreenPosition pos) {
	
		fr.drawStringWithShadow("X §f" + X, pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0x595959);
		fr.drawStringWithShadow("Y §f" + Y, pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 10, 0x595959);		
		fr.drawStringWithShadow("Z §f" + Z, pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 20, 0x595959);
	
}
	

}
