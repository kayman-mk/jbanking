package fr.marcwrobel.jbanking.calendar;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Bank holidays are holidays when banks, and many other businesses, are closed for the day. his
 * interface is representing a bank holiday.
 *
 * <p>Subclasses of this interface are (expected to be) thread-safe and immutable.
 */
public interface Holiday {

  /**
   * Check whether the given date is an occurrence of this holiday.
   *
   * @param date the date to check.
   * @return <code>true</code> if the given date is an occurrence of this holiday, <code>false
   *     </code> otherwise.
   * @throws IllegalArgumentException if the given date is <code>null</code>.
   */
  boolean check(LocalDate date);

  /**
   * Compute the previous occurrence of this bank holiday from the given date (excluded).
   *
   * @param from the date (excluded) from which the computation starts.
   * @return the previous occurrence of this bank holiday, or {@link Optional#empty()} if there is
   *     none.
   * @throws IllegalArgumentException if the given date is <code>null</code>.
   */
  Optional<LocalDate> previous(LocalDate from);

  /**
   * Compute the next occurrence of this bank holiday from the given date (excluded).
   *
   * @param from the date (excluded) from which the computation starts.
   * @return the next occurrence of this bank holiday, or {@link Optional#empty()} if there is none.
   * @throws IllegalArgumentException if the given date is <code>null</code>.
   */
  Optional<LocalDate> next(LocalDate from);
}
