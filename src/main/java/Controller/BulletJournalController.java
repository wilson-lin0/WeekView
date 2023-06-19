/**
 * Represents a controller for a bullet journal
 */
public interface BulletJournalController {
  /**
   * Initializes a bullet journal
   *
   * @throws IllegalStateException if the game board is not defined
   */
  void run() throws IllegalStateException;
}