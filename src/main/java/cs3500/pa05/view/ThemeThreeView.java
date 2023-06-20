package cs3500.pa05.view;

/**
 * Represents a view with theme.
 */
public class ThemeThreeView extends AbstractView {
  /**
   * Creates a ThemeThreeView.
   */
  public ThemeThreeView() {
    this.weekViewLoader.setLocation(getClass().getClassLoader().getResource("WeekView.fxml"));
  }
}
