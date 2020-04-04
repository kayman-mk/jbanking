package fr.marcwrobel.jbanking.calendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
   * Get all the {@link Holiday}s matching with the given day.
   *
   * @param date a non-null and unmodifiable set of {@link Holiday}s.
   * @return {@code true} if the given date is a holiday, {@code false} otherwise.
   */
  public Set<Holiday> getHolidaysFor(LocalDate date) {
    Set<Holiday> matchingHolidays = new HashSet<>(0);

    for (Holiday holiday : holidays) {
      if (holiday.check(date)) {
        matchingHolidays.add(holiday);
      }
    }

    return Collections.unmodifiableSet(matchingHolidays);
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

  /**
   * Compute the holidays between {@code from} (inclusive) and {@code to} (inclusive).
   *
   * @param from a non-null date
   * @param to a non-null date
   * @return a non-null and unmodifiable ordered list of dates
   * @throws IllegalArgumentException if {@code from} is after {@code to}
   */
  public List<LocalDate> holidaysWithin(LocalDate from, LocalDate to) {
    ensureFromIsNotAfterTo(from, to);
    List<LocalDate> occurrences = new ArrayList<>(0);

    for (LocalDate date = from; date.isBefore(to.plusDays(1)); date = date.plusDays(1)) {
      if (isHoliday(date)) {
        occurrences.add(date);
      }
    }

    return Collections.unmodifiableList(occurrences);
  }

  /**
   * Compute the business days between {@code from} (inclusive) and {@code to} (inclusive).
   *
   * @param from a non-null date
   * @param to a non-null date
   * @return a non-null and unmodifiable ordered list of dates
   * @throws IllegalArgumentException if {@code from} is after {@code to}
   */
  public List<LocalDate> businessDaysWithin(LocalDate from, LocalDate to) {
    ensureFromIsNotAfterTo(from, to);
    List<LocalDate> occurrences = new ArrayList<>(0);

    for (LocalDate date = from; date.isBefore(to.plusDays(1)); date = date.plusDays(1)) {
      if (isBusinessDay(date)) {
        occurrences.add(date);
      }
    }

    return Collections.unmodifiableList(occurrences);
  }

  private void ensureFromIsNotAfterTo(LocalDate from, LocalDate to) {
    if (from.isAfter(to)) {
      throw new IllegalArgumentException("from is after to");
    }
  }
}
