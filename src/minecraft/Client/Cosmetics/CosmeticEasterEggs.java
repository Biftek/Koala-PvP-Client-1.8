package Client.Cosmetics;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import Client.DatabaseUtil;
import Client.Cosmetics.utils.CosmeticBase;
import Client.Cosmetics.utils.CosmeticModelBase;





public class CosmeticEasterEggs extends CosmeticBase {
  private final CosmeticVilligerNose2 EggsModel;
  
  public CosmeticEasterEggs(RenderPlayer renderPlayer) {
    super(renderPlayer);
    this.EggsModel = new CosmeticVilligerNose2(renderPlayer);
  }
  
  public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
   
      GL11.glPushMatrix();
  	if(player.isSneaking()) {
    	GlStateManager.translate(0, 0.262, -0);
    }
  	 GlStateManager.rotate(netHeadYaw, 0.0F, 1.0F, 0.0F);
     GlStateManager.rotate(headPitch, 1.0F, 0.0F, 0.0F); 
 	  GlStateManager.rotate(ageInTicks * 17, 0, 1, 0);
 	  GlStateManager.rotate(180, 1, 0, 0);
	    String uuid = player.getUniqueID().toString();
 	 if(uuid.contains("dwabdwbo8adb8wbdwa")) {
	  this.EggsModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	  GL11.glColor3d(1, 1, 1);
	  }
	
      
      if(player == Minecraft.getMinecraft().thePlayer && Client.Client.CosmeticEasterEggs) {
    	 this.EggsModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);  
      }
      GL11.glPopMatrix();
    } 
  
  
  public class CosmeticVilligerNose2 extends CosmeticModelBase {
    
    public CosmeticVilligerNose2(RenderPlayer player) {
      super(player);
     
    
    }
    
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scale) {
    		    
    		      
    	
    	
    	GlStateManager.pushMatrix();
      	 GlStateManager.scale(0.25, 0.25, 0.25); 
    	  GlStateManager.translate(2, +1.5, 0);
  	ItemStack itemsword = new ItemStack(Items.egg);
  	   Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn,itemsword, TransformType.NONE);   
  	   GlStateManager.translate(-4, 0, 0);
  	   Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn,itemsword, TransformType.NONE);   
  	   GlStateManager.translate(2, 0, 2);
  	   Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn,itemsword, TransformType.NONE);  
  	   GlStateManager.translate(0, 0, -4);
  	  Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn,itemsword, TransformType.NONE);   
        
        GlStateManager.popMatrix();
        
    }
    
    
  }
  }

