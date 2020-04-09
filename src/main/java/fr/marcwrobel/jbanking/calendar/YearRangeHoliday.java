package fr.marcwrobel.jbanking.calendar;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.time.temporal.ValueRange;
import java.util.Objects;

/** This class is useful for model holidays valid only in a given range of years. */
public final class YearRangeHoliday implements Holiday {

  private final Holiday base;
  private final ValueRange validityRange;

  /**
   * Create a new holiday using the given base and years of validity.
   *
   * @param base a non-null holiday to use as a base.
   * @param validityRange a non-null validity range.
   * @throws NullPointerException if either {@code base} or {@code validityRange} is {@code null}
   */
  public YearRangeHoliday(Holiday base, ValueRange validityRange) {
    this.base = requireNonNull(base);
    this.validityRange = requireNonNull(validityRange);
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    if (!validityRange.isValidValue(date.getYear())) {
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
    YearRangeHoliday that = (YearRangeHoliday) o;
    return base.equals(that.base) && validityRange.equals(that.validityRange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(base, validityRange);
  }

  @Override
  public String toString() {
    return "PunctualHoliday{" + "base=" + base + ", validityRange=" + validityRange + '}';
  }
}
