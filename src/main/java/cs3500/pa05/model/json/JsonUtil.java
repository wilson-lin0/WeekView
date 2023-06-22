package cs3500.pa05.model.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 * Simple utils class used to hold static methods that help with serializing and deserializing JSON.
 */
public class JsonUtil {

  /**
   * Converts a given record object to a JsonNode.
   *
   * @param record the record to convert
   * @return the JsonNode representation of the given record
   * @throws IllegalArgumentException if the record could not be converted correctly
   */
  public static JsonNode serializeRecord(Object record) throws IllegalArgumentException {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.convertValue(record, JsonNode.class);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Given record cannot be serialized");
    }
  }

  /**
   * Deserializes a given JSON string to a JsonNode.
   *
   * @param jsonString the JSON string to deserialize
   * @return the deserialized JsonNode
   * @throws IllegalArgumentException if the JSON string could not be deserialized correctly
   */
  public static JsonNode deserializeJson(String jsonString) throws IllegalArgumentException {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.readTree(jsonString);
    } catch (IOException e) {
      throw new IllegalArgumentException("Given JSON string cannot be deserialized", e);
    }
  }

  /**
   * Deserializes a given JsonNode to a record object.
   *
   * @param jsonNode    the JsonNode to deserialize
   * @param recordClass the class of the record object
   * @param <Record>    the record object
   * @return the deserialized record object
   * @throws IllegalArgumentException if the JsonNode could not be deserialized correctly
   */
  public static <Record> Record deserializeRecord(JsonNode jsonNode, Class<Record> recordClass)
      throws IllegalArgumentException {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.treeToValue(jsonNode, recordClass);
    } catch (JsonProcessingException e) {
      throw new IllegalArgumentException("Given JsonNode cannot be deserialized to the "
          + "record object");
    }
  }
}
