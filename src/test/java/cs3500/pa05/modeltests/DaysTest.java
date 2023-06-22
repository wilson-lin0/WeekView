package cs3500.pa05.modeltests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.enumerations.Days;
import org.junit.jupiter.api.Test;

/**
 * Tests Days class.
 */
public class DaysTest {

  @Test
  public void testVerifyDay_ValidDay() {
    Days day = Days.verifyDay("Monday");
    assertEquals(Days.MONDAY, day);
  }

  @Test
  public void testVerifyDay_InvalidDay() {
    Days day = Days.verifyDay("Invalid");
    assertEquals(Days.INVALID, day);
  }


  @Test
  public void testVerifyDay_MultipleDays() {
    Days day1 = Days.verifyDay("Tuesday");
    assertEquals(Days.TUESDAY, day1);

    Days day2 = Days.verifyDay("Friday");
    assertEquals(Days.FRIDAY, day2);
  }

  @Test
  public void testVerifyDay_CaseInsensitive() {
    assertEquals(Days.MONDAY, Days.verifyDay("monday"));
    assertEquals(Days.TUESDAY, Days.verifyDay("tuesday"));
    assertEquals(Days.WEDNESDAY, Days.verifyDay("WEDNESDAY"));
    assertEquals(Days.THURSDAY, Days.verifyDay("thursday"));
    assertEquals(Days.FRIDAY, Days.verifyDay("fRiDaY"));
    assertEquals(Days.SATURDAY, Days.verifyDay("saturday"));
    assertEquals(Days.SUNDAY, Days.verifyDay("Sunday"));
  }

}
