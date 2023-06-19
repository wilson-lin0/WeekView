package cs3500.pa05.controller;

import cs3500.pa05.enumerations.Days;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.WeekView;

public class ControllerImpl implements Controller {
  Readable input;
  Appendable output;
  WeekView weekView;

  public ControllerImpl(Readable input, Appendable output, WeekView weekView) {
    this.input = input;
    this.output = output;
    this.weekView = weekView;
  }

  @Override
  public void run() {

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
