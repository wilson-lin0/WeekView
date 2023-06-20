package cs3500.pa05.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class ViewImpl implements View {
  FXMLLoader weekViewLoader;

  public ViewImpl () {
    this.weekViewLoader = new FXMLLoader();
    this.weekViewLoader.setLocation(getClass().getClassLoader().getResource("WeekView.fxml"));
  }

  @Override
  public Scene load() {
    try {
      return this.weekViewLoader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }

  public Scene chooseScene() {
    return null;
  }
}
