package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;

/**
 * Represents the Horizontal2 view.
 */
public class Horizontal2 extends ViewImpl {
  /**
   * Creates a ThemeOneView.
   *
   * @param controller the controller to associate with the view
   */
  public Horizontal2(Controller controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("horizontal2.fxml"));
  }
}
