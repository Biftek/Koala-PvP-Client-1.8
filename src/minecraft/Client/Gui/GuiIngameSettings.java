package Client.Gui;
 
import java.io.IOException;

import org.lwjgl.input.Keyboard;

import Client.Client;
import Client.ModToggle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiPageButtonList;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.main.Main;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
 
public class GuiIngameSettings extends GuiScreen{

	

	public GuiIngameSettings(GuiClientMenu guiClientMenu) {
		// TODO Auto-generated constructor stub
	}

	public void initGui()
    {
		ScaledResolution sr = new ScaledResolution(mc);
		if(Client.Fullbright) {
	        this.buttonList.add(new GuiButton(1, this.width / 2 - 25, 70, 60, 20, I18n.format("§2FULLBRIGHT", new Object[0])));
		}else {
	        this.buttonList.add(new GuiButton(1, this.width / 2 - 25, 70, 60, 20, I18n.format("§4FULLBRIGHT", new Object[0])));	
		}
		if(Client.FPS) {
			this.buttonList.add(new GuiButton(2, this.width / 2 - 90, 70, 60, 20, I18n.format("§2FPS", new Object[0])));	
		}else {
			this.buttonList.add(new GuiButton(2, this.width / 2 - 90, 70, 60, 20, I18n.format("§4FPS", new Object[0])));
		}
        if(Client.CPS) {
            this.buttonList.add(new GuiButton(3, this.width / 2 + 40, 70, 60, 20, I18n.format("§2CPS", new Object[0])));        	
        }else {
            this.buttonList.add(new GuiButton(3, this.width / 2 + 40, 70, 60, 20, I18n.format("§4CPS", new Object[0])));
        }
        if(Client.NAMETAG) {
        	  this.buttonList.add(new GuiButton(7, this.width / 2 - 25, 93, 60, 20, I18n.format("§2HEARTS", new Object[0])));  	
        }else {
        	  this.buttonList.add(new GuiButton(7, this.width / 2 - 25, 93, 60, 20, I18n.format("§4HEARTS", new Object[0])));
        }
      if(Client.IngameZoom) {
    	  this.buttonList.add(new GuiButton(5, this.width / 2 - 90, 93, 60, 20, I18n.format("§2OPTIFINE ZOOM", new Object[0])));  
      }else {
    	  this.buttonList.add(new GuiButton(5, this.width / 2 - 90, 93, 60, 20, I18n.format("§4OPTIFINE ZOOM", new Object[0])));
      }
        if(Client.XYZ) {
        	   this.buttonList.add(new GuiButton(6, this.width / 2 + 40, 93, 60, 20, I18n.format("§2X/Y/Z", new Object[0])));   	
        }else {
        	   this.buttonList.add(new GuiButton(6, this.width / 2 + 40, 93, 60, 20, I18n.format("§4X/Y/Z", new Object[0])));
        }
       
       if(Client.NAMETAG2) {
    	   this.buttonList.add(new GuiButton(12, this.width / 2 - 25, 116, 60, 20, I18n.format("§2NameTag", new Object[0])));   
       }else {
    	   this.buttonList.add(new GuiButton(12, this.width / 2 - 25, 116, 60, 20, I18n.format("§4NameTag", new Object[0])));
       }
       
       if(Client.PotionEffekt) {
    	   this.buttonList.add(new GuiButton(13, this.width / 2 - 90, 116, 60, 20, I18n.format("§2Potion Status", new Object[0])));   
       }else {
    	   this.buttonList.add(new GuiButton(13, this.width / 2 - 90, 116, 60, 20, I18n.format("§4Potion Status", new Object[0])));
       }
       
       if(Client.ArmorStatus) {
    	   this.buttonList.add(new GuiButton(14, this.width / 2 + 40, 116, 60, 20, I18n.format("§2Armor Status", new Object[0])));   
       }else {
    	   this.buttonList.add(new GuiButton(14, this.width / 2 + 40, 116, 60, 20, I18n.format("§4Armor Status", new Object[0])));
       }
       
       
      // if(Client.ping) {
    	//   this.buttonList.add(new GuiButton(15, this.width / 2 - 90, 162, 60, 20, I18n.format("§2Ping", new Object[0])));   
      // }else {
    	//   this.buttonList.add(new GuiButton(15, this.width / 2 - 90, 162, 60, 20, I18n.format("§4Ping", new Object[0])));
      // }
       if(Client.togglesprint) {
    	   this.buttonList.add(new GuiButton(16, this.width / 2 - 25, 139, 60, 20, I18n.format("§2ToggleSprint", new Object[0])));   
       }else {
    	   this.buttonList.add(new GuiButton(16, this.width / 2 - 25, 139, 60, 20, I18n.format("§4ToggleSprint", new Object[0])));
       }
       
       if(Client.toggleperspective) {
    	   this.buttonList.add(new GuiButton(17, this.width / 2 + 40, 139, 60, 20, I18n.format("§2360", new Object[0])));   
       }else {
    	   this.buttonList.add(new GuiButton(17, this.width / 2 + 40, 139, 60, 20, I18n.format("§4360", new Object[0])));
       }
       
       if(Client.direction) {
    	   //this.buttonList.add(new GuiButton(18, this.width / 2 - 90, 139, 60, 20, I18n.format("§2Direction", new Object[0])));   
       }else {
    	   //this.buttonList.add(new GuiButton(18, this.width / 2 - 90, 139, 60, 20, I18n.format("§4Direction", new Object[0])));
       }
       
       if(Client.CompactChat) {
    	   this.buttonList.add(new GuiButton(19, this.width / 2 - 90, 139, 60, 20, I18n.format("§2CompactChat", new Object[0])));   
       }else {
    	   this.buttonList.add(new GuiButton(19, this.width / 2 - 90, 139, 60, 20, I18n.format("§4CompactChat", new Object[0])));
       }
       
       
       if(Client.mlghelper) {
    	 //  this.buttonList.add(new GuiButton(20, this.width / 2 + 40, 162, 60, 20, I18n.format("§2MLGHelper", new Object[0])));   
       }else {
    	   //this.buttonList.add(new GuiButton(20, this.width / 2 + 40, 162, 60, 20, I18n.format("§4MLGHelper", new Object[0])));
       }
       
       
       if(Client.BlockOverlay) {
    	   this.buttonList.add(new GuiButton(21, this.width / 2 - 25, 162, 60, 20, I18n.format("§2BlockOverlay", new Object[0])));   
       }else {
    	   this.buttonList.add(new GuiButton(21, this.width / 2 - 25, 162, 60, 20, I18n.format("§4BlockOverlay", new Object[0])));
       }
       
       if(Client.time) {
    	   this.buttonList.add(new GuiButton(22, this.width / 2 + 40, 162, 60, 20, I18n.format("§2Time", new Object[0])));   
       }else {
    	   this.buttonList.add(new GuiButton(22, this.width / 2 + 40, 162, 60, 20, I18n.format("§4Time", new Object[0])));
       }
      
      
        
		drawDefaultBackground();
      
    }
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}
public String status;
 
