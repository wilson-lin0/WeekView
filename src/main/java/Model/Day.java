public enum Day {
  SUNDAY('S'), MONDAY('M'), TUESDAY('T'), WEDNESDAY('W'), THURSDAY('T'), FRIDAY('F'), SATURDAY('S');

  private char letter;

  private Day(char letter) {
    this.letter = letter;
  }

  public char getLetter() {
    return letter;
  }
}
