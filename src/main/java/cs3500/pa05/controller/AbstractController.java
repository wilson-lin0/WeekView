package cs3500.pa05.controller;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.WeekView;
import cs3500.pa05.model.enumerations.Days;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Controls the flow of the program.
 */
public abstract class AbstractController implements Controller {
  protected WeekView weekView;
  protected Stage stage;
  @FXML
  protected VBox sundayBox;
  @FXML
  protected VBox mondayBox;
  @FXML
  protected VBox tuesdayBox;
  @FXML
  protected VBox wednesdayBox;
  @FXML
  protected VBox thursdayBox;
  @FXML
  protected VBox fridayBox;
  @FXML
  protected VBox saturdayBox;

  List<Label> sundayEventList;
  List<Label> mondayEventList;
  List<Label> tuesdayEventList;
  List<Label> wednesdayEventList;
  List<Label> thursdayEventList;
  List<Label> fridayEventList;
  List<Label> saturdayEventList;

  List<Label> sundayTaskList;
  List<Label> mondayTaskList;
  List<Label> tuesdayTaskList;
  List<Label> wednesdayTaskList;
  List<Label> thursdayTaskList;
  List<Label> fridayTaskList;
  List<Label> saturdayTaskList;

  /**
   * Creates a Controller.
   *
   * @param weekView the WeekView
   * @throws IOException if popups fail to load
   */
  public AbstractController(WeekView weekView, Stage stage) {
    this.weekView = weekView;
    this.stage = stage;
  }

  /**
   * Runs the program.
   */
  @Override
  public abstract void run();

  public void initEventAndTasks() {
    sundayEventList = new ArrayList<>();
    mondayEventList = new ArrayList<>();
    tuesdayEventList = new ArrayList<>();
    wednesdayEventList = new ArrayList<>();
    thursdayEventList = new ArrayList<>();
    fridayEventList = new ArrayList<>();
    saturdayEventList = new ArrayList<>();

    sundayTaskList = new ArrayList<>();
    mondayTaskList = new ArrayList<>();
    tuesdayTaskList = new ArrayList<>();
    wednesdayTaskList = new ArrayList<>();
    thursdayTaskList = new ArrayList<>();
    fridayTaskList = new ArrayList<>();
    saturdayTaskList = new ArrayList<>();
  }

  /**
   * Shows the events in the WeekView.
   */
  public void showEvent() {
    updateLabelList();
    sundayBox.getChildren().addAll(sundayEventList);
    sundayBox.setAlignment(Pos.CENTER_LEFT);
    mondayBox.getChildren().addAll(mondayEventList);
    mondayBox.setAlignment(Pos.CENTER_LEFT);
    tuesdayBox.getChildren().addAll(tuesdayEventList);
    tuesdayBox.setAlignment(Pos.CENTER_LEFT);
    wednesdayBox.getChildren().addAll(wednesdayEventList);
    wednesdayBox.setAlignment(Pos.CENTER_LEFT);
    thursdayBox.getChildren().addAll(thursdayEventList);
    thursdayBox.setAlignment(Pos.CENTER_LEFT);
    fridayBox.getChildren().addAll(fridayEventList);
    fridayBox.setAlignment(Pos.CENTER_LEFT);
    saturdayBox.getChildren().addAll(saturdayEventList);
    saturdayBox.setAlignment(Pos.CENTER_LEFT);
  }

  private void updateLabelList() {
    for (Event event : weekView.returnEventList()) {
      Label label = new Label("Event: " + event.getName() + '\n' +
          "Description: " + event.getDescription() + '\n' +
          "Start Time: " + event.getStartTime()  + '\n' +
          "Duration: " + event.getDuration()
      );
      label.setFont(new Font(20));
      if (event.getDayOfWeek().equals(Days.SUNDAY)) {
        sundayEventList.add(label);
      } else if (event.getDayOfWeek().equals(Days.MONDAY)) {
        mondayEventList.add(label);
      } else if (event.getDayOfWeek().equals(Days.TUESDAY)) {
        tuesdayEventList.add(label);
      } else if (event.getDayOfWeek().equals(Days.WEDNESDAY)) {
        wednesdayEventList.add(label);
      } else if (event.getDayOfWeek().equals(Days.THURSDAY)) {
        thursdayEventList.add(label);
      } else if (event.getDayOfWeek().equals(Days.FRIDAY)) {
        fridayEventList.add(label);
      } else {
        saturdayEventList.add(label);
      }
    }
  }

  /**
   * Shows the tasks in the WeekView.
   */
  public void showTask() {
    // for (Task task : weekView.returnTaskList()) {}
    // creat new ... and when clicked, can edit
  }
}
