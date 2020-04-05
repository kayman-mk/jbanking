package fr.marcwrobel.jbanking.calendar;

import static java.util.Objects.requireNonNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

/**
 * {@link Holiday}s that are observed on the preceding {@link DayOfWeek#FRIDAY} or following {@link
 * DayOfWeek#MONDAY} when they fall on {@link DayOfWeek#SATURDAY} or {@link DayOfWeek#SUNDAY}.
 *
 * <p>This class is useful for modeling holidays like <a
 * href="https://wikipedia.org/wiki/Independence_Day_%28United_States%29">the Independence Day</a>
 * in United States.
 */
public final class ObservedOnWeekdayHoliday implements Holiday {

  private final Holiday base;

  /**
   * Create a new holiday using the given {@link Holiday base holiday}.
   *
   * @param base a non-null holiday to use as a base.
   * @throws NullPointerException if the given base is {@code null}
   */
  public ObservedOnWeekdayHoliday(Holiday base) {
    this.base = requireNonNull(base);
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    boolean result = base.check(unshift(date));

    if (!result
        && (date.getDayOfWeek() == DayOfWeek.FRIDAY || date.getDayOfWeek() == DayOfWeek.MONDAY)) {
      result = base.check(date);
    }

    return result;
  }

  private LocalDate unshift(LocalDate date) {
    LocalDate d = date;

    if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
      d = date.minusDays(1);
    } else if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
      d = date.plusDays(1);
    }

    return d;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ObservedOnWeekdayHoliday that = (ObservedOnWeekdayHoliday) o;
    return base.equals(that.base);
  }

  @Override
  public int hashCode() {
    return Objects.hash(base);
  }

  @Override
  public String toString() {
    return "ShiftOnWeekendHoliday{" + "base=" + base + '}';
  }
}
