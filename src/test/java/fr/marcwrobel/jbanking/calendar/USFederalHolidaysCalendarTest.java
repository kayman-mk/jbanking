package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.DECEMBER;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;
import static java.time.Month.JULY;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;
import static java.time.Month.OCTOBER;
import static java.time.Month.SEPTEMBER;
import static java.time.MonthDay.of;

import org.junit.jupiter.api.Test;

class USFederalHolidaysCalendarTest extends CalendarTestSupport {

  protected USFederalHolidaysCalendarTest() {
    super(StandardCalendars.US_FEDERAL_HOLIDAYS);
  }

  // https://www.timeanddate.com/holidays/us/2015?hol=1
  @Test
  public void year2015() {
    check(
        2015,
        of(JANUARY, 1),
        of(JANUARY, 19),
        of(FEBRUARY, 16),
        of(MAY, 25),
        of(JULY, 3),
        of(SEPTEMBER, 7),
        of(OCTOBER, 12),
        of(NOVEMBER, 11),
        of(NOVEMBER, 26),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/us/2016?hol=1
  @Test
  public void year2016() {
    check(
        2016,
        of(JANUARY, 1),
        of(JANUARY, 18),
        of(FEBRUARY, 15),
        of(MAY, 30),
        of(JULY, 4),
        of(SEPTEMBER, 5),
        of(OCTOBER, 10),
        of(NOVEMBER, 11),
        of(NOVEMBER, 24),
        of(DECEMBER, 26));
  }

  // https://www.timeanddate.com/holidays/us/2017?hol=1
  @Test
  public void year2017() {
    check(
        2017,
        of(JANUARY, 2),
        of(JANUARY, 16),
        of(FEBRUARY, 20),
        of(MAY, 29),
        of(JULY, 4),
        of(SEPTEMBER, 4),
        of(OCTOBER, 9),
        of(NOVEMBER, 10),
        of(NOVEMBER, 23),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/us/2018?hol=1
  @Test
  public void year2018() {
    check(
        2018,
        of(JANUARY, 1),
        of(JANUARY, 15),
        of(FEBRUARY, 19),
        of(MAY, 28),
        of(JULY, 4),
        of(SEPTEMBER, 3),
        of(OCTOBER, 8),
        of(NOVEMBER, 12),
        of(NOVEMBER, 22),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/us/2019?hol=1
  @Test
  public void year2019() {
    check(
        2019,
        of(JANUARY, 1),
        of(JANUARY, 21),
        of(FEBRUARY, 18),
        of(MAY, 27),
        of(JULY, 4),
        of(SEPTEMBER, 2),
        of(OCTOBER, 14),
        of(NOVEMBER, 11),
        of(NOVEMBER, 28),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/us/2020?hol=1
  @Test
  public void year2020() {
    check(
        2020,
        of(JANUARY, 1),
        of(JANUARY, 20),
        of(FEBRUARY, 17),
        of(MAY, 25),
        of(JULY, 3),
        of(SEPTEMBER, 7),
        of(OCTOBER, 12),
        of(NOVEMBER, 11),
        of(NOVEMBER, 26),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/us/2021?hol=1
  @Test
  public void year2021() {
    check(
        2021,
        of(JANUARY, 1),
        of(JANUARY, 18),
        of(FEBRUARY, 15),
        of(MAY, 31),
        of(JULY, 5),
        of(SEPTEMBER, 6),
        of(OCTOBER, 11),
        of(NOVEMBER, 11),
        of(NOVEMBER, 25),
        of(DECEMBER, 24),
        of(DECEMBER, 31));
  }

  // https://www.timeanddate.com/holidays/us/2022?hol=1
  @Test
  public void year2022() {
    check(
        2022,
        of(JANUARY, 17),
        of(FEBRUARY, 21),
        of(MAY, 30),
        of(JULY, 4),
        of(SEPTEMBER, 5),
        of(OCTOBER, 10),
        of(NOVEMBER, 11),
        of(NOVEMBER, 24),
        of(DECEMBER, 26));
  }

  // https://www.timeanddate.com/holidays/us/2023?hol=1
  @Test
  public void year2023() {
    check(
        2023,
        of(JANUARY, 2),
        of(JANUARY, 16),
        of(FEBRUARY, 20),
        of(MAY, 29),
        of(JULY, 4),
        of(SEPTEMBER, 4),
        of(OCTOBER, 9),
        of(NOVEMBER, 10),
        of(NOVEMBER, 23),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/us/2024?hol=1
  @Test
  public void year2024() {
    check(
        2024,
        of(JANUARY, 1),
        of(JANUARY, 15),
        of(FEBRUARY, 19),
        of(MAY, 27),
        of(JULY, 4),
        of(SEPTEMBER, 2),
        of(OCTOBER, 14),
        of(NOVEMBER, 11),
        of(NOVEMBER, 28),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/us/2025?hol=1
  @Test
  public void year2025() {
    check(
        2025,
        of(JANUARY, 1),
        of(JANUARY, 20),
        of(FEBRUARY, 17),
        of(MAY, 26),
        of(JULY, 4),
        of(SEPTEMBER, 1),
        of(OCTOBER, 13),
        of(NOVEMBER, 11),
        of(NOVEMBER, 27),
        of(DECEMBER, 25));
  }
}
