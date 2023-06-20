package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import java.util.List;

public record Week(
    @JsonProperty("maxTask") int maxTask,
    @JsonProperty("maxEvent") int maxEvent,
    @JsonProperty("eventList") List<Event> eventList,
    @JsonProperty("taskList") List<Task> taskList) {

  public int getMaxTask() {
    return maxTask;
  }

  public int getMaxEvent() {
    return maxEvent;
  }

  public List<Event> getEventList() {
    return eventList;
  }

  public List<Task> getTaskList() {
    return taskList;
  }
}
