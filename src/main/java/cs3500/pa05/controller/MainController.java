package cs3500.pa05.controller;

import static cs3500.pa05.model.enumerations.Days.verifyDay;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.WeekView;
import cs3500.pa05.model.enumerations.Days;
import cs3500.pa05.view.Horizontal1;
import cs3500.pa05.view.Horizontal2;
import cs3500.pa05.view.Horizontal3;
import cs3500.pa05.view.Vertical1;
import cs3500.pa05.view.Vertical2;
import cs3500.pa05.view.Vertical3;
import cs3500.pa05.view.ViewImpl;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Controls the program.
 */
public class MainController extends AbstractController {
  @FXML
  private VBox taskQueueVbox;
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
  private TextField fileNameTextField;
  @FXML
  private Button openFileButton0;
  @FXML
  private Button newFileButton;
  @FXML
  private TextField weekNameTextField;
  @FXML
  private Label totalEventsLabel;
  @FXML
  private Label totalTasksLabel;
  @FXML
  private Label titleLabel;
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
  private Popup scenePopup;
  @FXML
  private Button vertical1;
  @FXML
  private Button vertical2;
  @FXML
  private Button vertical3;
  @FXML
  private Button horizontal1;
  @FXML
  private Button horizontal2;
  @FXML
  private Button horizontal3;
  @FXML
  private Button layoutButton;
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
    this.layoutButton.setOnAction(event -> scenePopup());
  }

  /**
   * Shows a popup to change layout.
   */
  private void scenePopup() {
    try {
      this.scenePopup = new Popup();
      FXMLLoader eventLoader =
          new FXMLLoader(getClass().getClassLoader().getResource("ScenePopup.fxml"));
      eventLoader.setController(this);
      Scene createEventScene = eventLoader.load();
      scenePopup.getContent().add(createEventScene.getRoot());
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.scenePopup.show(this.stage);

    this.horizontal1.setOnAction(event -> {
      changeSceneHorizontal1();
      scenePopup.hide(); // Close the popup
    });

    this.horizontal2.setOnAction(event -> {
      changeSceneHorizontal2();
      scenePopup.hide(); // Close the popup
    });

    this.horizontal3.setOnAction(event -> {
      changeSceneHorizontal3();
      scenePopup.hide(); // Close the popup
    });

    this.vertical1.setOnAction(event -> {
      changeSceneVertical1();
      scenePopup.hide(); // Close the popup
    });

    this.vertical2.setOnAction(event -> {
      changeSceneVertical2();
      scenePopup.hide(); // Close the popup
    });

    this.vertical3.setOnAction(event -> {
      changeSceneVertical3();
      scenePopup.hide(); // Close the popup
    });
  }

  /**
   * Changes scene to Horizontal1.
   */
  private void changeSceneHorizontal1() {
    ViewImpl view = new Horizontal1(this);

    try {
      stage.setScene(view.load());
      stage.show();
      this.run();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Changes scene to Horizontal2.
   */
  private void changeSceneHorizontal2() {
    ViewImpl view = new Horizontal2(this);

    try {
      stage.setScene(view.load());
      stage.show();
      this.run();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Changes scene to Horizontal3.
   */
  private void changeSceneHorizontal3() {
    ViewImpl view = new Horizontal3(this);

    try {
      stage.setScene(view.load());
      stage.show();
      this.run();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Changes scene to Vertical1.
   */
  private void changeSceneVertical1() {
    ViewImpl view = new Vertical1(this);

    try {
      stage.setScene(view.load());
      stage.show();
      this.run();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Changes scene to Vertical2.
   */
  private void changeSceneVertical2() {
    ViewImpl view = new Vertical2(this);

    try {
      stage.setScene(view.load());
      stage.show();
      this.run();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Changes scene to Vertical3.
   */
  private void changeSceneVertical3() {
    ViewImpl view = new Vertical3(this);

    try {
      stage.setScene(view.load());
      stage.show();
      this.run();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Adds an event.
   */
  private void addEvent() {
    try {
      this.eventCreationPopup = new Popup();
      FXMLLoader eventLoader =
          new FXMLLoader(getClass().getClassLoader().getResource("AddEvent.fxml"));
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
      this.totalEventsLabel.setText("Total events: " + weekView.returnEventList().size());
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
    if (this.weekView.returnMaxEvent() != -1) {
      if (this.weekView.returnEventList().size() - 1 < this.weekView.returnMaxEvent()) {
        return true;
      } else {
        warningEventLabel.setText(
            "You have reached the maximum amount of events: " + this.weekView.returnMaxEvent());
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
    Label label = null;
    if (events.size() > 0) {
      Event event = events.get(events.size() - 1);
      if (event.getDescription().contains(".com") || event.getDescription().contains(".org")
          || event.getDescription().contains(".net")) {
        Hyperlink hyperlink = new Hyperlink(event.getDescription());
        hyperlink.setOnAction(e -> {
          try {
            openLink(event.getDescription());
          } catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
          }
        });

        label = new Label(
            "Event: " + event.getName() + '\n' + "Description: " + event.getDescription()
                + '\n' + "Start Time: " + event.getStartTime() + '\n' + "Duration: "
                + event.getDuration());
        label.setGraphic(hyperlink);
        label.setContentDisplay(ContentDisplay.TOP);
        label.setWrapText(true);
      } else {
        label = new Label(
            "Event: " + event.getName() + '\n' + "Description: " + event.getDescription()
                + '\n' + "Start Time: " + event.getStartTime() + '\n' + "Duration: "
                + event.getDuration());
        label.setFont(new Font(10));
      }
      labellists.addEventToList(label, event.getDayOfWeek());
    }
  }


  /**
   * Opens the link.
   *
   * @param url the url
   * @throws URISyntaxException when the url is wrong
   * @throws IOException        when the url is not found
   */
  private void openLink(String url) throws URISyntaxException, IOException {
    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
      Desktop.getDesktop().browse(new URI(url));
    } else {
      // Desktop browsing is not supported
      System.err.println("Desktop browsing is not supported.");
    }
  }

  /**
   * Adds a task.
   */
  private void addTask() {
    this.taskCreationPopup = new Popup();
    try {
      FXMLLoader taskLoader =
          new FXMLLoader(getClass().getClassLoader().getResource("AddTask.fxml"));
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
      this.totalTasksLabel.setText("Total tasks: " + weekView.returnTaskList().size());
      this.tasksCompletedLabel.setText(
          "Tasks completed: " + weekView.returnCompletedTasks().size() + "/"
              + weekView.returnTaskList().size());
    });
    this.exitTaskButton.setOnAction(event -> {
      this.taskCreationPopup.hide();
    });
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
    if (this.weekView.returnMaxTask() != -1) {
      if (this.weekView.returnTaskList().size() - 1 < this.weekView.returnMaxTask()) {
        return true;
      } else {
        warningTaskLabel.setText(
            "You have reached the maximum amount of tasks: " + this.weekView.returnMaxTask());
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
    Label label = null;
    if (tasks.size() > 0) {
      Task task = tasks.get(tasks.size() - 1);
      if (task.getDescription().contains(".com") || task.getDescription().contains(".org")
          || task.getDescription().contains(".net")) {
        Hyperlink hyperlink = new Hyperlink(task.getDescription());
        hyperlink.setOnAction(e -> {
          try {
            openLink(task.getDescription());
          } catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
          }
        });
        label = new Label(
            "Event: " + task.getName() + '\n' + "Description: "
                + task.getDescription() + '\n'
                + "Completed?: " + task.isCompleted());
        label.setGraphic(hyperlink);
        label.setContentDisplay(ContentDisplay.TOP);
        label.setWrapText(true);
      } else {
        label = new Label(
            "Event: " + task.getName() + '\n' + "Description: "
                + task.getDescription() + '\n'
                + "Completed?: " + task.isCompleted());
      }
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
      FXMLLoader loader = new FXMLLoader(getClass().getClassLoader()
          .getResource("StartMenu.fxml"));
      loader.setController(this);
      Scene createTaskScene = loader.load();
      startMenu.getContent().add(createTaskScene.getRoot());
      startMenu.show(this.stage);

      this.openFileButton0.setOnAction(event -> {
        titleLabel.setText(weekNameTextField.getText());
        openFile();
      });
      this.newFileButton.setOnAction(event -> {
        titleLabel.setText(weekNameTextField.getText());
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
  private void showGraphics() {
    sundayBox.getChildren().clear(); // Clear existing children
    sundayBox.getChildren().addAll(labellists.getSundayList());
    sundayBox.setAlignment(Pos.CENTER_LEFT);

    mondayBox.getChildren().clear(); // Clear existing children
    mondayBox.getChildren().addAll(labellists.getMondayList());
    mondayBox.setAlignment(Pos.CENTER_LEFT);

    tuesdayBox.getChildren().clear(); // Clear existing children
    tuesdayBox.getChildren().addAll(labellists.getTuesdayList());
    tuesdayBox.setAlignment(Pos.CENTER_LEFT);

    wednesdayBox.getChildren().clear(); // Clear existing children
    wednesdayBox.getChildren().addAll(labellists.getWednesdayList());
    wednesdayBox.setAlignment(Pos.CENTER_LEFT);

    thursdayBox.getChildren().clear(); // Clear existing children
    thursdayBox.getChildren().addAll(labellists.getThursdayList());
    thursdayBox.setAlignment(Pos.CENTER_LEFT);

    fridayBox.getChildren().clear(); // Clear existing children
    fridayBox.getChildren().addAll(labellists.getFridayList());
    fridayBox.setAlignment(Pos.CENTER_LEFT);

    saturdayBox.getChildren().clear(); // Clear existing children
    saturdayBox.getChildren().addAll(labellists.getSaturdayList());
    saturdayBox.setAlignment(Pos.CENTER_LEFT);

    List<Label> taskViewLabels = showTaskQueue();
    taskQueueVbox.getChildren().clear();
    taskQueueVbox.getChildren().addAll(taskViewLabels);
  }

  /**
   * Shows the task queue.
   *
   * @return list of tasks
   */
  private List<Label> showTaskQueue() {
    List<Label> labels = new ArrayList<>();

    List<Task> tasks = this.weekView.returnTaskList();
    for (Task task : tasks) {
      String name = task.getName();
      String completed = task.isCompleted().toString();
      Label label = new Label("Name: " + name + '\n' + "Completed?: " + completed);
      labels.add(label);
    }
    return labels;
  }

  /**
   * Updates the event label list.
   */
  private void refreshPage() {
    List<Event> events = this.weekView.returnEventList();
    if (events.size() > 0) {
      for (Event event : events) {
        Label label = new Label(
            "Event: " + event.getName() + '\n' + "Description: "
                + event.getDescription() + '\n'
                + "Start Time: " + event.getStartTime() + '\n' + "Duration: "
                + event.getDuration());
        label.setFont(new Font(10));
        labellists.addEventToList(label, event.getDayOfWeek());
      }
    }
    List<Task> tasks = this.weekView.returnTaskList();
    if (tasks.size() > 0) {
      for (Task task : tasks) {
        Label label = new Label(
            "Task: " + task.getName() + '\n' + "Description: "
                + task.getDescription() + '\n' + "Completed? " + task.isCompleted());
        label.setFont(new Font(10));
        labellists.addTaskToList(label, task.getDayOfWeek());
      }
    }
  }
}