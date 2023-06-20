package cs3500.pa05.controller;

import static cs3500.pa05.model.enumerations.Days.getDay;
import static java.lang.Integer.parseInt;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.WeekView;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
  private Button submitButton;
  @FXML
  private Button exitButton;

  /**
   * Creates an AddEventController.
   *
   * @param weekView the WeekView
   * @param stage    the stage
   */
  public AddEventController(WeekView weekView, Stage stage) {
    super(weekView, stage);
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

    this.submitButton.setOnAction(event -> {
      weekView.updateEvent(new Event(this.createEventName.getText(),
          this.createEventDescription.getText(), getDay(this.createEventDay.getText().charAt(0)),
          parseInt(this.createEventStartTime.getText()),
          parseInt(this.createEventDuration.getText())));
    });

    this.exitButton.setOnAction(event -> {
      this.eventCreationPopup.hide();
    });
  }
}
