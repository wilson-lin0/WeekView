package cs3500.pa05.modeltests;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.enumerations.Days;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests the Event class.
 */
public class EventTest {

  @Test
  public void testEquals_sameObject() {
    Event event = new Event("Event 1", "Description 1",
        Days.MONDAY, "10:00", 60);
    Assertions.assertEquals(event, event);
  }

  @Test
  public void testEquals_equalEvents() {
    Event event1 = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 60);
    Event event2 = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 60);
    Assertions.assertEquals(event1, event2);
  }

  @Test
  public void testEquals_notEqualEvents() {
    Event event1 = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 60);
    Event event2 = new Event("Event 2", "Description 2", Days.TUESDAY,
        "14:00", 120);
    Assertions.assertNotEquals(event1, event2);
  }

  @Test
  public void testGetName() {
    Event event = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 60);
    Assertions.assertEquals("Event 1", event.getName());
  }

  @Test
  public void testGetDescription_withDescription() {
    Event event = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 60);
    Assertions.assertEquals("Description 1", event.getDescription());
  }

  @Test
  public void testGetDescription_withoutDescription() {
    Event event = new Event("Event 1", null, Days.MONDAY,
        "10:00", 60);
    Assertions.assertEquals("N/A", event.getDescription());
  }

  @Test
  public void testGetDayOfWeek() {
    Event event = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 60);
    Assertions.assertEquals(Days.MONDAY, event.getDayOfWeek());
  }

  @Test
  public void testGetStartTime() {
    Event event = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 60);
    Assertions.assertEquals("10:00", event.getStartTime());
  }

  @Test
  public void testGetDuration() {
    Event event = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 60);
    Assertions.assertEquals(60, event.getDuration());
  }

  @Test
  public void testEquals_differentObjectTypes() {
    Event event = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 60);
    String differentType = "Not an Event object";
    Assertions.assertNotEquals(event, differentType);
  }

  @Test
  public void testEquals_nullObject() {
    Event event = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 60);
    Assertions.assertNotEquals(event, null);
  }

  @Test
  public void testGetDescription_nullDescription() {
    Event event = new Event("Event 1", null, Days.MONDAY,
        "10:00", 60);
    Assertions.assertEquals("N/A", event.getDescription());
  }

  @Test
  public void testGetDuration_negativeDuration() {
    Event event = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", -60);
    Assertions.assertEquals(-60, event.getDuration());
  }

  @Test
  public void testEquals_eventsWithNullFields() {
    Event event1 = new Event("Event 1", null, Days.MONDAY,
        "10:00", 60);
    Event event2 = new Event(null, null, Days.MONDAY,
        "10:00", 60);
    Assertions.assertNotEquals(event1, event2);
  }

  @Test
  public void testEquals_notEqualDayOfWeek() {
    Event event1 = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 60);
    Event event2 = new Event("Event 1", "Description 1", Days.TUESDAY,
        "10:00", 60);
    Assertions.assertNotEquals(event1, event2);
  }

  @Test
  public void testEquals_notEqualStartTime() {
    Event event1 = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 60);
    Event event2 = new Event("Event 1", "Description 1", Days.MONDAY,
        "12:00", 60);
    Assertions.assertNotEquals(event1, event2);
  }

  @Test
  public void testEquals_nullDayOfWeek() {
    Event event1 = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 60);
    Event event2 = new Event("Event 1", "Description 1", null,
        "10:00", 60);
    Assertions.assertNotEquals(event1, event2);
  }

  @Test
  public void testEquals_notEqualDuration() {
    Event event1 = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 60);
    Event event2 = new Event("Event 1", "Description 1", Days.MONDAY,
        "10:00", 120);
    Assertions.assertNotEquals(event1, event2);
  }
}


