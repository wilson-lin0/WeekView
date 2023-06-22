package cs3500.pa05.modelTests;

import cs3500.pa05.model.json.WeekJson;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WeekJsonTest {
  private WeekJson week;

  @BeforeEach
  public void setUp() {
    List<Event> events = Arrays.asList(new Event("Event 1", "Description 1",
            null, "0", "1"),
        new Event("Event 2", "Description 2", null,
            "1", "2"));
    List<Task> tasks = Arrays.asList(new Task("Task 1", "Description 1",
            null),
        new Task("Task 2", "Description 2", null));
    week = new WeekJson(5, 10, events, tasks);
  }

  @Test
  public void testGetMaxTask() {
    assertEquals(5, week.getMaxTask());
  }

  @Test
  public void testGetMaxEvent() {
    assertEquals(10, week.getMaxEvent());
  }

  @Test
  public void testGetEventList() {
    List<Event> expectedEvents = Arrays.asList(new Event("Event 1", "Description 1",
            null, "0", "1"),
        new Event("Event 2", "Description 2", null,
            "1", "2"));
    assertNotNull(week.getEventList());
    assertEquals(expectedEvents, week.getEventList());
  }

  @Test
  public void testGetTaskList() {
    List<Task> expectedTasks = Arrays.asList(new Task("Task 1", "Description 1",
            null),
        new Task("Task 2", "Description 2", null));
    assertNotNull(week.getTaskList());
    assertEquals(expectedTasks, week.getTaskList());
  }
}
