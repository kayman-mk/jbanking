package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.AUGUST;
import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static java.time.Month.JULY;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Optional;

/** A set of standards {@link Holiday}s. */
public enum StandardsHolidays implements Holiday {
  /**
   * Armistice Day is commemorated every year on 11 November to mark the armistice signed between
   * the Allies of World War I and Germany.
   *
   * @see <a href="https://wikipedia.org/wiki/Armistice_Day">Wikipedia</a>
   */
  ARMISTICE_DAY(new MonthDayHoliday(MonthDay.of(NOVEMBER, 11))),

  /**
   * All Saints' Day, also known as All Hallows' Day, Hallowmas, the Feast of All Saints or
   * Solemnity of All Saints, is a Christian festival celebrated in honour of all the saints, known
   * and unknown.
   *
   * @see <a href="https://wikipedia.org/wiki/All_Saints%27_Day">Wikipedia</a>
   */
  ALL_SAINTS_DAY(new MonthDayHoliday(MonthDay.of(NOVEMBER, 1))),

  /**
   * The Feast of the Ascension of Jesus Christ, also called Ascension Day, Ascension Thursday, or
   * sometimes Holy Thursday, commemorates the Christian belief of the bodily Ascension of Jesus
   * into heaven.
   *
   * @see <a href="https://wikipedia.org/wiki/Feast_of_the_Ascension">Wikipedia</a>
   */
  WESTERN_ASCENSION_DAY(new RelativeHoliday(WesternEasterHoliday.INSTANCE, 39)),

  /**
   * The Assumption of Mary into Heaven (often shortened to the Assumption) is, according to the
   * beliefs of the Catholic Church, Eastern and Oriental Orthodoxy, the bodily taking up of the
   * Virgin Mary into Heaven at the end of her earthly life.
   *
   * @see <a href="https://wikipedia.org/wiki/Assumption_of_Mary">Wikipedia</a>
   */
  ASSUMPTION(new MonthDayHoliday(MonthDay.of(AUGUST, 15))),

  /**
   * Christmas (or Feast of the Nativity) is an annual festival commemorating the birth of Jesus
   * Christ, observed primarily on December 25 as a religious and cultural celebration among
   * billions of people around the world.
   *
   * @see <a href="https://wikipedia.org/wiki/Christmas">Wikipedia</a>
   */
  CHRISTMAS(new MonthDayHoliday(MonthDay.of(DECEMBER, 25))),

  /**
   * Easter, also called Pascha (Greek, Latin) or Resurrection Sunday, is a festival and holiday
   * commemorating the resurrection of Jesus from the dead.
   *
   * @see <a href="https://wikipedia.org/wiki/Easter">Wikipedia</a>
   */
  WESTERN_EASTER(WesternEasterHoliday.INSTANCE),

  /**
   * Easter Monday is the day after Easter Sunday and is a holiday in some countries.
   *
   * @see <a href="https://wikipedia.org/wiki/Easter_Monday">Wikipedia</a>
   */
  WESTERN_EASTER_MONDAY(new RelativeHoliday(WesternEasterHoliday.INSTANCE, 1)),

  /**
   * Bastille Day is the common name given in English-speaking countries to the national day of
   * France, which is celebrated on 14 July each year.
   *
   * @see <a href="https://wikipedia.org/wiki/Bastille_Day">Wikipedia</a>
   */
  BASTILLE_DAY(new MonthDayHoliday(MonthDay.of(JULY, 14))),

  /**
   * Good Friday is a Christian holiday commemorating the crucifixion of Jesus and his death at
   * Calvary.
   *
   * @see <a href="https://wikipedia.org/wiki/Good_Friday">Wikipedia</a>
   */
  WESTERN_GOOD_FRIDAY(new RelativeHoliday(WesternEasterHoliday.INSTANCE, -2)),

  /**
   * Labour Day (Labor Day in the United States) is an annual holiday to celebrate the achievements
   * of workers.
   *
   * @see <a href="https://wikipedia.org/wiki/Labour_Day">Wikipedia</a>
   */
  LABOUR_DAY(new MonthDayHoliday(MonthDay.of(MAY, 1))),

  /**
   * New Year's Day, also simply called New Year, is observed on 1 January, the first day of the
   * year on the modern Gregorian calendar as well as the Julian calendar.
   *
   * @see <a href="https://wikipedia.org/wiki/New_Year%27s_Day">Wikipedia</a>
   */
  NEW_YEAR_DAY(new MonthDayHoliday(MonthDay.of(JANUARY, 1))),

