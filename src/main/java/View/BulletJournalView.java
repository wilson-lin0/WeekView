import javafx.scene.Scene;

  /**
   * Represents a GUI view for a bullet journal
   */
  public interface BulletJournalView {
    /**
     * Loads a scene from a bullet journal GUI layout.
     *
     * @return the layout
     */
    Scene load() throws IllegalStateException;
  }
