package cs3500.pa05.controller;

import static cs3500.pa05.model.enumerations.Days.verifyDay;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.WeekView;
import cs3500.pa05.model.enumerations.Days;
import java.io.IOException;
import java.util.List;
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
  private CheckBox taskCompleteCheck;
  @FXML
  private Label warningLabel;
  @FXML
  private Button submitButton;
  @FXML
  private Button exitButton;

  /**
   * Creates an AddTaskController.
   *
   * @param weekView the WeekView
   * @param stage    the stage
   */
  public AddTaskController(WeekView weekView, Stage stage) {
    super(weekView, stage);
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
      completed = taskCompleteCheck.isSelected();
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
      updateTaskLabelList();
      this.taskCreationPopup.hide();
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
   * Updates the task label list.
   */
  private void updateTaskLabelList() {
    List<Task> tasks = this.weekView.returnTaskList();
    if (tasks.size() > 0) {
      Task task = tasks.get(tasks.size() - 1);
      Label label = new Label("Event: " + task.getName() + '\n' +
          "Description: " + task.getDescription() + '\n' +
          "Completed? " + task.isCompleted()
      );
      label.setFont(new Font(10));
      labellists.addTaskToList(label, task.getDayOfWeek());
    }
  }
}