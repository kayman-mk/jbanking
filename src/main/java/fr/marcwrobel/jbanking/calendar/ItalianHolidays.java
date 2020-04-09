package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.APRIL;
import static java.time.Month.JUNE;

import java.time.LocalDate;
import java.time.MonthDay;

/** {@link Holiday}s specific to Italy. */
public enum ItalianHolidays implements Holiday {

  /**
   * Italy's Liberation Day (Italian: Festa della liberazione), also known as the Anniversary of the
   * Liberation (Italian: Anniversario della liberazione d'Italia), Anniversary of the Resistance
   * (Italian: Anniversario della Resistenza), or simply 25 April (Italian: 25 aprile) is a national
   * Italian holiday commemorating the end of Nazi occupation of the Country during World War II and
   * the victory of the Resistance.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Liberation_Day_%28Italy%29">Wikipedia</a>
   */
  LIBERATION_DAY(new MonthDayHoliday(MonthDay.of(APRIL, 25))),

  /**
   * Festa della Repubblica (English: Republic Day) is the Italian National Day and Republic Day,
   * which is celebrated on 2 June each year, with the main celebration that takes place in Rome.
   * The Festa della Repubblica is one of the national symbols of Italy.
   */
  REPUBLIC_DAY(new MonthDayHoliday(MonthDay.of(JUNE, 2)));

  private final Holiday holiday;

  ItalianHolidays(Holiday holiday) {
    this.holiday = holiday;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return holiday.check(date);
  }
}
