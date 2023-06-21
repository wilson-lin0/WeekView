package cs3500.pa05.controller;

import cs3500.pa05.model.WeekView;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
  }

  /**
   * Adds a task.
   */
  private void addTask() {
    new AddTaskController(this.weekView, this.stage).run();
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
}
