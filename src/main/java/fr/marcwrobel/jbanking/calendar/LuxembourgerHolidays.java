package fr.marcwrobel.jbanking.calendar;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.temporal.ValueRange;

/** {@link Holiday}s specific to Luxembourg. */
public enum LuxembourgerHolidays implements Holiday {

  /**
   * The "Europe Day" of the EU was introduced in 1985 by the European Communities (the predecessor
   * organisation of the EU) The date of commemorates the Schuman Declaration of 9 May 1950.
   *
   * <p>In 2019, 9 May became an official public holiday in Luxembourg each year, to mark Europe
   * Day.
   *
   * @see <a href="https://wikipedia.org/wiki/Europe_Day">Wikipedia</a>
   * @see <a href="https://www.timeanddate.com/holidays/luxembourg/europe-day">timeanddate.com</a>
   */
  EUROPE_DAY(
      new YearRangeHoliday(WorldEventHolidays.EUROPE_DAY, ValueRange.of(2019, Year.MAX_VALUE))),

  /**
   * The Grand Duke's Official Birthday (French: Célébration publique de l'anniversaire du
   * souverain), also known as Luxembourgish National Day (French: Fête nationale luxembourgeoise,
   * Luxembourgish: Lëtzebuerger Nationalfeierdag), is celebrated as the annual national holiday of
   * Luxembourg. It is celebrated on 23 June, although this has never been the actual birthday of
   * any ruler of Luxembourg.
   *
   * @see <a href="https://wikipedia.org/wiki/Grand_Duke%27s_Official_Birthday">Wikipedia</a>
   * @see <a href="https://www.timeanddate.com/holidays/luxembourg/national-day">timeanddate.com</a>
   */
  NATIONAL_DAY(new MonthDayHoliday(MonthDay.of(Month.JUNE, 23)));

  private final Holiday holiday;

  LuxembourgerHolidays(Holiday holiday) {
    this.holiday = holiday;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return holiday.check(date);
  }
}
