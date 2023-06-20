package cs3500.pa05.controller;

import static cs3500.pa05.enumerations.Days.getDay;

import cs3500.pa05.model.Task;
import cs3500.pa05.model.WeekView;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * Controls the AddTask FXML.
 */
public class AddTaskController extends AbstractController {
  @FXML
  private TextField createTaskName;
  @FXML
  private TextField createTaskDescription;
  @FXML
  private TextField createTaskDay;
  @FXML
  private CheckBox taskCompletedCheck;

  /**
   * Creates an AddTaskController.
   *
   * @param weekView the WeekView
   */
  public AddTaskController(WeekView weekView) {
    super(weekView);
  }

  /**
   * Runs the program (adds a Task to the WeekView).
   */
  @Override
  public void run() {
    weekView.updateTask(new Task(this.createTaskName.getText(),
            this.createTaskDescription.getText(), getDay(this.createTaskDay.getText().charAt(0))));
  }
}
