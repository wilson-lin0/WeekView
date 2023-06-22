package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents a view with the theme.
 */
public abstract class ViewImpl implements View {
  protected FXMLLoader loader;

  /**
   * Creates a ThemeOneView.
   */
  public ViewImpl(Controller controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setController(controller);
  }

  /**
   * Loads the WeekView GUI layout.
   *
   * @return the layout
   */
  @Override
  public Scene load() {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
