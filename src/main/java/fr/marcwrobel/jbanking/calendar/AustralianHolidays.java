package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.JANUARY;

import java.time.LocalDate;
import java.time.MonthDay;

/** {@link Holiday}s specific to Australia. */
public enum AustralianHolidays implements Holiday {

  /**
   * Australia Day is the official national day of Australia. Celebrated annually on 26 January, it
   * marks the anniversary of the 1788 arrival of the First Fleet of British ships at Port Jackson,
   * New South Wales, and the raising of the Flag of Great Britain at Sydney Cove by Governor Arthur
   * Phillip.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Australia_Day">Wikipedia</a>
   * @see <a href="https://www.timeanddate.com/holidays/australia/australia-day">timeanddate.com</a>
   */
  AUSTRALIA_DAY(new MonthDayHoliday(MonthDay.of(JANUARY, 26)));

  private final Holiday holiday;

  AustralianHolidays(Holiday holiday) {
    this.holiday = holiday;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return holiday.check(date);
  }
}
