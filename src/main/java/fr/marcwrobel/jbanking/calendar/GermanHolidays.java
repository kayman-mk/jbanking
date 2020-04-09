package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.OCTOBER;

import java.time.LocalDate;
import java.time.MonthDay;

/** {@link Holiday}s specific to Germany. */
public enum GermanHolidays implements Holiday {

  /**
   * The German Unity Day (German: Tag der Deutschen Einheit) is the National Day of Germany,
   * celebrated on 3 October as a public holiday.
   *
   * @see <a href="https://wikipedia.org/wiki/German_Unity_Day">Wikipedia</a>
   */
  GERMAN_UNITY_DAY(new MonthDayHoliday(MonthDay.of(OCTOBER, 3))),

  /**
   * Reformation Day is a public holiday in five states in Germany on October 31 each year to
   * remember the religious Reformation in Europe.
   *
   * @see <a href="https://www.timeanddate.com/holidays/germany/reformation-day">timeanddate.com</a>
   */
  REFORMATION_DAY(new MonthDayHoliday(MonthDay.of(OCTOBER, 31)));

  private final Holiday holiday;

  GermanHolidays(Holiday holiday) {
    this.holiday = holiday;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return holiday.check(date);
  }
}
