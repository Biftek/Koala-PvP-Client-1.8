package Client.Gui;
 
import java.io.IOException;

import org.lwjgl.input.Keyboard;

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
 
public class GuiCosmetics extends GuiScreen{
   


	public GuiCosmetics(GuiIngameMenu guiIngameMenu) {
		// TODO Auto-generated constructor stub
	}

	public GuiCosmetics(GuiClientMenu guiClientMenu) {
		// TODO Auto-generated constructor stub
	}

	public void initGui()
    {
		ScaledResolution sr = new ScaledResolution(mc);
		if(Client.CosmeticCape) {
			  this.buttonList.add(new GuiButton(2, this.width / 2 - 90, 70, 60, 20, I18n.format("§2Cape", new Object[0])));
		}else {
			  this.buttonList.add(new GuiButton(2, this.width / 2 - 90, 70, 60, 20, I18n.format("§4Cape", new Object[0])));
		}
		
		if(Client.CosmeticWings) {
			 this.buttonList.add(new GuiButton(3, this.width / 2 - 25, 70, 60, 20, I18n.format("§2Wings", new Object[0])));	
		}else {
			 this.buttonList.add(new GuiButton(3, this.width / 2 - 25, 70, 60, 20, I18n.format("§4Wings", new Object[0])));
		}
       if(Client.CosmeticWitchHat) {
    	   this.buttonList.add(new GuiButton(4, this.width / 2 + 40, 70, 60, 20, I18n.format("§2Witchhat", new Object[0])));
       }else {
    	   this.buttonList.add(new GuiButton(4, this.width / 2 + 40, 70, 60, 20, I18n.format("§4Witchhat", new Object[0])));   
       }
       if(Client.CosmeticEasterEggs) {
			  this.buttonList.add(new GuiButton(5, this.width / 2 - 90, 105, 60, 20, I18n.format("§2EasterEggs", new Object[0])));
		}else {
			  this.buttonList.add(new GuiButton(5, this.width / 2 - 90, 105, 60, 20, I18n.format("§4EasterEggs", new Object[0])));
		}
       
       if(Client.Sunglasses) {
			  this.buttonList.add(new GuiButton(6, this.width / 2 + 40, 105, 60, 20, I18n.format("§2Sunglasses", new Object[0])));
		}else {
			  this.buttonList.add(new GuiButton(6, this.width / 2 + 40, 105, 60, 20, I18n.format("§4Sunglasses", new Object[0])));
		}
       
       if(Client.Susanoo) {
			  this.buttonList.add(new GuiButton(7, this.width / 2 - 25, 105, 60, 20, I18n.format("§2Susanoo", new Object[0])));
		}else {
			  this.buttonList.add(new GuiButton(7, this.width / 2 - 25, 105, 60, 20, I18n.format("§4Susanoo", new Object[0])));
		}
     
        
        
		drawDefaultBackground();
      
    }
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
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
	 if(ModToggle.loadEnabledFromFile("ModCape") == true) { 
			Client.CosmeticCape = !Client.CosmeticCape;
		  ModToggle.saveIsEnabledToFile("ModCape", Client.CosmeticCape);
	  }else {
			Client.CosmeticCape = !Client.CosmeticCape;
		  ModToggle.saveIsEnabledToFile("ModCape", Client.CosmeticCape);
	  }
 }
 if(button.id == 3) {
	 if(ModToggle.loadEnabledFromFile("ModWings") == true) { 
			Client.CosmeticWings = !Client.CosmeticWings;
		  ModToggle.saveIsEnabledToFile("ModWings", Client.CosmeticWings);
	  }else {
			Client.CosmeticWings = !Client.CosmeticWings;
		  ModToggle.saveIsEnabledToFile("ModWings", Client.CosmeticWings);
	  }
 }
 if(button.id == 4) {
	
	 if(ModToggle.loadEnabledFromFile("ModWithHat") == true) { 
		 Client.CosmeticWitchHat = !Client.CosmeticWitchHat;
		  ModToggle.saveIsEnabledToFile("ModWithHat", Client.CosmeticWitchHat);
	  }else {
		  Client.CosmeticWitchHat = !Client.CosmeticWitchHat;
		  ModToggle.saveIsEnabledToFile("ModWithHat", Client.CosmeticWitchHat);
	  }
	 
	 
 }
 
 if(button.id == 5) {
		
	 if(ModToggle.loadEnabledFromFile("ModEasterEggs") == true) { 
		 Client.CosmeticEasterEggs = !Client.CosmeticEasterEggs;
		  ModToggle.saveIsEnabledToFile("ModEasterEggs", Client.CosmeticEasterEggs);
	  }else {
		  Client.CosmeticEasterEggs = !Client.CosmeticEasterEggs;
		  ModToggle.saveIsEnabledToFile("ModEasterEggs", Client.CosmeticEasterEggs);
	  }
	 
	 
 }
 
 if(button.id == 6) {
		
	 if(ModToggle.loadEnabledFromFile("ModSunglasses") == true) { 
		 Client.Sunglasses = !Client.Sunglasses;
		  ModToggle.saveIsEnabledToFile("ModSunglasses", Client.Sunglasses);
	  }else {
		  Client.Sunglasses = !Client.Sunglasses;
		  ModToggle.saveIsEnabledToFile("ModSunglasses", Client.Sunglasses);
	  }
	 
	 
 }
 
 if(button.id == 7) {
		
	 if(ModToggle.loadEnabledFromFile("ModSusanoo") == true) { 
		 Client.Susanoo = !Client.Susanoo;
		  ModToggle.saveIsEnabledToFile("ModSusanoo", Client.Susanoo);
	  }else {
		  Client.Susanoo = !Client.Susanoo;
		  ModToggle.saveIsEnabledToFile("ModSusanoo", Client.Susanoo);
	  }
	 
	 
 }

 

}





}