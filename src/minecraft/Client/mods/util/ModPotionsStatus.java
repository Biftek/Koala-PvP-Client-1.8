package Client.mods.util;

import java.util.Collection;

import Client.Gui.hud.ScreenPosition;
import Client.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class ModPotionsStatus extends ModDraggable {
  
  protected FontRenderer fontRendererObj;
  
  protected float zLevelFloat;
  
  public int getWidth() {
    return 101;
  }
  
  public int getHeight() {
    return 86;
  }
  
  public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
    float f = 0.00390625F;
    float f1 = 0.00390625F;
    Tessellator tessellator = Tessellator.getInstance();
    WorldRenderer worldrenderer = tessellator.getWorldRenderer();
    worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
    worldrenderer.pos((x + 0), (y + height), this.zLevelFloat).tex(((textureX + 0) * f), ((textureY + height) * f1)).endVertex();
    worldrenderer.pos((x + width), (y + height), this.zLevelFloat).tex(((textureX + width) * f), ((textureY + height) * f1)).endVertex();
    worldrenderer.pos((x + width), (y + 0), this.zLevelFloat).tex(((textureX + width) * f), ((textureY + 0) * f1)).endVertex();
    worldrenderer.pos((x + 0), (y + 0), this.zLevelFloat).tex(((textureX + 0) * f), ((textureY + 0) * f1)).endVertex();
    tessellator.draw();
  }
  
  public void render(ScreenPosition pos) {
    int offsetX = 21;
    int offsetY = 14;
    int i = 80;
    int i2 = 16;
    Collection<PotionEffect> collection = this.mc.thePlayer.getActivePotionEffects();
    if (!collection.isEmpty()) {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.disableLighting();
      int l = 33;
      if (collection.size() > 5)
        l = 132 / (collection.size() - 1); 
      for (PotionEffect potioneffect : this.mc.thePlayer.getActivePotionEffects()) {
        Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        if (potion.hasStatusIcon()) {
          Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
          int i1 = potion.getStatusIconIndex();
          drawTexturedModalRect(pos.getAbsoluteX() + offsetX - 20, pos.getAbsoluteY() + i2 - offsetY, 0 + i1 % 8 * 18, 198 + i1 / 8 * 18, 18, 18);
        } 
        String s1 = I18n.format(potion.getName(), new Object[0]);
        if (potioneffect.getAmplifier() == 1) {
          s1 = s1 + " " + I18n.format("enchantment.level.2", new Object[0]);
        } else if (potioneffect.getAmplifier() == 2) {
          s1 = s1 + " " + I18n.format("enchantment.level.3", new Object[0]);
        } else if (potioneffect.getAmplifier() == 3) {
          s1 = s1 + " " + I18n.format("enchantment.level.4", new Object[0]);
        } 
        this.fr.drawString(s1, (pos.getAbsoluteX() + offsetX), (pos.getAbsoluteY() + i2 - offsetY), 16777215, true);
        String s = Potion.getDurationString(potioneffect);
        this.fr.drawString(s, (pos.getAbsoluteX() + offsetX), (pos.getAbsoluteY() + i2 + 10 - offsetY), 8355711, true);
        i2 += l;
      
     }
    } 
  }
  
  public void renderDummy(ScreenPosition pos) {
    int offsetX = 21;
    int offsetY = 14;
    int i = 80;
    int i2 = 16;
    PotionEffect[] potionEffects = { new PotionEffect(Potion.moveSpeed.id, 1200, 0), new PotionEffect(Potion.damageBoost.id, 1200, 0), new PotionEffect(Potion.fireResistance.id, 1200, 0) };
    int l = 33;
    if (potionEffects.length > 5)
      l = 132 / (potionEffects.length - 1); 
    for (PotionEffect potioneffect : potionEffects) {
      Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      if (potion.hasStatusIcon()) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
        int i1 = potion.getStatusIconIndex();
        drawTexturedModalRect(pos.getAbsoluteX() + offsetX - 20, pos.getAbsoluteY() + i2 - offsetY, 0 + i1 % 8 * 18, 198 + i1 / 8 * 18, 18, 18);
      } 
      String s1 = I18n.format(potion.getName(), new Object[0]);
      if (potioneffect.getAmplifier() == 1) {
        s1 = s1 + " " + I18n.format("enchantment.level.2", new Object[0]);
      } else if (potioneffect.getAmplifier() == 2) {
        s1 = s1 + " " + I18n.format("enchantment.level.3", new Object[0]);
      } else if (potioneffect.getAmplifier() == 3) {
        s1 = s1 + " " + I18n.format("enchantment.level.4", new Object[0]);
      } 
      this.fr.drawString(s1, (pos.getAbsoluteX() + offsetX), (pos.getAbsoluteY() + i2 - offsetY), 16777215, true);
      String s = Potion.getDurationString(potioneffect);
      this.fr.drawString(s, (pos.getAbsoluteX() + offsetX), (pos.getAbsoluteY() + i2 + 10 - offsetY), 8355711, true);
      i2 += l;
    } 
	  
  }
  
 
}
