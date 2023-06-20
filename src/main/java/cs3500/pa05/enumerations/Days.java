package cs3500.pa05.enumerations;

/**
 * To represent a day of the week.
 */
public enum Days {
  /**
   * Monday.
   */
  MONDAY('M'),
  /**
   * Tuesday.
   */
  TUESDAY('T'),
  /**
   * Wednesday.
   */
  WEDNESDAY('W'),
  /**
   * Thursday.
   */
  THURSDAY('H'),
  /**
   * Friday.
   */
  FRIDAY('F'),
  /**
   * Saturday.
   */
  SATURDAY('S'),
  /**
   * Sunday.
   */
  SUNDAY('D');

  private char letter;

  Days(char letter) {
    this.letter = letter;
  }

  /**
   * Returns the day of the week given the character.
   *
   * @param letter the character
   * @return the corresponding day of the week
   * @throws IllegalArgumentException when an invalid character is provided
   */
  public static Days getDay(char letter) {
    switch (letter) {
      case 'M': return Days.MONDAY;
      case 'T': return Days.TUESDAY;
      case 'W': return Days.WEDNESDAY;
      case 'H': return Days.THURSDAY;
      case 'F': return Days.FRIDAY;
      case 'S': return Days.SATURDAY;
      case 'D': return Days.SUNDAY;
      default: throw new IllegalArgumentException("Not a valid day.");
    }
  }
}
