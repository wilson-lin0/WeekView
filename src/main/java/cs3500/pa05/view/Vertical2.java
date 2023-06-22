package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;

/**
 * Represents the Vertical2 view.
 */
public class Vertical2 extends ViewImpl {
  /**
   * Creates a ThemeOneView.
   *
   * @param controller the controller to associate with the view
   */
  public Vertical2(Controller controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("HorizontalGreen.fxml"));
  }
}
