package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.APRIL;
import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;
import static java.time.MonthDay.of;

import org.junit.jupiter.api.Test;

class AustralianNationalHolidaysCalendarTest extends CalendarTestSupport {

  protected AustralianNationalHolidaysCalendarTest() {
    super(StandardCalendars.AUSTRALIAN_NATIONAL_HOLIDAYS);
  }

  // https://www.timeanddate.com/holidays/australia/2018?hol=1
  @Test
  public void year2018() {
    check(
        2018,
        of(JANUARY, 1),
        of(JANUARY, 26),
        of(MARCH, 30),
        of(APRIL, 2),
        of(APRIL, 25),
        of(DECEMBER, 25),
        of(DECEMBER, 26));
  }

  // https://www.timeanddate.com/holidays/australia/2019?hol=1
  @Test
  public void year2019() {
    check(
        2019,
        of(JANUARY, 1),
        of(JANUARY, 26),
        of(APRIL, 19),
        of(APRIL, 22),
        of(APRIL, 25),
        of(DECEMBER, 25),
        of(DECEMBER, 26));
  }

  // https://www.timeanddate.com/holidays/australia/2020?hol=1
  @Test
  public void year2020() {
    check(
        2020,
        of(JANUARY, 1),
        of(JANUARY, 26),
        of(APRIL, 10),
        of(APRIL, 13),
        of(APRIL, 25),
        of(DECEMBER, 25),
        of(DECEMBER, 26));
  }

  // https://www.timeanddate.com/holidays/australia/2021?hol=1
  @Test
  public void year2021() {
    check(
        2021,
        of(JANUARY, 1),
        of(JANUARY, 26),
        of(APRIL, 2),
        of(APRIL, 5),
        of(APRIL, 25),
        of(DECEMBER, 25),
        of(DECEMBER, 26));
  }

  // https://www.timeanddate.com/holidays/australia/2022?hol=1
  @Test
  public void year2022() {
    check(
        2022,
        of(JANUARY, 1),
        of(JANUARY, 26),
        of(APRIL, 15),
        of(APRIL, 18),
        of(APRIL, 25),
        of(DECEMBER, 25),
        of(DECEMBER, 26));
  }
}
