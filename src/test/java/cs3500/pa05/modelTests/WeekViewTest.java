package cs3500.pa05.modelTests;

import cs3500.pa05.model.*;
import cs3500.pa05.model.enumerations.Days;
import cs3500.pa05.model.json.EventJson;
import cs3500.pa05.model.json.TaskJson;
import cs3500.pa05.model.json.WeekJson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WeekViewTest {

  private WeekView weekView;

  @BeforeEach
  public void setup() {
    weekView = new WeekView();
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
  public void testOpenFile() {
    WeekJson weekJson = new WeekJson(
        3,
        5,
        List.of(
            new EventJson("Meeting", "Discuss project", Days.MONDAY,
                "10:00", 60),
            new EventJson("Presentation", "Deliver presentation", Days.TUESDAY,
                "2:00", 90)
        ),
        List.of(
            new TaskJson("Homework", "Complete assignment", Days.MONDAY,
                false),
            new TaskJson("Study", "Prepare for exam", Days.TUESDAY,
                false)
        ),
        List.of("Note 1", "Note 2")
    );

    WeekView weekView = new WeekView();
    File testFile = new File("test.json");
    weekView.saveFile(testFile);

    WeekView loadedWeekView = new WeekView();
    loadedWeekView.openFile("test.json");

    List<Event> events = loadedWeekView.returnEventList();
    assertEquals(0, events.size());

    List<Task> tasks = loadedWeekView.returnTaskList();
    assertEquals(0, tasks.size());

    testFile.delete();
  }

  @Test
  public void testUpdateTask() {
    Task task = new Task("Homework", "Complete assignment", Days.MONDAY, false);
    weekView.updateTask(task);

    List<Task> tasks = weekView.returnTaskList();
    assertEquals(1, tasks.size());
    assertEquals("Homework", tasks.get(0).getName());
    assertEquals("Complete assignment", tasks.get(0).getDescription());
  }

  @Test
  public void testUpdateEvent() {
    Event event = new Event("Meeting", "Discuss project", Days.TUESDAY, "2:00 PM", 60);
    weekView.updateEvent(event);

    List<Event> events = weekView.returnEventList();
    assertEquals(1, events.size());
    assertEquals("Meeting", events.get(0).getName());
    assertEquals("Discuss project", events.get(0).getDescription());
  }

  @Test
  public void testReturnTaskList() {
    Task task1 = new Task("Homework", "Complete assignment", Days.MONDAY, false);
    Task task2 = new Task("Study", "Prepare for exam", Days.TUESDAY, false);

    weekView.updateTask(task1);
    weekView.updateTask(task2);

    List<Task> tasks = weekView.returnTaskList();
    assertEquals(2, tasks.size());
    assertEquals("Homework", tasks.get(0).getName());
    assertEquals("Study", tasks.get(1).getName());
  }

  @Test
  public void testReturnEventList() {
    Event event1 = new Event("Meeting", "Discuss project", Days.MONDAY, "10:00 AM", 60);
    Event event2 = new Event("Presentation", "Deliver presentation", Days.TUESDAY, "2:00 PM", 90);

    weekView.updateEvent(event1);
    weekView.updateEvent(event2);

    List<Event> events = weekView.returnEventList();
    assertEquals(2, events.size());
    assertEquals("Meeting", events.get(0).getName());
    assertEquals("Presentation", events.get(1).getName());
  }

  @Test
  public void testReturnMaxTask() {
    weekView.setMaxTask(5);
    assertEquals(5, weekView.returnMaxTask());
  }

  @Test
  public void testReturnMaxEvent() {
    weekView.setMaxEvent(10);
    assertEquals(10, weekView.returnMaxEvent());
  }

  @Test
  public void testHasMaximumEvents() {
    assertFalse(weekView.hasMaximumEvents());

    weekView.setMaxEvent(5);
    assertFalse(weekView.hasMaximumEvents());
  }

  @Test
  public void testHasMaximumTasks() {
    assertFalse(weekView.hasMaximumTasks());
    weekView.setMaxTask(3);
    assertFalse(weekView.hasMaximumTasks());
  }

  @Test
  public void testClearAll() {
    Event event = new Event("Meeting", "Discuss project", Days.MONDAY,
        "10:00", 60);
    Task task = new Task("Homework", "Complete assignment", Days.TUESDAY,
        false);

    weekView.updateEvent(event);
    weekView.updateTask(task);

    weekView.clearAll();

    List<Event> events = weekView.returnEventList();
    List<Task> tasks = weekView.returnTaskList();

    assertTrue(events.isEmpty());
    assertTrue(tasks.isEmpty());
  }

  @Test
  public void testReturnCompletedTasks() {
    Task task1 = new Task("Homework", "Complete assignment", Days.MONDAY, true);
    Task task2 = new Task("Study", "Prepare for exam", Days.TUESDAY, false);
    Task task3 = new Task("Read", "Read a book", Days.WEDNESDAY, true);

    weekView.updateTask(task1);
    weekView.updateTask(task2);
    weekView.updateTask(task3);

    List<Task> completedTasks = weekView.returnCompletedTasks();
    assertEquals(2, completedTasks.size());
    assertEquals("Homework", completedTasks.get(0).getName());
    assertEquals("Read", completedTasks.get(1).getName());
  }

  @Test
  public void testChangeQuote() {
    weekView.changeQuote("This is a new quote.");
    assertEquals("This is a new quote.", weekView.getQuote());
  }

  @Test
  public void testGetQuote() {
    assertEquals("Enter your quote.", weekView.getQuote());
  }
}

