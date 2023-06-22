package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;

/**
 * Represents the Horizontal3 view.
 */
public class Horizontal3 extends ViewImpl {
  /**
   * Creates a ThemeOneView.
   *
   * @param controller the controller to associate with the view
   */
  public Horizontal3(Controller controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("horizontal3.fxml"));
  }
}
