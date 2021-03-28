package Client.ModEveryLook;

import Client.Events.EventCancelable;

public class KeyEvent extends EventCancelable{
	
	private final int key;
	
	public KeyEvent(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}

}