  /**
   * The Christian holy day of Pentecost, which is celebrated fifty days after Easter Sunday,
   * commemorates the descent of the Holy Spirit upon the Apostles and other followers of Jesus
   * Christ while they were in Jerusalem celebrating the Feast of Weeks, as described in the Acts of
   * the Apostles (Acts 2:1–31).
   *
   * @see <a href="https://wikipedia.org/wiki/Pentecost">Wikipedia</a>
   */
  WESTERN_PENTECOST(new RelativeHoliday(WesternEasterHoliday.INSTANCE, 49)),

  /**
   * Whit Monday or Pentecost Monday (also known as Monday of the Holy Spirit) is the holiday
   * celebrated the day after Pentecost, a moveable feast in the Christian calendar. It is moveable
   * because it is determined by the date of Easter. In the Catholic Church, it is the Memorial of
   * the Blessed Virgin Mary, Mother of the Church.
   *
   * @see <a href="https://wikipedia.org/wiki/Whit_Monday">Wikipedia</a>
   */
  WESTERN_WHIT_MONDAY(new RelativeHoliday(WesternEasterHoliday.INSTANCE, 50)),

  /**
   * Saint Stephen's Day, also called the Feast of Saint Stephen, is a Christian saint's day to
   * commemorate Saint Stephen, the first Christian martyr or protomartyr, celebrated on 26 December
   * in the Latin Church and 27 December in Eastern Christianity.
   *
   * @see <a href="https://wikipedia.org/wiki/Saint_Stephen%27s_Day">Wikipedia</a>
   */
  WESTERN_SAINT_STEPHENS_DAY(new MonthDayHoliday(MonthDay.of(DECEMBER, 26))),

  /**
   * Victory in Europe Day, generally known as VE Day (United Kingdom) or V-E Day (North America),
   * is a day celebrating the formal acceptance by the Allies of World War II of Nazi Germany's
   * unconditional surrender of its armed forces on 8 May 1945.
   *
   * @see <a href="https://wikipedia.org/wiki/Victory_in_Europe_Day">Wikipedia</a>
   */
  VICTORY_IN_EUROPE_DAY(new MonthDayHoliday(MonthDay.of(MAY, 8))),

  /**
   * Monday is the day of the week between Sunday and Tuesday. It seems it is never a weekend day.
   */
  MONDAY(DayOfWeekHoliday.MONDAY),

  /**
   * Tuesday is the day of the week between Monday and Wednesday. It seems it is never a weekend
   * day.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Tuesday">Wikipedia</a>
   */
  TUESDAY(DayOfWeekHoliday.TUESDAY),

  /**
   * Wednesday is the day of the week between Tuesday and Thursday. It seems it is never a weekend
   * day.
   *
   * @see <a href="https://wikipedia.org/wiki/Wednesday">Wikipedia</a>
   */
  WEDNESDAY(DayOfWeekHoliday.WEDNESDAY),

  /**
   * Thursday is the day of the week between Wednesday and Friday. It seems is never a weekend day.
   *
   * @see <a href="https://wikipedia.org/wiki/Thursday">Wikipedia</a>
   */
  THURSDAY(DayOfWeekHoliday.THURSDAY),

  /**
   * Friday is the day of the week between Thursday and Saturday. Friday is the first day of the
   * weekend in some countries, with Saturday the second.
   *
   * @see <a href="https://wikipedia.org/wiki/Friday">Wikipedia</a>
   */
  FRIDAY(DayOfWeekHoliday.FRIDAY),

  /**
   * Saturday is the day of the week between Friday and Sunday. In most countries, Saturday is a
   * weekend day.
   *
   * @see <a href="https://wikipedia.org/wiki/Saturday">Wikipedia</a>
   */
  SATURDAY(DayOfWeekHoliday.SATURDAY),

  /**
   * Sunday is the day of the week between Saturday and Monday. Sunday is a day of rest in most
   * Western countries, as a part of the weekend.
   *
   * @see <a href="https://wikipedia.org/wiki/Sunday">Wikipedia</a>
   */
  SUNDAY(DayOfWeekHoliday.SUNDAY);

  private final Holiday holiday;

  StandardsHolidays(Holiday holiday) {
    this.holiday = holiday;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return holiday.check(date);
  }

  /** @see Holiday#previous(LocalDate) */
  @Override
  public Optional<LocalDate> previous(LocalDate from) {
    return holiday.previous(from);
  }

  /** @see Holiday#next(LocalDate) */
  @Override
  public Optional<LocalDate> next(LocalDate from) {
    return holiday.next(from);
  }
}
