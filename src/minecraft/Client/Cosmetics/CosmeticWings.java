package Client.Cosmetics;

import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import java.awt.Color;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.lwjgl.opengl.GL11;

import Client.DatabaseUtil;
import Client.Cosmetics.utils.CosmeticBase;
import Client.Cosmetics.utils.CosmeticModelBase;
import Client.util.Rainbow;




public class CosmeticWings extends CosmeticBase {
  private final CosmeticVilligerNose2 wingsModel;
  
  public CosmeticWings(RenderPlayer renderPlayer) {
    super(renderPlayer);
    this.wingsModel = new CosmeticVilligerNose2(renderPlayer);
  }
  
  public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
   
      GL11.glPushMatrix();
  	if(player.isSneaking()) {
  		GlStateManager.rotate(20, 1, 0, 0);
    	GlStateManager.translate(0, 0.20, -0.05);
    }
  	
  		if(Client.Client.CosmeticWings && player == Minecraft.getMinecraft().thePlayer) {
  			Minecraft.getMinecraft().fontRendererObj.drawString("", 0, 0, Rainbow.rainbowEffect(1, 1.0F).getRGB(), true);
  			
	  	 this.wingsModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
  		}
    String uuid = player.getUniqueID().toString();
    try {
 	if(uuid.contains("dwhnioad8zvwavdbwa8zdw")) {
 		GL11.glColor3d(DatabaseUtil.getDouble(uuid, "wings-r"), DatabaseUtil.getDouble(uuid, "wings-g"), DatabaseUtil.getDouble(uuid, "wings-b"));
 	  	 this.wingsModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
 	  	 GL11.glColor3d(1, 1, 1);
 	   }
 } catch (IOException e) {
 	e.printStackTrace();
 }
      GL11.glPopMatrix();
    } 
  
  
  public class CosmeticVilligerNose2 extends CosmeticModelBase {

	    private ModelRenderer wing;
	    private ModelRenderer wingTip;
    
    public CosmeticVilligerNose2(RenderPlayer player) {
      super(player);
      
      setTextureOffset("wing.bone", 0, 0);
      setTextureOffset("wing.skin", -10, 8);
      setTextureOffset("wingtip.bone", 0, 5);
      setTextureOffset("wingtip.skin", -10, 18);
      this.wing = new ModelRenderer((ModelBase)this, "wing");
      this.wing.setTextureSize(30, 30);
      this.wing.setRotationPoint(-2.0F, 0.0F, 0.0F);
      this.wing.addBox("bone", -10.0F, -1.0F, -1.0F, 10, 2, 2);
      this.wing.addBox("skin", -10.0F, 0.0F, 0.5F, 10, 0, 10);
      this.wingTip = new ModelRenderer((ModelBase)this, "wingtip");
      this.wingTip.setTextureSize(30, 30);
      this.wingTip.setRotationPoint(-10.0F, 0.0F, 0.0F);
      this.wingTip.addBox("bone", -10.0F, -0.5F, -0.5F, 10, 1, 1);
      this.wingTip.addBox("skin", -10.0F, 0.0F, 0.5F, 10, 0, 10);
      this.wing.addChild(this.wingTip);
     
    
    }
    
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scale) {
    	GlStateManager.pushMatrix();
    	GlStateManager.disableLighting();
    	GlStateManager.scale(0.9, 0.9, 0.9);
    	GlStateManager.rotate(20, 1, 0, 0);
    	GlStateManager.translate(0, 0, 0.09);
        GlStateManager.translate(0.0D, 0.2, 0.0D);
    	Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("wings.png"));
        for (int j = 0; j < 2; j++) {
            float f11 = (float)(System.currentTimeMillis() % 1000L) / 1000.0F * 3.1415927F * 2.0F;
            this.wing.rotateAngleX = (float)Math.toRadians(-80.0D) - (float)Math.cos(f11) * 0.4F;
            this.wing.rotateAngleY = (float)Math.toRadians(30.0D) + (float)Math.sin(f11) * 0.2F;
            this.wing.rotateAngleZ = (float)Math.toRadians(20.0F);
            this.wingTip.rotateAngleZ = -((float)(Math.sin((f11 + 2F)) + 0.9D)) * 0.75F;
            
            this.wing.render(0.0625F);
            GlStateManager.scale(-1.0F, 1.0F, 1.0F);
            if (j == 0);
          } 
        GlStateManager.enableLighting();
    	GlStateManager.popMatrix();
    }
   }
  }

