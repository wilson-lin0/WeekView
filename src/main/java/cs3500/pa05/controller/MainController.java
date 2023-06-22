package cs3500.pa05.controller;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.WeekView;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
  private final Popup startMenu;
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
      showGraphics();
    }));
    this.eventTaskLimitButton.setOnAction(event -> {
      setLimit();
    });
    // this.verticalHorizontalButton.setOnAction(event -> ViewInmpl. change to vertical/horizontal
    // if horizontal change to vertical, if vertical change to horizontal);
    this.quoteButton.setOnAction(event -> quoteText());
    // this.quoteButton.setOnAction(event -> this.quoteLabel.setText);) pop up to choose quote text
    // on click task/event, show popup
    // links
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
    new AddEventController(this.weekView, this.stage).run();
    showGraphics();
  }

  /**
   * Adds a task.
   */
  private void addTask() {
    new AddTaskController(this.weekView, this.stage).run();
    showGraphics();
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
