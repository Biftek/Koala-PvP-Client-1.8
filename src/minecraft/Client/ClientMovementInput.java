package Client;

import java.text.DecimalFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.potion.Potion;
import net.minecraft.util.MovementInput;

public class ClientMovementInput extends MovementInput {
  public static boolean sprint = false;
  
  private GameSettings gameSettings;
  
  private int sneakWasPressed = 0;
  
  private int sprintWasPressed = 0;
  
  private EntityPlayerSP player;
  
  private float originalFlySpeed = -1.0F;
  
  private float boostedFlySpeed = 1.0F;
  
  private Minecraft mc;
  
  public boolean flyBoost = false;
  
  public float flyBoostFactor = 1.0F;
  
  public int keyHoldTicks = 7;
  
  public boolean shiftToggled = false;
  
  public ClientMovementInput(GameSettings gameSettings) {
    this.gameSettings = gameSettings;
    this.mc = Minecraft.getMinecraft();
  }
  
  public void updatePlayerMoveState() {
    this.player = this.mc.thePlayer;
    this.moveStrafe = 0.0F;
    this.moveForward = 0.0F;
    if (this.gameSettings.keyBindForward.isKeyDown())
      this.moveForward++; 
    if (this.gameSettings.keyBindBack.isKeyDown())
      this.moveForward--; 
    if (this.gameSettings.keyBindLeft.isKeyDown())
      this.moveStrafe++; 
    if (this.gameSettings.keyBindRight.isKeyDown())
      this.moveStrafe--; 
    this.jump = this.gameSettings.keyBindJump.isKeyDown();
    this.sneak = this.gameSettings.keyBindSneak.isKeyDown();
    if (this.sneak) {
      this.moveStrafe *= 0.3F;
      this.moveForward *= 0.3F;
    } 
    if (this.gameSettings.keyBindSprint.isKeyDown()) {
      if (this.sprintWasPressed == 0) {
        if (sprint) {
          this.sprintWasPressed = -1;
        } else if (this.player.capabilities.isFlying) {
          this.sprintWasPressed = this.keyHoldTicks + 1;
        } else {
          this.sprintWasPressed = 1;
        } 
        sprint = !sprint;
      } else if (this.sprintWasPressed > 0) {
        this.sprintWasPressed++;
      } 
    } else {
      if (this.keyHoldTicks > 0 && this.sprintWasPressed > this.keyHoldTicks)
        sprint = false; 
      this.sprintWasPressed = 0;
    } 
    if(Client.togglesprint) {
    	   if (this.moveForward == 1.0F && this.player.onGround && !this.player.isUsingItem() && !this.player.isPotionActive(Potion.blindness))
    		      this.player.setSprinting(true); 
    }else {
    	  if (sprint && this.moveForward == 1.0F && this.player.onGround && !this.player.isUsingItem() && !this.player.isPotionActive(Potion.blindness))
    	      this.player.setSprinting(true); 	
    }
    if (this.flyBoost && this.player.capabilities.isCreativeMode && this.player.capabilities.isFlying && this.mc.getRenderViewEntity() == this.player && sprint) {
      if (this.originalFlySpeed < 0.0F || this.player.capabilities.getFlySpeed() != this.boostedFlySpeed)
        this.originalFlySpeed = this.player.capabilities.getFlySpeed(); 
      this.boostedFlySpeed = this.originalFlySpeed * this.flyBoostFactor;
      this.player.capabilities.setFlySpeed(this.boostedFlySpeed);
      if (this.sneak)
        this.player.motionY -= 0.15D * (this.flyBoostFactor - 1.0F); 
      if (this.jump)
        this.player.motionY += 0.15D * (this.flyBoostFactor - 1.0F); 
    } else {
      if (this.player.capabilities.getFlySpeed() == this.boostedFlySpeed)
        this.player.capabilities.setFlySpeed(this.originalFlySpeed); 
      this.originalFlySpeed = -1.0F;
    } 
  }
  
  private static final DecimalFormat df = new DecimalFormat("#.0");
  
}
