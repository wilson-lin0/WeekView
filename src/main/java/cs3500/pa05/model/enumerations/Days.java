package cs3500.pa05.model.enumerations;

/**
 * To represent a day of the week.
 */
public enum Days {
  /**
   * Monday.
   */
  MONDAY("MONDAY"),
  /**
   * Tuesday.
   */
  TUESDAY("Tuesday"),
  /**
   * Wednesday.
   */
  WEDNESDAY("Wednesday"),
  /**
   * Thursday.
   */
  THURSDAY("Thursday"),
  /**
   * Friday.
   */
  FRIDAY("Friday"),
  /**
   * Saturday.
   */
  SATURDAY("Saturday"),
  /**
   * Sunday.
   */
  SUNDAY("Sunday"),
  INVALID("Invalid Day");

  private String day;

  Days(String day) {
    this.day = day;
  }

  /**
   * Returns the day of the week given the character.
   *
   * @param day the day of the week
   * @return the corresponding day of the week
   * @throws IllegalArgumentException when an invalid character is provided
   */
  public static Days verifyDay(String day) {
    return switch (day.toUpperCase()) {
      case "MONDAY" -> MONDAY;
      case "TUESDAY" -> TUESDAY;
      case "WEDNESDAY" -> WEDNESDAY;
      case "THURSDAY" -> THURSDAY;
      case "FRIDAY" -> FRIDAY;
      case "SATURDAY" -> SATURDAY;
      case "SUNDAY" -> SUNDAY;
      default -> INVALID;
    };
  }
}