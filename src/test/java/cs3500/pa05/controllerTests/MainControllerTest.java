package cs3500.pa05.controllerTests;

import cs3500.pa05.controller.MainController;
import cs3500.pa05.model.WeekView;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class MainControllerTest {

  private WeekView weekView;
  private Stage stage;
  private MainControllerMock mainController;

  @BeforeEach
  void setUp() {
    weekView = mock(WeekView.class);
    stage = mock(Stage.class);
    mainController = new MainControllerMock(weekView, stage);
  }

  @Test
  void run_AddEventButtonClicked_AddEventControllerRunCalled() {
    // Create mock objects
    Button addEventButton = mock(Button.class);

    // Set mock objects in the controller
    mainController.setAddEventButton(addEventButton);

    // Perform button click
    mainController.clickAddEventButton();

    // Verify that AddEventController.run() was called
    verify(mainController).addEvent();
  }

  @Test
  void run_AddTaskButtonClicked_AddTaskControllerRunCalled() {
    // Create mock objects
    Button addTaskButton = mock(Button.class);

    // Set mock objects in the controller
    mainController.setAddTaskButton(addTaskButton);

    // Perform button click
    mainController.clickAddTaskButton();

    // Verify that AddTaskController.run() was called
    verify(mainController).addTask();
  }

  @Test
  void run_EventTaskLimitButtonClicked_MaximumEventTaskControllerRunCalled() {
    // Create mock objects
    Button eventTaskLimitButton = mock(Button.class);

    // Set mock objects in the controller
    mainController.setEventTaskLimitButton(eventTaskLimitButton);

    // Perform button click
    mainController.clickEventTaskLimitButton();

    // Verify that MaximumEventTaskController.run() was called
    verify(mainController).setLimit();
  }

  // Mock class that extends MainController
  private static class MainControllerMock extends MainController {

    private Button addEventButton;
    private Button addTaskButton;
    private Button saveToFileButton;
    private Button openFileButton;
    private Button eventTaskLimitButton;

    public MainControllerMock(WeekView weekView, Stage stage) {
      super(weekView, stage);
    }

    public void setAddEventButton(Button addEventButton) {
      this.addEventButton = addEventButton;
    }

    public void setAddTaskButton(Button addTaskButton) {
      this.addTaskButton = addTaskButton;
    }

    public void setSaveToFileButton(Button saveToFileButton) {
      this.saveToFileButton = saveToFileButton;
    }

    public void setOpenFileButton(Button openFileButton) {
      this.openFileButton = openFileButton;
    }

    public void setEventTaskLimitButton(Button eventTaskLimitButton) {
      this.eventTaskLimitButton = eventTaskLimitButton;
    }

    public void clickAddEventButton() {
      addEventButton.fire();
    }

    public void clickAddTaskButton() {
      addTaskButton.fire();
    }

    public void clickSaveToFileButton() {
      saveToFileButton.fire();
    }

    public void clickOpenFileButton() {
      openFileButton.fire();
    }

    public void clickEventTaskLimitButton() {
      eventTaskLimitButton.fire();
    }
  }
}
