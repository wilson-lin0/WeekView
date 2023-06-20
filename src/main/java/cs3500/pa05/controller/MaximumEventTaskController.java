package cs3500.pa05.controller;

import static java.lang.Integer.parseInt;

import cs3500.pa05.model.WeekView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controls the MaximumEventsTasks FXML.
 */
public class MaximumEventTaskController extends AbstractController {
  @FXML
  private TextField eventTextBox;
  @FXML
  private TextField taskTextBox;

  /**
   * Creates a MaximumEventTaskController.
   *
   * @param weekView the WeekView
   */
  public MaximumEventTaskController(WeekView weekView) {
    super(weekView);
  }

  /**
   * Runs the program (sets a maximum number of Events and Tasks).
   */
  @Override
  public void run() {
    this.eventTextBox.setOnAction(event ->
        weekView.setMaxEvent(parseInt(this.eventTextBox.getText())));
    this.taskTextBox.setOnAction(event ->
        weekView.setMaxTask(parseInt(this.taskTextBox.getText())));
  }
}
