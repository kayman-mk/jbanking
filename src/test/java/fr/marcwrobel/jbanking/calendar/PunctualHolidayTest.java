package fr.marcwrobel.jbanking.calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import org.junit.jupiter.api.Test;

class PunctualHolidayTest {

  private static final int YEAR = 2020;
  private static final Month MONTH = Month.JUNE;
  private static final int DAY = 15;
  private static final LocalDate DATE = LocalDate.of(YEAR, MONTH, DAY);

  private static final Holiday BASE = new MonthDayHoliday(MonthDay.of(MONTH, DAY));
  private static final Holiday HOLIDAY = new PunctualHoliday(BASE, YEAR);

  @Test
  public void baseCannotBeNull() {
    assertThrows(NullPointerException.class, () -> new PunctualHoliday(null, YEAR));
  }

  @Test
  public void equalsAndHashCodeAndToString() {
    Holiday holiday1 = HOLIDAY;
    Holiday holiday2 = HOLIDAY;
    Holiday holiday3 = new PunctualHoliday(new MonthDayHoliday(MonthDay.of(MONTH, DAY + 1)), YEAR);
    Holiday holiday4 = new PunctualHoliday(BASE);

    assertEquals(holiday1, holiday2);
    assertEquals(holiday2, holiday1);
    assertEquals(holiday1, holiday1);
    assertEquals(holiday1.hashCode(), holiday2.hashCode());
    assertEquals(holiday1.toString(), holiday2.toString());

    assertNotEquals(holiday1, holiday3);
    assertNotEquals(holiday3, holiday1);
    assertNotEquals(holiday1.hashCode(), holiday3.hashCode());
    assertNotEquals(holiday1.toString(), holiday3.toString());

    assertNotEquals(holiday1, holiday4);
    assertNotEquals(holiday4, holiday1);
    assertNotEquals(holiday1.hashCode(), holiday4.hashCode());
    assertNotEquals(holiday1.toString(), holiday4.toString());
  }

  @Test
  public void holidayIsPunctual() {
    assertFalse(HOLIDAY.check(DATE.minusYears(1)));
    assertTrue(HOLIDAY.check(DATE));
    assertFalse(HOLIDAY.check(DATE.plusYears(1)));
  }
}
