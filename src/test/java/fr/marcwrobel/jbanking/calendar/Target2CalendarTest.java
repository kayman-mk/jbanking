package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.APRIL;
import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;
import static java.time.Month.MAY;
import static java.time.MonthDay.of;

import org.junit.jupiter.api.Test;

class Target2CalendarTest extends CalendarTestSupport {

  protected Target2CalendarTest() {
    super(StandardCalendars.TARGET2_CLOSING_DAYS);
  }

  // https://www.sepaforcorporates.com/single-euro-payments-area/european-sepa-target-closing-days-2017-2018/
  @Test
  public void year2018() {
    check(
        2018,
        of(JANUARY, 1),
        of(MARCH, 30),
        of(APRIL, 2),
        of(MAY, 1),
        of(DECEMBER, 25),
        of(DECEMBER, 26));
  }

  // https://www.sepaforcorporates.com/single-euro-payments-area/sepa-target-closing-days-2019-and-2020/
  @Test
  public void year2019() {
    check(
        2019,
        of(JANUARY, 1),
        of(APRIL, 19),
        of(APRIL, 22),
        of(MAY, 1),
        of(DECEMBER, 25),
        of(DECEMBER, 26));
  }

  // https://www.sepaforcorporates.com/single-euro-payments-area/sepa-target-closing-days-2019-and-2020/
  @Test
  public void year2020() {
    check(
        2020,
        of(JANUARY, 1),
        of(APRIL, 10),
        of(APRIL, 13),
        of(MAY, 1),
        of(DECEMBER, 25),
        of(DECEMBER, 26));
  }
}
