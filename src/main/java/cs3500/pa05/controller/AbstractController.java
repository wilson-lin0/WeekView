package cs3500.pa05.controller;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.LabelLists;
import cs3500.pa05.model.WeekView;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Controls the flow of the program.
 */
public abstract class AbstractController implements Controller {
  protected WeekView weekView;
  protected Stage stage;
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
