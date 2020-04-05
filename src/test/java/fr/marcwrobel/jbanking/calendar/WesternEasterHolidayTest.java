package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WesternEasterHolidayTest {

  private static final int YEAR = 2020;
  private static final int MONTH = 4;
  private static final int DAY = 12;

  private static final LocalDate HOLIDAY_2020 = LocalDate.of(YEAR, MONTH, DAY);
  private static final LocalDate HOLIDAY_2019 = LocalDate.of(YEAR - 1, MONTH, 21);
  private static final LocalDate HOLIDAY_2021 = LocalDate.of(YEAR + 1, MONTH, 4);

  private static final WesternEasterHoliday HOLIDAY = WesternEasterHoliday.INSTANCE;

  @Test
  public void checkDoesNotAcceptNull() {
    assertThrows(NullPointerException.class, () -> HOLIDAY.check(null));
  }

  // Data from https://www.census.gov/srd/www/genhol/easter500.html
  @ParameterizedTest
  @MethodSource("easter500")
  public void easter500(int month, int dayOfMonth, int year) {
    LocalDate date = LocalDate.of(year, month, dayOfMonth);
    assertTrue(HOLIDAY.check(date));
  }

  private static Stream<Arguments> easter500() {
    InputStream easter500 =
        WesternEasterHolidayTest.class.getClassLoader().getResourceAsStream("easter500.txt");
    return new BufferedReader(new InputStreamReader(easter500))
        .lines()
        .map(line -> line.trim().replaceAll("\\s+", " "))
        .map(line -> line.split(" "))
        .map(Arguments::of);
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
}
