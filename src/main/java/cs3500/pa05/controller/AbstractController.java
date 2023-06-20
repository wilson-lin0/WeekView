package cs3500.pa05.controller;

import cs3500.pa05.model.WeekView;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * Controls the flow of the program.
 */
public abstract class AbstractController implements Controller {
  protected WeekView weekView;
  protected Stage stage;

  /**
   * Creates a Controller.
   *
   * @param weekView the WeekView
   * @throws IOException if popups fail to load
   */
  public AbstractController(WeekView weekView, Stage stage) {
    this.weekView = weekView;
    this.stage = stage;
  }

  /**
   * Runs the program.
   */
  @Override
  public abstract void run();

  /**
   * Shows the events in the WeekView.
   */
  public void showEvent() {
    // for (Event event : weekView.returnEventList()) {}
    // create new ... and when clicked, can edit
  }

  /**
   * Shows the tasks in the WeekView.
   */
  public void showTask() {
    // for (Task task : weekView.returnTaskList()) {}
    // creat new ... and when clicked, can edit
  }
}
