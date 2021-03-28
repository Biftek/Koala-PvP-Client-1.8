package Client.FeaturedServer;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.ResourceLocation;

public class ServerDataFeatured extends ServerData{
	
	public static final ResourceLocation ICON = new ResourceLocation("star.png");

	public ServerDataFeatured(String serverName, String serverIP) {
		super(serverName, serverIP, false);
	}

}
