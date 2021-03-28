package Client.mods.util;


import Client.Gui.hud.ScreenPosition;
import Client.mods.ModDraggable;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class ModArmourStatus extends ModDraggable {
  
  public int getWidth() {
    return 40;
  }
  
  public int getHeight() {
    return 60;
  }
  
  public void render(ScreenPosition pos) {
	 
    for (int i = 0; i < this.mc.thePlayer.inventory.armorInventory.length; i++) {
      ItemStack itemStack = this.mc.thePlayer.inventory.armorInventory[i];
      renderItemStack(pos, i, itemStack);
     
    } 
  }
  
  public void renderDummy(ScreenPosition pos) {
    renderItemStack(pos, 3, new ItemStack((Item)Items.diamond_helmet));
    renderItemStack(pos, 2, new ItemStack((Item)Items.diamond_chestplate));
    renderItemStack(pos, 1, new ItemStack((Item)Items.diamond_leggings));
    renderItemStack(pos, 0, new ItemStack((Item)Items.diamond_boots));
	  
  }
  
  private void renderItemStack(ScreenPosition pos, int i, ItemStack itemStack) {
    if (itemStack == null)
      return; 
    GlStateManager.pushMatrix();
    int yAdd = -16 * i + 48;
    if (itemStack.getItem().isDamageable())
      this.fr.drawStringWithShadow(String.valueOf(itemStack.getMaxDamage() - itemStack.getItemDamage()), (pos.getAbsoluteX() + 20), (pos.getAbsoluteY() + yAdd + 5), -1); 
    RenderHelper.enableGUIStandardItemLighting();
    this.mc.getRenderItem().renderItemAndEffectIntoGUI(itemStack, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
    GlStateManager.popMatrix();
  }
  

}