package cs3500.pa05.modeltests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cs3500.pa05.model.enumerations.Days;
import cs3500.pa05.model.json.EventJson;
import org.junit.jupiter.api.Test;

/**
 * Tests EventJson class.
 */
public class EventJsonTest {

  @Test
  public void testGetters() {
    EventJson eventJson = new EventJson("Event 1", "Description 1",
        Days.MONDAY, "09:00", 60);

    assertEquals("Event 1", eventJson.getName());
    assertEquals("Description 1", eventJson.getDescription());
    assertEquals(Days.MONDAY, eventJson.getDayOfWeek());
    assertEquals("09:00", eventJson.getStartTime());
    assertEquals(60, eventJson.getDuration());
  }

  @Test
  public void testRecordEquality() {
    EventJson eventJson1 = new EventJson("Event 1", "Description 1",
        Days.MONDAY, "09:00", 60);
    EventJson eventJson2 = new EventJson("Event 1", "Description 1",
        Days.MONDAY, "09:00", 60);
    EventJson eventJson3 = new EventJson("Event 2", "Description 2",
        Days.TUESDAY, "14:30", 90);

    assertEquals(eventJson1, eventJson2);
    assertNotEquals(eventJson1, eventJson3);
  }

  @Test
  public void testHashCode() {
    EventJson eventJson1 = new EventJson("Event 1", "Description 1",
        Days.MONDAY, "09:00", 60);
    EventJson eventJson2 = new EventJson("Event 1", "Description 1",
        Days.MONDAY, "09:00", 60);

    assertEquals(eventJson1.hashCode(), eventJson2.hashCode());
  }
}
