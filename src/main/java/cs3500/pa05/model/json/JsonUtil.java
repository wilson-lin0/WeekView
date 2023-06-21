package cs3500.pa05.model.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Iterator;
import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * Simple utils class used to hold static methods that help with serializing and deserializing JSON.
 */
public class JsonUtil {
  /**
   * Deserializes the given JSON string to a JsonNode.
   *
   * @param jsonString the JSON string to deserialize
   * @return the deserialized JsonNode object
   * @throws IOException if an error occurs during deserialization
   * @throws JsonProcessingException if an error occurs during deserialization
   */
  public static JsonNode deserializeJson(String jsonString) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readTree(jsonString);
  }

  /**
   * Converts a given record object to a JsonNode.
   *
   * @param record the record to convert
   * @return the JsonNode representation of the given record
   * @throws IllegalArgumentException if the record could not be converted correctly
   */
  public static JsonNode serializeRecord(Record record) throws IllegalArgumentException {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.convertValue(record, JsonNode.class);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Given record cannot be serialized");
    }
  }

  /**
   * Deserializes a given JsonNode to a record object.
   *
   * @param jsonNode the JsonNode to deserialize
   * @param recordClass the class of the record object
   * @param <Record> the record object
   * @return the deserialized record object
   * @throws IllegalArgumentException if the JsonNode could not be deserialized correctly
   */
  public static <Record> Record deserializeRecord(JsonNode jsonNode, Class<Record> recordClass)
      throws IllegalArgumentException {
    try {
      ObjectMapper mapper = new ObjectMapper();
      Record record = mapper.treeToValue(jsonNode, recordClass);
      return constructRecordObject(record, jsonNode, mapper);
    } catch (JsonProcessingException e) {
      throw new IllegalArgumentException("Given JsonNode cannot be deserialized to the record " +
          "object");
    }
  }

  private static <Record> Record constructRecordObject(Record record, JsonNode jsonNode, ObjectMapper mapper)
      throws JsonProcessingException {
    JsonNode fieldsNode = mapper.valueToTree(record);
    Iterator<String> fieldNames = fieldsNode.fieldNames();
    while (fieldNames.hasNext()) {
      String fieldName = fieldNames.next();
      JsonNode fieldValue = jsonNode.get(fieldName);
      ((ObjectNode) fieldsNode).replace(fieldName, fieldValue);
    }
    return mapper.treeToValue(fieldsNode, (Class<Record>) record.getClass());
  }
}

