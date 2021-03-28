package Client;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import Client.Events.EventManager;
import Client.Gui.GuiClientMenu;
import Client.Gui.hud.HUDManager;
import Client.ModEveryLook.KeyEvent;
import Client.mods.ModInstance;
import net.minecraft.client.ClientTickEvent;
import net.minecraft.client.Minecraft;

public class Client {
	
	public static  boolean XYZ = ModToggle.loadEnabledFromFile("ModXYZ");
	public static boolean NAMETAG = ModToggle.loadEnabledFromFile("ModHearts");
	public static boolean Keystrokes = ModToggle.loadEnabledFromFile("ModKeystrokes");
	public static boolean Fullbright = ModToggle.loadEnabledFromFile("ModFullbright");
	public static boolean FPS = ModToggle.loadEnabledFromFile("ModFPS");
	public static boolean CPS = ModToggle.loadEnabledFromFile("ModCPS");
	public static String Client_Name = "KOALA CLIENT";
	public static String Client_Version = "1.0";
	
	public static boolean CosmeticWings = ModToggle.loadEnabledFromFile("ModWings");
	public static boolean CosmeticWitchHat = ModToggle.loadEnabledFromFile("ModWithHat");
	public static boolean CosmeticCape = ModToggle.loadEnabledFromFile("ModCape");
	public static  boolean CosmeticCape2 = ModToggle.loadEnabledFromFile("ModCape2");
	public static boolean IngameZoom = ModToggle.loadEnabledFromFile("ModIngameZoom");

	private static boolean IsKeyDown = false;
	private static int savedFOV = 0;
	public static boolean Blockhit = ModToggle.loadEnabledFromFile("ModBlockhit");
	public static boolean EatDrink = ModToggle.loadEnabledFromFile("ModEatandDrink");
	public static boolean Bow = ModToggle.loadEnabledFromFile("ModBow");
	private static final Client INSTANCE = new Client();
	public static boolean Susanoo = ModToggle.loadEnabledFromFile("ModSusanoo");
	public static boolean BlockOverlay = ModToggle.loadEnabledFromFile("ModBlockOverlay");
	public static boolean CompactChat = ModToggle.loadEnabledFromFile("ModCompactChat");
	public static boolean Sunglasses = ModToggle.loadEnabledFromFile("ModSunglasses");
	public static  boolean CosmeticEasterEggs = ModToggle.loadEnabledFromFile("ModEasterEggs");
	public static boolean ArmorStatus = ModToggle.loadEnabledFromFile("ModArmorStatus");
	public static boolean PotionEffekt = ModToggle.loadEnabledFromFile("ModPotionStatus");
	public static boolean NAMETAG2 = ModToggle.loadEnabledFromFile("ModNameTags");
	public static boolean Health = ModToggle.loadEnabledFromFile("ModHealth");
	public static boolean  Biome = true;
	public static boolean ping = ModToggle.loadEnabledFromFile("ModPing");
	public static boolean togglesprint = ModToggle.loadEnabledFromFile("ModToggleSprint");
	public static boolean strafe;
	  private static float cameraYaw = 0F;
	  private static float cameraPitch = 0F;
	  private static int previousePrespective = 0;
	  private static boolean perspectiveToggled = false;
	  public static boolean returnOnRelease = true;
		public static boolean toggleperspective = ModToggle.loadEnabledFromFile("ModTogglePerspective");
		public static boolean direction = ModToggle.loadEnabledFromFile("ModDirection");
		public static boolean mlghelper = ModToggle.loadEnabledFromFile("ModMLGHelper");
		public static boolean buttonstyle = ModToggle.loadEnabledFromFile("ModButtonStyle");
		public static boolean time = ModToggle.loadEnabledFromFile("ModTime");
		
		private static DiscordRP discordRP = new DiscordRP();
		
		private HUDManager hudManager;
		
	public static final Client getInstance() {
		return INSTANCE;
		
		
	}

	
	public void init() {
		discordRP.start();
	EventManager.register(this);
	FileManager.init();
	}
	
	
	@EventTarget
	public void onTick(ClientTickEvent e) {
		if(Minecraft.getMinecraft().gameSettings.CLIENT_OPENSETTINGS.isKeyDown()) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiClientMenu(this));
		}
		if(Minecraft.getMinecraft().gameSettings.OPEN_HUD.isPressed()) {
			hudManager.openConfigScreen();
		}
		
		
	}
	
	 @EventTarget
	 public void keyboardEvent(KeyEvent e) {
		 if(this.toggleperspective) {
		 Minecraft mc = Minecraft.getMinecraft();
		 if(e.getKey() == mc.gameSettings.CLIENT_PERSPECTIVE.getKeyCode()) {
		    	
		    	if(Keyboard.getEventKeyState())
		    	{
		    		perspectiveToggled = !perspectiveToggled;
		    		
		    		cameraYaw = mc.thePlayer.rotationYaw;
		    		cameraPitch = mc.thePlayer.rotationPitch;
		    		
		    		if(perspectiveToggled) {
		    			previousePrespective = mc.gameSettings.thirdPersonView;
		    			mc.gameSettings.thirdPersonView = 1;
		    		}
		    		else {
		    			mc.gameSettings.thirdPersonView = previousePrespective;
		    		}
		    	}
		    	
		    	else if(returnOnRelease){
		    		perspectiveToggled = false;
		    		mc.gameSettings.thirdPersonView = previousePrespective;
		    		
		    	}
		    }
		 if(Keyboard.getEventKey() == mc.gameSettings.keyBindTogglePerspective.getKeyCode()) {
			 perspectiveToggled = false;
		 }
		 }
		 
	 }
	 
	 public static float getCameraYaw() {
		 Minecraft mc = Minecraft.getMinecraft();
			return perspectiveToggled ? cameraYaw : mc.thePlayer.rotationYaw;
		}
		
		public static float getCameraPitch() {
			 Minecraft mc = Minecraft.getMinecraft();
			return perspectiveToggled ? cameraPitch : mc.thePlayer.rotationPitch;
		}
		
		public static boolean overriderMouse() {
			 Minecraft mc = Minecraft.getMinecraft();
			if(mc.inGameHasFocus && Display.isActive()) {
				
				if(!perspectiveToggled) {
					return true;
				}
				
				mc.mouseHelper.mouseXYChange();
				float f1 = mc.gameSettings.mouseSensitivity * 0.6F + 0.2F;
				float f2 = f1 * f1 * f1 * 8.0F;
				float f3 = (float) mc.mouseHelper.deltaX * f2;
				float f4 = (float) mc.mouseHelper.deltaY * f2;
				
				cameraYaw += f3 * 0.15F;
				cameraPitch += f4 * 0.15F;
				
				if (cameraPitch > 90) cameraPitch = 90;
				if (cameraPitch < -90) cameraPitch = -90;
						
						
			}
			return false;
			
		}
		
		public static void shutdown() {
			discordRP.shoutdown();
		}
	
	public void start() {
		DatabaseUtil.parseData();
		hudManager = HUDManager.getInstance();
		ModInstance.register(hudManager);
	}
	
	public static DiscordRP getDiscordRP() {
		return discordRP;
	}
	
	
	
}
