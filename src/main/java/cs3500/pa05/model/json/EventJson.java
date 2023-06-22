package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.enumerations.Days;

/**
 * Represents an event.
 *
 * @param name name of the event
 * @param description description
 * @param dayOfWeek what day of week
 * @param startTime start time
 * @param duration how long
 */
public record EventJson(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("dayOfWeek") Days dayOfWeek,
    @JsonProperty("startTime") String startTime,
    @JsonProperty("duration") int duration) {

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Days getDayOfWeek() {
    return dayOfWeek;
  }

  public String getStartTime() {
    return startTime();
  }

  public int getDuration() {
    return duration();
  }
}
