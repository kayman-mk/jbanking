package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.APRIL;
import static java.time.Month.AUGUST;
import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static java.time.Month.JULY;
import static java.time.Month.JUNE;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;
import static java.time.MonthDay.of;

import org.junit.jupiter.api.Test;

class BelgianNationalHolidaysCalendarTest extends CalendarTestSupport {

  protected BelgianNationalHolidaysCalendarTest() {
    super(StandardCalendars.BELGIAN_NATIONAL_HOLIDAYS);
  }

  // https://www.timeanddate.com/holidays/belgium/2018?hol=1
  @Test
  public void year2018() {
    check(
        2018,
        of(JANUARY, 1),
        of(APRIL, 1),
        of(APRIL, 2),
        of(MAY, 1),
        of(MAY, 10),
        of(MAY, 20),
        of(MAY, 21),
        of(JULY, 21),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/belgium/2019?hol=1
  @Test
  public void year2019() {
    check(
        2019,
        of(JANUARY, 1),
        of(APRIL, 21),
        of(APRIL, 22),
        of(MAY, 1),
        of(MAY, 30),
        of(JUNE, 9),
        of(JUNE, 10),
        of(JULY, 21),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/belgium/2020?hol=1
  @Test
  public void year2020() {
    check(
        2020,
        of(JANUARY, 1),
        of(APRIL, 12),
        of(APRIL, 13),
        of(MAY, 1),
        of(MAY, 21),
        of(MAY, 31),
        of(JUNE, 1),
        of(JULY, 21),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/belgium/2021?hol=1
  @Test
  public void year2021() {
    check(
        2021,
        of(JANUARY, 1),
        of(APRIL, 4),
        of(APRIL, 5),
        of(MAY, 1),
        of(MAY, 13),
        of(MAY, 23),
        of(MAY, 24),
        of(JULY, 21),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/belgium/2022?hol=1
  @Test
  public void year2022() {
    check(
        2022,
        of(JANUARY, 1),
        of(APRIL, 17),
        of(APRIL, 18),
        of(MAY, 1),
        of(MAY, 26),
        of(JUNE, 5),
        of(JUNE, 6),
        of(JULY, 21),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }
}
