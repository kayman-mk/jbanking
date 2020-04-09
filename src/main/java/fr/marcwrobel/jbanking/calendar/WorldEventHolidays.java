package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.JANUARY;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 * A set of {@link Holiday}s that relates to world events (e.g. events meaningful for multiple
 * countries), such as feasts or wars.
 */
public enum WorldEventHolidays implements Holiday {
  /**
   * Armistice Day is commemorated every year on 11 November to mark the armistice signed between
   * the Allies of World War I and Germany.
   *
   * @see <a href="https://wikipedia.org/wiki/Armistice_Day">Wikipedia</a>
   */
  ARMISTICE_DAY(new MonthDayHoliday(MonthDay.of(NOVEMBER, 11))),

  /**
   * The "Europe Day" of the EU was introduced in 1985 by the European Communities (the predecessor
   * organisation of the EU) The date of commemorates the Schuman Declaration of 9 May 1950.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Europe_Day">Wikipedia</a>
   */
  EUROPE_DAY(new MonthDayHoliday(MonthDay.of(MAY, 9))),

  /**
   * International Workers' Day, also known as Workers' Day, Labour Day in some countries and often
   * referred to as May Day, is a celebration of labourers and the working classes that is promoted
   * by the international labour movement which occurs every year on May Day (1 May), an ancient
   * European spring festival.
   *
   * @see <a href="https://wikipedia.org/wiki/International_Workers%27_Day">Wikipedia</a>
   */
  INTERNATIONAL_WORKERS_DAY(new MonthDayHoliday(MonthDay.of(MAY, 1))),

  /**
   * New Year's Day, also simply called New Year, is observed on 1 January, the first day of the
   * year on the modern Gregorian calendar as well as the Julian calendar.
   *
   * @see <a href="https://wikipedia.org/wiki/New_Year%27s_Day">Wikipedia</a>
   */
  NEW_YEAR_DAY(new MonthDayHoliday(MonthDay.of(JANUARY, 1))),

  /**
   * Victory in Europe Day, generally known as VE Day (United Kingdom) or V-E Day (North America),
   * is a day celebrating the formal acceptance by the Allies of World War II of Nazi Germany's
   * unconditional surrender of its armed forces on 8 May 1945.
   *
   * @see <a href="https://wikipedia.org/wiki/Victory_in_Europe_Day">Wikipedia</a>
   */
  VICTORY_IN_EUROPE_DAY(new MonthDayHoliday(MonthDay.of(MAY, 8)));

  private final Holiday holiday;

  WorldEventHolidays(Holiday holiday) {
    this.holiday = holiday;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return holiday.check(date);
  }
}
