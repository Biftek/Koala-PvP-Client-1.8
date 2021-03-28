package Client.mods.util;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import Client.Gui.hud.ScreenPosition;
import Client.mods.ModDraggable;
import net.minecraft.client.Minecraft;

public class ModTime extends ModDraggable{

	public int FPS = mc.debugFPS;
	
	
	@Override
	public int getWidth() {

		return fr.getStringWidth("FPS:     ");
	}

	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		 String pattern = "hh:mm:ss";
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	        String time = simpleDateFormat.format(new Date());
			fr.drawStringWithShadow(time, pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0x595959);
			
		
}
	
	@Override
	public void renderDummy(ScreenPosition pos) {
		FPS = mc.debugFPS;
		 String pattern = "hh:mm:ss";
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	        String time = simpleDateFormat.format(new Date());
		fr.drawStringWithShadow(time + "", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0x595959);
	
}

}
