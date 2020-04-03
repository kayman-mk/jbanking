package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class EasterHolidayTest {

  private static final int YEAR = 2020;
  private static final int MONTH = 4;
  private static final int DAY = 12;
  private static final EasterHoliday HOLIDAY = new EasterHoliday();

  @ParameterizedTest
  @MethodSource("easter500")
  public void easter500(int month, int dayOfMonth, int year) {
    LocalDate date = LocalDate.of(year, month, dayOfMonth);
    assertTrue(HOLIDAY.check(date));
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
    LocalDate date = LocalDate.of(YEAR, MONTH, DAY - 1);
    Optional<LocalDate> previous = HOLIDAY.previous(date);

    assertTrue(previous.isPresent());
    assertTrue(HOLIDAY.check(previous.get()));
    assertEquals(LocalDate.of(YEAR - 1, MONTH, 21), previous.get());
  }

  @Test
  public void previousCalculationWithDatesEquals() {
    LocalDate date = LocalDate.of(YEAR, MONTH, DAY);
    Optional<LocalDate> previous = HOLIDAY.previous(date);

    assertTrue(previous.isPresent());
    assertTrue(HOLIDAY.check(previous.get()));
    assertEquals(LocalDate.of(YEAR - 1, MONTH, 21), previous.get());
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
    assertEquals(LocalDate.of(YEAR + 1, MONTH, 4), next.get());
  }

  @Test
  public void nextCalculationWithDateAfter() {
    LocalDate date = LocalDate.of(YEAR, MONTH, DAY + 1);
    Optional<LocalDate> next = HOLIDAY.next(date);

    assertTrue(next.isPresent());
    assertTrue(HOLIDAY.check(next.get()));
    assertEquals(LocalDate.of(YEAR + 1, MONTH, 4), next.get());
  }

  /*
   * Easter dates comes from https://www.census.gov/srd/www/genhol/easter500.html.
   */
  private static Stream<Arguments> easter500() {
    InputStream easter500 =
        EasterHolidayTest.class.getClassLoader().getResourceAsStream("easter500.txt");
    return new BufferedReader(new InputStreamReader(easter500))
        .lines()
        .map(line -> line.trim().replaceAll("\\s+", " "))
        .map(line -> line.split(" "))
        .map(Arguments::of);
  }
}
