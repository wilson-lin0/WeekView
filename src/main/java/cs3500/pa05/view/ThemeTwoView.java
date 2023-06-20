package cs3500.pa05.view;

/**
 * Represents a view with theme.
 */
public class ThemeTwoView extends AbstractView {
  /**
   * Creates a ThemeTwoView.
   */
  public ThemeTwoView() {
    this.weekViewLoader.setLocation(getClass().getClassLoader().getResource("WeekView.fxml"));
  }
}
