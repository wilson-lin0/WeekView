package cs3500.pa05;

import javafx.application.Application;
import javafx.stage.Stage;

public class Driver extends Application {

  @Override
  public void start(Stage stage) {
    try {
      stage.show();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }
  public static void main(String[] args) {
    launch();
  }
}
