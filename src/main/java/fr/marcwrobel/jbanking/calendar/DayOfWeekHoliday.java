package fr.marcwrobel.jbanking.calendar;

import static java.util.Objects.requireNonNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

/**
 * A {@link Holiday} occurring the same day every week.
 *
 * <p>This class is useful for modeling saturday and sunday.
 */
public final class DayOfWeekHoliday implements Holiday {

  private final DayOfWeek dayOfWeek;

  /**
   * Create a new holiday using the given {@link DayOfWeek}
   *
   * @param dayOfWeek a non-null {@link DayOfWeek}
   * @throws NullPointerException if the given {@link DayOfWeek} is <code>null</code>
   */
  public DayOfWeekHoliday(DayOfWeek dayOfWeek) {
    this.dayOfWeek = requireNonNull(dayOfWeek);
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return dayOfWeek.equals(DayOfWeek.from(date));
  }

  /** @see Holiday#previous(LocalDate) */
  @Override
  public Optional<LocalDate> previous(LocalDate from) {
    LocalDate result;

    if (from.getDayOfWeek().getValue() > dayOfWeek.getValue()) {
      result = from.with(dayOfWeek);
    } else {
      result = from.minusWeeks(1).with(dayOfWeek);
    }

    return Optional.of(result);
  }

  /** @see Holiday#next(LocalDate) */
  @Override
  public Optional<LocalDate> next(LocalDate from) {
    LocalDate result;

    if (from.getDayOfWeek().getValue() < dayOfWeek.getValue()) {
      result = from.with(dayOfWeek);
    } else {
      result = from.plusWeeks(1).with(dayOfWeek);
    }

    return Optional.of(result);
  }
}
