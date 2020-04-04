package fr.marcwrobel.jbanking.calendar;

import static fr.marcwrobel.jbanking.calendar.StandardCalendars.TARGET;
import static java.time.Month.APRIL;
import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;
import static java.time.Month.MAY;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class TargetCalendarTest {

  // https://www.sepaforcorporates.com/single-euro-payments-area/sepa-holidays-2014-2015-the-dates-and-why-you-need-to-know-them/
  @Test
  public void year2015() {
    int year = 2015;
    check(
        asList(
            LocalDate.of(year, JANUARY, 1),
            LocalDate.of(year, APRIL, 3),
            LocalDate.of(year, APRIL, 6),
            LocalDate.of(year, MAY, 1),
            LocalDate.of(year, DECEMBER, 25),
            LocalDate.of(year, DECEMBER, 26)),
        year);
  }

  // https://www.sepaforcorporates.com/single-euro-payments-area/sepa-holidays-2014-2015-the-dates-and-why-you-need-to-know-them/
  @Test
  public void year2016() {
    int year = 2016;
    check(
        asList(
            LocalDate.of(year, JANUARY, 1),
            LocalDate.of(year, MARCH, 25),
            LocalDate.of(year, MARCH, 28),
            LocalDate.of(year, MAY, 1),
            LocalDate.of(year, DECEMBER, 25),
            LocalDate.of(year, DECEMBER, 26)),
        year);
  }

  // https://www.sepaforcorporates.com/single-euro-payments-area/european-sepa-target-closing-days-2017-2018/
  @Test
  public void year2017() {
    int year = 2017;
    check(
        asList(
            LocalDate.of(year, JANUARY, 1),
            LocalDate.of(year, APRIL, 14),
            LocalDate.of(year, APRIL, 17),
            LocalDate.of(year, MAY, 1),
            LocalDate.of(year, DECEMBER, 25),
            LocalDate.of(year, DECEMBER, 26)),
        year);
  }

  // https://www.sepaforcorporates.com/single-euro-payments-area/european-sepa-target-closing-days-2017-2018/
  @Test
  public void year2018() {
    int year = 2018;
    check(
        asList(
            LocalDate.of(year, JANUARY, 1),
            LocalDate.of(year, MARCH, 30),
            LocalDate.of(year, APRIL, 2),
            LocalDate.of(year, MAY, 1),
            LocalDate.of(year, DECEMBER, 25),
            LocalDate.of(year, DECEMBER, 26)),
        year);
  }

  // https://www.sepaforcorporates.com/single-euro-payments-area/sepa-target-closing-days-2019-and-2020/
  @Test
  public void year2019() {
    int year = 2019;
    check(
        asList(
            LocalDate.of(year, JANUARY, 1),
            LocalDate.of(year, APRIL, 19),
            LocalDate.of(year, APRIL, 22),
            LocalDate.of(year, MAY, 1),
            LocalDate.of(year, DECEMBER, 25),
            LocalDate.of(year, DECEMBER, 26)),
        year);
  }

  // https://www.sepaforcorporates.com/single-euro-payments-area/sepa-target-closing-days-2019-and-2020/
  @Test
  public void year2020() {
    int year = 2020;
    check(
        asList(
            LocalDate.of(year, JANUARY, 1),
            LocalDate.of(year, APRIL, 10),
            LocalDate.of(year, APRIL, 13),
            LocalDate.of(year, MAY, 1),
            LocalDate.of(year, DECEMBER, 25),
            LocalDate.of(year, DECEMBER, 26)),
        year);
  }

  private void check(List<LocalDate> expected, int year) {
    List<LocalDate> holidays =
        TARGET.holidaysWithin(LocalDate.of(year, JANUARY, 1), LocalDate.of(year, DECEMBER, 31));

    assertEquals(filterOutWeekends(expected), filterOutWeekends(holidays));
  }

  private List<LocalDate> filterOutWeekends(List<LocalDate> dates) {
    return dates.stream()
        .filter(d -> d.getDayOfWeek() != DayOfWeek.SATURDAY && d.getDayOfWeek() != DayOfWeek.SUNDAY)
        .collect(Collectors.toList());
  }
}
