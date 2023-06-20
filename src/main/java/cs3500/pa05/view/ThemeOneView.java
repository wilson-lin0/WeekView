package cs3500.pa05.view;

/**
 * Represents a view with the theme.
 */
public class ThemeOneView extends AbstractView {
  /**
   * Creates a ThemeOneView.
   */
  public ThemeOneView() {
    this.weekViewLoader.setLocation(getClass().getClassLoader().getResource("WeekView.fxml"));
  }
}
