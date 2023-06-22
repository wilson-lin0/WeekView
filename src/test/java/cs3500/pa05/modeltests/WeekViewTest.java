package cs3500.pa05.modeltests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.WeekView;
import cs3500.pa05.model.enumerations.Days;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the WeekView class.
 */
public class WeekViewTest {
  private WeekView weekView;

  @BeforeEach
  public void setUp() {
    weekView = new WeekView();
  }

  @Test
  public void testUpdateTask() {
    Task task = new Task("Task 1", "Description 1", Days.MONDAY, false);
    weekView.updateTask(task);
    assertEquals(1, weekView.returnTaskList().size());
    assertTrue(weekView.returnTaskList().contains(task));
  }

  @Test
  public void testUpdateEvent() {
    Event event = new Event("Event 1", "Description 1", Days.TUESDAY, "10:00", 60);
    weekView.updateEvent(event);
    assertEquals(1, weekView.returnEventList().size());
    assertTrue(weekView.returnEventList().contains(event));
  }

  @Test
  public void testSortTasksAndEventsByDuration() {
    Task task1 = new Task("Task 1", "Description 1", Days.MONDAY, false);
    Task task2 = new Task("Task 2", "Description 2", Days.TUESDAY, true);
    Event event1 = new Event("Event 1", "Description 1", Days.WEDNESDAY, "10:00", 60);
    Event event2 = new Event("Event 2", "Description 2", Days.THURSDAY, "14:00", 120);
    weekView.updateTask(task1);
    weekView.updateTask(task2);
    weekView.updateEvent(event1);
    weekView.updateEvent(event2);

    List<Object> sortedList = weekView.sortTasksAndEventsByDuration();
    assertEquals(4, sortedList.size());
    assertTrue(sortedList.get(0) instanceof Task);
    assertTrue(sortedList.get(1) instanceof Task);
    assertTrue(sortedList.get(2) instanceof Event);
    assertTrue(sortedList.get(3) instanceof Event);
    assertEquals(task1, sortedList.get(0));
    assertEquals(task2, sortedList.get(1));
    assertEquals(event1, sortedList.get(2));
    assertEquals(event2, sortedList.get(3));
  }

  @Test
  public void testSortTasksAndEventsByName() {
    Task task1 = new Task("Task 1", "Description 1", Days.MONDAY, false);
    Task task2 = new Task("Task 2", "Description 2", Days.TUESDAY, true);
    Event event1 = new Event("Event 1", "Description 1", Days.WEDNESDAY, "10:00", 60);
    Event event2 = new Event("Event 2", "Description 2", Days.THURSDAY, "14:00", 120);
    weekView.updateTask(task1);
    weekView.updateTask(task2);
    weekView.updateEvent(event1);
    weekView.updateEvent(event2);

    List<Object> sortedList = weekView.sortTasksAndEventsByName();
    assertEquals(4, sortedList.size());
    assertTrue(sortedList.get(0) instanceof Event);
    assertTrue(sortedList.get(1) instanceof Event);
    assertTrue(sortedList.get(2) instanceof Task);
    assertTrue(sortedList.get(3) instanceof Task);
    assertEquals(event1, sortedList.get(0));
    assertEquals(event2, sortedList.get(1));
    assertEquals(task1, sortedList.get(2));
    assertEquals(task2, sortedList.get(3));
  }
}
