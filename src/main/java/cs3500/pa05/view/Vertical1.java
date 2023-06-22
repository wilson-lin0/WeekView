package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;

public class Vertical1 extends ViewImpl {
  /**
   * Creates a ThemeOneView.
   *
   * @param controller
   */
  public Vertical1(Controller controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("HorizontalBlue.fxml"));
  }
}
