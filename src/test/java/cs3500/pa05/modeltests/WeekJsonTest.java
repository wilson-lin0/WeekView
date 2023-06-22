package cs3500.pa05.modeltests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.json.EventJson;
import cs3500.pa05.model.json.TaskJson;
import cs3500.pa05.model.json.WeekJson;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the WeekJson class.
 */
public class WeekJsonTest {

  private WeekJson weekJson;

  /**
   * Sets up the test fixture.
   */
  @BeforeEach
  public void setUp() {
    List<EventJson> eventList = Arrays.asList(new EventJson("Event 1",
            "Description 1", null, "10:00", 60),
        new EventJson("Event 2", "Description 2", null,
            "14:00", 120));
    List<TaskJson> taskList = Arrays.asList(new TaskJson("Task 1",
            "Description 1", null, true),
        new TaskJson("Task 2", "Description 2", null, false));
    List<String> notes = Arrays.asList("Note 1", "Note 2", "Note 3");
    weekJson = new WeekJson(5, 10, eventList, taskList, notes);
  }

  @Test
  public void testGetMaxTask() {
    assertEquals(5, weekJson.getMaxTask());
  }

  @Test
  public void testGetMaxEvent() {
    assertEquals(10, weekJson.getMaxEvent());
  }

  @Test
  public void testGetEventList() {
    List<EventJson> eventList = Arrays.asList(new EventJson("Event 1",
            "Description 1", null, "10:00", 60),
        new EventJson("Event 2", "Description 2", null,
            "14:00", 120));
    assertEquals(eventList, weekJson.getEventList());
  }

  @Test
  public void testGetTaskList() {
    List<TaskJson> taskList = Arrays.asList(new TaskJson("Task 1",
            "Description 1", null, true),
        new TaskJson("Task 2", "Description 2", null, false));
    assertEquals(taskList, weekJson.getTaskList());
  }

  @Test
  public void testGetNotes() {
    List<String> notes = Arrays.asList("Note 1", "Note 2", "Note 3");
    assertEquals(notes, weekJson.getNotes());
  }
}
