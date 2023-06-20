package cs3500.pa05.modelTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import cs3500.pa05.model.json.JsonUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonUtilTest {
  private JsonUtil jsonUtil;

  @BeforeEach
  public void setUp() {
    jsonUtil = new JsonUtil();
  }

  @Test
  public void testDeserializeJson() throws IOException {
    // Sample JSON string
    String jsonString = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";

    // Deserialize the JSON string using JsonUtil
    JsonNode jsonNode = jsonUtil.deserializeJson(jsonString);

    // Verify the deserialized JsonNode
    assertNotNull(jsonNode);
    assertEquals("John", jsonNode.get("name").asText());
    assertEquals(30, jsonNode.get("age").asInt());
    assertEquals("New York", jsonNode.get("city").asText());
  }

  @Test
  public void testDeserializeJson_InvalidJson() {
    // Invalid JSON string
    String jsonString = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"";

    // Deserialize the invalid JSON string using JsonUtil and expect an exception
    assertThrows(JsonProcessingException.class, () -> {
      jsonUtil.deserializeJson(jsonString);
    });
  }

  @Test
  public void testSerializeRecord() {
    // Create a sample record object
    Record record = new Record("John", 30);

    /*
    // Serialize the record object using JsonUtil
    JsonNode jsonNode = jsonUtil.serializeRecord(record);

    // Verify the serialized JsonNode
    assertNotNull(jsonNode);
    assertEquals("John", jsonNode.get("name").asText());
    assertEquals(30, jsonNode.get("age").asInt());
     */
  }

  @Test
  public void testDeserializeRecord() throws IOException {
    // Sample JSON string
    String jsonString = "{\"name\":\"John\",\"age\":30}";

    // Deserialize the JSON string to a JsonNode
    JsonNode jsonNode = jsonUtil.deserializeJson(jsonString);

    // Deserialize the JsonNode to a record object using JsonUtil
    Record record = jsonUtil.deserializeRecord(jsonNode, Record.class);

    // Verify the deserialized record object
    assertNotNull(record);
    assertEquals("John", record.getName());
    assertEquals(30, record.getAge());
  }

  @Test
  public void testDeserializeRecord_InvalidJson() {
    // Invalid JSON string
    String jsonString = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";

    // Deserialize the invalid JSON string to a record object using JsonUtil and expect an exception

  }

  // Helper class for testing serialization/deserialization
  static class Record {
    private String name;
    private int age;

    public Record(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }
  }
}


