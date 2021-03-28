package Client.Gui.hud;

public interface IRendererConfig {
  void save(ScreenPosition paramScreenPosition);
  
  ScreenPosition load();
}
