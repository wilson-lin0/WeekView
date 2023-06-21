package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

public class VerticalView1 extends VerticalView {
  /**
   * Creates a ThemeOneView.
   *
   * @param controller
   */
  public VerticalView1(Controller controller) {
    super(controller);
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("WeekView.fxml"));
  }
}
