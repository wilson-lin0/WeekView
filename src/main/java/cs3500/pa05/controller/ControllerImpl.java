package cs3500.pa05.controller;

import static java.lang.Integer.parseInt;

import cs3500.pa05.enumerations.Days;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.WeekView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerImpl implements Controller {
  Readable input;
  Appendable output;
  WeekView weekView;

  @FXML
  private TextField eventTextBox;

  @FXML
  private TextField taskTextBox;

  public ControllerImpl(Readable input, Appendable output, WeekView weekView) {
    this.input = input;
    this.output = output;
    this.weekView = weekView;
  }

  @Override
  public void run() {
    this.eventTextBox.setOnAction(event ->
        weekView.setMaxEvent(parseInt(this.eventTextBox.getText())));
    this.taskTextBox.setOnAction(event ->
        weekView.setMaxTask(parseInt(this.taskTextBox.getText())));
    // on click button to create event -> show AddEvent.fxml and create event from TextBox
    // on click button to create task -> show AddTask.fxml and create task from TextBox
  }

  public void createEvent(String name, String description, Days dayOfWeek, int startTime,
                          int duration) {
    Event newEvent = new Event(name, description, dayOfWeek, startTime, duration);
    weekView.updateEvent(newEvent);
  }

  public void createTask(String name, String description, Days dayOfWeek, int startTime,
                         int duration) {
    Task newTask = new Task(name, description, dayOfWeek, startTime, duration);
    weekView.updateTask(newTask);
  }

  public void showEvent() {
    for (Event event : weekView.returnEventList()) {

    }
  }

  public void showTask() {
    for (Task task : weekView.returnTaskList()) {

    }
  }

  public WeekView chooseFile() {
    return null;
  }
}
