package cs3500.pa05.controller;

import static cs3500.pa05.model.enumerations.Days.getDay;
import static java.lang.Integer.parseInt;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.WeekView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controls the AddEvent FXML.
 */
public class AddEventController extends AbstractController {
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

  /**
   * Creates an AddEventController.
   *
   * @param weekView the WeekView
   */
  public AddEventController(WeekView weekView) {
    super(weekView);
  }

  /**
   * Runs the program (adds an Event to the WeekView).
   */
  @Override
  public void run() {
    weekView.updateEvent(new Event(this.createEventName.getText(),
            this.createEventDescription.getText(), getDay(this.createEventDay.getText().charAt(0)),
            parseInt(this.createEventStartTime.getText()),
            parseInt(this.createEventDuration.getText())));
  }
}
