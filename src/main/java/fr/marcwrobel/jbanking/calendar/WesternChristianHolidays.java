package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.AUGUST;
import static java.time.Month.DECEMBER;
import static java.time.Month.NOVEMBER;

import java.time.LocalDate;
import java.time.MonthDay;

/** A set of {@link Holiday}s that relates to western christianity. */
public enum WesternChristianHolidays implements Holiday {

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
  ASCENSION_DAY(new RelativeHoliday(WesternEasterHoliday.INSTANCE, 39)),

  /**
   * The Assumption of Mary into Heaven (often shortened to the Assumption) is, according to the
   * beliefs of the Catholic Church, Eastern and Oriental Orthodoxy, the bodily taking up of the
   * Virgin Mary into Heaven at the end of her earthly life.
   *
   * @see <a href="https://wikipedia.org/wiki/Assumption_of_Mary">Wikipedia</a>
   */
  ASSUMPTION_OF_MARY(new MonthDayHoliday(MonthDay.of(AUGUST, 15))),

  /**
   * Christmas (or Feast of the Nativity) is an annual festival commemorating the birth of Jesus
   * Christ, observed primarily on December 25 as a religious and cultural celebration among
   * billions of people around the world.
   *
   * @see <a href="https://wikipedia.org/wiki/Christmas">Wikipedia</a>
   */
  CHRISTMAS(new MonthDayHoliday(MonthDay.of(DECEMBER, 25))),

  /**
   * Easter, also called Pascha (Greek, Latin)[nb 2] or Resurrection Sunday, is a festival and
   * holiday commemorating the resurrection of Jesus from the dead, described in the New Testament
   * as having occurred on the third day after his burial following his crucifixion.
   *
   * @see <a href="https://wikipedia.org/wiki/Easter">Wikipedia</a>
   */
  EASTER(WesternEasterHoliday.INSTANCE),

  /**
   * Easter Monday is the day after Easter Sunday and is a holiday in some countries. Easter Monday
   * in the Western Christian liturgical calendar is the second day of Eastertide and analogously in
   * the Byzantine Rite is the second day of Bright Week.
   *
   * @see <a href="https://wikipedia.org/wiki/Easter_Monday">Wikipedia</a>
   */
  EASTER_MONDAY(new RelativeHoliday(WesternEasterHoliday.INSTANCE, 1)),

  /**
   * Good Friday is a Christian holiday commemorating the crucifixion of Jesus and his death at
   * Calvary. It is observed during Holy Week as part of the Paschal Triduum on the Friday preceding
   * Easter Sunday, and may coincide with the Jewish observance of Passover. It is also known as
   * Holy Friday, Great Friday, and Black Friday.
   *
   * @see <a href="https://wikipedia.org/wiki/Good_Friday">Wikipedia</a>
   */
  GOOD_FRIDAY(new RelativeHoliday(WesternEasterHoliday.INSTANCE, -2)),

  /**
   * The Christian holy day of Pentecost, which is celebrated fifty days after Easter Sunday,
   * commemorates the descent of the Holy Spirit upon the Apostles and other followers of Jesus
   * Christ while they were in Jerusalem celebrating the Feast of Weeks, as described in the Acts of
   * the Apostles.
   *
   * @see <a href="https://wikipedia.org/wiki/Pentecost">Wikipedia</a>
   */
  PENTECOST(new RelativeHoliday(WesternEasterHoliday.INSTANCE, 49)),

  /**
   * Saint Stephen's Day, also called the Feast of Saint Stephen, is a Christian saint's day to
   * commemorate Saint Stephen, the first Christian martyr or protomartyr, celebrated on 26 December
   * in the Latin Church and 27 December in Eastern Christianity.
   *
   * @see <a href="https://wikipedia.org/wiki/Saint_Stephen%27s_Day">Wikipedia</a>
   */
  SAINT_STEPHENS_DAY(new MonthDayHoliday(MonthDay.of(DECEMBER, 26))),

  /**
   * Whit Monday or Pentecost Monday (also known as Monday of the Holy Spirit) is the holiday
   * celebrated the day after Pentecost. In the Catholic Church, it is the Memorial of the Blessed
   * Virgin Mary, Mother of the Church.
   *
   * @see <a href="https://wikipedia.org/wiki/Whit_Monday">Wikipedia</a>
   */
  WHIT_MONDAY(new RelativeHoliday(WesternEasterHoliday.INSTANCE, 50));

  private final Holiday holiday;

  WesternChristianHolidays(Holiday holiday) {
    this.holiday = holiday;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return holiday.check(date);
  }
}
