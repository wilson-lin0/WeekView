package cs3500.pa05.controller;

import static cs3500.pa05.model.enumerations.Days.getDay;

import cs3500.pa05.model.Task;
import cs3500.pa05.model.WeekView;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Controls the AddTask FXML.
 */
public class AddTaskController extends AbstractController {
  protected Popup taskCreationPopup;
  @FXML
  private TextField createTaskName;
  @FXML
  private TextField createTaskDescription;
  @FXML
  private TextField createTaskDay;
  @FXML
  private CheckBox taskCompletedCheck;
  @FXML
  private Button submitButton;
  @FXML
  private Button exitButton;

  /**
   * Creates an AddTaskController.
   *
   * @param weekView the WeekView
   * @param stage the stage
   */
  public AddTaskController(WeekView weekView, Stage stage) {
    super(weekView, stage);
  }

  /**
   * Runs the program (adds a Task to the WeekView).
   */
  @Override
  public void run() {
    try {
      this.taskCreationPopup = new Popup();
      FXMLLoader taskLoader = new FXMLLoader(getClass().getClassLoader().getResource(
          "AddTask.fxml"));
      taskLoader.setController(this);
      Scene createTaskScene = taskLoader.load();
      taskCreationPopup.getContent().add(createTaskScene.getRoot());
      this.taskCreationPopup.show(this.stage);
    } catch (IOException e) {
      e.printStackTrace();
    }

    this.submitButton.setOnAction(event -> {
      weekView.updateTask(new Task(
          this.createTaskName.getText(),
          this.createTaskDescription.getText(),
          getDay(this.createTaskDay.getText().charAt(0))
      ));
    });

    this.exitButton.setOnAction(event -> {
      this.taskCreationPopup.hide();
    });
  }
}
