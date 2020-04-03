package fr.marcwrobel.jbanking.calendar;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.Optional;

/** A {@link Holiday} relative to another {@link Holiday}. */
public class RelativeHoliday implements Holiday {

  private final Holiday base;
  private final int plusDays;

  /**
   * Create a new holiday using the given {@link Holiday base holiday} and the given number of days
   * as the shift.
   *
   * @param base a non-null holiday to use as the base.
   * @param plusDays a number of days to use as the shift (may be negative)
   * @throws NullPointerException if the given base is <code>null</code>
   */
  public RelativeHoliday(Holiday base, int plusDays) {
    this.base = requireNonNull(base);
    this.plusDays = plusDays;
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return base.check(date.minusDays(plusDays));
  }

  /** @see Holiday#previous(LocalDate) */
  @Override
  public Optional<LocalDate> previous(LocalDate from) {
    Optional<LocalDate> previous = base.previous(from.minusDays(plusDays));
    return previous.map(d -> d.plusDays(plusDays));
  }

  /** @see Holiday#next(LocalDate) */
  @Override
  public Optional<LocalDate> next(LocalDate from) {
    Optional<LocalDate> next = base.next(from.minusDays(plusDays));
    return next.map(d -> d.plusDays(plusDays));
  }
}
