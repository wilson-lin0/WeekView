package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;

public class Horizontal3 extends ViewImpl {
  /**
   * Creates a ThemeOneView.
   *
   * @param controller
   */
  public Horizontal3(Controller controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("Horizontal3.fxml"));
  }
}
