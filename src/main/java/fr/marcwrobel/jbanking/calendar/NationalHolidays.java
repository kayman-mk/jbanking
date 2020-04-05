package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.JULY;
import static java.time.Month.OCTOBER;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 * <a href="https://en.wikipedia.org/wiki/National_day">National holidays</a> (if there is no enum
 * for the given countries).
 */
public enum NationalHolidays implements Holiday {

  /**
   * Bastille Day is the common name given in English-speaking countries to the national day of
   * France, which is celebrated on 14 July each year.
   *
   * @see <a href="https://wikipedia.org/wiki/Bastille_Day">Wikipedia</a>
   */
  BASTILLE_DAY(new MonthDayHoliday(MonthDay.of(JULY, 14))),

  /**
   * The German Unity Day (German: Tag der Deutschen Einheit) is the National Day of Germany,
   * celebrated on 3 October as a public holiday.
   *
   * @see <a href="https://wikipedia.org/wiki/German_Unity_Day">Wikipedia</a>
   */
  GERMAN_UNITY_DAY(new MonthDayHoliday(MonthDay.of(OCTOBER, 3)));

  private final Holiday holiday;

  NationalHolidays(Holiday holiday) {
    this.holiday = holiday;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return holiday.check(date);
  }
}
