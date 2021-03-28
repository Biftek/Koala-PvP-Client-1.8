package Client.Gui;
 
import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import Client.Client;
import Client.ModToggle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.main.Main;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
 
public class GuiClientMenu extends GuiScreen{
   


	public GuiClientMenu(GuiIngameMenu guiIngameMenu) {
		// TODO Auto-generated constructor stub
	}

	public GuiClientMenu(Client client) {
		// TODO Auto-generated constructor stub
	}

	public void initGui()
    {
		ScaledResolution sr = new ScaledResolution(mc);
		if(Client.Keystrokes) {
			 this.buttonList.add(new GuiButton(1, this.width / 2 - 25, 70, 60, 20, I18n.format("§2Keystrokes", new Object[0])));	
		}else {
			 this.buttonList.add(new GuiButton(1, this.width / 2 - 25, 70, 60, 20, I18n.format("§4Keystrokes", new Object[0])));
		}
       
        this.buttonList.add(new GuiButton(2, this.width / 2 - 90, 70, 60, 20, I18n.format("Ingame", new Object[0])));
        this.buttonList.add(new GuiButton(3, this.width / 2 + 40, 70, 60, 20, I18n.format("Cosmetics", new Object[0])));
        
   	 this.buttonList.add(new GuiButton(4, this.width / 2 - 25, 93, 60, 20, I18n.format("1.7 Animation", new Object[0])));
   	if(Client.buttonstyle) {
        this.buttonList.add(new GuiButton(5, this.width / 2 + 40,93, 60, 20, I18n.format("Style", new Object[0])));
	}else {
        this.buttonList.add(new GuiButton(5, this.width / 2 + 40, 93, 60, 20, I18n.format("Style", new Object[0])));	
	}
        
        
		drawDefaultBackground();
      
    }
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}
	 public void openConfigScreen() {
		    this.mc.displayGuiScreen(this);
		  }


public void drawScreen(int mouseX,int mouseY, float partialTicks)
{
	ScaledResolution sr = new ScaledResolution(mc);
	
	this.drawDefaultBackground();
		  this.drawCenteredString(this.fontRendererObj, I18n.format("Menu", new Object[0]), this.width / 2, 40, 0xffffff);
		  
		
	  
 super.drawScreen(mouseX, mouseY, partialTicks);
 }

 public void actionPerformed(GuiButton button) throws IOException
{
 if(button.id == 1) {
	 if(ModToggle.loadEnabledFromFile("ModKeystrokes") == true) { 
		 Client.Keystrokes = !Client.Keystrokes;
		  ModToggle.saveIsEnabledToFile("ModKeystrokes", Client.Keystrokes);
		  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
	  }else {
		  Client.Keystrokes = !Client.Keystrokes;
		  ModToggle.saveIsEnabledToFile("ModKeystrokes", Client.Keystrokes);
		  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
	  }
 }
	 
 if(button.id == 2) {
	 mc.displayGuiScreen(new GuiIngameSettings(this));
 }
 
 if(button.id == 3) {
	 mc.displayGuiScreen(new GuiCosmetics(this));
 }
 
 if(button.id == 4) {
	 mc.displayGuiScreen(new GuiAnimations(this));
 }
 
 if(button.id == 5) {
	 if(ModToggle.loadEnabledFromFile("ModButtonStyle") == true) { 
		 Client.buttonstyle = !Client.buttonstyle;
		  ModToggle.saveIsEnabledToFile("ModButtonStyle", Client.buttonstyle);
	  }else {
		  Client.buttonstyle = !Client.buttonstyle;
		  ModToggle.saveIsEnabledToFile("ModButtonStyle", Client.buttonstyle);
	  }
 }
 

 

}
 






}