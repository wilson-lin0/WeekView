package cs3500.pa05.enumerations;

public enum Days {
  MONDAY('M'),
  TUESDAY('T'),
  WEDNEDAY('W'),
  THURSDAY('H'),
  FRIDAY('F'),
  SATURDAY('S'),
  SUNDAY('D');

  private char letter;

  Days(char letter) {
    this.letter = letter;
  }

}
