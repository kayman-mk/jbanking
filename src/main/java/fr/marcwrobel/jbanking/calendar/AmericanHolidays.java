package fr.marcwrobel.jbanking.calendar;

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

/** A set of {@link Holiday}s specific to United States. */
public enum AmericanHolidays implements Holiday {

  /**
   * Columbus Day is a national holiday in many countries of the Americas and elsewhere which
   * officially celebrates the anniversary of Christopher Columbus's arrival in the Americas on
   * October 12, 1492.
   *
   * @see <a href="https://wikipedia.org/wiki/Columbus_Day">Wikipedia</a>
   */
  COLUMBUS_DAY(new DayOfWeekInMonthHoliday(2, DayOfWeek.MONDAY, OCTOBER)),

  /**
   * Independence Day (colloquially the Fourth of July or July 4th) is a federal holiday in the
   * United States commemorating the Declaration of Independence of the United States, on July 4,
   * 1776.
   *
   * @see <a href="https://wikipedia.org/wiki/Independence_Day_(United_States)">Wikipedia</a>
   */
  INDEPENDENCE_DAY(new MonthDayHoliday(MonthDay.of(JULY, 4))),

  /**
   * Labor Day in the United States of America is a public holiday celebrated on the first Monday in
   * September. It honors the American labor movement and the power of collective action by
   * laborers, who are essential for the workings of society. It is the Monday of the long weekend
   * known as Labor Day Weekend. It is recognized as a federal holiday.
   *
   * @see <a href="https://wikipedia.org/wiki/Labor_Day">Wikipedia</a>
   */
  LABOR_DAY(new DayOfWeekInMonthHoliday(1, DayOfWeek.MONDAY, SEPTEMBER)),

  /**
   * Martin Luther King Jr. Day (officially Birthday of Martin Luther King, Jr., and sometimes
   * referred to as MLK Day) is an American federal holiday marking the birthday of Martin Luther
   * King Jr.
   *
   * @see <a href="https://wikipedia.org/wiki/Martin_Luther_King_Jr._Day">Wikipedia</a>
   */
  MARTIN_LUTHER_KING_JR_DAY(new DayOfWeekInMonthHoliday(3, DayOfWeek.MONDAY, JANUARY)),

  /**
   * Memorial Day (previously but now seldom called Decoration Day) is a federal holiday in the
   * United States for remembering, honoring, and mourning the military personnel that had died
   * while serving in the United States Armed Forces.
   *
   * @see <a href="https://wikipedia.org/wiki/Memorial_Day">Wikipedia</a>
   */
  MEMORIAL_DAY(new DayOfWeekInMonthHoliday(-1, DayOfWeek.MONDAY, MAY)),

  /**
   * Washington's Birthday is a federal holiday in the United States celebrated on the third Monday
   * of February in honor of George Washington, the first President of the United States.
   * Colloquially, the day is also now widely known as Presidents' Day.
   *
   * @see <a href="https://wikipedia.org/wiki/Washington%27s_Birthday">Wikipedia</a>
   */
  WASHINGTONS_BIRTHDAY(new DayOfWeekInMonthHoliday(3, DayOfWeek.MONDAY, FEBRUARY)),

  /**
   * Veterans Day (originally known as Armistice Day) is a federal holiday in the United States
   * observed annually on November 11, for honoring military veterans.It coincides with other
   * holidays including Armistice Day and Remembrance Day which are celebrated in other countries
   * that mark the anniversary of the end of World War I.
   *
   * @see <a href="https://wikipedia.org/wiki/Veterans_Day">Wikipedia</a>
   */
  VETERANS_DAY(WorldEventHolidays.ARMISTICE_DAY),

  /**
   * Thanksgiving is a federal holiday in the United States, celebrated on the fourth Thursday of
   * November. It originated as a harvest festival, and to this day the centerpiece of Thanksgiving
   * celebrations remains Thanksgiving dinner.
   *
   * @see <a href="https://wikipedia.org/wiki/Thanksgiving_(United_States)">Wikipedia</a>
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
