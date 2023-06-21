package cs3500.pa05.controller;

import static cs3500.pa05.model.enumerations.Days.verifyDay;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.WeekView;
import cs3500.pa05.model.enumerations.Days;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
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
  private Label warningLabel;
  @FXML
  private Button submitButton;
  @FXML
  private Button exitButton;
  @FXML
  protected HBox sundayBox;
  @FXML
  protected HBox mondayBox;
  @FXML
  protected HBox tuesdayBox;
  @FXML
  protected HBox wednesdayBox;
  @FXML
  protected HBox thursdayBox;
  @FXML
  protected HBox fridayBox;
  @FXML
  protected HBox saturdayBox;

  /**
   * Creates an AddTaskController.
   *
   * @param weekView the WeekView
   * @param stage    the stage
   */
  public AddTaskController(WeekView weekView, Stage stage, HBox sundayBox, HBox mondayBox,
                           HBox tuesdayBox, HBox wednesdayBox, HBox thursdayBox,
                           HBox fridayBox, HBox saturdayBox) {
    super(weekView, stage);
    this.sundayBox = sundayBox;
    this.mondayBox = mondayBox;
    this.tuesdayBox = tuesdayBox;
    this.wednesdayBox = wednesdayBox;
    this.thursdayBox = thursdayBox;
    this.fridayBox = fridayBox;
    this.saturdayBox = saturdayBox;
  }

  /**
   * Runs the program (adds a Task to the WeekView).
   */
  @Override
  public void run() {
    this.taskCreationPopup = new Popup();
    try {
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
      addTask();
    });

    this.exitButton.setOnAction(event -> {
      this.taskCreationPopup.hide();
    });
  }


  /**
   * Adds a task.
   */
  private void addTask() {
    String taskName = null;
    String description = null;
    Days day = null;
    boolean completed = false;

    boolean canContinue = canContinue();

    try {
      taskName = createTaskName.getText();
      day = verifyDay(this.createTaskDay.getText());
      if (day.equals(Days.INVALID)) {
        warningLabel.setText("You entered an invalid day");
        canContinue = false;
      }
      completed = taskCompletedCheck.isSelected();
    } catch (NullPointerException n) {
      warningLabel.setText("You left a required field empty!");
      canContinue = false;
    }

    try {
      description = createTaskDescription.getText();
    } catch (NullPointerException n) {
      // it is okay to not have a description
    }

    if (canContinue) {
      weekView.updateTask(new Task(taskName, description, day, completed));
      showTask();
    }
  }

  /**
   * Returns true if you can add a task.
   *
   * @return true if you can add a task
   */
  private boolean canContinue() {
    if (this.weekView.hasMaximumTasks()) {
      if (this.weekView.returnTaskList().size() < this.weekView.returnMaxTask()) {
        return true;
      } else {
        warningLabel.setText("You have reached the maximum amount of tasks: " +
            this.weekView.returnMaxTask());
        return false;
      }
    } else {
      return true;
    }
  }

  /**
   * Shows the tasks in the WeekView.
   */
  public void showTask() {
    updateTaskLabelList();
    sundayBox.getChildren().clear(); // Clear existing children
    sundayBox.getChildren().addAll(labellists.getSundayTaskList());
    sundayBox.setAlignment(Pos.CENTER_LEFT);

    mondayBox.getChildren().clear(); // Clear existing children
    mondayBox.getChildren().addAll(labellists.getMondayTaskList());
    mondayBox.setAlignment(Pos.CENTER_LEFT);

    tuesdayBox.getChildren().clear(); // Clear existing children
    tuesdayBox.getChildren().addAll(labellists.getTuesdayTaskList());
    tuesdayBox.setAlignment(Pos.CENTER_LEFT);

    wednesdayBox.getChildren().clear(); // Clear existing children
    wednesdayBox.getChildren().addAll(labellists.getWednesdayTaskList());
    wednesdayBox.setAlignment(Pos.CENTER_LEFT);

    thursdayBox.getChildren().clear(); // Clear existing children
    thursdayBox.getChildren().addAll(labellists.getThursdayTaskList());
    thursdayBox.setAlignment(Pos.CENTER_LEFT);

    fridayBox.getChildren().clear(); // Clear existing children
    fridayBox.getChildren().addAll(labellists.getFridayTaskList());
    fridayBox.setAlignment(Pos.CENTER_LEFT);

    saturdayBox.getChildren().clear(); // Clear existing children
    saturdayBox.getChildren().addAll(labellists.getSaturdayTaskList());
    saturdayBox.setAlignment(Pos.CENTER_LEFT);
  }

  /**
   * Updates the task label list.
   */
  private void updateTaskLabelList() {
    Task task = this.weekView.returnTaskList().get(weekView.returnTaskList().size() - 1);
    Label label = new Label("Event: " + task.getName() + '\n' +
        "Description: " + task.getDescription() + '\n' +
        "Completed? " + task.isCompleted()
    );
    label.setFont(new Font(10));
    labellists.addTaskToList(label, task.getDayOfWeek());
  }
}