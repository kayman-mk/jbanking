package fr.marcwrobel.jbanking.calendar;

import java.time.LocalDate;
import java.time.temporal.ValueRange;
import java.util.List;
import java.util.Set;

/** A set of standard {@link ConfigurableCalendar}. */
public enum StandardCalendars implements Calendar {

  /**
   * Belgian national holidays calendar.
   *
   * @see <a href="https://www.timeanddate.com/holidays/belgium/?hol=1">timeanddate.com</a>
   */
  BELGIAN_NATIONAL_HOLIDAYS(
      new ConfigurableCalendar(
          DayOfWeekHoliday.SATURDAY,
          DayOfWeekHoliday.SUNDAY,
          WorldEventHolidays.NEW_YEAR_DAY,
          WesternChristianHolidays.EASTER,
          WesternChristianHolidays.EASTER_MONDAY,
          WorldEventHolidays.INTERNATIONAL_WORKERS_DAY,
          WesternChristianHolidays.ASCENSION_DAY,
          WesternChristianHolidays.PENTECOST,
          WesternChristianHolidays.PENTECOST_MONDAY,
          BelgianHolidays.BELGIAN_NATIONAL_DAY,
          WesternChristianHolidays.ASSUMPTION_OF_MARY,
          WesternChristianHolidays.ALL_SAINTS_DAY,
          WorldEventHolidays.ARMISTICE_DAY,
          WesternChristianHolidays.CHRISTMAS)),

  /**
   * French national holidays calendar.
   *
   * @see <a href="https://www.timeanddate.com/holidays/france/?hol=1">timeanddate.com</a>
   */
  FRENCH_NATIONAL_HOLIDAYS(
      new ConfigurableCalendar(
          DayOfWeekHoliday.SATURDAY,
          DayOfWeekHoliday.SUNDAY,
          WorldEventHolidays.NEW_YEAR_DAY,
          WesternChristianHolidays.EASTER_MONDAY,
          WorldEventHolidays.INTERNATIONAL_WORKERS_DAY,
          WorldEventHolidays.VICTORY_IN_EUROPE_DAY,
          WesternChristianHolidays.ASCENSION_DAY,
          WesternChristianHolidays.PENTECOST_MONDAY,
          FrenchHolidays.BASTILLE_DAY,
          WesternChristianHolidays.ASSUMPTION_OF_MARY,
          WesternChristianHolidays.ALL_SAINTS_DAY,
          WorldEventHolidays.ARMISTICE_DAY,
          WesternChristianHolidays.CHRISTMAS)),

  /**
   * German official holidays calendar.
   *
   * <p>Note that 2017 was the 500th anniversary of the act by Martin Luther which stated the
   * Reformation. In Germany, the 31st of October was a national holiday that year. More on <a
   * href="https://www.bbc.com/news/world-europe-41817418">this bbc.com article</a>.
   *
   * @see <a href="https://www.timeanddate.com/holidays/germany/?hol=1">timeanddate.com</a>
   */
  GERMAN_OFFICIAL_HOLIDAYS(
      new ConfigurableCalendar(
          DayOfWeekHoliday.SATURDAY,
          DayOfWeekHoliday.SUNDAY,
          WorldEventHolidays.NEW_YEAR_DAY,
          WesternChristianHolidays.GOOD_FRIDAY,
          WesternChristianHolidays.EASTER_MONDAY,
          WorldEventHolidays.INTERNATIONAL_WORKERS_DAY,
          WesternChristianHolidays.ASCENSION_DAY,
          WesternChristianHolidays.PENTECOST_MONDAY,
          GermanHolidays.GERMAN_UNITY_DAY,
          new YearRangeHoliday(GermanHolidays.REFORMATION_DAY, ValueRange.of(2017, 2017)),
          WesternChristianHolidays.CHRISTMAS,
          WesternChristianHolidays.SAINT_STEPHENS_DAY)),

  /**
   * French national holidays calendar.
   *
   * @see <a href="https://www.timeanddate.com/holidays/luxembourg/?hol=1">timeanddate.com</a>
   */
  LUXEMBOURGER_NATIONAL_HOLIDAYS(
      new ConfigurableCalendar(
          DayOfWeekHoliday.SATURDAY,
          DayOfWeekHoliday.SUNDAY,
          WorldEventHolidays.NEW_YEAR_DAY,
          WesternChristianHolidays.EASTER_MONDAY,
          WorldEventHolidays.INTERNATIONAL_WORKERS_DAY,
          LuxembourgerHolidays.EUROPE_DAY,
          WesternChristianHolidays.ASCENSION_DAY,
          WesternChristianHolidays.PENTECOST_MONDAY,
          LuxembourgerHolidays.NATIONAL_DAY,
          WesternChristianHolidays.ASSUMPTION_OF_MARY,
          WesternChristianHolidays.ALL_SAINTS_DAY,
          WesternChristianHolidays.CHRISTMAS,
          WesternChristianHolidays.SAINT_STEPHENS_DAY)),

