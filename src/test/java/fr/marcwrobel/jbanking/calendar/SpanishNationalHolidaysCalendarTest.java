package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.APRIL;
import static java.time.Month.AUGUST;
import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;
import static java.time.Month.OCTOBER;
import static java.time.MonthDay.of;

import org.junit.jupiter.api.Test;

class SpanishNationalHolidaysCalendarTest extends CalendarTestSupport {

  protected SpanishNationalHolidaysCalendarTest() {
    super(StandardCalendars.SPANISH_NATIONAL_HOLIDAYS);
  }

  // https://www.timeanddate.com/holidays/spain/2018?hol=1
  @Test
  public void year2018() {
    check(
        2018,
        of(JANUARY, 1),
        of(JANUARY, 6),
        of(MARCH, 30),
        of(MAY, 1),
        of(AUGUST, 15),
        of(OCTOBER, 12),
        of(NOVEMBER, 1),
        of(DECEMBER, 6),
        of(DECEMBER, 8),
        of(DECEMBER, 9),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/spain/2019?hol=1
  @Test
  public void year2019() {
    check(
        2019,
        of(JANUARY, 1),
        of(JANUARY, 6),
        of(APRIL, 19),
        of(MAY, 1),
        of(AUGUST, 15),
        of(OCTOBER, 12),
        of(NOVEMBER, 1),
        of(DECEMBER, 6),
        of(DECEMBER, 8),
        of(DECEMBER, 9),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/spain/2020?hol=1
  @Test
  public void year2020() {
    check(
        2020,
        of(JANUARY, 1),
        of(JANUARY, 6),
        of(APRIL, 10),
        of(MAY, 1),
        of(AUGUST, 15),
        of(OCTOBER, 12),
        of(DECEMBER, 8),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/spain/2021?hol=1 +
  // https://en.wikipedia.org/wiki/Public_holidays_in_Spain
  @Test
  public void year2021() {
    check(
        2021,
        of(JANUARY, 1),
        of(JANUARY, 6),
        of(APRIL, 2),
        of(MAY, 1),
        of(AUGUST, 15),
        of(AUGUST, 16),
        of(OCTOBER, 12),
        of(NOVEMBER, 1),
        of(DECEMBER, 6),
        of(DECEMBER, 8),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/spain/2022?hol=1 +
  //  // https://en.wikipedia.org/wiki/Public_holidays_in_Spain
  @Test
  public void year2022() {
    check(
        2022,
        of(JANUARY, 1),
        of(JANUARY, 6),
        of(APRIL, 15),
        of(MAY, 1),
        of(MAY, 2),
        of(AUGUST, 15),
        of(OCTOBER, 12),
        of(NOVEMBER, 1),
        of(DECEMBER, 6),
        of(DECEMBER, 8),
        of(DECEMBER, 25));
  }
}
