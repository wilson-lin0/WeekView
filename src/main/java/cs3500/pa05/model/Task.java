package cs3500.pa05.model;

import cs3500.pa05.model.enumerations.Days;
import java.util.Objects;

/**
 * To represent a task.
 */
public class Task {
  String name;
  String description;
  Days dayOfWeek;
  Boolean completed;

  /**
   * Creates a task.
   *
   * @param name the name of the task
   * @param description the description of the task
   * @param dayOfWeek the day of the week the task occurs
   */
  public Task(String name, String description, Days dayOfWeek, boolean completed) {
    this.name = name;
    this.description = description;
    this.dayOfWeek = dayOfWeek;
    this.completed = false;
  }

  public String getName() { return this.name; }

  /**
   * returns the String description, if there is one, else return the String "N/A"
   *
   * @return the description, if there is one
   */
  public String getDescription() {
    return Objects.requireNonNullElse(this.description, "N/A");
  }
  public Days getDayOfWeek() { return this.dayOfWeek; }
  public Boolean isCompleted() { return this.completed; }
}
