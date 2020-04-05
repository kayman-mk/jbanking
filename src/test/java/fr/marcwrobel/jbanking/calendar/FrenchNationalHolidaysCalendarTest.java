package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.APRIL;
import static java.time.Month.AUGUST;
import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static java.time.Month.JULY;
import static java.time.Month.JUNE;
import static java.time.Month.MARCH;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;
import static java.time.MonthDay.of;

import org.junit.jupiter.api.Test;

class FrenchNationalHolidaysCalendarTest extends CalendarTestSupport {

  protected FrenchNationalHolidaysCalendarTest() {
    super(StandardCalendars.FRENCH_NATIONAL_HOLIDAYS);
  }

  // https://www.timeanddate.com/holidays/france/2015?hol=1
  @Test
  public void year2015() {
    check(
        2015,
        of(JANUARY, 1),
        of(APRIL, 6),
        of(MAY, 1),
        of(MAY, 8),
        of(MAY, 14),
        of(MAY, 25),
        of(JULY, 14),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/france/2016?hol=1
  @Test
  public void year2016() {
    check(
        2016,
        of(JANUARY, 1),
        of(MARCH, 28),
        of(MAY, 1),
        of(MAY, 5),
        of(MAY, 8),
        of(MAY, 16),
        of(JULY, 14),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/france/2017?hol=1
  @Test
  public void year2017() {
    check(
        2017,
        of(JANUARY, 1),
        of(APRIL, 17),
        of(MAY, 1),
        of(MAY, 8),
        of(MAY, 25),
        of(JUNE, 5),
        of(JULY, 14),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/france/2018?hol=1
  @Test
  public void year2018() {
    check(
        2018,
        of(JANUARY, 1),
        of(APRIL, 2),
        of(MAY, 1),
        of(MAY, 8),
        of(MAY, 10),
        of(MAY, 21),
        of(JULY, 14),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/france/2019?hol=1
  @Test
  public void year2019() {
    check(
        2019,
        of(JANUARY, 1),
        of(APRIL, 22),
        of(MAY, 1),
        of(MAY, 8),
        of(MAY, 30),
        of(JUNE, 10),
        of(JULY, 14),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/france/2020?hol=1
  @Test
  public void year2020() {
    check(
        2020,
        of(JANUARY, 1),
        of(APRIL, 13),
        of(MAY, 1),
        of(MAY, 8),
        of(MAY, 21),
        of(JUNE, 1),
        of(JULY, 14),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/france/2021?hol=1
  @Test
  public void year2021() {
    check(
        2021,
        of(JANUARY, 1),
        of(APRIL, 5),
        of(MAY, 1),
        of(MAY, 8),
        of(MAY, 13),
        of(MAY, 24),
        of(JULY, 14),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/france/2022?hol=1
  @Test
  public void year2022() {
    check(
        2022,
        of(JANUARY, 1),
        of(APRIL, 18),
        of(MAY, 1),
        of(MAY, 8),
        of(MAY, 26),
        of(JUNE, 6),
        of(JULY, 14),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/france/2023?hol=1
  @Test
  public void year2023() {
    check(
        2023,
        of(JANUARY, 1),
        of(APRIL, 10),
        of(MAY, 1),
        of(MAY, 8),
        of(MAY, 18),
        of(MAY, 29),
        of(JULY, 14),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/france/2024?hol=1
  @Test
  public void year2024() {
    check(
        2024,
        of(JANUARY, 1),
        of(APRIL, 1),
        of(MAY, 1),
        of(MAY, 8),
        of(MAY, 9),
        of(MAY, 20),
        of(JULY, 14),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }

  // https://www.timeanddate.com/holidays/france/2025?hol=1
  @Test
  public void year2025() {
    check(
        2025,
        of(JANUARY, 1),
        of(APRIL, 21),
        of(MAY, 1),
        of(MAY, 8),
        of(MAY, 29),
        of(JUNE, 9),
        of(JULY, 14),
        of(AUGUST, 15),
        of(NOVEMBER, 1),
        of(NOVEMBER, 11),
        of(DECEMBER, 25));
  }
}
