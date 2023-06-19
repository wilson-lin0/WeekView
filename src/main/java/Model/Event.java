public class Event {
  String name;
  String description;
  Day dayOfTheWeek;
  int startTime;
  int duration;

  public Event(String name, String description, Day dayOfTheWeek, int startTime, int duration) {
    this.name = name;
    this.description = description;
    this.dayOfTheWeek = dayOfTheWeek;
    this.startTime = startTime;
    this.duration = duration;
  }


}

