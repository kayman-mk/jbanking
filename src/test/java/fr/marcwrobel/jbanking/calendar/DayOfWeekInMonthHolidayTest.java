package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DayOfWeekInMonthHolidayTest {

  private static final int WEEK_NUMBER = 3;
  private static final DayOfWeek DAY_OF_WEEK = DayOfWeek.WEDNESDAY;
  private static final Month MONTH = Month.JANUARY;

  private static final LocalDate HOLIDAY_2020 = LocalDate.of(2020, MONTH, 15);
  private static final LocalDate HOLIDAY_2019 = LocalDate.of(2019, MONTH, 16);;
  private static final LocalDate HOLIDAY_2021 = LocalDate.of(2021, MONTH, 20);

  private static final DayOfWeekInMonthHoliday HOLIDAY =
      new DayOfWeekInMonthHoliday(WEEK_NUMBER, DAY_OF_WEEK, MONTH);

  @Test
  public void dayOfWeekCannotBeNull() {
    assertThrows(
        NullPointerException.class, () -> new DayOfWeekInMonthHoliday(0, null, Month.MARCH));
  }

  @Test
  public void monthCannotBeNull() {
    assertThrows(
        NullPointerException.class, () -> new DayOfWeekInMonthHoliday(0, DayOfWeek.MONDAY, null));
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

  @ParameterizedTest
  @ValueSource(
      strings = {
        "2010-01-20",
        "2011-01-19",
        "2012-01-18",
        "2013-01-16",
        "2014-01-15",
        "2015-01-21",
        "2016-01-20",
        "2017-01-18",
        "2018-01-17",
        "2019-01-16",
        "2020-01-15",
        "2021-01-20"
      })
  public void holidayCheckSucceed(String date) {
    assertTrue(HOLIDAY.check(LocalDate.parse(date)));
  }

  @Test
  public void onlyOneHolidayPerYear() {
    LocalDate start = LocalDate.of(2020, JANUARY, 1);
    LocalDate end = LocalDate.of(start.getYear(), DECEMBER, 31);

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
    Optional<LocalDate> previous = HOLIDAY.previous(HOLIDAY_2020.minusDays(1));

    assertTrue(previous.isPresent());
    assertTrue(HOLIDAY.check(previous.get()));
    assertEquals(HOLIDAY_2019, previous.get());
  }

  @Test
  public void previousCalculationWithDatesEquals() {
    Optional<LocalDate> previous = HOLIDAY.previous(HOLIDAY_2020);

    assertTrue(previous.isPresent());
    assertTrue(HOLIDAY.check(previous.get()));
    assertEquals(HOLIDAY_2019, previous.get());
  }

  @Test
  public void previousCalculationWithDateAfter() {
    Optional<LocalDate> previous = HOLIDAY.previous(HOLIDAY_2020.plusDays(1));

    assertTrue(previous.isPresent());
    assertTrue(HOLIDAY.check(previous.get()));
    assertEquals(HOLIDAY_2020, previous.get());
  }

  @Test
  public void nextCalculationWithDateBefore() {
    Optional<LocalDate> next = HOLIDAY.next(HOLIDAY_2020.minusDays(1));

    assertTrue(next.isPresent());
    assertTrue(HOLIDAY.check(next.get()));
    assertEquals(HOLIDAY_2020, next.get());
  }

  @Test
  public void nextCalculationWithDatesEquals() {
    Optional<LocalDate> next = HOLIDAY.next(HOLIDAY_2020);

    assertTrue(next.isPresent());
    assertTrue(HOLIDAY.check(next.get()));
    assertEquals(HOLIDAY_2021, next.get());
  }

  @Test
  public void nextCalculationWithDateAfter() {
    Optional<LocalDate> next = HOLIDAY.next(HOLIDAY_2020.plusDays(1));

    assertTrue(next.isPresent());
    assertTrue(HOLIDAY.check(next.get()));
    assertEquals(HOLIDAY_2021, next.get());
  }

  @Test
  public void equalsAndHashCodeAndToString() {
    Holiday holiday1 = new DayOfWeekInMonthHoliday(WEEK_NUMBER, DAY_OF_WEEK, MONTH);
    Holiday holiday2 = new DayOfWeekInMonthHoliday(WEEK_NUMBER, DAY_OF_WEEK, MONTH);

    assertEquals(holiday1, holiday2);
    assertEquals(holiday2, holiday1);
    assertEquals(holiday1, holiday1);
    assertEquals(holiday1.hashCode(), holiday2.hashCode());
    assertEquals(holiday1.toString(), holiday2.toString());
  }
}
