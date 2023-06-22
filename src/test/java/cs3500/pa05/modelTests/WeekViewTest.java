package cs3500.pa05.modelTests;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.WeekView;
import cs3500.pa05.model.enumerations.Days;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WeekViewTest {
  private WeekView weekView;

  @BeforeEach
  void setUp() {
    weekView = new WeekView();
  }

  @Test
  void testSetMaxTask() {
    weekView.setMaxTask(10);
    assertEquals(10, weekView.returnMaxTask());
  }

  @Test
  void testSetMaxEvent() {
    weekView.setMaxEvent(5);
    assertEquals(5, weekView.returnMaxEvent());
  }

  @Test
  public void testSaveFile() {
    // Set some sample data in the WeekView
    weekView.setMaxTask(5);
    weekView.setMaxEvent(10);

    Task task1 = new Task("Task 1", "Description 1", Days.MONDAY, false);
    Task task2 = new Task("Task 2", "Description 2", Days.TUESDAY, true);
    Event event1 = new Event("Event 1", "Description 1", Days.MONDAY, "10:00 AM", 2);
    Event event2 = new Event("Event 2", "Description 2", Days.TUESDAY, "2:00 PM", 1);

    weekView.updateTask(task1);
    weekView.updateTask(task2);
    weekView.updateEvent(event1);
    weekView.updateEvent(event2);

    try {
      File tempFile = Files.createTempFile("weekViewTest", ".json").toFile();

      weekView.saveFile(tempFile);

      assertTrue(tempFile.exists());

      List<String> lines = Files.readAllLines(tempFile.toPath());
      assertEquals(1, lines.size()); // Check the number of lines in the file

      assertEquals("{\"maxTask\":5,\"maxEvent\":10,\"eventList\":[{\"name\":\"Event 1\",\"description\":\"Description 1\",\"dayOfWeek\":\"MONDAY\",\"startTime\":\"10:00 AM\",\"duration\":2},{\"name\":\"Event 2\",\"description\":\"Description 2\",\"dayOfWeek\":\"TUESDAY\",\"startTime\":\"2:00 PM\",\"duration\":1}],\"taskList\":[{\"name\":\"Task 1\",\"description\":\"Description 1\",\"dayOfWeek\":\"MONDAY\",\"completed\":false},{\"name\":\"Task 2\",\"description\":\"Description 2\",\"dayOfWeek\":\"TUESDAY\",\"completed\":true}],\"notes\":[]}", lines.get(0));
      assertEquals("{\"maxTask\":5,\"maxEvent\":10,\"eventList\":[{\"name\":\"Event 1\",\"description\":\"Description 1\",\"dayOfWeek\":\"MONDAY\",\"startTime\":\"10:00 AM\",\"duration\":2},{\"name\":\"Event 2\",\"description\":\"Description 2\",\"dayOfWeek\":\"TUESDAY\",\"startTime\":\"2:00 PM\",\"duration\":1}],\"taskList\":[{\"name\":\"Task 1\",\"description\":\"Description 1\",\"dayOfWeek\":\"MONDAY\",\"completed\":false},{\"name\":\"Task 2\",\"description\":\"Description 2\",\"dayOfWeek\":\"TUESDAY\",\"completed\":true}],\"notes\":[]}", lines.get(0));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testOpenFile() {
    String fileString = "path/to/sample.json";

    // Prepare the content of the JSON file
    String jsonString = "{\"maxTask\": 10, \"maxEvent\": 5, \"eventList\": [{\"name\": \"Event 1\", " +
        "\"description\": \"Event description\", \"dayOfWeek\": \"MONDAY\", \"startTime\": \"10:00 AM\", " +
        "\"duration\": 60}], \"taskList\": [{\"name\": \"Task 1\", \"description\": \"Task description\", " +
        "\"dayOfWeek\": \"TUESDAY\", \"completed\": false}], \"notes\": []}";

    try {
      // Create the JSON file
      Files.write(Paths.get(fileString), jsonString.getBytes());

      // Open the file and populate the WeekView
      weekView.openFile(fileString);

      // Assert the properties of the WeekView
      assertEquals(10, weekView.returnMaxTask());
      assertEquals(5, weekView.returnMaxEvent());

      List<Event> eventList = weekView.returnEventList();
      assertEquals(1, eventList.size());
      Event event = eventList.get(0);
      assertEquals("Event 1", event.getName());
      assertEquals("Event description", event.getDescription());
      assertEquals(Days.MONDAY, event.getDayOfWeek());
      assertEquals("10:00 AM", event.getStartTime());
      assertEquals(60, event.getDuration());

      List<Task> taskList = weekView.returnTaskList();
      assertEquals(1, taskList.size());
      Task task = taskList.get(0);
      assertEquals("Task 1", task.getName());
      assertEquals("Task description", task.getDescription());
      assertEquals(Days.TUESDAY, task.getDayOfWeek());
      assertFalse(task.isCompleted());
    } catch (IOException e) {
    }
  }



  @Test
  void testUpdateTask() {
    Task task = new Task("Task 1", "Task description", Days.MONDAY, false);
    weekView.updateTask(task);

    List<Task> taskList = weekView.returnTaskList();
    assertEquals(1, taskList.size());
    assertEquals(task, taskList.get(0));
  }

  @Test
  void testUpdateEvent() {
    Event event = new Event("Event 1", "Event description", Days.TUESDAY, "10:00 AM", 60);
    weekView.updateEvent(event);

    List<Event> eventList = weekView.returnEventList();
    assertEquals(1, eventList.size());
    assertEquals(event, eventList.get(0));
  }

  @Test
  void testReturnTaskList() {
    List<Task> taskList = weekView.returnTaskList();
    assertNotNull(taskList);
    assertTrue(taskList.isEmpty());
  }

  @Test
  void testReturnEventList() {
    List<Event> eventList = weekView.returnEventList();
    assertNotNull(eventList);
    assertTrue(eventList.isEmpty());
  }

  @Test
  void testReturnMaxTask() {
    assertEquals(-1, weekView.returnMaxTask());
  }

  @Test
  void testReturnMaxEvent() {
    assertEquals(-1, weekView.returnMaxEvent());
  }

  @Test
  void testClearAll() {
    weekView.updateTask(new Task("Task 1", "Task description", Days.MONDAY, false));
    weekView.updateEvent(new Event("Event 1", "Event description", Days.TUESDAY, "10:00 AM", 60));

    weekView.clearAll();

    assertTrue(weekView.returnTaskList().isEmpty());
    assertTrue(weekView.returnEventList().isEmpty());
  }

  @Test
  void testReturnCompletedTasks() {
    Task task1 = new Task("Task 1", "Task description", Days.MONDAY, true);
    Task task2 = new Task("Task 2", "Task description", Days.TUESDAY, false);
    Task task3 = new Task("Task 3", "Task description", Days.WEDNESDAY, true);

    weekView.updateTask(task1);
    weekView.updateTask(task2);
    weekView.updateTask(task3);

    List<Task> completedTasks = weekView.returnCompletedTasks();
    assertEquals(2, completedTasks.size());
    assertTrue(completedTasks.contains(task1));
    assertTrue(completedTasks.contains(task3));
  }

  @Test
  void testChangeQuote() {
    String quote = "This is a new quote";
    weekView.changeQuote(quote);

    assertEquals(quote, weekView.getQuote());
  }

  @Test
  void testGetQuote() {
    assertEquals("Enter your quote.", weekView.getQuote());
  }

  @Test
  public void testGetQuoteWithModifiedQuote() {
    weekView.changeQuote("Original quote");
    assertEquals("Original quote", weekView.getQuote());
  }

  @Test
  public void testChangeQuoteWithEmptyQuote() {
    weekView.changeQuote("");
    assertEquals("", weekView.getQuote());
  }

  @Test
  public void testReturnCompletedTasksNoCompletedTasks() {
    Task task1 = new Task("Task 1", "Description 1", Days.MONDAY, false);
    Task task2 = new Task("Task 2", "Description 2", Days.TUESDAY, false);

    weekView.updateTask(task1);
    weekView.updateTask(task2);

    List<Task> completedTasks = weekView.returnCompletedTasks();
    assertEquals(0, completedTasks.size());
  }
}
