package cs3500.pa05.model;

import cs3500.pa05.enumerations.Days;

public class Task {
  String name;
  String description;
  Days dayOfWeek;
  int startTime;
  int duration;

  public Task(String name, String description, Days dayOfWeek, int startTime, int duration) {
    this.name = name;
    this.description = description;
    this.dayOfWeek = dayOfWeek;
    this.startTime = startTime;
    this.duration = duration;
  }
}
