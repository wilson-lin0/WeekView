package cs3500.pa05.controller;

import static cs3500.pa05.model.enumerations.Days.verifyDay;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.WeekView;
import cs3500.pa05.model.enumerations.Days;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
  @FXML
  private Button verticalHorizontalButton;
  @FXML
  private Button quoteButton;
  @FXML
  private Label quoteLabel;
  @FXML
  private TextField fileNameTextField;
  @FXML
  private Button openFileButton0;
  @FXML
  private Button newFileButton;
  @FXML
  private Label totalEventsLabel;
  @FXML
  private Label totalTasksLabel;
  @FXML
  private Label tasksCompletedLabel;
  @FXML
  private TextField createEventName;
  @FXML
  private TextField createEventDescription;
  @FXML
  private TextField createEventDay;
  @FXML
  private TextField createEventStartTime;
  @FXML
  private TextField createEventDuration;

  @FXML
  private TextField createTaskName;
  @FXML
  private TextField createTaskDescription;
  @FXML
  private TextField createTaskDay;
  @FXML
  private CheckBox taskCompleteCheck;
  @FXML
  private HBox sundayBox;
  @FXML
  private HBox mondayBox;
  @FXML
  private HBox tuesdayBox;
  @FXML
  private HBox wednesdayBox;
  @FXML
  private HBox thursdayBox;
  @FXML
  private HBox fridayBox;
  @FXML
  private HBox saturdayBox;
  private final Popup startMenu;
  private Popup eventCreationPopup;
  private Popup taskCreationPopup;
  @FXML
  private Label warningEventLabel;
  @FXML
  private Label warningTaskLabel;
  @FXML
  private Button submitEventButton;
  @FXML
  private Button exitEventButton;
  @FXML
  private Button submitTaskButton;
  @FXML
  private Button exitTaskButton;
  String file;

  /**
   * Creates a MainController.
   *
   * @param weekView the WeekView
   * @param stage    the stage
   */
  public MainController(WeekView weekView, Stage stage) {
    super(weekView, stage);
    startMenu = new Popup();
  }

  /**
   * Runs the program.
   */
  @Override
  public void run() {
    startMenu();

    this.quoteButton.setText(weekView.getQuote());

    this.openFileButton.setOnAction(event -> {
      startMenu();
    });
    this.saveToFileButton.setOnAction(event -> {
      saveFile();
    });
    this.addEventButton.setOnAction(event -> {
      addEvent();
    });
    this.addTaskButton.setOnAction((event -> {
      addTask();
    }));
    this.eventTaskLimitButton.setOnAction(event -> {
      setLimit();
    });
    // this.verticalHorizontalButton.setOnAction(event -> ViewInmpl. change to vertical/horizontal
    // if horizontal change to vertical, if vertical change to horizontal);
    // this.quoteButton.setOnAction(event -> quoteText());
    // have a quote TextArea, have button above it
    // on click, popup to set quote
    // Enter quote label
    // TextField
    // Submit button that exits
    // on submit get text from textfield and save in weekview
    // change text in textarea to quote from weekview
    // this.quoteButton.setOnAction(event -> this.quoteLabel.setText);) pop up to choose quote text
    // on click task/event, show popup
    // links

    // for theme changes, in each controller, add a theme method -> maybe just in abstractcontroller
    // add change layout (theme/ horizontal/vertical) choose from 6 option depending on the option,
    // display different scenes

    // only need two copies of controllers -> for horizontal and vertical
  }

  public void quoteText() {
    new QuoteController(this.weekView, this.stage).run();
    this.quoteButton.setText(this.weekView.getQuote());
  }

  public void updateTotalEventsLabel() {
    this.totalEventsLabel.setText("Total Events: " + weekView.returnEventList().size());
  }

  public void updateTotalTasksLabel() {
    this.totalTasksLabel.setText("Total Tasks: " + weekView.returnTaskList().size());
  }

  public void updateTasksCompleted() {
    this.tasksCompletedLabel.setText("Tasks Completed: " + weekView.returnCompletedTasks()
        + "/" + weekView.returnTaskList().size());
  }

  /**
   * Adds an event.
   */
  private void addEvent() {
    try {
      this.eventCreationPopup = new Popup();
      FXMLLoader eventLoader = new FXMLLoader(getClass().getClassLoader().getResource(
          "AddEvent.fxml"));
      eventLoader.setController(this);
      Scene createEventScene = eventLoader.load();
      eventCreationPopup.getContent().add(createEventScene.getRoot());
    } catch (IOException e) {
      e.printStackTrace();
    }

    this.eventCreationPopup.show(this.stage);

    this.submitEventButton.setOnAction(event -> {
      addEventToList();
      showGraphics();
    });

    this.exitEventButton.setOnAction(event -> {
      this.eventCreationPopup.hide();
    });
  }

  private void addEventToList() {
    String eventName = null;
    String description = null;
    Days day = null;
    String startTime = null;
    int duration = -1;

    boolean canEventContinue = canEventContinue();

    try {
      eventName = createEventName.getText();
      day = verifyDay(this.createEventDay.getText());
      if (day.equals(Days.INVALID)) {
        warningEventLabel.setText("You entered an invalid day");
        canEventContinue = false;
      }
      if (correctTimeFormat(createEventStartTime.getText())) {
        startTime = createEventStartTime.getText();
      } else {
        warningEventLabel.setText("The format for the starting time is incorrect");
        canEventContinue = false;
      }
      if (isInteger(createEventDuration.getText())) {
        duration = Integer.parseInt(createEventDuration.getText());
      } else {
        warningEventLabel.setText("The duration is not an integer");
        canEventContinue = false;
      }
    } catch (NullPointerException n) {
      warningEventLabel.setText("You left a required field empty!");
      canEventContinue = false;
    }

    try {
      description = createEventDescription.getText();
    } catch (NullPointerException n) {
      // it is okay to not have a description
    }

    if (canEventContinue) {
      weekView.updateEvent(new Event(eventName, description, day, startTime, duration));
      updateEventLabelList();
      this.eventCreationPopup.hide();
    }
  }

  /**
   * Returns true if you can add an event.
   *
   * @return true if you can add an event
   */
  private boolean canEventContinue() {
    if (this.weekView.hasMaximumEvents()) {
      if (this.weekView.returnEventList().size() < this.weekView.returnMaxEvent()) {
        return true;
      } else {
        warningEventLabel.setText("You have reached the maximum amount of events: " +
            this.weekView.returnMaxEvent());
        return false;
      }
    } else {
      return true;
    }
  }

  /**
   * Returns true if the format is correct.
   *
   * @param timeString the string
   * @return true if the format is correct
   */
  private boolean correctTimeFormat(String timeString) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("k:mm");
    dateFormat.setLenient(false);

    try {
      Date time = dateFormat.parse(timeString);
      return timeString.equals(dateFormat.format(time));
    } catch (ParseException e) {
      return false;
    }
  }

  /**
   * Returns true if the string is an integer.
   *
   * @param string the string
   * @return true if the string is an integer.
   */
  private boolean isInteger(String string) {
    try {
      Integer.parseInt(string);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Updates the event label list.
   */
  private void updateEventLabelList() {
    List<Event> events = this.weekView.returnEventList();
    if (events.size() > 0) {
      Event event = events.get(events.size() - 1);
      Label label = new Label("Event: " + event.getName() + '\n' +
          "Description: " + event.getDescription() + '\n' +
          "Start Time: " + event.getStartTime() + '\n' +
          "Duration: " + event.getDuration()
      );
      label.setFont(new Font(10));
      labellists.addEventToList(label, event.getDayOfWeek());
    }
  }

  /**
   * Adds a task.
   */
  private void addTask() {
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

    this.submitTaskButton.setOnAction(event -> {
      addTaskToList();
      showGraphics();
    });

    this.exitTaskButton.setOnAction(event -> {
      this.taskCreationPopup.hide();
    });
    showGraphics();
  }

  /**
   * Adds a task.
   */
  private void addTaskToList() {
    String taskName = null;
    String description = null;
    Days day = null;
    boolean completed = false;
    boolean canContinue = canTaskContinue();

    try {
      taskName = createTaskName.getText();
      day = verifyDay(this.createTaskDay.getText());
      if (day.equals(Days.INVALID)) {
        warningTaskLabel.setText("You entered an invalid day");
        canContinue = false;
      }
      completed = taskCompleteCheck.isSelected();
    } catch (NullPointerException n) {
      warningTaskLabel.setText("You left a required field empty!");
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
  private boolean canTaskContinue() {
    if (this.weekView.hasMaximumTasks()) {
      if (this.weekView.returnTaskList().size() < this.weekView.returnMaxTask()) {
        return true;
      } else {
        warningTaskLabel.setText("You have reached the maximum amount of tasks: " +
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

  /**
   * Sets a limit.
   */
  private void setLimit() {
    new MaximumEventTaskController(this.weekView, this.stage).run();
  }

  /**
   * Shows the start menu.
   */
  private void startMenu() {
    try {
      FXMLLoader loader = new FXMLLoader(
          getClass().getClassLoader().getResource("StartMenu.fxml"));
      loader.setController(this);
      Scene createTaskScene = loader.load();
      startMenu.getContent().add(createTaskScene.getRoot());
      startMenu.show(this.stage);

      this.openFileButton0.setOnAction(event -> {
        openFile();
      });
      this.newFileButton.setOnAction(event -> {
        newFile();
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Opens the file.
   */
  private void openFile() {
    this.weekView.clearAll();
    this.labellists.clearAll();
    file = fileNameTextField.getText() + ".bujo";
    this.weekView.openFile(file);
    startMenu.hide();
    refreshPage();
    showGraphics();
  }

  /**
   * Creates a new file.
   */
  private void newFile() {
    this.weekView.clearAll();
    file = fileNameTextField.getText() + ".bujo";
    this.weekView.createFile(file);
    startMenu.hide();
  }

  /**
   * Saves the file.
   */
  private void saveFile() {
    this.weekView.saveFile(new File(file));
  }

  /**
   * Shows the events in the WeekView.
   */
  public void showGraphics() {
    sundayBox.getChildren().clear(); // Clear existing children
    sundayBox.getChildren().addAll(labellists.getSundayEventList());
    sundayBox.getChildren().addAll(labellists.getSundayTaskList());
    sundayBox.setAlignment(Pos.CENTER_LEFT);

    mondayBox.getChildren().clear(); // Clear existing children
    mondayBox.getChildren().addAll(labellists.getMondayEventList());
    mondayBox.getChildren().addAll(labellists.getMondayTaskList());
    mondayBox.setAlignment(Pos.CENTER_LEFT);

    tuesdayBox.getChildren().clear(); // Clear existing children
    tuesdayBox.getChildren().addAll(labellists.getTuesdayEventList());
    tuesdayBox.getChildren().addAll(labellists.getTuesdayTaskList());
    tuesdayBox.setAlignment(Pos.CENTER_LEFT);

    wednesdayBox.getChildren().clear(); // Clear existing children
    wednesdayBox.getChildren().addAll(labellists.getWednesdayEventList());
    wednesdayBox.getChildren().addAll(labellists.getWednesdayTaskList());
    wednesdayBox.setAlignment(Pos.CENTER_LEFT);

    thursdayBox.getChildren().clear(); // Clear existing children
    thursdayBox.getChildren().addAll(labellists.getThursdayEventList());
    thursdayBox.getChildren().addAll(labellists.getThursdayTaskList());
    thursdayBox.setAlignment(Pos.CENTER_LEFT);

    fridayBox.getChildren().clear(); // Clear existing children
    fridayBox.getChildren().addAll(labellists.getFridayEventList());
    fridayBox.getChildren().addAll(labellists.getFridayTaskList());
    fridayBox.setAlignment(Pos.CENTER_LEFT);

    saturdayBox.getChildren().clear(); // Clear existing children
    saturdayBox.getChildren().addAll(labellists.getSaturdayEventList());
    saturdayBox.getChildren().addAll(labellists.getSaturdayTaskList());
    saturdayBox.setAlignment(Pos.CENTER_LEFT);
  }

  /**
   * Updates the event label list.
   */
  private void refreshPage() {
    List<Event> events = this.weekView.returnEventList();
    if (events.size() > 0) {
      for (Event event : events) {
        Label label = new Label("Event: " + event.getName() + '\n' +
            "Description: " + event.getDescription() + '\n' +
            "Start Time: " + event.getStartTime() + '\n' +
            "Duration: " + event.getDuration()
        );
        label.setFont(new Font(10));
        labellists.addEventToList(label, event.getDayOfWeek());
      }
    }
    List<Task> tasks = this.weekView.returnTaskList();
    if (tasks.size() > 0) {
      for (Task task : tasks) {
        Label label = new Label("Event: " + task.getName() + '\n' +
            "Description: " + task.getDescription() + '\n' +
            "Completed? " + task.isCompleted()
        );
        label.setFont(new Font(10));
        labellists.addTaskToList(label, task.getDayOfWeek());
      }
    }
  }
}
