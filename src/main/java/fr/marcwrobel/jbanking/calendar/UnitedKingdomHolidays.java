package fr.marcwrobel.jbanking.calendar;

import static fr.marcwrobel.jbanking.calendar.ShiftingStrategy.FOLLOWING_WEEK;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/** {@link Holiday}s specific to the United Kingdom. */
public enum UnitedKingdomHolidays implements Holiday {

  /**
   * Boxing Day in the United Kingdom is the day after Christmas Day and falls on December 26.
   *
   * @see <a href="https://www.timeanddate.com/holidays/uk/boxing-day">timeanddate.com</a>
   */
  BOXING_DAY(new ShiftedHoliday(WesternChristianHolidays.BOXING_DAY, FOLLOWING_WEEK)),

  /**
   * Christmas (or Feast of the Nativity) is an annual festival commemorating the birth of Jesus
   * Christ.
   *
   * @see <a href="https://www.timeanddate.com/holidays/us/christmas-day">timeanddate.com</a>
   */
  CHRISTMAS(new ShiftedHoliday(WesternChristianHolidays.CHRISTMAS, FOLLOWING_WEEK)),

  /**
   * The first Monday of May is a bank holiday in the United Kingdom. It is called May Day in
   * England, Wales and Northern Ireland. It is known as the Early May Bank Holiday in Scotland.
   *
   * @see <a
   *     href="https://www.timeanddate.com/holidays/uk/early-may-bank-holiday">timeanddate.com</a>
   */
  MAY_DAY(
      new MovedHoliday(
          new DayOfWeekInMonthHoliday(1, DayOfWeek.MONDAY, Month.MAY),
          LocalDate.of(2020, 5, 4),
          LocalDate.of(2020, 5, 8))),

  /**
   * New Year's Day, also simply called New Year, is observed on 1 January, the first day of the
   * year on the modern Gregorian calendar as well as the Julian calendar.
   *
   * @see <a href="https://www.timeanddate.com/holidays/uk/new-year-day">timeanddate.com</a>
   */
  NEW_YEAR_DAY(new ShiftedHoliday(WorldEventHolidays.NEW_YEAR_DAY, FOLLOWING_WEEK)),

  /**
   * The spring bank holiday, also known as the late May bank holiday, is a time for people in the
   * United Kingdom to have a day off work or school. It falls on the last Monday of May but it used
   * to be on the Monday after Pentecost.
   *
   * @see <a href="https://www.timeanddate.com/holidays/uk/spring-bank-holiday">timeanddate.com</a>
   */
  SPRING_BANK_HOLIDAY(new DayOfWeekInMonthHoliday(-1, DayOfWeek.MONDAY, Month.MAY));

  private final Holiday holiday;

  UnitedKingdomHolidays(Holiday holiday) {
    this.holiday = holiday;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return holiday.check(date);
  }
}
