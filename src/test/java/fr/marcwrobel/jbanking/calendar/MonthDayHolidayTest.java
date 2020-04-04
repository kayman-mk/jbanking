package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MonthDayHolidayTest {

  private static final int YEAR = 2020;
  private static final int MONTH = 6;
  private static final int DAY = 15;

  private static final LocalDate HOLIDAY_2020 = LocalDate.of(YEAR, MONTH, DAY);
  private static final LocalDate HOLIDAY_2019 = HOLIDAY_2020.minusYears(1);
  private static final LocalDate HOLIDAY_2021 = HOLIDAY_2020.plusYears(1);

  private static final MonthDayHoliday HOLIDAY = new MonthDayHoliday(MonthDay.of(MONTH, DAY));

  @Test
  public void monthDayCannotBeNull() {
    assertThrows(NullPointerException.class, () -> new MonthDayHoliday((MonthDay) null));
  }

  @Test
  public void textCannotBeNull() {
    assertThrows(NullPointerException.class, () -> new MonthDayHoliday((CharSequence) null));
  }

  @Test
  public void textMustBeAValidMonthDay() {
    assertThrows(DateTimeParseException.class, () -> new MonthDayHoliday("test"));
  }

  @Test
  public void validTextDoesNotThrows() {
    assertDoesNotThrow(() -> new MonthDayHoliday("--12-03"));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 100, 1970, YEAR, 2050, 10000})
  public void holidayCheckSucceed(int year) {
    assertTrue(HOLIDAY.check(LocalDate.of(year, MONTH, DAY)));
  }

  @Test
  public void onlyOneHolidayPerYear() {
    LocalDate start = LocalDate.of(YEAR, JANUARY, 1);
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
}
