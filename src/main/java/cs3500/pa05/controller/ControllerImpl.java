package cs3500.pa05.controller;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.WeekView;

public class ControllerImpl implements Controller {
  Readable input;
  Appendable output;

  public ControllerImpl(Readable input, Appendable output) {
    this.input = input;
    this.output = output;
  }

  @Override
  public void run() {

  }

  public Event createEvent() {
    return null;
  }

  public Task createTask() {
    return null;
  }

  public WeekView chooseFile() {
    return null;
  }
}
