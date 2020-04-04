package fr.marcwrobel.jbanking.calendar;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class CalendarTest {

  @Test
  public void holidaysMustNotBeNull() {
    assertThrows(NullPointerException.class, () -> new Calendar(null));
  }

  @Test
  public void emptyCalendarDateCalculation() {
    Calendar calendar = new Calendar(new ArrayList<>());
    LocalDate date = LocalDate.of(2020, 4, 14);

    assertTrue(calendar.isBusinessDay(date));
    assertFalse(calendar.isHoliday(date));
    assertEquals(date.plusDays(1), calendar.nextBusinessDay(date));
    assertEquals(date.minusDays(1), calendar.previousBusinessDay(date));
  }

  @Test
  public void badCalendarDateCalculation() {
    Calendar calendar =
        new Calendar(
            Arrays.asList(
                new DayOfWeekHoliday(MONDAY),
                new DayOfWeekHoliday(TUESDAY),
                new DayOfWeekHoliday(WEDNESDAY),
                new DayOfWeekHoliday(THURSDAY),
                new DayOfWeekHoliday(FRIDAY),
                new DayOfWeekHoliday(SATURDAY),
                new DayOfWeekHoliday(SUNDAY)));
    LocalDate date = LocalDate.of(2020, 4, 14);

    for (int i = 0; i < 365; i++) {
      assertTrue(calendar.isHoliday(date));
      assertFalse(calendar.isBusinessDay(date));
    }

    assertThrows(DateCalculationException.class, () -> calendar.nextBusinessDay(date));
    assertThrows(DateCalculationException.class, () -> calendar.previousBusinessDay(date));
  }

  @Test
  public void weekendCalendarDateCalculation() {
    Calendar calendar =
        new Calendar(Arrays.asList(new DayOfWeekHoliday(SATURDAY), new DayOfWeekHoliday(SUNDAY)));
    LocalDate saturday = LocalDate.of(2020, 4, 4);

    assertFalse(calendar.isBusinessDay(saturday));
    assertTrue(calendar.isHoliday(saturday));

    assertTrue(calendar.isBusinessDay(saturday.minusDays(1)));
    assertFalse(calendar.isHoliday(saturday.minusDays(1)));

    assertFalse(calendar.isBusinessDay(saturday.plusDays(1)));
    assertTrue(calendar.isHoliday(saturday.plusDays(1)));

    assertTrue(calendar.isBusinessDay(saturday.plusDays(2)));
    assertFalse(calendar.isHoliday(saturday.plusDays(2)));

    assertEquals(saturday.plusDays(2), calendar.nextBusinessDay(saturday));
    assertEquals(saturday.minusDays(1), calendar.previousBusinessDay(saturday));
  }
}
