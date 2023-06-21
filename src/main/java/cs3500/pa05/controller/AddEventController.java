package cs3500.pa05.controller;

import static cs3500.pa05.model.enumerations.Days.verifyDay;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.WeekView;
import cs3500.pa05.model.enumerations.Days;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Controls the AddEvent FXML.
 */
public class AddEventController extends AbstractController {

  protected Popup eventCreationPopup;
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
  private Label warningLabel;
  @FXML
  private Button submitButton;
  @FXML
  private Button exitButton;
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

  /**
   * Creates an AddEventController.
   *
   * @param weekView the WeekView
   * @param stage    the stage
   */
  public AddEventController(WeekView weekView, Stage stage, HBox sundayBox, HBox mondayBox,
                            HBox tuesdayBox, HBox wednesdayBox, HBox thursdayBox,
                            HBox fridayBox, HBox saturdayBox) {
    super(weekView, stage);
    this.sundayBox = sundayBox;
    this.mondayBox = mondayBox;
    this.tuesdayBox = tuesdayBox;
    this.wednesdayBox = wednesdayBox;
    this.thursdayBox = thursdayBox;
    this.fridayBox = fridayBox;
    this.saturdayBox = saturdayBox;
  }

  /**
   * Runs the program (adds an Event to the WeekView).
   */
  @Override
  public void run() {
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

    this.submitButton.setOnAction(event -> addEvent());

    this.exitButton.setOnAction(event -> {
      this.eventCreationPopup.hide();
    });
  }

  /**
   * Adds an event.
   */
  private void addEvent() {
    String eventName = null;
    String description = null;
    Days day = null;
    String startTime = null;
    String duration = null;

    boolean canContinue = canContinue();

    try {
      eventName = createEventName.getText();
      day = verifyDay(this.createEventDay.getText());
      if (day.equals(Days.INVALID)) {
        warningLabel.setText("You entered an invalid day");
        canContinue = false;
      }
      if (correctTimeFormat(createEventStartTime.getText())) {
        startTime = createEventStartTime.getText();
      } else {
        warningLabel.setText("The format for the starting time is incorrect");
        canContinue = false;
      }
      if (isInteger(createEventDuration.getText())) {
        duration = createEventDuration.getText();
      } else {
        warningLabel.setText("The duration is not an integer");
        canContinue = false;
      }
    } catch (NullPointerException n) {
      warningLabel.setText("You left a required field empty!");
      canContinue = false;
    }

    try {
      description = createEventDescription.getText();
    } catch (NullPointerException n) {
      // it is okay to not have a description
    }

    if (canContinue) {
      weekView.updateEvent(new Event(eventName, description, day, startTime, duration));
      showEvent();
    }
  }

  /**
   * Returns true if you can add an event.
   *
   * @return true if you can add an event
   */
  private boolean canContinue() {
    if (this.weekView.hasMaximumEvents()) {
      if (this.weekView.returnEventList().size() < this.weekView.returnMaxEvent()) {
        return true;
      } else {
        warningLabel.setText("You have reached the maximum amount of events: " +
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
   * Shows the events in the WeekView.
   */
  public void showEvent() {
    updateEventLabelList();
    sundayBox.getChildren().clear(); // Clear existing children
    sundayBox.getChildren().addAll(labellists.getSundayEventList());
    sundayBox.setAlignment(Pos.CENTER_LEFT);

    mondayBox.getChildren().clear(); // Clear existing children
    mondayBox.getChildren().addAll(labellists.getMondayEventList());
    mondayBox.setAlignment(Pos.CENTER_LEFT);

    tuesdayBox.getChildren().clear(); // Clear existing children
    tuesdayBox.getChildren().addAll(labellists.getTuesdayEventList());
    tuesdayBox.setAlignment(Pos.CENTER_LEFT);

    wednesdayBox.getChildren().clear(); // Clear existing children
    wednesdayBox.getChildren().addAll(labellists.getWednesdayEventList());
    wednesdayBox.setAlignment(Pos.CENTER_LEFT);

    thursdayBox.getChildren().clear(); // Clear existing children
    thursdayBox.getChildren().addAll(labellists.getThursdayEventList());
    thursdayBox.setAlignment(Pos.CENTER_LEFT);

    fridayBox.getChildren().clear(); // Clear existing children
    fridayBox.getChildren().addAll(labellists.getFridayEventList());
    fridayBox.setAlignment(Pos.CENTER_LEFT);

    saturdayBox.getChildren().clear(); // Clear existing children
    saturdayBox.getChildren().addAll(labellists.getSaturdayEventList());
    saturdayBox.setAlignment(Pos.CENTER_LEFT);
  }


  /**
   * Updates the event label list.
   */
  private void updateEventLabelList() {
    Event event = this.weekView.returnEventList().get(weekView.returnEventList().size() - 1);
    Label label = new Label("Event: " + event.getName() + '\n' +
        "Description: " + event.getDescription() + '\n' +
        "Start Time: " + event.getStartTime() + '\n' +
        "Duration: " + event.getDuration()
    );
    label.setFont(new Font(10));
    labellists.addEventToList(label, event.getDayOfWeek());
  }

}
