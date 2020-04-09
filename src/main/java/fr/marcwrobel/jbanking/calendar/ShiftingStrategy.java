package fr.marcwrobel.jbanking.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

/** Holidays shifting strategies. */
public enum ShiftingStrategy {

  /**
   * For {@link Holiday}s that are observed on the preceding {@link DayOfWeek#FRIDAY} when they fall
   * on {@link DayOfWeek#SATURDAY}, or on the following {@link DayOfWeek#MONDAY} when they fall on
   * {@link DayOfWeek#SUNDAY}.
   *
   * <p>This strategy is useful for {@link AmericanHolidays American holidays}.
   */
  CLOSEST_WEEKDAY {
    @Override
    public LocalDate shift(LocalDate date) {
      LocalDate d = date;

      DayOfWeek dayOfWeek = date.getDayOfWeek();
      if (dayOfWeek == DayOfWeek.SATURDAY) {
        d = date.minusDays(1);
      } else if (dayOfWeek == DayOfWeek.SUNDAY) {
        d = date.plusDays(1);
      }

      return d;
    }

    @Override
    public LocalDate unshift(LocalDate date) {
      LocalDate d = date;

      DayOfWeek dayOfWeek = date.getDayOfWeek();
      if (dayOfWeek == DayOfWeek.MONDAY) {
        d = date.minusDays(1);
      } else if (dayOfWeek == DayOfWeek.FRIDAY) {
        d = date.plusDays(1);
      }

      return d;
    }
  },

  /**
   * For {@link Holiday}s that are observed on the following {@link DayOfWeek#MONDAY} when they fall
   * on {@link DayOfWeek#SATURDAY}, or on the following {@link DayOfWeek#TUESDAY} when they fall on
   * {@link DayOfWeek#SUNDAY}.
   *
   * <p>This strategy is useful for {@link UnitedKingdomHolidays United Kingdom holidays} (Christmas
   * and Boxing Day).
   */
  FOLLOWING_WEEK {
    @Override
    public LocalDate shift(LocalDate date) {
      LocalDate d = date;

      DayOfWeek dayOfWeek = date.getDayOfWeek();
      if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
        d = date.plusDays(2);
      }

      return d;
    }

    @Override
    public LocalDate unshift(LocalDate date) {
      LocalDate d = date;

      DayOfWeek dayOfWeek = date.getDayOfWeek();
      if (dayOfWeek == DayOfWeek.MONDAY || dayOfWeek == DayOfWeek.TUESDAY) {
        d = date.minusDays(2);
      }

      return d;
    }
  };

  /**
   * Shift the given date.
   *
   * @param localDate a non-null date
   * @return a non-null date
   * @throws NullPointerException if the given date is {@code null}
   */
  public abstract LocalDate shift(LocalDate localDate);

  /**
   * Unshift the given date.
   *
   * @param localDate a non-null date
   * @return a non-null date
   * @throws NullPointerException if the given date is {@code null}
   */
  public abstract LocalDate unshift(LocalDate localDate);
}
