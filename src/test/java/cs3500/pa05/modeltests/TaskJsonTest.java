package cs3500.pa05.modeltests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.enumerations.Days;
import cs3500.pa05.model.json.TaskJson;
import org.junit.jupiter.api.Test;

/**
 * Tests TaskJson class.
 */
public class TaskJsonTest {

  @Test
  public void testGetName() {
    TaskJson task = new TaskJson("Task 1", "Do something",
        Days.MONDAY, true);
    assertEquals("Task 1", task.getName());
  }

  @Test
  public void testGetDescription() {
    TaskJson task = new TaskJson("Task 1", "Do something", Days.MONDAY,
        true);
    assertEquals("Do something", task.getDescription());
  }

  @Test
  public void testGetDayOfWeek() {
    TaskJson task = new TaskJson("Task 1", "Do something", Days.MONDAY,
        true);
    assertEquals(Days.MONDAY, task.getDayOfWeek());
  }

  @Test
  public void testGetCompleted() {
    TaskJson task = new TaskJson("Task 1", "Do something", Days.MONDAY,
        true);
    assertTrue(task.getCompleted());
  }

  @Test
  void testEquals() {
    TaskJson task1 = new TaskJson("Task 1", "Do something", Days.MONDAY,
        true);
    TaskJson task2 = new TaskJson("Task 1", "Do something", Days.MONDAY,
        true);

    assertEquals(task1, task2);
  }

  @Test
  void testToString() {
    TaskJson task = new TaskJson("Task 1", "Do something", Days.MONDAY,
        true);

    String expected = "TaskJson[name=Task 1, description=Do something, "
        + "dayOfWeek=MONDAY, completed=true]";

    assertEquals(expected, task.toString());
  }
}