public void drawScreen(int mouseX,int mouseY, float partialTicks)
{
	drawDefaultBackground();
		  this.drawCenteredString(this.fontRendererObj, I18n.format("Ingame Settings Menu", new Object[0]), this.width / 2, 40,0xffffff);
		
 super.drawScreen(mouseX, mouseY, partialTicks);
 }

 public void actionPerformed(GuiButton button) throws IOException
{
 if(button.id == 1) {
	 if(ModToggle.loadEnabledFromFile("ModFullbright") == true) { 
			Client.Fullbright = !Client.Fullbright;
		  ModToggle.saveIsEnabledToFile("ModFullbright", Client.Fullbright);
	  }else {
		Client.Fullbright = !Client.Fullbright;
		  ModToggle.saveIsEnabledToFile("ModFullbright", Client.Fullbright);
	  }
 }
	 
 if(button.id == 2) {
	 if(ModToggle.loadEnabledFromFile("ModFPS") == true) { 
		 Client.FPS = !Client.FPS;
		  ModToggle.saveIsEnabledToFile("ModFPS", Client.FPS);
		  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
	  }else {
		  Client.FPS = !Client.FPS;
		  ModToggle.saveIsEnabledToFile("ModFPS", Client.FPS);
		  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
	  }
 }
 
 if(button.id == 3) {
	 if(ModToggle.loadEnabledFromFile("ModCPS") == true) { 
		 Client.CPS = !Client.CPS;
		  ModToggle.saveIsEnabledToFile("ModCPS", Client.CPS);
		  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
	  }else {
		  Client.CPS = !Client.CPS;
		  ModToggle.saveIsEnabledToFile("ModCPS", Client.CPS);
		  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
	  }
 }
 
 if(button.id == 7) {
	 if(ModToggle.loadEnabledFromFile("ModHearts") == true) { 
		 Client.NAMETAG = !Client.NAMETAG;
		  ModToggle.saveIsEnabledToFile("ModHearts", Client.NAMETAG);
	  }else {
		  Client.NAMETAG = !Client.NAMETAG;
		  ModToggle.saveIsEnabledToFile("ModHearts", Client.NAMETAG);
	  }
 }

 if(button.id == 5) {
	 if(ModToggle.loadEnabledFromFile("ModIngameZoom") == true) { 
		 Client.IngameZoom = !Client.IngameZoom;
		  ModToggle.saveIsEnabledToFile("ModIngameZoom", Client.IngameZoom);
	  }else {
		  Client.IngameZoom = !Client.IngameZoom;
		  ModToggle.saveIsEnabledToFile("ModIngameZoom", Client.IngameZoom);
	  }
 }
 
 if(button.id == 6) {
	 if(ModToggle.loadEnabledFromFile("ModXYZ") == true) { 
		 Client.XYZ = !Client.XYZ;
		  ModToggle.saveIsEnabledToFile("ModXYZ", Client.XYZ);
		  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
	  }else {
		  Client.XYZ = !Client.XYZ;
		  ModToggle.saveIsEnabledToFile("ModXYZ", Client.XYZ);
		  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
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
 
 if(button.id == 10) {
	 if(ModToggle.loadEnabledFromFile("ModEatandDrink") == true) { 
		 Client.EatDrink = !Client.EatDrink;
		  ModToggle.saveIsEnabledToFile("ModEatandDrink", Client.EatDrink);
	  }else {
		  Client.EatDrink = !Client.EatDrink;
		  ModToggle.saveIsEnabledToFile("ModEatandDrink", Client.EatDrink);
	  }
 }
 
 if(button.id == 11) {
	 if(ModToggle.loadEnabledFromFile("ModBow") == true) { 
		 Client.Bow = !Client.Bow;
		  ModToggle.saveIsEnabledToFile("ModBow", Client.Bow);
	  }else {
		  Client.Bow = !Client.Bow;
		  ModToggle.saveIsEnabledToFile("ModBow", Client.Bow);
	  }
	 
	 
 }
 
 if(button.id == 12) {
	 if(ModToggle.loadEnabledFromFile("ModNameTags") == true) { 
		 Client.NAMETAG2 = !Client.NAMETAG2;
		  ModToggle.saveIsEnabledToFile("ModNameTags", Client.NAMETAG2);
	  }else {
		  Client.NAMETAG2 = !Client.NAMETAG2;
		  ModToggle.saveIsEnabledToFile("ModNameTags", Client.NAMETAG2);
	  }
 }
	 
	 if(button.id == 13) {
		 if(ModToggle.loadEnabledFromFile("ModPotionStatus") == true) { 
			 Client.PotionEffekt = !Client.PotionEffekt;
			  ModToggle.saveIsEnabledToFile("ModPotionStatus", Client.PotionEffekt);
			  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
		  }else {
			  Client.PotionEffekt = !Client.PotionEffekt;
			  ModToggle.saveIsEnabledToFile("ModPotionStatus", Client.PotionEffekt);
			  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
		  }
	 }
		 
		 if(button.id == 14) {
			 if(ModToggle.loadEnabledFromFile("ModArmorStatus") == true) { 
				 Client.ArmorStatus = !Client.ArmorStatus;
				  ModToggle.saveIsEnabledToFile("ModArmorStatus", Client.ArmorStatus);
				  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
			  }else {
				  Client.ArmorStatus = !Client.ArmorStatus;
				  ModToggle.saveIsEnabledToFile("ModArmorStatus", Client.ArmorStatus);
				  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
			  }
	 
		 }
		 
		 if(button.id == 15) {
			 if(ModToggle.loadEnabledFromFile("ModPing") == true) { 
				 Client.ping = !Client.ping;
				  ModToggle.saveIsEnabledToFile("ModPing", Client.ping);
				  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
			  }else {
				  Client.ping = !Client.ping;
				  ModToggle.saveIsEnabledToFile("ModPing", Client.ping);
				  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
			  }
			 
			 
	 
 }
		 
		 if(button.id == 16) {
			 if(ModToggle.loadEnabledFromFile("ModToggleSprint") == true) { 
				 Client.togglesprint = !Client.togglesprint;
				  ModToggle.saveIsEnabledToFile("ModToggleSprint", Client.togglesprint);
			  }else {
				  Client.togglesprint = !Client.togglesprint;
				  ModToggle.saveIsEnabledToFile("ModToggleSprint", Client.togglesprint);
			  }
		 }
			 
			 if(button.id == 17) {
				 if(ModToggle.loadEnabledFromFile("ModTogglePerspective") == true) { 
					 Client.toggleperspective = !Client.toggleperspective;
					  ModToggle.saveIsEnabledToFile("ModTogglePerspective", Client.toggleperspective);
				  }else {
					  Client.toggleperspective = !Client.toggleperspective;
					  ModToggle.saveIsEnabledToFile("ModTogglePerspective", Client.toggleperspective);
				  }
			 
			 
	 
 }
			 
			 if(button.id == 18) {
				 if(ModToggle.loadEnabledFromFile("ModDirection") == true) { 
					 Client.direction = !Client.direction;
					  ModToggle.saveIsEnabledToFile("ModDirection", Client.direction);
					  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
				  }else {
					  Client.direction = !Client.direction;
					  ModToggle.saveIsEnabledToFile("ModDirection", Client.direction);
					  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
				  }
			 
			 
	 
 }
			 
			 if(button.id == 19) {
				 if(ModToggle.loadEnabledFromFile("ModCompactChat") == true) { 
					 Client.CompactChat = !Client.CompactChat;
					  ModToggle.saveIsEnabledToFile("ModCompactChat", Client.CompactChat);
				  }else {
					  Client.CompactChat = !Client.CompactChat;
					  ModToggle.saveIsEnabledToFile("ModCompactChat", Client.CompactChat);
				  }
			 
			 
	 
 }
			 
			 if(button.id == 21) {
				 if(ModToggle.loadEnabledFromFile("ModBlockOverlay") == true) { 
					 Client.BlockOverlay = !Client.BlockOverlay;
					  ModToggle.saveIsEnabledToFile("ModBlockOverlay", Client.BlockOverlay);
				  }else {
					  Client.BlockOverlay = !Client.BlockOverlay;
					  ModToggle.saveIsEnabledToFile("ModBlockOverlay", Client.BlockOverlay);
				  }
			 
			 
	 
 }
			 
			 
			 if(button.id == 20) {
				 if(ModToggle.loadEnabledFromFile("ModMLGHelper") == true) { 
					 Client.mlghelper = !Client.mlghelper;
					  ModToggle.saveIsEnabledToFile("ModMLGHelper", Client.mlghelper);
					  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
				  }else {
					  Client.mlghelper = !Client.mlghelper;
					  ModToggle.saveIsEnabledToFile("ModMLGHelper", Client.mlghelper);
					  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
				  }
			 
			 
	 
 }


			 if(button.id == 22) {
				 if(ModToggle.loadEnabledFromFile("ModTime") == true) { 
					 Client.time = !Client.time;
					  ModToggle.saveIsEnabledToFile("ModTime", Client.time);
					  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
				  }else {
					  Client.time = !Client.time;
					  ModToggle.saveIsEnabledToFile("ModTime", Client.time);
					  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§4Restart to see changes!"));
				  }
			 
			 
	 
 }
}





}