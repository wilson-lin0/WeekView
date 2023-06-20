package cs3500.pa05.controllerTests;

import cs3500.pa05.controller.AddEventController;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.WeekView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class AddEventControllerTest {

  private WeekView weekView;
  private Stage stage;
  private AddEventControllerMock addEventController;

  @BeforeEach
  void setUp() {
    weekView = mock(WeekView.class);
    stage = mock(Stage.class);
    addEventController = new AddEventControllerMock(weekView, stage);
  }

  @Test
  void run_SubmitButtonClicked_EventAddedToWeekView() {
    // Create mock objects
    Popup eventCreationPopup = mock(Popup.class);
    TextField createEventName = mock(TextField.class);
    TextField createEventDescription = mock(TextField.class);
    TextField createEventDay = mock(TextField.class);
    TextField createEventStartTime = mock(TextField.class);
    TextField createEventDuration = mock(TextField.class);
    Button submitButton = mock(Button.class);
    Button exitButton = mock(Button.class);

    // Set mock objects in the controller
    addEventController.setEventCreationPopup(eventCreationPopup);
    addEventController.setCreateEventName(createEventName);
    addEventController.setCreateEventDescription(createEventDescription);
    addEventController.setCreateEventDay(createEventDay);
    addEventController.setCreateEventStartTime(createEventStartTime);
    addEventController.setCreateEventDuration(createEventDuration);
    addEventController.setSubmitButton(submitButton);
    addEventController.setExitButton(exitButton);

    // Perform button click
    addEventController.clickSubmitButton();

    // Verify that the event was added to the WeekView
    verify(weekView).updateEvent(any(Event.class));
  }

  @Test
  void run_ExitButtonClicked_PopupHidden() {
    // Create mock objects
    Popup eventCreationPopup = mock(Popup.class);
    TextField createEventName = mock(TextField.class);
    TextField createEventDescription = mock(TextField.class);
    TextField createEventDay = mock(TextField.class);
    TextField createEventStartTime = mock(TextField.class);
    TextField createEventDuration = mock(TextField.class);
    Button submitButton = mock(Button.class);
    Button exitButton = mock(Button.class);

    // Set mock objects in the controller
    addEventController.setEventCreationPopup(eventCreationPopup);
    addEventController.setCreateEventName(createEventName);
    addEventController.setCreateEventDescription(createEventDescription);
    addEventController.setCreateEventDay(createEventDay);
    addEventController.setCreateEventStartTime(createEventStartTime);
    addEventController.setCreateEventDuration(createEventDuration);
    addEventController.setSubmitButton(submitButton);
    addEventController.setExitButton(exitButton);

    // Perform button click
    addEventController.clickExitButton();

    // Verify that the popup was hidden
    verify(eventCreationPopup).hide();
  }

  // Mock class that extends AddEventController
  private static class AddEventControllerMock extends AddEventController {

    private Popup eventCreationPopup;
    private TextField createEventName;
    private TextField createEventDescription;
    private TextField createEventDay;
    private TextField createEventStartTime;
    private TextField createEventDuration;
    private Button submitButton;
    private Button exitButton;

    public AddEventControllerMock(WeekView weekView, Stage stage) {
      super(weekView, stage);
    }

    public void setEventCreationPopup(Popup eventCreationPopup) {
      this.eventCreationPopup = eventCreationPopup;
    }

    public void setCreateEventName(TextField createEventName) {
      this.createEventName = createEventName;
    }

    public void setCreateEventDescription(TextField createEventDescription) {
      this.createEventDescription = createEventDescription;
    }

    public void setCreateEventDay(TextField createEventDay) {
      this.createEventDay = createEventDay;
    }

    public void setCreateEventStartTime(TextField createEventStartTime) {
      this.createEventStartTime = createEventStartTime;
    }

    public void setCreateEventDuration(TextField createEventDuration) {
      this.createEventDuration = createEventDuration;
    }

    public void setSubmitButton(Button submitButton) {
      this.submitButton = submitButton;
    }

    public void setExitButton(Button exitButton) {
      this.exitButton = exitButton;
    }

    public void clickSubmitButton() {
      submitButton.fire();
    }

    public void clickExitButton() {
      exitButton.fire();
    }
  }
}