  /**
   * The calendar for <a
   * href="https://www.ecb.europa.eu/paym/target/target2/html/index.en.html">Trans-European
   * Automated Real-time Gross settlement Express Transfer (TARGET)</a> closing days, as described
   * on <a
   * href="https://www.ecb.europa.eu/press/pr/date/2000/html/pr001214_4.en.html">ecb.europa.eu</a>.
   *
   * <p>This calendar is valid from 2002 until further notice.
   */
  TARGET2_CLOSING_DAYS(
      new ConfigurableCalendar(
          DayOfWeekHoliday.SATURDAY,
          DayOfWeekHoliday.SUNDAY,
          WorldEventHolidays.NEW_YEAR_DAY,
          WesternChristianHolidays.GOOD_FRIDAY,
          WesternChristianHolidays.EASTER_MONDAY,
          WorldEventHolidays.INTERNATIONAL_WORKERS_DAY,
          WesternChristianHolidays.CHRISTMAS,
          WesternChristianHolidays.SAINT_STEPHENS_DAY)),

  /**
   * United Kingdom bank holidays calendar.
   *
   * @see <a href="https://www.timeanddate.com/holidays/uk/?hol=1">timeanddate.com</a>
   */
  UNITED_KINGDOM_BANK_HOLIDAYS(
      new ConfigurableCalendar(
          DayOfWeekHoliday.SATURDAY,
          DayOfWeekHoliday.SUNDAY,
          UnitedKingdomHolidays.NEW_YEAR_DAY,
          WesternChristianHolidays.GOOD_FRIDAY,
          UnitedKingdomHolidays.MAY_DAY,
          UnitedKingdomHolidays.SPRING_BANK_HOLIDAY,
          UnitedKingdomHolidays.CHRISTMAS,
          UnitedKingdomHolidays.BOXING_DAY)),

  /**
   * The US federal holidays calendar.
   *
   * <p>Though not technically accurate, U.S. federal holidays are often referred to as "public
   * holidays" or "legal holidays" because of their wide spread observance. Bank holidays are
   * usually the same as federal holidays since most banks follow the holiday calendar of the U.S.
   * Federal Reserve.
   *
   * @see <a href="https://www.timeanddate.com/holidays/us/?hol=1">timeanddate.com</a>
   * @see <a href="https://www.federalreserve.gov/aboutthefed/k8.htm">K.8 - Holidays Observed by the
   *     Federal Reserve System</a>
   */
  US_FEDERAL_HOLIDAYS(
      new ConfigurableCalendar(
          DayOfWeekHoliday.SATURDAY,
          DayOfWeekHoliday.SUNDAY,
          AmericanHolidays.NEW_YEAR_DAY,
          AmericanHolidays.MARTIN_LUTHER_KING_JR_DAY,
          AmericanHolidays.PRESIDENTS_DAY,
          AmericanHolidays.MEMORIAL_DAY,
          AmericanHolidays.INDEPENDENCE_DAY,
          AmericanHolidays.LABOR_DAY,
          AmericanHolidays.COLUMBUS_DAY,
          AmericanHolidays.VETERANS_DAY,
          AmericanHolidays.THANKSGIVING,
          AmericanHolidays.CHRISTMAS));

  private final ConfigurableCalendar calendar;

  StandardCalendars(ConfigurableCalendar calendar) {
    this.calendar = calendar;
  }

  /** @see Calendar#isHoliday(LocalDate) */
  @Override
  public boolean isHoliday(LocalDate date) {
    return calendar.isHoliday(date);
  }

  /** @see Calendar#getHolidaysFor(LocalDate) */
  @Override
  public Set<Holiday> getHolidaysFor(LocalDate date) {
    return calendar.getHolidaysFor(date);
  }

  /** @see Calendar#isBusinessDay(LocalDate) */
  @Override
  public boolean isBusinessDay(LocalDate date) {
    return calendar.isBusinessDay(date);
  }

  /** @see Calendar#previousBusinessDay(LocalDate) */
  @Override
  public LocalDate previousBusinessDay(LocalDate date) {
    return calendar.previousBusinessDay(date);
  }

  /** @see Calendar#nextBusinessDay(LocalDate) */
  @Override
  public LocalDate nextBusinessDay(LocalDate date) {
    return calendar.nextBusinessDay(date);
  }

  /** @see Calendar#holidaysWithin(LocalDate, LocalDate) */
  @Override
  public List<LocalDate> holidaysWithin(LocalDate from, LocalDate to) {
    return calendar.holidaysWithin(from, to);
  }

  /** @see Calendar#businessDaysWithin(LocalDate, LocalDate) */
  @Override
  public List<LocalDate> businessDaysWithin(LocalDate from, LocalDate to) {
    return calendar.businessDaysWithin(from, to);
  }
}
