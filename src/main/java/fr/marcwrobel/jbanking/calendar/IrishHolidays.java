package fr.marcwrobel.jbanking.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/** {@link Holiday}s specific to Ireland. */
public enum IrishHolidays implements Holiday {

  /**
   * In Ireland, the August Holiday (sometimes called the August Bank Holiday) is observed on the
   * first Monday of August. It was first observed in 1871, when it was created by the British Act
   * of Parliament, the Bank Holidays Act 1871.
   *
   * @see <a href="https://wikipedia.org/wiki/August_Holiday">Wikipedia</a>
   * @see <a
   *     href="https://www.timeanddate.com/holidays/ireland/august-bank-holiday">timeanddate.com</a>
   */
  AUGUST_HOLIDAY(new DayOfWeekInMonthHoliday(1, DayOfWeek.MONDAY, Month.AUGUST)),

  /**
   * In Ireland, the June Holiday (sometimes called the June Bank Holiday) is observed on the first
   * Monday of June. It was previously observed as Whit Monday until 1973.
   *
   * @see <a href="https://wikipedia.org/wiki/June_Holiday">timeanddate.com</a>
   * @see <a
   *     href="https://www.timeanddate.com/holidays/ireland/june-bank-holiday">timeanddate.com</a>
   */
  JUNE_HOLIDAY(new DayOfWeekInMonthHoliday(1, DayOfWeek.MONDAY, Month.JUNE)),

  /**
   * May Day, or Labour Day, is the first Monday of May. It is a public holiday in the Republic of
   * Ireland. It is a traditional Celtic festival and a time to campaign for workers rights.
   *
   * @see <a href="https://wikipedia.org/wiki/May_Day">Wikipedia</a>
   * @see <a href="https://www.timeanddate.com/holidays/ireland/may-day">timeanddate.com</a>
   */
  MAY_DAY(new DayOfWeekInMonthHoliday(1, DayOfWeek.MONDAY, Month.MAY)),

  /**
   * In Ireland, the October Holiday (sometimes called the October Bank Holiday) is observed on the
   * last Monday of October. Usually, but not always, this is the day after the end of Western
   * European Summer Time. It was introduced in 1977.
   *
   * @see <a href="https://wikipedia.org/wiki/October_Holiday">Wikipedia</a>
   * @see <a
   *     href="https://www.timeanddate.com/holidays/ireland/october-bank-holiday">timeanddate.com</a>
   */
  OCTOBER_HOLIDAY(new DayOfWeekInMonthHoliday(-1, DayOfWeek.MONDAY, Month.OCTOBER));

  private final Holiday holiday;

  IrishHolidays(Holiday holiday) {
    this.holiday = holiday;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return holiday.check(date);
  }
}
