package cs3500.pa05.modeltests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cs3500.pa05.model.Task;
import cs3500.pa05.model.enumerations.Days;
import org.junit.jupiter.api.Test;

/**
 * Tests the Task class.
 */
public class TaskTest {

  @Test
  public void testGetName() {
    Task task = new Task("Task 1", "Description 1", Days.MONDAY, false);
    assertEquals("Task 1", task.getName());
  }

  @Test
  public void testGetDescription() {
    Task task = new Task("Task 1", "Description 1", Days.MONDAY, false);
    assertEquals("Description 1", task.getDescription());
  }

  @Test
  public void testGetDescriptionWithNull() {
    Task task = new Task("Task 1", null, Days.MONDAY, false);
    assertEquals("N/A", task.getDescription());
  }

  @Test
  public void testGetDayOfWeek() {
    Task task = new Task("Task 1", "Description 1", Days.MONDAY, false);
    assertEquals(Days.MONDAY, task.getDayOfWeek());
  }

  @Test
  public void testIsCompleted() {
    Task task = new Task("Task 1", "Description 1", Days.MONDAY, false);
    assertFalse(task.isCompleted());
  }

  @Test
  public void testToString() {
    Task task = new Task("Task 1", "Description 1", Days.MONDAY, false);
    String expected = "Task: Task 1\nDescription: Description 1\nDay of Week: MONDAY\n"
        + "Completed: false";
    assertEquals(expected, task.toString());
  }

  @Test
  public void testEquals() {
    Task task1 = new Task("Task 1", "Description 1", Days.MONDAY, false);
    Task task2 = new Task("Task 1", "Description 1", Days.MONDAY, false);
    Task task3 = new Task("Task 2", "Description 2", Days.TUESDAY, true);

    assertEquals(task1, task2);
    assertNotEquals(task1, task3);
  }

  @Test
  public void testEquals_notEqualCompleted() {
    Task task1 = new Task("Task 1", "Description 1", Days.MONDAY, false);
    Task task2 = new Task("Task 1", "Description 1", Days.MONDAY, true);
    assertNotEquals(task1, task2);
  }

  @Test
  public void testEquals_nullDayOfWeek() {
    Task task1 = new Task("Task 1", "Description 1", Days.MONDAY, false);
    Task task2 = new Task("Task 1", "Description 1", null, false);
    assertNotEquals(task1, task2);
  }

  @Test
  public void testEquals_nullDescription() {
    Task task1 = new Task("Task 1", "Description 1", Days.MONDAY, false);
    Task task2 = new Task("Task 1", null, Days.MONDAY, false);
    assertNotEquals(task1, task2);
  }

  @Test
  public void testEquals_nullName() {
    Task task1 = new Task("Task 1", "Description 1", Days.MONDAY, false);
    Task task2 = new Task(null, "Description 1", Days.MONDAY, false);
    assertNotEquals(task1, task2);
  }

  @Test
  public void testEquals_differentObjectTypes() {
    Task task = new Task("Task 1", "Description 1", Days.MONDAY, false);
    String differentType = "Not a Task object";
    assertNotEquals(task, differentType);
  }

  @Test
  public void testEquals_nullObject() {
    Task task = new Task("Task 1", "Description 1", Days.MONDAY, false);
    assertNotEquals(task, null);
  }

  @Test
  public void testEquals_notEqualName() {
    Task task1 = new Task("Task 1", "Description 1", Days.MONDAY, false);
    Task task2 = new Task("Task 2", "Description 1", Days.MONDAY, false);
    assertNotEquals(task1, task2);
  }
}
