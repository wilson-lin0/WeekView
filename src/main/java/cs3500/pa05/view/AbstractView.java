package cs3500.pa05.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * To represent a view.
 */
public abstract class AbstractView implements View {
  protected FXMLLoader weekViewLoader;

  /**
   * Creates a view.
   */
  public AbstractView() {
    this.weekViewLoader = new FXMLLoader();
  }

  /**
   * Loads the scene.
   *
   * @return the scene
   */
  @Override
  public Scene load() {
    try {
      return this.weekViewLoader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
