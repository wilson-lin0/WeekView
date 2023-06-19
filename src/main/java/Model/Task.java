public class Task {
  String name;
  String description;
  Day dayOfTheWeek;
  int startTime;
  int duration;

  public Task(String name, String description, Day dayOfTheWeek, int startTime, int duration) {
    this.name = name;
    this.description = description;
    this.dayOfTheWeek = dayOfTheWeek;
    this.startTime = startTime;
    this.duration = duration;
  }
}

