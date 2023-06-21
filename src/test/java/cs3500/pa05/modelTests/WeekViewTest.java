package cs3500.pa05.modelTests;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.WeekView;
import cs3500.pa05.model.enumerations.Days;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WeekViewTest {
  private WeekView weekView;
  private File testFile;

  @BeforeEach
  public void setUp() {
    weekView = new WeekView();
    testFile = new File("test.json");
  }

  @Test
  public void testSetMaxTask() {
    weekView.setMaxTask(5);
    assertEquals(5, weekView.returnMaxTask());
  }

  @Test
  public void testSetMaxEvent() {
    weekView.setMaxEvent(10);
    assertEquals(10, weekView.returnMaxEvent());
  }

  @Test
  public void testSaveFile() {
    Task task1 = new Task("Task 1", "Description 1", Days.MONDAY, false);
    Event event1 = new Event("Event 1", "Description 1", Days.TUESDAY, "09:00", "10:00");
    weekView.updateTask(task1);
    weekView.updateEvent(event1);

    weekView.saveFile(testFile);

    assertTrue(testFile.exists());
    assertTrue(testFile.length() > 0);
  }

  @Test
  public void testOpenFile() throws IOException {
    String jsonString = "{\"maxTask\": 5, \"maxEvent\": 10, \"eventList\": [], \"taskList\": []}";

    Files.write(testFile.toPath(), jsonString.getBytes());

    weekView.openFile(testFile.getPath());

    // Verify the WeekView properties
    assertEquals(5, weekView.returnMaxTask());
    assertEquals(10, weekView.returnMaxEvent());
    assertTrue(weekView.returnEventList().isEmpty());
    assertTrue(weekView.returnTaskList().isEmpty());
  }

  @Test
  public void testCreateFile() {
    weekView.createFile(testFile.getPath());

    assertTrue(testFile.exists());
    assertTrue(testFile.length() > 0);

    weekView.openFile(testFile.getPath());

    assertEquals(0, weekView.returnMaxTask());
    assertEquals(0, weekView.returnMaxEvent());
    assertTrue(weekView.returnEventList().isEmpty());
    assertTrue(weekView.returnTaskList().isEmpty());
  }

  @Test
  public void testUpdateTask() {
    Task task = new Task("Task 1", "Description 1", Days.MONDAY, false);
    weekView.updateTask(task);
    List<Task> taskList = weekView.returnTaskList();
    assertEquals(1, taskList.size());
    assertTrue(taskList.contains(task));
  }

  @Test
  public void testUpdateEvent() {
    Event event = new Event("Event 1", "Description 1", Days.TUESDAY, "09:00", "10:00");
    weekView.updateEvent(event);
    List<Event> eventList = weekView.returnEventList();
    assertEquals(1, eventList.size());
    assertTrue(eventList.contains(event));
  }

  @Test
  public void testClearAll() {
    Task task1 = new Task("Task 1", "Description 1", Days.MONDAY, false);
    Event event1 = new Event("Event 1", "Description 1", Days.TUESDAY, "09:00", "10:00");
    weekView.updateTask(task1);
    weekView.updateEvent(event1);

    weekView.clearAll();

    assertTrue(weekView.returnTaskList().isEmpty());
    assertTrue(weekView.returnEventList().isEmpty());
  }
}

