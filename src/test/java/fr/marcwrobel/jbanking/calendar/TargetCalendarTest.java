package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.APRIL;
import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;
import static java.time.Month.MAY;

import java.time.MonthDay;
import org.junit.jupiter.api.Test;

class TargetCalendarTest extends CalendarTestSupport {

  protected TargetCalendarTest() {
    super(StandardCalendars.TARGET2);
  }

  // https://www.sepaforcorporates.com/single-euro-payments-area/sepa-holidays-2014-2015-the-dates-and-why-you-need-to-know-them/
  @Test
  public void year2015() {
    check(
        2015,
        MonthDay.of(JANUARY, 1),
        MonthDay.of(APRIL, 3),
        MonthDay.of(APRIL, 6),
        MonthDay.of(MAY, 1),
        MonthDay.of(DECEMBER, 25),
        MonthDay.of(DECEMBER, 26));
  }

  // https://www.sepaforcorporates.com/single-euro-payments-area/sepa-holidays-2014-2015-the-dates-and-why-you-need-to-know-them/
  @Test
  public void year2016() {
    check(
        2016,
        MonthDay.of(JANUARY, 1),
        MonthDay.of(MARCH, 25),
        MonthDay.of(MARCH, 28),
        MonthDay.of(MAY, 1),
        MonthDay.of(DECEMBER, 25),
        MonthDay.of(DECEMBER, 26));
  }

  // https://www.sepaforcorporates.com/single-euro-payments-area/european-sepa-target-closing-days-2017-2018/
  @Test
  public void year2017() {
    check(
        2017,
        MonthDay.of(JANUARY, 1),
        MonthDay.of(APRIL, 14),
        MonthDay.of(APRIL, 17),
        MonthDay.of(MAY, 1),
        MonthDay.of(DECEMBER, 25),
        MonthDay.of(DECEMBER, 26));
  }

  // https://www.sepaforcorporates.com/single-euro-payments-area/european-sepa-target-closing-days-2017-2018/
  @Test
  public void year2018() {
    check(
        2018,
        MonthDay.of(JANUARY, 1),
        MonthDay.of(MARCH, 30),
        MonthDay.of(APRIL, 2),
        MonthDay.of(MAY, 1),
        MonthDay.of(DECEMBER, 25),
        MonthDay.of(DECEMBER, 26));
  }

  // https://www.sepaforcorporates.com/single-euro-payments-area/sepa-target-closing-days-2019-and-2020/
  @Test
  public void year2019() {
    check(
        2019,
        MonthDay.of(JANUARY, 1),
        MonthDay.of(APRIL, 19),
        MonthDay.of(APRIL, 22),
        MonthDay.of(MAY, 1),
        MonthDay.of(DECEMBER, 25),
        MonthDay.of(DECEMBER, 26));
  }

  // https://www.sepaforcorporates.com/single-euro-payments-area/sepa-target-closing-days-2019-and-2020/
  @Test
  public void year2020() {
    check(
        2020,
        MonthDay.of(JANUARY, 1),
        MonthDay.of(APRIL, 10),
        MonthDay.of(APRIL, 13),
        MonthDay.of(MAY, 1),
        MonthDay.of(DECEMBER, 25),
        MonthDay.of(DECEMBER, 26));
  }
}
