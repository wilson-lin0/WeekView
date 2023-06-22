package cs3500.pa05.controller;

import static java.lang.Integer.parseInt;

import cs3500.pa05.model.WeekView;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Controls the MaximumEventsTasks FXML.
 */
public class MaximumEventTaskController extends AbstractController {
  protected Popup maximumPopup;
  @FXML
  private TextField eventLimitTextBox;
  @FXML
  private TextField taskLimitTextBox;
  @FXML
  private Button eventLimitButton;
  @FXML
  private Button taskLimitButton;
  @FXML
  private Button exitLimitButton;


  /**
   * Creates a MaximumEventTaskController.
   *
   * @param weekView the WeekView
   * @param stage the stage
   */
  public MaximumEventTaskController(WeekView weekView, Stage stage) {
    super(weekView, stage);
  }

  /**
   * Runs the program (sets a maximum number of Events and Tasks).
   */
  @Override
  public void run() {
    this.maximumPopup = new Popup();

    try {
      FXMLLoader taskLoader = new FXMLLoader(getClass().getClassLoader().getResource(
          "Maximum-Events-Tasks.fxml"));
      taskLoader.setController(this);
      Scene createTaskScene = taskLoader.load();
      maximumPopup.getContent().add(createTaskScene.getRoot());
      this.maximumPopup.show(this.stage);
    } catch (IOException e) {
      e.printStackTrace();
    }

    this.eventLimitButton.setOnAction(event ->
        weekView.setMaxEvent(parseInt(this.eventLimitTextBox.getText())));
    this.taskLimitButton.setOnAction(event ->
        weekView.setMaxTask(parseInt(this.taskLimitTextBox.getText())));
    this.exitLimitButton.setOnAction(event -> {
      this.maximumPopup.hide();
    });
  }
}
