package fr.marcwrobel.jbanking.calendar;

import static java.util.Objects.requireNonNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A {@link Holiday} relative to another {@link Holiday} with that shift if it occurs during
 * weekend.
 *
 * <p>The shift algorithm is the following :
 *
 * <ul>
 *   <li>if the holiday occurs on {@link DayOfWeek#SATURDAY}, it is moved to the preceding {@link
 *       DayOfWeek#FRIDAY}
 *   <li>if the holiday occurs on {@link DayOfWeek#SUNDAY}, it is moved to the following {@link
 *       DayOfWeek#MONDAY}
 * </ul>
 *
 * <p>This class is useful for modeling holidays like <a
 * href="https://wikipedia.org/wiki/Easter_Monday">easter monday</a> or <a
 * href="https://wikipedia.org/wiki/Good_Friday">good friday</a>.
 */
public final class ShiftOnWeekendHoliday implements Holiday {

  private final Holiday base;

  /**
   * Create a new holiday using the given {@link Holiday base holiday}.
   *
   * @param base a non-null holiday to use as a base.
   * @throws NullPointerException if the given base is {@code null}
   */
  public ShiftOnWeekendHoliday(Holiday base) {
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

    ShiftOnWeekendHoliday that = (ShiftOnWeekendHoliday) o;
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
