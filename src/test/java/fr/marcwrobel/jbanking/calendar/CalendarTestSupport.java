package fr.marcwrobel.jbanking.calendar;

import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

abstract class CalendarTestSupport {

  private final Calendar calendar;

  protected CalendarTestSupport(Calendar calendar) {
    this.calendar = calendar;
  }

  protected void check(int year, MonthDay... expectedDatesForYear) {
    LocalDate from = LocalDate.of(year, JANUARY, 1);
    LocalDate to = LocalDate.of(year, DECEMBER, 31);
    List<LocalDate> actual = calendar.holidaysWithin(from, to);

    List<LocalDate> expected =
        Arrays.stream(expectedDatesForYear)
            .map(d -> LocalDate.of(year, d.getMonth(), d.getDayOfMonth()))
            .collect(Collectors.toList());

    assertEquals(filterOutWeekends(expected), filterOutWeekends(actual));
  }

  private List<LocalDate> filterOutWeekends(List<LocalDate> dates) {
    return dates.stream()
        .filter(d -> d.getDayOfWeek() != DayOfWeek.SATURDAY && d.getDayOfWeek() != DayOfWeek.SUNDAY)
        .collect(Collectors.toList());
  }
}
