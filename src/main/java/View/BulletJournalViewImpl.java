import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class BulletJournalViewImpl implements BulletJournalView {
  FXMLLoader loader;

  public BulletJournalViewImpl(BulletJournalController controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("journal.fxml"));
    this.loader.setController(controller);
  }
  /**
   * Loads a scene from a Whack-a-Mole GUI layout.
   *
   * @return the layout
   */
  @Override
  public Scene load() throws IllegalStateException {
    // load the layout
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
