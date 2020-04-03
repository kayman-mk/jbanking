package fr.marcwrobel.jbanking.calendar;

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

  private static final FixedHoliday HOLIDAY = new FixedHoliday(MonthDay.of(6, 15));

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

  @ParameterizedTest
  @ValueSource(ints = {1, 100, 1970, 2020, 2050, 10000})
  public void holidayCheck(int year) {
    assertTrue(HOLIDAY.check(HOLIDAY.getMonthDay().atYear(year)));
  }

  @Test
  public void previousCalculationWithMonthDayBefore() {
    LocalDate date = LocalDate.of(2020, 5, 1);
    Optional<LocalDate> previous = HOLIDAY.previous(date);

    assertTrue(previous.isPresent());
    LocalDate expected = LocalDate.of(2019, 6, 15);
    assertEquals(expected, previous.get());
  }

  @Test
  public void previousCalculationWithMonthDayAfter() {
    LocalDate date = LocalDate.of(2020, 7, 1);
    Optional<LocalDate> previous = HOLIDAY.previous(date);

    assertTrue(previous.isPresent());
    LocalDate expected = LocalDate.of(2020, 6, 15);
    assertEquals(expected, previous.get());
  }

  @Test
  public void previousCalculationWithMonthDaysEquals() {
    LocalDate date = LocalDate.of(2020, 6, 15);
    Optional<LocalDate> previous = HOLIDAY.previous(date);

    assertTrue(previous.isPresent());
    LocalDate expected = LocalDate.of(2019, 6, 15);
    assertEquals(expected, previous.get());
  }

  @Test
  public void nextCalculationWithMonthDayBefore() {
    LocalDate date = LocalDate.of(2020, 5, 1);
    Optional<LocalDate> next = HOLIDAY.next(date);

    assertTrue(next.isPresent());
    LocalDate expected = LocalDate.of(2020, 6, 15);
    assertEquals(expected, next.get());
  }

  @Test
  public void nextCalculationWithMonthDayAfter() {
    LocalDate date = LocalDate.of(2020, 7, 1);
    Optional<LocalDate> next = HOLIDAY.next(date);

    assertTrue(next.isPresent());
    LocalDate expected = LocalDate.of(2021, 6, 15);
    assertEquals(expected, next.get());
  }

  @Test
  public void nextCalculationWithMonthDaysEquals() {
    LocalDate date = LocalDate.of(2020, 6, 15);
    Optional<LocalDate> next = HOLIDAY.next(date);

    assertTrue(next.isPresent());
    LocalDate expected = LocalDate.of(2021, 6, 15);
    assertEquals(expected, next.get());
  }
}
