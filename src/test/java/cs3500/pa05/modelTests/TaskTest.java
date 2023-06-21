package cs3500.pa05.modelTests;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.enumerations.Days;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
  private Task task;

  @BeforeEach
  public void setUp() {
    String name = "Task 1";
    String description = "Description 1";
    Days dayOfWeek = Days.MONDAY;

    task = new Task(name, description, dayOfWeek, false);
  }

  @Test
  public void testTaskInitialization() {
    assertEquals("Task 1", task.getName());
    assertEquals("Description 1", task.getDescription());
    assertEquals(Days.MONDAY, task.getDayOfWeek());
    assertFalse(task.isCompleted());
  }

  @Test
  public void testToString() {
    String expected = "Task: Task 1\nDescription: Description 1\nDay of Week: MONDAY\nCompleted: false";
    assertEquals(expected, task.toString());
  }
}
