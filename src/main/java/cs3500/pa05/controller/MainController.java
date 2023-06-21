package cs3500.pa05.controller;

import cs3500.pa05.model.WeekView;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
  private TextField fileNameTextField;
  @FXML
  private Button openFileButton0;
  @FXML
  private Button newFileButton;
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
  }

  private void addEvent() {
    new AddEventController(this.weekView, this.stage).run();
  }

  private void addTask() {
    new AddTaskController(this.weekView, this.stage).run();
  }

  private void setLimit() {
    new MaximumEventTaskController(this.weekView, this.stage).run();
  }

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

  private void openFile() {
    this.weekView.clearAll();
    file = fileNameTextField.getText() + ".bujo";
    this.weekView.openFile(file);
    startMenu.hide();
  }

  private void newFile() {
    this.weekView.clearAll();
    file = fileNameTextField.getText() + ".bujo";
    this.weekView.createFile(file);
    startMenu.hide();
  }


  private void saveFile() {
    this.weekView.saveFile(new File(file));
  }
}
