package cs3500.pa05.model;

import cs3500.pa05.enumerations.Days;

public class Event {
  String name;
  String description;
  Days dayOfWeek;
  int startTime;
  int duration;

  public Event(String name, Days dayOfWeek, int startTime, int duration) {
    this.name = name;
    this.dayOfWeek = dayOfWeek;
    this.startTime = startTime;
    this.duration = duration;
    this.description = "";
  }

  public Event createEvent(String name, Days dayOfWeek, int startTime, int duration,
                           String description) {
    return null;
  }
}
