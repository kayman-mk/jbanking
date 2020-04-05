package fr.marcwrobel.jbanking.calendar;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/** A set of standard {@link ConfigurableCalendar}. */
public enum StandardCalendars implements Calendar {

  /**
   * Long-term calendar for <a
   * href="https://www.ecb.europa.eu/paym/target/target2/html/index.en.html">Trans-European
   * Automated Real-time Gross settlement Express Transfer (TARGET)</a> closing days, as described
   * on <a
   * href="https://www.ecb.europa.eu/press/pr/date/2000/html/pr001214_4.en.html">ecb.europa.eu</a>.
   *
   * <p>This calendar is valid from 2002 until further notice.
   */
  TARGET2(
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
   * US Federal Reserve Bank Holidays, as described on <a
   * href="https://www.federalreserve.gov/aboutthefed/k8.htm">federalreserve.gov</a>
   */
  US_FEDERAL_RESERVE(
      new ConfigurableCalendar(
          DayOfWeekHoliday.SATURDAY,
          DayOfWeekHoliday.SUNDAY,
          new ShiftOnWeekendHoliday(WorldEventHolidays.NEW_YEAR_DAY),
          AmericanHolidays.MARTIN_LUTHER_KING_JR_DAY,
          AmericanHolidays.WASHINGTONS_BIRTHDAY,
          AmericanHolidays.MEMORIAL_DAY,
          new ShiftOnWeekendHoliday(AmericanHolidays.INDEPENDENCE_DAY),
          AmericanHolidays.LABOR_DAY,
          AmericanHolidays.COLUMBUS_DAY,
          new ShiftOnWeekendHoliday(AmericanHolidays.VETERANS_DAY),
          AmericanHolidays.THANKSGIVING,
          new ShiftOnWeekendHoliday(WesternChristianHolidays.CHRISTMAS)));

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
