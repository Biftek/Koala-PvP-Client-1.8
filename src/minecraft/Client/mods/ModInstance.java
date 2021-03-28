package Client.mods;

import Client.ModToggle;
import Client.Gui.hud.HUDManager;
import Client.mods.util.ModArmourStatus;
import Client.mods.util.ModCPS;
import Client.mods.util.ModCoordinates;
import Client.mods.util.ModDirection;
import Client.mods.util.ModFPS;
import Client.mods.util.ModKeystrokes;
import Client.mods.util.ModMLDGHelper;
import Client.mods.util.ModPotionsStatus;
import Client.mods.util.ModTime;

public class ModInstance {

	public static ModFPS modFPS;
	public static ModCPS modCPS;
	public static ModPotionsStatus modPotionsStatus;
	public static ModArmourStatus modArmourStatus;
	public static ModCoordinates modCoordiantes;
	public static ModDirection modDirection;
	public static ModKeystrokes modKeystrokes;
	public static ModMLDGHelper modMLGHelper;
	public static ModTime modTIME;

  
  public static void register(HUDManager api) {
   if (ModToggle.loadEnabledFromFile("ModFPS") == true) {  
	   modFPS = new ModFPS();
   api.register(modFPS);
   }
   
   if (ModToggle.loadEnabledFromFile("ModTime") == true) {  
	   modTIME = new ModTime();
   api.register(modTIME);
   }
   
   if (ModToggle.loadEnabledFromFile("ModCPS") == true) {  
	   modCPS = new ModCPS();
   api.register(modCPS);
   }
   
   if (ModToggle.loadEnabledFromFile("ModPotionStatus") == true) {  
	   modPotionsStatus = new ModPotionsStatus();
   api.register(modPotionsStatus);
   }
   
   if (ModToggle.loadEnabledFromFile("ModArmorStatus") == true) {  
	   modArmourStatus = new ModArmourStatus();
   api.register(modArmourStatus);
   }
   
   if (ModToggle.loadEnabledFromFile("ModXYZ") == true) {  
	   modCoordiantes = new ModCoordinates();
   api.register(modCoordiantes);
   }
   
   if (ModToggle.loadEnabledFromFile("ModDirection") == true) {  
	   modDirection = new ModDirection();
   api.register(modDirection);
   }
   
   if (ModToggle.loadEnabledFromFile("ModKeystrokes") == true) {  
	   modKeystrokes = new ModKeystrokes();
   api.register(modKeystrokes);
   }
   
   if (ModToggle.loadEnabledFromFile("ModMLGHelper") == true) {  
	   modMLGHelper = new ModMLDGHelper();
   api.register(modMLGHelper);
   }
   

	
  }
  
  public static ModFPS getModFPS() {
	  return modFPS;
  }
  
  public static ModTime getModTIME() {
	  return modTIME;
  }
  
  public static ModMLDGHelper getModMLGHelper() {
	  return modMLGHelper;
  }
  
  public static ModCoordinates getModCoordinates() {
	  return modCoordiantes;
  }
  
  public static ModPotionsStatus getModPotionsStatus() {
	  return modPotionsStatus;
  }
  
  public static ModCPS getModCPS() {
	  return modCPS;
  }
  
  public static ModArmourStatus getModArmourStatus() {
	  return modArmourStatus;
  }
  
  public static ModDirection getModDirection() {
	  return modDirection;
  }
  
  public static ModKeystrokes getModKeystrokes() {
	  return modKeystrokes;
  }
  
  


}
