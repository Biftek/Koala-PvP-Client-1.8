package Client.mods;

import Client.Client;
import Client.Events.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Mod {
	
	public boolean isEnabled = true;
	
	protected final Minecraft mc;
	protected final FontRenderer fr;
	protected final Client client;
	
	public Mod() {
		this.mc = Minecraft.getMinecraft();
		this.fr = this.mc.fontRendererObj;
		this.client = Client.getInstance();
		
		setEnabled(isEnabled);
	}
	
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
		
		if(isEnabled) {
			EventManager.register(this);
		}else {
			EventManager.unregister(this);
		}
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}

}
