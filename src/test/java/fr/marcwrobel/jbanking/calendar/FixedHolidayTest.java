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

class FixedHolidayTest {

  private static final int YEAR = 2020;
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
  @ValueSource(ints = {1, 100, 1970, YEAR, 2050, 10000})
  public void holidayCheckSucceed(int year) {
    assertTrue(HOLIDAY.check(HOLIDAY.getMonthDay().atYear(year)));
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
    LocalDate date = LocalDate.of(YEAR, MONTH, DAY - 1);
    Optional<LocalDate> previous = HOLIDAY.previous(date);

    assertTrue(previous.isPresent());
    assertTrue(HOLIDAY.check(previous.get()));
    assertEquals(LocalDate.of(YEAR - 1, MONTH, DAY), previous.get());
  }

  @Test
  public void previousCalculationWithDatesEquals() {
    LocalDate date = LocalDate.of(YEAR, MONTH, DAY);
    Optional<LocalDate> previous = HOLIDAY.previous(date);

    assertTrue(previous.isPresent());
    assertTrue(HOLIDAY.check(previous.get()));
    assertEquals(LocalDate.of(YEAR - 1, MONTH, DAY), previous.get());
  }

  @Test
  public void previousCalculationWithDateAfter() {
    LocalDate date = LocalDate.of(YEAR, MONTH, DAY + 1);
    Optional<LocalDate> previous = HOLIDAY.previous(date);

    assertTrue(previous.isPresent());
    assertTrue(HOLIDAY.check(previous.get()));
    assertEquals(LocalDate.of(YEAR, MONTH, DAY), previous.get());
  }

  @Test
  public void nextCalculationWithDateBefore() {
    LocalDate date = LocalDate.of(YEAR, MONTH, DAY - 1);
    Optional<LocalDate> next = HOLIDAY.next(date);

    assertTrue(next.isPresent());
    assertTrue(HOLIDAY.check(next.get()));
    assertEquals(LocalDate.of(YEAR, MONTH, DAY), next.get());
  }

  @Test
  public void nextCalculationWithDatesEquals() {
    LocalDate date = LocalDate.of(YEAR, MONTH, DAY);
    Optional<LocalDate> next = HOLIDAY.next(date);

    assertTrue(next.isPresent());
    assertTrue(HOLIDAY.check(next.get()));
    assertEquals(LocalDate.of(YEAR + 1, MONTH, DAY), next.get());
  }

  @Test
  public void nextCalculationWithDateAfter() {
    LocalDate date = LocalDate.of(YEAR, MONTH, DAY + 1);
    Optional<LocalDate> next = HOLIDAY.next(date);

    assertTrue(next.isPresent());
    assertTrue(HOLIDAY.check(next.get()));
    assertEquals(LocalDate.of(YEAR + 1, MONTH, DAY), next.get());
  }
}
