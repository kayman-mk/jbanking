package fr.marcwrobel.jbanking.calendar;

import java.time.LocalDate;
import java.util.Optional;

/**
 * This class is modeling the <a href="https://wikipedia.org/wiki/Easter">western easter sunday</a>.
 *
 * <p>This class computes the date of Easter Sunday with the Meeus/Jones/Butcher Gregorian
 * algorithm.
 *
 * @see <a
 *     href="http://en.wikipedia.org/wiki/Computus#Meeus.2FJones.2FButcher_Gregorian_algorithm">Meeus/Jones/Butcher
 *     Gregorian algorithm</a>
 */
public class EasterHoliday implements Holiday {

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return meeusJonesButcherComputus(date.getYear()).equals(date);
  }

  /** @see Holiday#previous(LocalDate) */
  @Override
  public Optional<LocalDate> previous(LocalDate from) {
    LocalDate easter = meeusJonesButcherComputus(from.getYear());

    LocalDate previous = easter;
    if (from.equals(easter) || from.isBefore(easter)) {
      previous = meeusJonesButcherComputus(from.getYear() - 1);
    }

    return Optional.of(previous);
  }

  /** @see Holiday#next(LocalDate) */
  @Override
  public Optional<LocalDate> next(LocalDate from) {
    LocalDate easter = meeusJonesButcherComputus(from.getYear());

    LocalDate next = easter;
    if (from.equals(easter) || from.isAfter(easter)) {
      next = meeusJonesButcherComputus(from.getYear() + 1);
    }

    return Optional.of(next);
  }

  private static LocalDate meeusJonesButcherComputus(final int year) {
    final int a = year % 19;
    final int b = year / 100;
    final int c = year % 100;
    final int d = b / 4;
    final int e = b % 4;
    final int f = (b + 8) / 25;
    final int g = (b - f + 1) / 3;
    final int h = (19 * a + b - d - g + 15) % 30;
    final int i = c / 4;
    final int k = c % 4;
    final int l = (32 + 2 * e + 2 * i - h - k) % 7;
    final int m = (a + 11 * h + 22 * l) / 451;
    final int n = h + l - 7 * m + 114;
    final int month = n / 31;
    final int day = (n % 31) + 1;
    return LocalDate.of(year, month, day);
  }
}
