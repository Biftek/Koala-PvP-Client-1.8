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
import net.minecraft.util.ResourceLocation;
 
public class GuiAnimations extends GuiScreen{
   


	public GuiAnimations(GuiIngameMenu guiIngameMenu) {
		// TODO Auto-generated constructor stub
	}

	public GuiAnimations(Client client) {
		// TODO Auto-generated constructor stub
	}

	public GuiAnimations(GuiClientMenu guiClientMenu) {
		// TODO Auto-generated constructor stub
	}

	public void initGui()
    {
		if(Client.EatDrink) {
	        this.buttonList.add(new GuiButton(2, this.width / 2 - 25, 70, 60, 20, I18n.format("§2Eat/Drink", new Object[0])));
		}else {
	        this.buttonList.add(new GuiButton(2, this.width / 2 - 25, 70, 60, 20, I18n.format("§4Eat/Drink", new Object[0])));	
		}
		if(Client.Bow) {
			this.buttonList.add(new GuiButton(3, this.width / 2 - 90, 70, 60, 20, I18n.format("§2Bow", new Object[0])));	
		}else {
			this.buttonList.add(new GuiButton(3, this.width / 2 - 90, 70, 60, 20, I18n.format("§4Bow", new Object[0])));
		}
        if(Client.Blockhit) {
            this.buttonList.add(new GuiButton(4, this.width / 2 + 40, 70, 60, 20, I18n.format("§2Blockhit", new Object[0])));        	
        }else {
            this.buttonList.add(new GuiButton(4, this.width / 2 + 40, 70, 60, 20, I18n.format("§4Blockhit", new Object[0])));
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

	 
 if(button.id == 2) {
	 if(ModToggle.loadEnabledFromFile("ModEatandDrink") == true) { 
		 Client.EatDrink = !Client.EatDrink;
		  ModToggle.saveIsEnabledToFile("ModEatandDrink", Client.EatDrink);
	  }else {
		  Client.EatDrink = !Client.EatDrink;
		  ModToggle.saveIsEnabledToFile("ModEatandDrink", Client.EatDrink);
	  }
 }
 
 if(button.id == 3) {
	 if(ModToggle.loadEnabledFromFile("ModBow") == true) { 
		 Client.Bow = !Client.Bow;
		  ModToggle.saveIsEnabledToFile("ModBow", Client.Bow);
	  }else {
		  Client.Bow = !Client.Bow;
		  ModToggle.saveIsEnabledToFile("ModBow", Client.Bow);
	  }
 }
 
 if(button.id == 4) {
	 if(ModToggle.loadEnabledFromFile("ModBlockhit") == true) { 
		 Client.Blockhit = !Client.Blockhit;
		  ModToggle.saveIsEnabledToFile("ModBlockhit", Client.Blockhit);
	  }else {
		  Client.Blockhit = !Client.Blockhit;
		  ModToggle.saveIsEnabledToFile("ModBlockhit", Client.Blockhit);
	  }
 }
 

 

}
 






}