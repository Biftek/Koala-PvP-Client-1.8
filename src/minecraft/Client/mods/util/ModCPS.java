package Client.mods.util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import Client.Gui.hud.ScreenPosition;
import Client.mods.ModDraggable;



public class ModCPS extends ModDraggable{

	
	private List<Long> clicks = new ArrayList<Long>();
	private boolean wasPressed;
	private long lastPressed;
	
	private List<Long> clicks2 = new ArrayList<Long>();
	private boolean wasPressed2;
	private long lastPressed2;
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("CPS: 2:2");
	}

	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition paramScreenPosition) {
		final boolean lpressed = Mouse.isButtonDown(0);
		final boolean rpressed = Mouse.isButtonDown(1);
		
		if(lpressed != this.wasPressed) {
			this.lastPressed = System.currentTimeMillis() + 10;
			this.wasPressed = lpressed;
			if(lpressed) {
				this.clicks.add(this.lastPressed);
			}
		}
		
		if(rpressed != this.wasPressed2) {
			this.lastPressed2 = System.currentTimeMillis() + 10;
			this.wasPressed2 = rpressed;
			if(rpressed) {
				this.clicks2.add(this.lastPressed2);
			}
		}
		
			fr.drawStringWithShadow("CPS§f" + " " + getCPS() + ":" + getCPS2(), pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0x595959);
		
		
		
	}
	
	@Override
	public void renderDummy(ScreenPosition pos) {
		
			fr.drawStringWithShadow("CPS§f 1:1", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0x595959);
		
	 
	}
	private int getCPS() {
		final long time = System.currentTimeMillis();
		this.clicks.removeIf(aLong -> aLong + 1000 < time);
		return this.clicks.size();
	}
	
	private int getCPS2() {
		final long time2 = System.currentTimeMillis();
		this.clicks2.removeIf(aLong2 -> aLong2 + 1000 < time2);
		return this.clicks2.size();
	}
	

}
