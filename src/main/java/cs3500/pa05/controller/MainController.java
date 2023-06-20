package cs3500.pa05.controller;

import cs3500.pa05.model.WeekView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controls the program.
 */
public class MainController extends AbstractController {
  @FXML
  private Button addEventButton;
  @FXML
  private Button addTaskButton;
  @FXML
  private Button saveToFileButton;
  @FXML
  private Button openFileButton;
  @FXML
  private Button eventTaskLimitButton;

  /**
   * Creates a MainController.
   *
   * @param weekView the WeekView
   */
  public MainController(WeekView weekView) {
    super(weekView);
  }

  /**
   * Runs the program.
   */
  @Override
  public void run() {
    Boolean maxTask;
    Boolean maxEvent;
    if (this.weekView.returnEventList().size() < this.weekView.returnMaxEvent()) {
      maxEvent = true;
    } else {
      maxEvent = false;
      // TextField updates to state exceed max task
    }

    if (this.weekView.returnTaskList().size() < this.weekView.returnMaxTask()) {
      maxTask = true;
    } else {
      maxTask = false;
      // TextField updates to state exceed max events
    }

    while (maxEvent = true) {
      this.addEventButton.setOnAction(event -> new AddEventController(weekView).run());
    }

    while (maxTask = true) {
      this.addTaskButton.setOnAction(event -> new AddTaskController(weekView).run());
    }

    // change saveToFileButton -> on event, call this.weekView.saveFile(Path.of(TextField.get()).toFile()
    // this.saveToFileButton.setOnAction(event -> )
    // same as saveToFileButton
    // this.openFileButton.setOnAction(event -> )
    this.eventTaskLimitButton.setOnAction(event -> new MaximumEventTaskController(weekView).run());
  }
}
