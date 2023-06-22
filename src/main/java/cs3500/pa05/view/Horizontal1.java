package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;

/**
 * Represents the Horizontal1 view.
 */
public class Horizontal1 extends ViewImpl {
  /**
   * Creates a ThemeOneView.
   *
   * @param controller the controller to associate with the view
   */
  public Horizontal1(Controller controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("horizontal1.fxml"));
  }
}
