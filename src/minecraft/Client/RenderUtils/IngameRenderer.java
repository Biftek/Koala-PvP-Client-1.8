package Client.RenderUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import Client.Client;
import Client.ClientMovementInput;
import Client.EventTarget;
import Client.ModEveryLook.KeyEvent;
import Client.util.Rainbow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class IngameRenderer extends GuiIngame{
	public static Minecraft mc = Minecraft.getMinecraft();
	private static List<Long> clicks = new ArrayList<Long>();
	private static boolean wasPressed;
	private static long lastPressed;

	private static boolean IsKeyDown = false;
	private static int savedFOV = 0;
	private static List<Long> clicks2 = new ArrayList<Long>();
	private static boolean wasPressed2;
	private static long lastPressed2;
	  protected static float zLevelFloat;
	  private static float cameraYaw = 0F;
	  private static float cameraPitch = 0F;
	  private static int previousePrespective = 0;
	  private static boolean perspectiveToggled = false;
	  public static boolean returnOnRelease = true;
	  
	public IngameRenderer(Minecraft mcIn) {
		super(mcIn);
	}
	
	 public static void drawTexturedModalRectt(int x, int y, int textureX, int textureY, int width, int height) {
		    float f = 0.00390625F;
		    float f1 = 0.00390625F;
		    Tessellator tessellator = Tessellator.getInstance();
		    WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		    worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
		    worldrenderer.pos((x + 0), (y + height), zLevelFloat).tex(((textureX + 0) * f), ((textureY + height) * f1)).endVertex();
		    worldrenderer.pos((x + width), (y + height), zLevelFloat).tex(((textureX + width) * f), ((textureY + height) * f1)).endVertex();
		    worldrenderer.pos((x + width), (y + 0), zLevelFloat).tex(((textureX + width) * f), ((textureY + 0) * f1)).endVertex();
		    worldrenderer.pos((x + 0), (y + 0), zLevelFloat).tex(((textureX + 0) * f), ((textureY + 0) * f1)).endVertex();
		    tessellator.draw();
		  }
	 
	 
	public static void renderIngameUtils() {
		
		ScaledResolution sr = new ScaledResolution(mc);
		final boolean lpressed = Mouse.isButtonDown(0);
		final boolean rpressed = Mouse.isButtonDown(1);
		if(lpressed != wasPressed) {
			lastPressed = System.currentTimeMillis() + 10;
			wasPressed = lpressed;
			if(lpressed) {
				clicks.add(lastPressed);
			}
		}
		
		if(rpressed != wasPressed2) {
			lastPressed2 = System.currentTimeMillis() + 10;
			wasPressed2 = rpressed;
			if(rpressed) {
				clicks2.add(lastPressed2);
			}
		}
		Rainbow.drawChromaString(Client.Client_Name, 0, 0, true);
		if(Client.FPS) {
	//	mc.fontRendererObj.drawStringWithShadow("FPS§f " + mc.getDebugFPS(), 0, 10, 0xfc00ec);
	}
	
		if(Client.CPS) {
		//mc.fontRendererObj.drawStringWithShadow("CPS§f " + getCPS() + ":" + getCPS2(), 0, 20, 0xfc00ec);
		}
		
		
		if(Client.Fullbright) {
			Minecraft.getMinecraft().gameSettings.gammaSetting = 100;
		}else {
			Minecraft.getMinecraft().gameSettings.gammaSetting = 2;
		}
		if(Client.XYZ) {
		//mc.fontRendererObj.drawStringWithShadow("X§f " + (int)mc.thePlayer.posX, 0, 30, 0xfc00ec);
		//mc.fontRendererObj.drawStringWithShadow("Y§f " + (int)mc.thePlayer.posY, 0, 40, 0xfc00ec);
		//mc.fontRendererObj.drawStringWithShadow("Z§f " + (int)mc.thePlayer.posZ, 0, 50, 0xfc00ec);
		}
		
		if(Client.direction) {
		//	mc.fontRendererObj.drawStringWithShadow("Direction§f " + mc.thePlayer.getHorizontalFacing(), 0, 60, 0xfc00ec);
			}
		if(Client.IngameZoom) {
		if(IsKeyDown != Minecraft.getMinecraft().gameSettings.CLIENT_ZOOM.isKeyDown()) {
	    	
	        if(Minecraft.getMinecraft().gameSettings.CLIENT_ZOOM.isKeyDown()) {
	        	
	            savedFOV = (int) Minecraft.getMinecraft().gameSettings.fovSetting;
	            Minecraft.getMinecraft().gameSettings.fovSetting = 20;
	            Minecraft.getMinecraft().gameSettings.smoothCamera = true; 
	        } else {
	            Minecraft.getMinecraft().gameSettings.fovSetting = savedFOV;
	            Minecraft.getMinecraft().gameSettings.smoothCamera = false;
	        }
	    }
	    IsKeyDown = Minecraft.getMinecraft().gameSettings.CLIENT_ZOOM.isKeyDown();
	
		
		}
		
			
		}
	
	
	
	
	
	 
	
	
	private static int getCPS() {
		final long time = System.currentTimeMillis();
		clicks.removeIf(aLong -> aLong + 1000 < time);
		return clicks.size();
	}
	
	private static int getCPS2() {
		final long time2 = System.currentTimeMillis();
		clicks2.removeIf(aLong2 -> aLong2 + 1000 < time2);
		return clicks2.size();
	}
	
}
