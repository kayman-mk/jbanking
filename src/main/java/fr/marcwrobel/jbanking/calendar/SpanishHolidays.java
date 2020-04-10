package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.DECEMBER;

import java.time.LocalDate;
import java.time.MonthDay;

/** {@link Holiday}s specific to Spain. */
public enum SpanishHolidays implements Holiday {

  /**
   * Constitution Day (Día de la Constitución) marks the anniversary of a referendum held in Spain
   * on December 6, 1978. In this referendum, a new constitution was approved . This was an
   * important step in Spain's transition to becoming a constitutional monarchy and democracy.
   *
   * @see <a href="https://www.timeanddate.com/holidays/spain/constitution-day">timeanddate.com</a>
   */
  CONSTITUTION_DAY(new MonthDayHoliday(MonthDay.of(DECEMBER, 6))),

  /**
   * Hispanic Day (Día de la Hispanidad) or National Day (Fiesta Nacional de España) is an annual
   * national public holiday in Spain on October 12. It commemorates when Christopher Columbus first
   * set foot in the Americas in 1492.
   *
   * @see <a href="https://www.timeanddate.com/holidays/spain/hispanic-day">timeanddate.com</a>
   */
  HISPANIC_DAY(WorldEventHolidays.COLUMBUS_DAY);

  private final Holiday holiday;

  SpanishHolidays(Holiday holiday) {
    this.holiday = holiday;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return holiday.check(date);
  }
}
