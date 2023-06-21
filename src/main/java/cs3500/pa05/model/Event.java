package cs3500.pa05.model;

import cs3500.pa05.model.enumerations.Days;
import java.util.Objects;

/**
 * To represent an event.
 */
public class Event {
  private String name;
  private String description;
  private Days dayOfWeek;
  private String startTime;
  private String duration;

  /**
   * Creates an Event.
   *
   * @param name        the name of the event
   * @param description the description of the event
   * @param dayOfWeek   the day of the week the event occurs
   * @param startTime   the start time of the event
   * @param duration    how long the event is
   */
  public Event(String name, String description, Days dayOfWeek,
               String startTime, String duration) {
    this.name = name;
    this.description = description;
    this.dayOfWeek = dayOfWeek;
    this.startTime = startTime;
    this.duration = duration;
  }

  /**
   * returns the String name
   *
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * returns the String description, if there is one, else return the String "N/A"
   *
   * @return the description, if there is one
   */
  public String getDescription() {
    return Objects.requireNonNullElse(this.description, "N/A");
  }

  /**
   * @return the day of the week of the event
   */
  public Days getDayOfWeek() {
    return dayOfWeek;
  }

  /**
   * @return the start time of the event
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * @return the duration of the event
   */
  public String getDuration() {
    return duration;
  }
}
