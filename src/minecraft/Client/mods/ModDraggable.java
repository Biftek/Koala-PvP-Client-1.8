package Client.mods;

import java.io.File;

import Client.FileManager;
import Client.Gui.hud.IRenderer;
import Client.Gui.hud.ScreenPosition;


public abstract class ModDraggable extends Mod implements IRenderer {
	
	protected ScreenPosition pos;
	
	
	public ModDraggable() {
		pos = loadPositionFromFile();
	}
	private ScreenPosition loadPositionFromFile() {
		ScreenPosition loaded = FileManager.readFromJson(new File(getFolder(), "pos.json"), ScreenPosition.class);
		
		if(loaded == null) {
			loaded = ScreenPosition.fromRelativePosition(0.5, 0.5);
			this.pos = loaded;
			savePositionToFile();
		}
		
		return loaded;
	}
	
	public void savePositionToFile() {
	FileManager.writeJsonToFile(new File(getFolder(), "pos.json"), pos);
	}
	
	private File getFolder() {
		File file = new  File(FileManager.getModsDirectory(), this.getClass().getSimpleName());
		file.mkdirs();
		return file;
	}
	
	@Override
	public ScreenPosition load() {
		
		return pos;
	}
	
	@Override
	public void save(ScreenPosition pos) {
		this.pos = pos;
		savePositionToFile();
	}
	
	
public final int getLineOffset(ScreenPosition pos, int lineNumber) {
    return pos.getAbsoluteY() + getLineOffset(lineNumber);
  }
  
  private int getLineOffset(int lineNumber) {
    return (fr.FONT_HEIGHT + 3) * lineNumber;
  }
}
