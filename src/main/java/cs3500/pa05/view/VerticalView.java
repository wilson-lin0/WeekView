package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public abstract class VerticalView extends AbstractView {
  protected FXMLLoader loader;

  /**
   * Creates a ThemeOneView.
   */
  public VerticalView(Controller controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("WeekView.fxml"));
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