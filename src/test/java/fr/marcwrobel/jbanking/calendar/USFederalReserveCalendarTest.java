package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.DECEMBER;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;
import static java.time.Month.JULY;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;
import static java.time.Month.OCTOBER;
import static java.time.Month.SEPTEMBER;

import java.time.MonthDay;
import org.junit.jupiter.api.Test;

class USFederalReserveCalendarTest extends CalendarTestSupport {

  protected USFederalReserveCalendarTest() {
    super(StandardCalendars.US_FEDERAL_RESERVE);
  }

  // https://californiapayroll.com/holidays-observed-by-the-federal-reserve-system-2016-2019/
  @Test
  public void year2016() {
    check(
        2016,
        MonthDay.of(JANUARY, 1),
        MonthDay.of(JANUARY, 18),
        MonthDay.of(FEBRUARY, 15),
        MonthDay.of(MAY, 30),
        MonthDay.of(JULY, 4),
        MonthDay.of(SEPTEMBER, 5),
        MonthDay.of(OCTOBER, 10),
        MonthDay.of(NOVEMBER, 11),
        MonthDay.of(NOVEMBER, 24),
        MonthDay.of(DECEMBER, 26));
  }

  // https://californiapayroll.com/holidays-observed-by-the-federal-reserve-system-2016-2019/
  @Test
  public void year2017() {
    check(
        2017,
        MonthDay.of(JANUARY, 2),
        MonthDay.of(JANUARY, 16),
        MonthDay.of(FEBRUARY, 20),
        MonthDay.of(MAY, 29),
        MonthDay.of(JULY, 4),
        MonthDay.of(SEPTEMBER, 4),
        MonthDay.of(OCTOBER, 9),
        MonthDay.of(NOVEMBER, 10),
        MonthDay.of(NOVEMBER, 23),
        MonthDay.of(DECEMBER, 25));
  }

  // https://californiapayroll.com/holidays-observed-by-the-federal-reserve-system-2016-2019/
  @Test
  public void year2018() {
    check(
        2018,
        MonthDay.of(JANUARY, 1),
        MonthDay.of(JANUARY, 15),
        MonthDay.of(FEBRUARY, 19),
        MonthDay.of(MAY, 28),
        MonthDay.of(JULY, 4),
        MonthDay.of(SEPTEMBER, 3),
        MonthDay.of(OCTOBER, 8),
        MonthDay.of(NOVEMBER, 12),
        MonthDay.of(NOVEMBER, 22),
        MonthDay.of(DECEMBER, 25));
  }

  // https://californiapayroll.com/holidays-observed-by-the-federal-reserve-system-2016-2019/
  @Test
  public void year2019() {
    check(
        2019,
        MonthDay.of(JANUARY, 1),
        MonthDay.of(JANUARY, 21),
        MonthDay.of(FEBRUARY, 18),
        MonthDay.of(MAY, 27),
        MonthDay.of(JULY, 4),
        MonthDay.of(SEPTEMBER, 2),
        MonthDay.of(OCTOBER, 14),
        MonthDay.of(NOVEMBER, 11),
        MonthDay.of(NOVEMBER, 28),
        MonthDay.of(DECEMBER, 25));
  }

  // https://www.federalreserve.gov/aboutthefed/k8.htm
  @Test
  public void year2020() {
    check(
        2020,
        MonthDay.of(JANUARY, 1),
        MonthDay.of(JANUARY, 20),
        MonthDay.of(FEBRUARY, 17),
        MonthDay.of(MAY, 25),
        MonthDay.of(JULY, 3),
        MonthDay.of(SEPTEMBER, 7),
        MonthDay.of(OCTOBER, 12),
        MonthDay.of(NOVEMBER, 11),
        MonthDay.of(NOVEMBER, 26),
        MonthDay.of(DECEMBER, 25));
  }

  // https://www.federalreserve.gov/aboutthefed/k8.htm
  @Test
  public void year2021() {
    check(
        2021,
        MonthDay.of(JANUARY, 1),
        MonthDay.of(JANUARY, 18),
        MonthDay.of(FEBRUARY, 15),
        MonthDay.of(MAY, 31),
        MonthDay.of(JULY, 5),
        MonthDay.of(SEPTEMBER, 6),
        MonthDay.of(OCTOBER, 11),
        MonthDay.of(NOVEMBER, 11),
        MonthDay.of(NOVEMBER, 25),
        MonthDay.of(DECEMBER, 24),
        MonthDay.of(DECEMBER, 31));
  }

  // https://www.federalreserve.gov/aboutthefed/k8.htm
  @Test
  public void year2022() {
    check(
        2022,
        MonthDay.of(JANUARY, 17),
        MonthDay.of(FEBRUARY, 21),
        MonthDay.of(MAY, 30),
        MonthDay.of(JULY, 4),
        MonthDay.of(SEPTEMBER, 5),
        MonthDay.of(OCTOBER, 10),
        MonthDay.of(NOVEMBER, 11),
        MonthDay.of(NOVEMBER, 24),
        MonthDay.of(DECEMBER, 26));
  }

  // https://www.federalreserve.gov/aboutthefed/k8.htm
  @Test
  public void year2023() {
    check(
        2023,
        MonthDay.of(JANUARY, 2),
        MonthDay.of(JANUARY, 16),
        MonthDay.of(FEBRUARY, 20),
        MonthDay.of(MAY, 29),
        MonthDay.of(JULY, 4),
        MonthDay.of(SEPTEMBER, 4),
        MonthDay.of(OCTOBER, 9),
        MonthDay.of(NOVEMBER, 10),
        MonthDay.of(NOVEMBER, 23),
        MonthDay.of(DECEMBER, 25));
  }

  // https://www.federalreserve.gov/aboutthefed/k8.htm
  @Test
  public void year2024() {
    check(
        2024,
        MonthDay.of(JANUARY, 1),
        MonthDay.of(JANUARY, 15),
        MonthDay.of(FEBRUARY, 19),
        MonthDay.of(MAY, 27),
        MonthDay.of(JULY, 4),
        MonthDay.of(SEPTEMBER, 2),
        MonthDay.of(OCTOBER, 14),
        MonthDay.of(NOVEMBER, 11),
        MonthDay.of(NOVEMBER, 28),
        MonthDay.of(DECEMBER, 25));
  }
}
