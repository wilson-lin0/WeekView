package cs3500.pa05.controller;

import cs3500.pa05.model.WeekView;

/**
 * Controls the flow of the program.
 */
public abstract class AbstractController implements Controller {
  protected WeekView weekView;

  /**
   * Creates a Controller.
   *
   * @param weekView the WeekView
   */
  public AbstractController(WeekView weekView) {
    this.weekView = weekView;
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
    // for (Event event : weekView.returnEventList()) {}
    // create new ... and when clicked, can edit
  }

  /**
   * Shows the tasks in the WeekView.
   */
  public void showTask() {
    // for (Task task : weekView.returnTaskList()) {}
    // creat new ... and when clicked, can edit
  }
}
