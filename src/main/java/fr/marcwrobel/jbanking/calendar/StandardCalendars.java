package fr.marcwrobel.jbanking.calendar;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/** A set of standard {@link ConfigurableCalendar}. */
public enum StandardCalendars implements Calendar {

  /**
   * Long-term calendar for Trans-European Automated Real-time Gross settlement Express Transfer
   * (TARGET) closing days, as described on <a
   * href="https://www.ecb.europa.eu/press/pr/date/2000/html/pr001214_4.en.html">ecb.europa.eu</a>.
   *
   * <p>This calendar is valid from 2002 until further notice.
   */
  TARGET(
      new ConfigurableCalendar(
          Arrays.asList(
              StandardsHolidays.SATURDAY,
              StandardsHolidays.SUNDAY,
              StandardsHolidays.NEW_YEAR_DAY,
              StandardsHolidays.WESTERN_GOOD_FRIDAY,
              StandardsHolidays.WESTERN_EASTER_MONDAY,
              StandardsHolidays.LABOUR_DAY,
              StandardsHolidays.CHRISTMAS,
              StandardsHolidays.WESTERN_SAINT_STEPHENS_DAY)));

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
