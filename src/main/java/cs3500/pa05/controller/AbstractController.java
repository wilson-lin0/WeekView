package cs3500.pa05.controller;

import cs3500.pa05.model.LabelLists;
import cs3500.pa05.model.WeekView;
import javafx.stage.Stage;

/**
 * Controls the flow of the program.
 */
public abstract class AbstractController implements Controller {
  protected WeekView weekView;
  protected Stage stage;
  protected LabelLists labellists;

  /**
   * Creates a Controller.
   *
   * @param weekView the WeekView
   * @param stage    the stage
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
}
