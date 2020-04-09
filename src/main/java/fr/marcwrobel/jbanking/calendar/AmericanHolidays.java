package fr.marcwrobel.jbanking.calendar;

import static fr.marcwrobel.jbanking.calendar.ShiftingStrategy.CLOSEST_WEEKDAY;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;
import static java.time.Month.JULY;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;
import static java.time.Month.OCTOBER;
import static java.time.Month.SEPTEMBER;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;

/** {@link Holiday}s specific to the United States. */
public enum AmericanHolidays implements Holiday {

  /**
   * Christmas (or Feast of the Nativity) is an annual festival commemorating the birth of Jesus
   * Christ.
   *
   * @see <a href="https://www.timeanddate.com/holidays/us/christmas-day">timeanddate.com</a>
   */
  CHRISTMAS(new ShiftedHoliday(WesternChristianHolidays.CHRISTMAS, CLOSEST_WEEKDAY)),

  /**
   * Columbus Day, which is on the second Monday of October, remembers Christopher Columbus' arrival
   * to the Americas on October 12, 1492.
   *
   * @see <a href="https://www.timeanddate.com/holidays/us/columbus-day">timeanddate.com</a>
   */
  COLUMBUS_DAY(new DayOfWeekInMonthHoliday(2, DayOfWeek.MONDAY, OCTOBER)),

  /**
   * Independence Day is annually celebrated on July 4 and is often known as "the Fourth of July".
   * It is the anniversary of the publication of the declaration of independence from Great Britain
   * in 1776.
   *
   * @see <a href="https://www.timeanddate.com/holidays/us/independence-day">timeanddate.com</a>
   */
  INDEPENDENCE_DAY(new ShiftedHoliday(new MonthDayHoliday(MonthDay.of(JULY, 4)), CLOSEST_WEEKDAY)),

  /**
   * Labor Day is on the first Monday of September every year. It was originally organized to
   * celebrate various labor unions' strengths of and contributions to the United States' economy.
   *
   * @see <a href="https://www.timeanddate.com/holidays/us/labor-day">timeanddate.com</a>
   */
  LABOR_DAY(new DayOfWeekInMonthHoliday(1, DayOfWeek.MONDAY, SEPTEMBER)),

  /**
   * Martin Luther King Day is a federal holiday held on the third Monday of January. It celebrates
   * the life and achievements of Martin Luther King Jr.
   *
   * @see <a
   *     href="https://www.timeanddate.com/holidays/us/martin-luther-king-day">timeanddate.com</a>
   */
  MARTIN_LUTHER_KING_JR_DAY(new DayOfWeekInMonthHoliday(3, DayOfWeek.MONDAY, JANUARY)),

  /**
   * Memorial Day is observed on the last Monday of May. It was formerly known as Decoration Day and
   * commemorates all men and women who have died in military service for the United States.
   *
   * @see <a href="https://www.timeanddate.com/holidays/us/memorial-day">timeanddate.com</a>
   */
  MEMORIAL_DAY(new DayOfWeekInMonthHoliday(-1, DayOfWeek.MONDAY, MAY)),

  /**
   * New Year's Day falls on January 1 and marks the start of a new year according to the Gregorian
   * calendar. It marks the end of New Year's Eve celebrations in the United States and gives many
   * Americans a chance to remember the previous year.
   *
   * @see <a href="https://www.timeanddate.com/holidays/us/new-year-day">timeanddate.com</a>
   */
  NEW_YEAR_DAY(new ShiftedHoliday(WorldEventHolidays.NEW_YEAR_DAY, CLOSEST_WEEKDAY)),

  /**
   * Presidents' Day, also known as Washington's Birthday, is a federal holiday held on the third
   * Monday of February. The day honors presidents of the United States, including George
   * Washington, the USA's first president.
   *
   * @see <a href="https://www.timeanddate.com/holidays/us/washington-birthday">timeanddate.com</a>
   */
  PRESIDENTS_DAY(new DayOfWeekInMonthHoliday(3, DayOfWeek.MONDAY, FEBRUARY)),

  /**
   * In the USA, Veterans Day annually falls on November 11. This day is the anniversary of the
   * signing of the armistice, which ended the World War I hostilities between the Allied nations
   * and Germany in 1918. Veterans are thanked for their services to the United States on Veterans
   * Day.
   *
   * @see <a href="https://www.timeanddate.com/holidays/us/veterans-day">timeanddate.com</a>
   */
  VETERANS_DAY(new ShiftedHoliday(WorldEventHolidays.ARMISTICE_DAY, CLOSEST_WEEKDAY)),

  /**
   * Thanksgiving is a federal holiday in the United States, celebrated on the fourth Thursday of
   * November. It originated as a harvest festival, and to this day the centerpiece of Thanksgiving
   * celebrations remains Thanksgiving dinner.
   *
   * @see <a href="https://www.timeanddate.com/holidays/us/thanksgiving-day">timeanddate.com</a>
   */
  THANKSGIVING(new DayOfWeekInMonthHoliday(4, DayOfWeek.THURSDAY, NOVEMBER));

  private final Holiday holiday;

  AmericanHolidays(Holiday holiday) {
    this.holiday = holiday;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return holiday.check(date);
  }
}
