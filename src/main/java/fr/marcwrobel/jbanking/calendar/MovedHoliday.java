package fr.marcwrobel.jbanking.calendar;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * This class is useful for model holidays which some dates have been punctually moved like the 2020
 * May Day in the united kingdom.
 */
public final class MovedHoliday implements Holiday {

  private final Holiday base;
  private final Map<LocalDate, LocalDate> replacements;
  private final Map<LocalDate, LocalDate> invertedReplacements;

  /**
   * Create a new holiday using the given base and replacements {@link Map}.
   *
   * <p>The replacements are expressed as {@code k1, v1, k2, v2, ..., kn, vn} where kn are the
   * original dates dans vn are the replacement.
   *
   * @param base a non-null holiday to use as a base.
   * @param replacements replacements, expressed as key / value
   * @throws NullPointerException if <code>base</code> is null
   */
  public MovedHoliday(Holiday base, LocalDate... replacements) {
    this.base = requireNonNull(base);
    this.replacements = new HashMap<>(0);
    this.invertedReplacements = new HashMap<>(0);

    for (int i = 0; i < replacements.length / 2; i++) {
      LocalDate from = replacements[i * 2];
      LocalDate to = replacements[i * 2 + 1];

      if (!from.equals(to)) {
        this.replacements.put(from, to);
        this.invertedReplacements.put(to, from);
      }
    }
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    if (replacements.containsKey(date)) {
      return false;
    }

    return base.check(invertedReplacements.getOrDefault(date, date));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    MovedHoliday that = (MovedHoliday) o;
    return base.equals(that.base) && replacements.equals(that.replacements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(base, replacements);
  }

  @Override
  public String toString() {
    return "MovedHoliday{" + "base=" + base + ", replacements=" + replacements + '}';
  }
}
