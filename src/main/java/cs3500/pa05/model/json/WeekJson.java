package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import java.util.List;

public record WeekJson(
    @JsonProperty("maxTask") int maxTask,
    @JsonProperty("maxEvent") int maxEvent,
    @JsonProperty("eventList") List<EventJson> eventList,
    @JsonProperty("taskList") List<TaskJson> taskList,
    @JsonProperty("notes") List<String> notes) {

  /**
   * @return the max amount of tasks
   */
  public int getMaxTask() {
    return maxTask;
  }

  /**
   * @return the max amount of events
   */
  public int getMaxEvent() {
    return maxEvent;
  }

  /**
   * @return the events list
   */
  public List<EventJson> getEventList() {
    return eventList;
  }

  /**
   * @return the task list
   */
  public List<TaskJson> getTaskList() {
    return taskList;
  }

  public List<String> getNotes() {
    return notes;
  }
}
