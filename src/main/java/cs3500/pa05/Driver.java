package cs3500.pa05;

import cs3500.pa05.controller.MainController;
import cs3500.pa05.model.WeekView;
import cs3500.pa05.view.Vertical1;
import cs3500.pa05.view.ViewImpl;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This is the main driver of this project.
 */
public class Driver extends Application {

  /**
   * Starts the GUI for the program.
   *
   * @param stage the JavaFX stage to add elements to
   */
  @Override
  public void start(Stage stage) {
    WeekView weekView = new WeekView();
    MainController controller = new MainController(weekView, stage);
    ViewImpl view = new Vertical1(controller);

    try {
      stage.setScene(view.load());
      stage.show();
      controller.run();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Project entry point.
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) {
    launch();
  }
}
