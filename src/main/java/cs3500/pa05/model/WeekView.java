package cs3500.pa05.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.controller.FileReader;
import cs3500.pa05.controller.FileWriter;
import cs3500.pa05.json.JsonUtil;
import cs3500.pa05.json.Week;
import java.io.File;
import java.io.IOException;
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

  public void setMaxTask(int max) {
    this.maxTask = max;
  }

  public void setMaxEvent(int max) {
    this.maxEvent = max;
  }

  public void saveFile(File fileName) {
    // Convert WeekView properties to Week record
    Week weekRecord = new Week(this.maxTask, this.maxEvent, this.eventList, this.taskList);

    // Convert Week record to JSON
    JsonNode jsonNode = JsonUtil.serializeRecord(weekRecord);
    String jsonString = jsonNode.toString();

    // Write JSON string to file
    FileWriter fileWriter = new FileWriter();
    fileWriter.writeToFile(fileName, jsonString);
  }

  public void openFile(File fileName) {
    try {
      // Read JSON string from file
      FileReader fileReader = new FileReader();
      String jsonString = fileReader.readFile(fileName);

      // Parse JSON string to JsonNode
      JsonNode jsonNode = JsonUtil.deserializeJson(jsonString);

      // Deserialize JsonNode to Week record
      Week weekRecord = JsonUtil.deserializeRecord(jsonNode, Week.class);

      // Update WeekView object with Week record properties
      this.maxTask = weekRecord.maxTask();
      this.maxEvent = weekRecord.maxEvent();
      this.eventList.clear();
      this.eventList.addAll(weekRecord.eventList());
      this.taskList.clear();
      this.taskList.addAll(weekRecord.taskList());
    } catch (IOException e) {
      System.out.println("An error occurred while deserializing the WeekView object: " + e.getMessage());
    }
  }

  public void displayWarning() {}

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

  public void taskQueue() {}
}
