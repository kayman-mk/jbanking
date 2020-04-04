package fr.marcwrobel.jbanking.calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class DayOfWeekHolidayTest {

  private static final int YEAR = 2020;
  private static final int MONTH = 6;
  private static final int DAY = 16;
  private static final DayOfWeek DAY_OF_WEEK = DayOfWeek.TUESDAY;

  private static final LocalDate CURRENT_WEEK = LocalDate.of(YEAR, MONTH, DAY);
  private static final LocalDate PREVIOUS_WEEK = CURRENT_WEEK.minusWeeks(1);
  private static final LocalDate NEXT_WEEK = CURRENT_WEEK.plusWeeks(1);

  private static final DayOfWeekHoliday HOLIDAY = new DayOfWeekHoliday(DAY_OF_WEEK);

  @Test
  public void monthDayCannotBeNull() {
    assertThrows(NullPointerException.class, () -> new DayOfWeekHoliday(null));
  }

  @Test
  public void checkDoesNotAcceptNull() {
    assertThrows(NullPointerException.class, () -> HOLIDAY.check(null));
  }

  @Test
  public void nextDoesNotAcceptNull() {
    assertThrows(NullPointerException.class, () -> HOLIDAY.next(null));
  }

  @Test
  public void previousDoesNotAcceptNull() {
    assertThrows(NullPointerException.class, () -> HOLIDAY.next(null));
  }

  @Test
  public void holidayCheckSucceed() {
    assertTrue(HOLIDAY.check(CURRENT_WEEK));
  }

  @Test
  public void onlyOneHolidayPerWeek() {
    LocalDate start = LocalDate.of(YEAR, MONTH, DAY);
    LocalDate end = start.with(DayOfWeek.SUNDAY);

    int count = 0;
    for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
      if (HOLIDAY.check(date)) {
        count++;
      }
    }

    assertEquals(1, count);
  }

  @Test
  public void previousCalculationWithDateBefore() {
    Optional<LocalDate> previous = HOLIDAY.previous(CURRENT_WEEK.minusDays(1));

    assertTrue(previous.isPresent());
    assertTrue(HOLIDAY.check(previous.get()));
    assertEquals(PREVIOUS_WEEK, previous.get());
  }

  @Test
  public void previousCalculationWithDatesEquals() {
    Optional<LocalDate> previous = HOLIDAY.previous(CURRENT_WEEK);

    assertTrue(previous.isPresent());
    assertTrue(HOLIDAY.check(previous.get()));
    assertEquals(PREVIOUS_WEEK, previous.get());
  }

  @Test
  public void previousCalculationWithDateAfter() {
    Optional<LocalDate> previous = HOLIDAY.previous(CURRENT_WEEK.plusDays(1));

    assertTrue(previous.isPresent());
    assertTrue(HOLIDAY.check(previous.get()));
    assertEquals(CURRENT_WEEK, previous.get());
  }

  @Test
  public void nextCalculationWithDateBefore() {
    Optional<LocalDate> next = HOLIDAY.next(CURRENT_WEEK.minusDays(1));

    assertTrue(next.isPresent());
    assertTrue(HOLIDAY.check(next.get()));
    assertEquals(CURRENT_WEEK, next.get());
  }

  @Test
  public void nextCalculationWithDatesEquals() {
    Optional<LocalDate> next = HOLIDAY.next(CURRENT_WEEK);

    assertTrue(next.isPresent());
    assertTrue(HOLIDAY.check(next.get()));
    assertEquals(NEXT_WEEK, next.get());
  }

  @Test
  public void nextCalculationWithDateAfter() {
    Optional<LocalDate> next = HOLIDAY.next(CURRENT_WEEK.plusDays(1));

    assertTrue(next.isPresent());
    assertTrue(HOLIDAY.check(next.get()));
    assertEquals(NEXT_WEEK, next.get());
  }
}
