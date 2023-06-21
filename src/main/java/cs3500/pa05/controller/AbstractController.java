package cs3500.pa05.controller;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.LabelLists;
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
  protected LabelLists labellists;

  /**
   * Creates a Controller.
   *
   * @param weekView the WeekView
   * @throws IOException if popups fail to load
   */
  public AbstractController(WeekView weekView, Stage stage) {
    this.weekView = weekView;
    this.stage = stage;
    this.labellists = new LabelLists();
  }

  /**
   * Runs the program.
   */
  @Override
  public abstract void run();

  /**
   * Shows the events in the WeekView.
   */
  public void showEvent() {
    updateEventLabelList();
    sundayBox.getChildren().addAll(labellists.getSundayEventList());
    sundayBox.setAlignment(Pos.CENTER_LEFT);
    mondayBox.getChildren().addAll(labellists.getMondayEventList());
    mondayBox.setAlignment(Pos.CENTER_LEFT);
    tuesdayBox.getChildren().addAll(labellists.getTuesdayEventList());
    tuesdayBox.setAlignment(Pos.CENTER_LEFT);
    wednesdayBox.getChildren().addAll(labellists.getWednesdayEventList());
    wednesdayBox.setAlignment(Pos.CENTER_LEFT);
    thursdayBox.getChildren().addAll(labellists.getThursdayEventList());
    thursdayBox.setAlignment(Pos.CENTER_LEFT);
    fridayBox.getChildren().addAll(labellists.getFridayEventList());
    fridayBox.setAlignment(Pos.CENTER_LEFT);
    saturdayBox.getChildren().addAll(labellists.getSaturdayEventList());
    saturdayBox.setAlignment(Pos.CENTER_LEFT);
  }

  private void updateEventLabelList() {
    for (Event event : weekView.returnEventList()) {
      Label label = new Label("Event: " + event.getName() + '\n' +
          "Description: " + event.getDescription() + '\n' +
          "Start Time: " + event.getStartTime() + '\n' +
          "Duration: " + event.getDuration()
      );
      label.setFont(new Font(20));
      labellists.addEventToList(label, event.getDayOfWeek());
    }
  }

  /**
   * Shows the tasks in the WeekView.
   */
  public void showTask() {
    updateTaskLabelList();
    sundayBox.getChildren().addAll(labellists.getSundayTaskList());
    sundayBox.setAlignment(Pos.CENTER_LEFT);
    mondayBox.getChildren().addAll(labellists.getMondayTaskList());
    mondayBox.setAlignment(Pos.CENTER_LEFT);
    tuesdayBox.getChildren().addAll(labellists.getTuesdayTaskList());
    tuesdayBox.setAlignment(Pos.CENTER_LEFT);
    wednesdayBox.getChildren().addAll(labellists.getWednesdayTaskList());
    wednesdayBox.setAlignment(Pos.CENTER_LEFT);
    thursdayBox.getChildren().addAll(labellists.getThursdayTaskList());
    thursdayBox.setAlignment(Pos.CENTER_LEFT);
    fridayBox.getChildren().addAll(labellists.getFridayTaskList());
    fridayBox.setAlignment(Pos.CENTER_LEFT);
    saturdayBox.getChildren().addAll(labellists.getSaturdayTaskList());
    saturdayBox.setAlignment(Pos.CENTER_LEFT);
  }

  private void updateTaskLabelList() {
    for (Event event : weekView.returnEventList()) {
      Label label = new Label("Event: " + event.getName() + '\n' +
          "Description: " + event.getDescription() + '\n' +
          "Start Time: " + event.getStartTime() + '\n' +
          "Duration: " + event.getDuration()
      );
      label.setFont(new Font(20));
      labellists.addTaskToList(label, event.getDayOfWeek());
    }
  }
}
