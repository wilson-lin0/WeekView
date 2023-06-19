package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;

public class WeekView {
  int maxTask;
  int maxEvent;
  List<Event> eventList;
  List<Task> taskList;

  public WeekView(int maxTask, int maxEvent) {
    this.maxEvent = maxEvent;
    this.maxTask = maxTask;
    this.eventList = new ArrayList<>();
    this.taskList = new ArrayList<>();
  }

  public void saveFile() {

  }

  public void openFile() {

  }

  public void displayWarning() {

  }

  public void updateTask(Task task) {
    taskList.add(task);
  }

  public void updateEvent(Event event) {
    eventList.add(event);
  }

  public List<Task> returnTaskList() {
    return this.taskList;
  }

  public List<Event> returnEventList() {
    return this.eventList;
  }

  public void taskQueue() {

  }
}
