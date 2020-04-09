package fr.marcwrobel.jbanking.calendar;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/** This class is useful for model holidays valid only on certain years. */
public final class PunctualHoliday implements Holiday {

  private final Holiday base;
  private final List<Integer> yearsOfValidity;

  /**
   * Create a new holiday using the given base and years of validity.
   *
   * @param base a non-null holiday to use as a base.
   * @param yearsOfValidity a non-null list of years
   * @throws NullPointerException if <code>base</code> is null
   */
  public PunctualHoliday(Holiday base, Integer... yearsOfValidity) {
    this.base = requireNonNull(base);
    this.yearsOfValidity = Arrays.asList(yearsOfValidity);
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    if (!yearsOfValidity.contains(date.getYear())) {
      return false;
    }

    return base.check(date);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PunctualHoliday that = (PunctualHoliday) o;
    return base.equals(that.base) && yearsOfValidity.equals(that.yearsOfValidity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(base, yearsOfValidity);
  }
}
