package cs3500.pa05.model;

import com.fasterxml.jackson.databind.JsonNode;
import cs3500.pa05.model.json.JsonUtil;
import cs3500.pa05.model.json.Week;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

  /**
   * Creates a WeekView.
   */
  public WeekView() {
    this.eventList = new ArrayList<>();
    this.taskList = new ArrayList<>();
    this.maxEvents = false;
    this.maxTasks = false;
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
    Week weekRecord = new Week(this.maxTask, this.maxEvent, this.eventList, this.taskList);

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
      // Read JSON string from file
      String jsonString = new String(Files.readAllBytes(Paths.get(fileString)));

      // Parse JSON string to JsonNode
      JsonNode jsonNode = JsonUtil.deserializeJson(jsonString);

      // Deserialize JsonNode to Week record
      Week weekRecord = JsonUtil.deserializeRecord(jsonNode, Week.class);

      // Update WeekView object with Week record properties
      this.maxTask = weekRecord.getMaxTask();
      this.maxEvent = weekRecord.getMaxEvent();
      this.eventList.addAll(weekRecord.getEventList());
      this.taskList.addAll(weekRecord.getTaskList());
    } catch (IOException e) {
      System.err.println("An error occurred while deserializing the WeekView object: " +
          e.getMessage());
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
   * Returns the maximum number of events.
   *
   * @return the maximum number of events
   */
  public boolean hasMaximumEvents() {
    return this.maxEvents;
  }

  /**
   * Returns if there is a maximum number of tasks.
   *
   * @return whether there is a maximum number of tasks
   */
  public boolean hasMaximumTasks() {
    return this.maxTasks;
  }

  /**
   *  Clears event and tasks lists
   */
  public void clearAll() {
    this.eventList.clear();
    this.taskList.clear();
  }
}
