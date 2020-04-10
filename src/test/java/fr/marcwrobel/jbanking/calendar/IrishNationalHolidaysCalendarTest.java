package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.APRIL;
import static java.time.Month.AUGUST;
import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static java.time.Month.JUNE;
import static java.time.Month.MARCH;
import static java.time.Month.MAY;
import static java.time.Month.OCTOBER;
import static java.time.MonthDay.of;

import org.junit.jupiter.api.Test;

class IrishNationalHolidaysCalendarTest extends CalendarTestSupport {

  protected IrishNationalHolidaysCalendarTest() {
    super(StandardCalendars.IRISH_NATIONAL_HOLIDAYS);
  }

  // https://www.timeanddate.com/holidays/ireland/2018?hol=1
  @Test
  public void year2018() {
    check(
        2018,
        of(JANUARY, 1),
        of(MARCH, 17),
        of(APRIL, 2),
        of(MAY, 7),
        of(JUNE, 4),
        of(AUGUST, 6),
        of(OCTOBER, 29),
        of(DECEMBER, 25),
        of(DECEMBER, 26));
  }

  // https://www.timeanddate.com/holidays/ireland/2019?hol=1
  @Test
  public void year2019() {
    check(
        2019,
        of(JANUARY, 1),
        of(MARCH, 17),
        of(APRIL, 22),
        of(MAY, 6),
        of(JUNE, 3),
        of(AUGUST, 5),
        of(OCTOBER, 28),
        of(DECEMBER, 25),
        of(DECEMBER, 26));
  }

  // https://www.timeanddate.com/holidays/ireland/2020?hol=1
  @Test
  public void year2020() {
    check(
        2020,
        of(JANUARY, 1),
        of(MARCH, 17),
        of(APRIL, 13),
        of(MAY, 4),
        of(JUNE, 1),
        of(AUGUST, 3),
        of(OCTOBER, 26),
        of(DECEMBER, 25),
        of(DECEMBER, 26));
  }

  // https://www.timeanddate.com/holidays/ireland/2021?hol=1
  @Test
  public void year2021() {
    check(
        2021,
        of(JANUARY, 1),
        of(MARCH, 17),
        of(APRIL, 5),
        of(MAY, 3),
        of(JUNE, 7),
        of(AUGUST, 2),
        of(OCTOBER, 25),
        of(DECEMBER, 25),
        of(DECEMBER, 26));
  }

  // https://www.timeanddate.com/holidays/ireland/2022?hol=1
  @Test
  public void year2022() {
    check(
        2022,
        of(JANUARY, 1),
        of(MARCH, 17),
        of(APRIL, 18),
        of(MAY, 2),
        of(JUNE, 6),
        of(AUGUST, 1),
        of(OCTOBER, 31),
        of(DECEMBER, 25),
        of(DECEMBER, 26));
  }
}
