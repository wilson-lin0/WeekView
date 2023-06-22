package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

public class HorizontalView2 extends HorizontalView {
  /**
   * Creates a ThemeOneView.
   *
   * @param controller
   */
  public HorizontalView2(Controller controller) {
    super(controller);
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("WeekView.fxml"));
  }
}