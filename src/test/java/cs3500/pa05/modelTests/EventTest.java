package cs3500.pa05.modelTests;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.enumerations.Days;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EventTest {

  @Test
  public void testEventInitialization() {
    String name = "Event 1";
    String description = "Description 1";
    Days dayOfWeek = Days.MONDAY;
    String startTime = "10:00 AM";
    String duration = "1 hour";

    Event event = new Event(name, description, dayOfWeek, startTime, duration);

    assertEquals("Event 1", event.getName());
    assertEquals("Description 1", event.getDescription());
    assertEquals(Days.MONDAY, event.getDayOfWeek());
    assertEquals("10:00 AM", event.getStartTime());
    assertEquals("1 hour", event.getDuration());
  }

  @Test
  public void testEventDescriptionNull() {
    String name = "Event 2";
    Days dayOfWeek = Days.TUESDAY;
    String startTime = "2:00 PM";
    String duration = "2 hours";

    Event event = new Event(name, null, dayOfWeek, startTime, duration);

    assertEquals("N/A", event.getDescription());
  }

  @Test
  public void testGetName() {
    String name = "Event 3";
    Event event = new Event(name, null, Days.WEDNESDAY, "12:00 PM", "1 hour");

    assertEquals("Event 3", event.getName());
  }

  @Test
  public void testGetDayOfWeek() {
    Days dayOfWeek = Days.THURSDAY;
    Event event = new Event("Event 4", null, dayOfWeek, "3:00 PM", "2 hours");

    assertEquals(Days.THURSDAY, event.getDayOfWeek());
  }

  @Test
  public void testGetStartTime() {
    String startTime = "9:00 AM";
    Event event = new Event("Event 5", null, Days.FRIDAY, startTime, "1 hour");

    assertEquals("9:00 AM", event.getStartTime());
  }

  @Test
  public void testGetDuration() {
    String duration = "3 hours";
    Event event = new Event("Event 6", null, Days.SATURDAY, "2:00 PM", duration);

    assertEquals("3 hours", event.getDuration());
  }

  @Test
  public void testEquals() {
    Event event1 = new Event("Event 7", "Description 1", Days.SUNDAY, "10:00 AM", "1 hour");
    Event event2 = new Event("Event 7", "Description 1", Days.SUNDAY, "10:00 AM", "1 hour");

    assertEquals(event1, event2);
  }

  @Test
  public void testNotEquals() {
    Event event1 = new Event("Event 8", "Description 1", Days.MONDAY, "2:00 PM", "2 hours");
    Event event2 = new Event("Event 9", "Description 2", Days.TUESDAY, "3:00 PM", "1 hour");

    assertNotEquals(event1, event2);
  }
}

