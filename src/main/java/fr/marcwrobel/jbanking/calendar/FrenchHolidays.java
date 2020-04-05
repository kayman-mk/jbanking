package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.JULY;

import java.time.LocalDate;
import java.time.MonthDay;

/** A set of {@link Holiday}s specific to France. */
public enum FrenchHolidays implements Holiday {

  /**
   * Bastille Day is the common name given in English-speaking countries to the national day of
   * France, which is celebrated on 14 July each year.
   *
   * @see <a href="https://wikipedia.org/wiki/Bastille_Day">Wikipedia</a>
   */
  BASTILLE_DAY(new MonthDayHoliday(MonthDay.of(JULY, 14)));

  private final Holiday holiday;

  FrenchHolidays(Holiday holiday) {
    this.holiday = holiday;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return holiday.check(date);
  }
}
