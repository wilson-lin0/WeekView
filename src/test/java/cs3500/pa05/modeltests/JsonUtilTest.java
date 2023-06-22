package cs3500.pa05.modeltests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.fasterxml.jackson.databind.JsonNode;
import cs3500.pa05.model.enumerations.Days;
import cs3500.pa05.model.json.EventJson;
import cs3500.pa05.model.json.JsonUtil;
import cs3500.pa05.model.json.TaskJson;
import org.junit.jupiter.api.Test;

/**
 * Tests the JsonUtil Class.
 */
class JsonUtilTest {

  @Test
  void serializeRecord_validRecord_successfullySerializes() {
    EventJson event = new EventJson("Event Name", "Event Description", Days.MONDAY,
        "10:00", 60);

    JsonNode jsonNode = JsonUtil.serializeRecord(event);

    assertNotNull(jsonNode);
    assertEquals("Event Name", jsonNode.get("name").asText());
    assertEquals("Event Description", jsonNode.get("description").asText());
    assertEquals("MONDAY", jsonNode.get("dayOfWeek").asText());
    assertEquals("10:00", jsonNode.get("startTime").asText());
    assertEquals(60, jsonNode.get("duration").asInt());
  }

  @Test
  void deserializeJson_validJson_successfullyDeserializes() {
    String jsonString = "{\"name\":\"Event Name\",\"description\":\"Event Description\","
        + "\"dayOfWeek\":\"MONDAY\",\"startTime\":\"10:00\",\"duration\":60}";

    JsonNode jsonNode = JsonUtil.deserializeJson(jsonString);

    assertNotNull(jsonNode);
    assertEquals("Event Name", jsonNode.get("name").asText());
    assertEquals("Event Description", jsonNode.get("description").asText());
    assertEquals("MONDAY", jsonNode.get("dayOfWeek").asText());
    assertEquals("10:00", jsonNode.get("startTime").asText());
    assertEquals(60, jsonNode.get("duration").asInt());
  }

  @Test
  void deserializeRecord_validJsonNodeAndRecordClass_successfullyDeserializes() {
    // Create a sample JSON node
    JsonNode jsonNode = JsonUtil.deserializeJson("{\"name\":\"Event Name\","
        + "\"description\":\"Event Description\","
        + "\"dayOfWeek\":\"MONDAY\",\"startTime\":\"10:00\",\"duration\":60}");

    EventJson event = JsonUtil.deserializeRecord(jsonNode, EventJson.class);

    assertNotNull(event);
    assertEquals("Event Name", event.getName());
    assertEquals("Event Description", event.getDescription());
    assertEquals(Days.MONDAY, event.getDayOfWeek());
    assertEquals("10:00", event.getStartTime());
    assertEquals(60, event.getDuration());
  }

  @Test
  void serializeRecord_differentRecordClass_successfullySerializes() {
    TaskJson record = new TaskJson("Record", "123", Days.FRIDAY, false);

    JsonNode jsonNode = JsonUtil.serializeRecord(record);

    assertNotNull(jsonNode);
    assertEquals("Record", jsonNode.get("name").asText());
    assertEquals("123", jsonNode.get("description").asText());
  }

  @Test
  void deserializeJson_invalidJsonString_throwsException() {
    String invalidJsonString = "This is not a valid JSON string";

    assertThrows(IllegalArgumentException.class, () -> {
      JsonUtil.deserializeJson(invalidJsonString);
    });
  }

  @Test
  void deserializeRecord_nullRecordClass_throwsException() {
    JsonNode jsonNode = JsonUtil.deserializeJson("{\"name\":\"Event Name\"}");

    assertThrows(NullPointerException.class, () -> {
      JsonUtil.deserializeRecord(jsonNode, null);
    });
  }
}



