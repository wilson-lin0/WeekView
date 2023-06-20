package cs3500.pa05.controllerTests;

import cs3500.pa05.controller.AddTaskController;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.WeekView;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AddTaskControllerTest {

  private WeekView weekView;
  private Stage stage;
  private AddTaskControllerMock addTaskController;

  @BeforeEach
  void setUp() {
    weekView = mock(WeekView.class);
    stage = mock(Stage.class);
    addTaskController = new AddTaskControllerMock(weekView, stage);
  }

  @Test
  void run_SubmitButtonClicked_TaskAddedToWeekView() {
    // Create mock objects
    Popup taskCreationPopup = mock(Popup.class);
    TextField createTaskName = mock(TextField.class);
    TextField createTaskDescription = mock(TextField.class);
    TextField createTaskDay = mock(TextField.class);
    CheckBox taskCompletedCheck = mock(CheckBox.class);
    Button submitButton = mock(Button.class);
    Button exitButton = mock(Button.class);

    // Set mock objects in the controller
    addTaskController.setTaskCreationPopup(taskCreationPopup);
    addTaskController.setCreateTaskName(createTaskName);
    addTaskController.setCreateTaskDescription(createTaskDescription);
    addTaskController.setCreateTaskDay(createTaskDay);
    addTaskController.setTaskCompletedCheck(taskCompletedCheck);
    addTaskController.setSubmitButton(submitButton);
    addTaskController.setExitButton(exitButton);

    // Perform button click
    addTaskController.clickSubmitButton();

    // Verify that the task was added to the WeekView
    verify(weekView).updateTask(any(Task.class));
  }

  @Test
  void run_ExitButtonClicked_PopupHidden() {
    // Create mock objects
    Popup taskCreationPopup = mock(Popup.class);
    TextField createTaskName = mock(TextField.class);
    TextField createTaskDescription = mock(TextField.class);
    TextField createTaskDay = mock(TextField.class);
    CheckBox taskCompletedCheck = mock(CheckBox.class);
    Button submitButton = mock(Button.class);
    Button exitButton = mock(Button.class);

    // Set mock objects in the controller
    addTaskController.setTaskCreationPopup(taskCreationPopup);
    addTaskController.setCreateTaskName(createTaskName);
    addTaskController.setCreateTaskDescription(createTaskDescription);
    addTaskController.setCreateTaskDay(createTaskDay);
    addTaskController.setTaskCompletedCheck(taskCompletedCheck);
    addTaskController.setSubmitButton(submitButton);
    addTaskController.setExitButton(exitButton);

    // Perform button click
    addTaskController.clickExitButton();

    // Verify that the popup was hidden
    verify(taskCreationPopup).hide();
  }

  // Mock class that extends AddTaskController
  private static class AddTaskControllerMock extends AddTaskController {

    private Popup taskCreationPopup;
    private TextField createTaskName;
    private TextField createTaskDescription;
    private TextField createTaskDay;
    private CheckBox taskCompletedCheck;
    private Button submitButton;
    private Button exitButton;

    public AddTaskControllerMock(WeekView weekView, Stage stage) {
      super(weekView, stage);
    }

    public void setTaskCreationPopup(Popup taskCreationPopup) {
      this.taskCreationPopup = taskCreationPopup;
    }

    public void setCreateTaskName(TextField createTaskName) {
      this.createTaskName = createTaskName;
    }

    public void setCreateTaskDescription(TextField createTaskDescription) {
      this.createTaskDescription = createTaskDescription;
    }

    public void setCreateTaskDay(TextField createTaskDay) {
      this.createTaskDay = createTaskDay;
    }

    public void setTaskCompletedCheck(CheckBox taskCompletedCheck) {
      this.taskCompletedCheck = taskCompletedCheck;
    }

    public void setSubmitButton(Button submitButton) {
      this.submitButton = submitButton;
    }

    public void setExitButton(Button exitButton) {
      this.exitButton = exitButton;
    }

    public void clickSubmitButton() {
      submitButton.fire();
    }

    public void clickExitButton() {
      exitButton.fire();
    }
  }
}
