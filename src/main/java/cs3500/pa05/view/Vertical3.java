package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;

/**
 * Represents the Vertical3 view.
 */
public class Vertical3 extends ViewImpl {
  /**
   * Creates a ThemeOneView.
   *
   * @param controller the controller to associate with the view
   */
  public Vertical3(Controller controller) {
    super(controller);
    this.loader.setLocation(getClass().getClassLoader().getResource("HorizontalPink.fxml"));
  }
}
