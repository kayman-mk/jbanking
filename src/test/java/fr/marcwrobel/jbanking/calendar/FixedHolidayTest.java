package fr.marcwrobel.jbanking.calendar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FixedHolidayTest {

  private static final int DAY = 15;
  private static final int MONTH = 6;
  private static final FixedHoliday HOLIDAY = new FixedHoliday(MonthDay.of(MONTH, DAY));

  @Test
  public void monthDayCannotBeNull() {
    assertThrows(NullPointerException.class, () -> new FixedHoliday((MonthDay) null));
  }

  @Test
  public void textCannotBeNull() {
    assertThrows(NullPointerException.class, () -> new FixedHoliday((CharSequence) null));
  }

  @Test
  public void textMustBeAValidMonthDay() {
    assertThrows(DateTimeParseException.class, () -> new FixedHoliday("test"));
  }

  @Test
  public void validTextDoesNotThrows() {
    assertDoesNotThrow(() -> new FixedHoliday("--12-03"));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 100, 1970, 2020, 2050, 10000})
  public void holidayCheckSucceed(int year) {
    assertTrue(HOLIDAY.check(HOLIDAY.getMonthDay().atYear(year)));
  }

  @Test
  @ValueSource(ints = {1, 100, 1970, 2020, 2050, 10000})
  public void holidayCheckFails() {
    assertFalse(HOLIDAY.check(MonthDay.of(MONTH, DAY + 1).atYear(2020)));
  }

  @Test
  public void previousCalculationWithMonthDayBefore() {
    LocalDate date = LocalDate.of(2020, MONTH, DAY - 1);
    Optional<LocalDate> previous = HOLIDAY.previous(date);

    assertTrue(previous.isPresent());
    LocalDate expected = LocalDate.of(2019, MONTH, DAY);
    assertEquals(expected, previous.get());
  }

  @Test
  public void previousCalculationWithMonthDayAfter() {
    LocalDate date = LocalDate.of(2020, MONTH, DAY + 1);
    Optional<LocalDate> previous = HOLIDAY.previous(date);

    assertTrue(previous.isPresent());
    LocalDate expected = LocalDate.of(2020, MONTH, DAY);
    assertEquals(expected, previous.get());
  }

  @Test
  public void previousCalculationWithMonthDaysEquals() {
    LocalDate date = LocalDate.of(2020, MONTH, DAY);
    Optional<LocalDate> previous = HOLIDAY.previous(date);

    assertTrue(previous.isPresent());
    LocalDate expected = LocalDate.of(2019, MONTH, DAY);
    assertEquals(expected, previous.get());
  }

  @Test
  public void nextCalculationWithMonthDayBefore() {
    LocalDate date = LocalDate.of(2020, MONTH, DAY - 1);
    Optional<LocalDate> next = HOLIDAY.next(date);

    assertTrue(next.isPresent());
    LocalDate expected = LocalDate.of(2020, MONTH, DAY);
    assertEquals(expected, next.get());
  }

  @Test
  public void nextCalculationWithMonthDayAfter() {
    LocalDate date = LocalDate.of(2020, MONTH, DAY + 1);
    Optional<LocalDate> next = HOLIDAY.next(date);

    assertTrue(next.isPresent());
    LocalDate expected = LocalDate.of(2021, MONTH, DAY);
    assertEquals(expected, next.get());
  }

  @Test
  public void nextCalculationWithMonthDaysEquals() {
    LocalDate date = LocalDate.of(2020, MONTH, DAY);
    Optional<LocalDate> next = HOLIDAY.next(date);

    assertTrue(next.isPresent());
    LocalDate expected = LocalDate.of(2021, MONTH, DAY);
    assertEquals(expected, next.get());
  }
}
