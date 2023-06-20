package cs3500.pa05.model;

import cs3500.pa05.model.enumerations.Days;

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
   * @param name the name of the event
   * @param description the description of the event
   * @param dayOfWeek the day of the week the event occurs
   * @param startTime the start time of the event
   * @param duration how long the event is
   */
  public Event(String name, String description, Days dayOfWeek,
               String startTime, String duration) {
    this.name = name;
    this.description = description;
    this.dayOfWeek = dayOfWeek;
    this.startTime = startTime;
    this.duration = duration;
  }
}
