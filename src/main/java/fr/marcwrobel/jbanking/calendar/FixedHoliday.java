package fr.marcwrobel.jbanking.calendar;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Optional;

/** A {@link Holiday}s occurring every year the same day and month. */
public final class FixedHoliday implements Holiday {

  private final MonthDay monthDay;

  /**
   * Create a new FixedHoliday using the given {@link MonthDay}
   *
   * @param monthDay a non-null {@link MonthDay}
   * @throws NullPointerException if the given {@link MonthDay} is <code>null</code>
   */
  public FixedHoliday(MonthDay monthDay) {
    this.monthDay = requireNonNull(monthDay);
  }

  /**
   * Create a new FixedHoliday using the given from a text string such as <code>--12-03</code>.
   *
   * <p>The string must represent a valid month-day. The format is <code>--MM-dd</code>.
   *
   * @param text the text to parse such as "--12-03", not null
   * @throws NullPointerException if the given text is <code>null</code>
   * @throws java.time.format.DateTimeParseException if the text cannot be parsed
   */
  public FixedHoliday(CharSequence text) {
    this.monthDay = MonthDay.parse(text);
  }

  /** @see Holiday#check(LocalDate) */
  @Override
  public boolean check(LocalDate date) {
    return monthDay.getMonth() == date.getMonth()
        && monthDay.getDayOfMonth() == date.getDayOfMonth();
  }

  /** @see Holiday#previous(LocalDate) */
  @Override
  public Optional<LocalDate> previous(LocalDate from) {
    LocalDate result;

    if (MonthDay.from(from).isAfter(monthDay)) {
      result = monthDay.atYear(from.getYear());
    } else {
      result = monthDay.atYear(from.getYear() - 1);
    }

    return Optional.of(result);
  }

  /** @see Holiday#next(LocalDate) */
  @Override
  public Optional<LocalDate> next(LocalDate from) {
    LocalDate result;

    if (MonthDay.from(from).isBefore(monthDay)) {
      result = monthDay.atYear(from.getYear());
    } else {
      result = monthDay.atYear(from.getYear() + 1);
    }

    return Optional.of(result);
  }

  public MonthDay getMonthDay() {
    return monthDay;
  }
}
