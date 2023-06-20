package cs3500.pa05.controller;

import cs3500.pa05.model.WeekView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
   * @param stage    the stage
   */
  public MainController(WeekView weekView, Stage stage) {
    super(weekView, stage);
  }

  /**
   * Runs the program.
   */
  @Override
  public void run() {
    this.addEventButton.setOnAction(event -> {
      addEvent();
    });
    this.addTaskButton.setOnAction((event -> {
      addTask();
    }));
    this.eventTaskLimitButton.setOnAction(event -> {
      setLimit();
    });

    // change saveToFileButton -> on event, call this.weekView.saveFile(Path.of(TextField.get()).toFile()
    // this.saveToFileButton.setOnAction(event -> )
    // same as saveToFileButton
    // this.openFileButton.setOnAction(event -> )
  }

  private void addEvent() {
    new AddEventController(this.weekView, this.stage).run();
  }

  private void addTask() {
    new AddTaskController(this.weekView, this.stage).run();
  }

  private void setLimit() {
    new MaximumEventTaskController(this.weekView, this.stage).run();
  }
}
