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
   * @param completed whether the task is completed or not
   */
  public Task(String name, String description, Days dayOfWeek, boolean completed) {
    this.name = name;
    this.description = description;
    this.dayOfWeek = dayOfWeek;
    this.completed = completed;
  }

  public String getName() { return this.name; }

  /**
   * Returns the String description, if there is one, else returns the String "N/A".
   *
   * @return the description, if there is one
   */
  public String getDescription() {
    return Objects.requireNonNullElse(this.description, "N/A");
  }

  /**
   * Returns the day of the week.
   *
   * @return the day of the week
   */
  public Days getDayOfWeek() { return this.dayOfWeek; }

  /**
   * Returns whether the task is completed or not.
   *
   * @return true if the task is completed, false otherwise
   */
  public Boolean isCompleted() { return this.completed; }

  @Override
  public String toString() {
    return "Task: " + name + "\nDescription: " + getDescription() +
        "\nDay of Week: " + dayOfWeek +
        "\nCompleted: " + completed;
  }
}
