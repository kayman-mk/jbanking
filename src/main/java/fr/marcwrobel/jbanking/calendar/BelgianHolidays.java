package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.JULY;

import java.time.LocalDate;
import java.time.MonthDay;

/** {@link Holiday}s specific to Belgium. */
public enum BelgianHolidays implements Holiday {

  /**
   * Belgian National Day (Dutch: Nationale feestdag van België; French: Fête nationale belge;
   * German: Belgischer Nationalfeiertag) is the national holiday of Belgium commemorated annually
   * on 21 July.
   *
   * @see <a href="https://wikipedia.org/wiki/Belgian_National_Day">Wikipedia</a>
   */
  BELGIAN_NATIONAL_DAY(new MonthDayHoliday(MonthDay.of(JULY, 21)));

  private final Holiday holiday;

  BelgianHolidays(Holiday holiday) {
    this.holiday = holiday;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return holiday.check(date);
  }
}
