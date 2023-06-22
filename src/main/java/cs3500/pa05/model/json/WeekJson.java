package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a WeekView.
 *
 * @param maxTask max tasks allowed
 * @param maxEvent max events allowed
 * @param eventList the list of events
 * @param taskList the list of tasks
 * @param notes any notes
 */
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
