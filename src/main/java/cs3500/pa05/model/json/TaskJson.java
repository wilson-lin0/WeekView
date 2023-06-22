package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.enumerations.Days;

/**
 * Represents a Task.
 *
 * @param name name
 * @param description description
 * @param dayOfWeek what day of week
 * @param completed whether it's completed
 */
public record TaskJson(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("dayOfWeek") Days dayOfWeek,
    @JsonProperty("completed") boolean completed
) {

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Days getDayOfWeek() {
    return dayOfWeek;
  }

  public boolean getCompleted() {
    return completed;
  }
}
