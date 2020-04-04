package fr.marcwrobel.jbanking.calendar;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * A business calendar that handles date calculations, taking bank {@link Holiday}s into account.
 * Days that are not bank holidays are called business days.
 *
 * <p>This class is immutable.
 */
public final class Calendar {

  /** Maximum number of iteration for date calculations before giving up. */
  private static final int MAX_ITERATIONS = 3650;

  private final Set<Holiday> holidays;

  /**
   * Creates a new {@code Calendar} instance using the given bank {@link Holiday}s.
   *
   * @param holidays the {@link Holiday}s that the calendar will be using.
   * @throws NullPointerException if {@code holidays} is {code null}.
   */
  public Calendar(Collection<Holiday> holidays) {
    this.holidays = Collections.unmodifiableSet(new HashSet<>(holidays));
  }

  /**
   * Check whether the given date is a bank holiday.
   *
   * @param date a non-null date.
   * @return {@code true} if the given date is a holiday, {@code false} otherwise.
   */
  public boolean isHoliday(LocalDate date) {
    for (Holiday holiday : holidays) {
      if (holiday.check(date)) {
        return true;
      }
    }

    return false;
  }

  /**
   * Check whether the given date is a business day.
   *
   * @param date a non-null date.
   * @return {@code true} if the given date is a business day, {@code false} otherwise.
   */
  public boolean isBusinessDay(LocalDate date) {
    return !isHoliday(date);
  }

  /**
   * Compute the next business day after the given date (excluded).
   *
   * @param date a non-null date
   * @return a non-null date
   * @throws DateCalculationException if no business day could be found in the next {@value
   *     MAX_ITERATIONS} days
   */
  public LocalDate nextBusinessDay(LocalDate date) {
    int c = 0;

    LocalDate next = date.plusDays(1);
    while (isHoliday(next)) {
      next = next.plusDays(1);

      if (++c >= MAX_ITERATIONS) {
        throw new DateCalculationException(
            "no business day found within the next " + MAX_ITERATIONS + " days");
      }
    }

    return next;
  }

  /**
   * Compute the previous business day before the given date (excluded).
   *
   * @param date a non-null date
   * @return a non-null date
   * @throws DateCalculationException if no business day could be found in the previous {@value
   *     MAX_ITERATIONS} days
   */
  public LocalDate previousBusinessDay(LocalDate date) {
    int c = 0;

    LocalDate previous = date.minusDays(1);
    while (isHoliday(previous)) {
      previous = previous.minusDays(1);

      if (++c >= MAX_ITERATIONS) {
        throw new DateCalculationException(
            "no business day found within the previous " + MAX_ITERATIONS + " days");
      }
    }

    return previous;
  }
}