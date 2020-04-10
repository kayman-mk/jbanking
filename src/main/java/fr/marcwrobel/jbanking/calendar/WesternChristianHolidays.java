package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.AUGUST;
import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;
import static java.time.Month.NOVEMBER;

import java.time.LocalDate;
import java.time.MonthDay;

/** A set of {@link Holiday}s that relates to western christianity. */
public enum WesternChristianHolidays implements Holiday {

  /**
   * All Saints' Day is a celebration of all Christian saints, particularly those who have no
   * special feast days of their own, in many Roman Catholic, Anglican and Protestant churches. In
   * many western churches it is annually held November 1 and in many eastern churches it is
   * celebrated on the first Sunday after Pentecost. It is also known as All Hallows Tide,
   * All-Hallomas, or All Hallows' Day.
   *
   * @see <a href="https://www.timeanddate.com/holidays/common/all-saints-day">timeanddate.com</a>
   */
  ALL_SAINTS_DAY(new MonthDayHoliday(MonthDay.of(NOVEMBER, 1))),

  /**
   * Ascension Day is the 40th day of Easter. It occurs 39 days after Easter Sunday. It is a
   * Christian holiday that commemorates Jesus Christ's ascension into heaven, according to
   * Christian belief.
   *
   * @see <a href="https://www.timeanddate.com/holidays/common/ascension-day">timeanddate.com</a>
   */
  ASCENSION_DAY(new RelativeHoliday(WesternEaster.INSTANCE, 39)),

  /**
   * The Assumption of Mary into Heaven (often shortened to the Assumption) is, according to the
   * beliefs of the Catholic Church, Eastern and Oriental Orthodoxy, the bodily taking up of the
   * Virgin Mary into Heaven at the end of her earthly life.
   *
   * @see <a href="https://wikipedia.org/wiki/Assumption_of_Mary">Wikipedia</a>
   */
  ASSUMPTION_OF_MARY(new MonthDayHoliday(MonthDay.of(AUGUST, 15))),

  /**
   * Boxing Day is a holiday celebrated the day after Christmas Day, thus being the second day of
   * Christmastide. It originated in the United Kingdom and is celebrated in a number of countries
   * that previously formed part of the British Empire. Boxing Day is on 26 December, although the
   * attached bank holiday or public holiday may take place either on that day or two days later.
   *
   * @see <a href="https://wikipedia.org/wiki/Boxing_Day">Wikipedia</a>
   * @see #SAINT_STEPHENS_DAY
   */
  BOXING_DAY(new MonthDayHoliday(MonthDay.of(DECEMBER, 26))),

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
  EASTER(WesternEaster.INSTANCE),

  /**
   * Easter Monday is the day after Easter Sunday and is a holiday in some countries. Easter Monday
   * in the Western Christian liturgical calendar is the second day of Eastertide and analogously in
   * the Byzantine Rite is the second day of Bright Week.
   *
   * @see <a href="https://wikipedia.org/wiki/Easter_Monday">Wikipedia</a>
   */
  EASTER_MONDAY(new RelativeHoliday(WesternEaster.INSTANCE, 1)),

  /**
   * Epiphany is a Christian feast day that celebrates the revelation (theophany) of God incarnate
   * as Jesus Christ. In Western Christianity, the feast commemorates principally (but not solely)
   * the visit of the Magi to the Christ Child, and thus Jesus' physical manifestation to the
   * Gentiles. It is sometimes called Three Kings' Day, and in some traditions celebrated as Little
   * Christmas. Moreover, the feast of the Epiphany, in some denominations, also initiates the
   * liturgical season of Epiphanytide.
   *
   * @see <a href="https://wikipedia.org/wiki/Epiphany_(holiday)">Wikipedia</a>
   */
  EPIPHANY(new MonthDayHoliday(MonthDay.of(JANUARY, 6))),

  /**
   * The Solemnity of the Immaculate Conception celebrates the solemn celebration of belief in the
   * Immaculate Conception of the Virgin Mary. It is universally celebrated on December 8, nine
   * months before the feast of the Nativity of Mary, which is celebrated on September 8. The
   * Immaculate Conception is one of the most important Marian feasts in the liturgical calendar of
   * the Roman Catholic Church, and is celebrated worldwide.
   *
   * @see <a href="https://wikipedia.org/wiki/Feast_of_the_Immaculate_Conception">Wikipedia</a>
   */
  FEAST_OF_THE_IMMACULATE_CONCEPTION(new MonthDayHoliday(MonthDay.of(DECEMBER, 8))),

  /**
   * Good Friday is a Christian holiday commemorating the crucifixion of Jesus and his death at
   * Calvary. It is observed during Holy Week as part of the Paschal Triduum on the Friday preceding
   * Easter Sunday, and may coincide with the Jewish observance of Passover. It is also known as
   * Holy Friday, Great Friday, and Black Friday.
   *
   * @see <a href="https://wikipedia.org/wiki/Good_Friday">Wikipedia</a>
   */
  GOOD_FRIDAY(new RelativeHoliday(WesternEaster.INSTANCE, -2)),

  /**
   * The Christian holy day of Pentecost, which is celebrated fifty days after Easter Sunday,
   * commemorates the descent of the Holy Spirit upon the Apostles and other followers of Jesus
   * Christ while they were in Jerusalem celebrating the Feast of Weeks, as described in the Acts of
   * the Apostles.
   *
   * @see <a href="https://wikipedia.org/wiki/Pentecost">Wikipedia</a>
   */
  PENTECOST(new RelativeHoliday(WesternEaster.INSTANCE, 49)),

  /**
   * Whit Monday or Pentecost Monday (also known as Monday of the Holy Spirit) is the holiday
   * celebrated the day after Pentecost. In the Catholic Church, it is the Memorial of the Blessed
   * Virgin Mary, Mother of the Church.
   *
   * @see <a href="https://wikipedia.org/wiki/Whit_Monday">Wikipedia</a>
   */
  PENTECOST_MONDAY(new RelativeHoliday(WesternEaster.INSTANCE, 50)),

  /**
   * Saint Patrick's Day, or the Feast of Saint Patrick ('the Day of the Festival of Patrick'), is a
   * cultural and religious celebration held on 17 March, the traditional death date of Saint
   * Patrick, the foremost patron saint of Ireland.
   *
   * @see <a href="https://wikipedia.org/wiki/Saint_Patrick%27s_Day">Wikipedia</a>
   */
  SAINT_PATRICKS_DAY(new MonthDayHoliday(MonthDay.of(MARCH, 17))),

  /**
   * Saint Stephen's Day, also called the Feast of Saint Stephen, is a Christian saint's day to
   * commemorate Saint Stephen, the first Christian martyr or protomartyr, celebrated on 26 December
   * in the Latin Church and 27 December in Eastern Christianity.
   *
   * @see <a href="https://wikipedia.org/wiki/Saint_Stephen%27s_Day">Wikipedia</a>
   * @see #BOXING_DAY
   */
  SAINT_STEPHENS_DAY(new MonthDayHoliday(MonthDay.of(DECEMBER, 26)));

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
