package cs3500.pa05.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.enumerations.Days;
import cs3500.pa05.model.json.EventJson;
import cs3500.pa05.model.json.JsonUtil;
import cs3500.pa05.model.json.TaskJson;
import cs3500.pa05.model.json.WeekJson;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * To represent a WeekView.
 */
public class WeekView {
  private boolean maxTasks;
  private boolean maxEvents;
  private int maxTask;
  private int maxEvent;
  private List<Event> eventList;
  private List<Task> taskList;
  private List<String> notes;
  private String quote;
  private final ObjectMapper mapper = new ObjectMapper();

  /**
   * Creates a WeekView.
   */
  public WeekView() {
    this.eventList = new ArrayList<>();
    this.taskList = new ArrayList<>();
    this.notes = new ArrayList<>();
    this.maxEvent = -1;
    this.maxTask = -1;
    this.quote = "Enter your quote.";
  }

  /**
   * Sets the maximum number of tasks.
   *
   * @param max the maximum number of tasks.
   */
  public void setMaxTask(int max) {
    this.maxTask = max;
  }

  /**
   * Sets the maximum number of events.
   *
   * @param max the maximum number of events.
   */
  public void setMaxEvent(int max) {
    this.maxEvent = max;
  }

  /**
   * Saves the WeekView to a file.
   *
   * @param fileName the name of the file the WeekView is to be saved
   */
  public void saveFile(File fileName) {
    // Convert WeekView properties to Week record
    List<EventJson> eventJsons = new ArrayList<>();
    for (Event event : eventList) {
      String name = event.getName();
      String description = event.getDescription();
      Days day = event.getDayOfWeek();
      String startTime = event.getStartTime();
      int duration = event.getDuration();
      EventJson eventJson = new EventJson(name, description, day, startTime, duration);
      eventJsons.add(eventJson);
    }
    List<TaskJson> taskJsons = new ArrayList<>();
    for (Task task : taskList) {
      String name = task.getName();
      String description = task.getDescription();
      Days day = task.getDayOfWeek();
      boolean completed = task.isCompleted();
      TaskJson taskJson = new TaskJson(name, description, day, completed);
      taskJsons.add(taskJson);
    }
    WeekJson
        weekRecord = new WeekJson(this.maxTask, this.maxEvent, eventJsons, taskJsons, this.notes);

    // Convert Week record to JSON
    JsonNode jsonNode = JsonUtil.serializeRecord(weekRecord);
    String jsonString = jsonNode.toString();

    // Write JSON string to file
    FileWriter fileWriter = new FileWriter(fileName);
    fileWriter.writeToFile(jsonString);
  }

  /**
   * Opens a file and converts it back to a WeekView.
   *
   * @param fileString the name of the file to open
   */
  public void openFile(String fileString) {
    try {
      String jsonString = new String(Files.readAllBytes(Paths.get(fileString)));
      JsonNode jsonNode;
      jsonNode = JsonUtil.deserializeJson(jsonString);
      WeekJson weekRecord = mapper.convertValue(jsonNode, WeekJson.class);
      this.maxTask = weekRecord.getMaxTask();
      this.maxEvent = weekRecord.getMaxEvent();
      List<EventJson> eventJsons = weekRecord.getEventList();
      for (EventJson eventJson : eventJsons) {
        String name = eventJson.getName();
        String description = eventJson.getDescription();
        Days day = eventJson.getDayOfWeek();
        String startTime = eventJson.getStartTime();
        int duration = eventJson.getDuration();
        Event event = new Event(name, description, day, startTime, duration);
        eventList.add(event);
      }
      List<TaskJson> taskJsons = weekRecord.getTaskList();
      for (TaskJson taskJson : taskJsons) {
        String name = taskJson.getName();
        String description = taskJson.getDescription();
        Days day = taskJson.getDayOfWeek();
        boolean completed = taskJson.getCompleted();
        Task task = new Task(name, description, day, completed);
        taskList.add(task);
      }
      this.notes.addAll(weekRecord.getNotes());
    } catch (IOException e) {
      System.err.println("An error occurred while deserializing the WeekView object: "
          + e.getMessage());
    }
  }


  /**
   * Creates an empty file
   *
   * @param fileString the name of the file to be created
   */
  public void createFile(String fileString) {
    File bujoFile = new File(fileString);
    saveFile(bujoFile);
  }

  /**
   * Adds a task to the list of tasks.
   *
   * @param task the task to add
   */
  public void updateTask(Task task) {
    taskList.add(task);
  }

  /**
   * Adds an event ot the list of events.
   *
   * @param event the event to add
   */
  public void updateEvent(Event event) {
    eventList.add(event);
  }

  /**
   * Returns the task list.
   *
   * @return the task list
   */
  public List<Task> returnTaskList() {
    return this.taskList;
  }

  /**
   * Returns the event list.
   *
   * @return the event list
   */
  public List<Event> returnEventList() {
    return this.eventList;
  }

  /**
   * Returns the maximum number of tasks.
   *
   * @return the maximum number of tasks
   */
  public int returnMaxTask() {
    return this.maxTask;
  }

  /**
   * Returns the maximum number of events.
   *
   * @return the maximum number of events
   */
  public int returnMaxEvent() {
    return this.maxEvent;
  }

  /**
   *  Clears event and tasks lists
   */
  public void clearAll() {
    this.eventList.clear();
    this.taskList.clear();
  }

  /**
   * Returns the list of completed tasks.
   *
   * @return the completed tasks
   */
  public List<Task> returnCompletedTasks() {
    List<Task> returnList = new ArrayList<>();
    for (Task task : taskList) {
      if (task.isCompleted()) {
        returnList.add(task);
      }
    }
    return returnList;
  }

  /**
   * Sorts the tasks and events by duration.
   *
   * @return the list of events and tasks
   */
  public List<Object> sortTasksAndEventsByDuration() {
    List<Object> tasksAndEvents = new ArrayList<>();
    tasksAndEvents.addAll(this.taskList);
    Collections.sort(this.eventList, new Comparator<Event>() {
      @Override
      public int compare(Event event1, Event event2) {
        int duration1 = event1.getDuration();
        int duration2 = event2.getDuration();
        return Integer.compare(duration1, duration2);
      }
    });
    tasksAndEvents.addAll(eventList);
    return tasksAndEvents;
  }

  /**
   * Sorts the tasks and events by name.
   *
   * @return the list of events and tasks
   */
  public List<Object> sortTasksAndEventsByName() {
    List<Object> tasksAndEvents = new ArrayList<>();
    tasksAndEvents.addAll(eventList);
    tasksAndEvents.addAll(taskList);
    Collections.sort(tasksAndEvents, (obj1, obj2) -> {
      String name1 = null;
      String name2 = null;
      if (obj1 instanceof Event) {
        name1 = ((Event) obj1).getName();
      } else if (obj1 instanceof Task) {
        name1 = ((Task) obj1).getName();
      }
      if (obj2 instanceof Event) {
        name2 = ((Event) obj2).getName();
      } else if (obj2 instanceof Task) {
        name2 = ((Task) obj2).getName();
      }
      return name1.compareTo(name2);
    });
    return tasksAndEvents;
  }
}
