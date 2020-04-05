package fr.marcwrobel.jbanking.calendar;

import static java.util.Arrays.asList;
import static java.util.Collections.emptySet;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConfigurableCalendarTest {

  private static final LocalDate MONDAY = LocalDate.of(2020, 3, 30);
  private static final LocalDate TUESDAY = MONDAY.plusDays(1);
  private static final LocalDate WEDNESDAY = TUESDAY.plusDays(1);
  private static final LocalDate THURSDAY = WEDNESDAY.plusDays(1);
  private static final LocalDate FRIDAY = THURSDAY.plusDays(1);
  private static final LocalDate SATURDAY = FRIDAY.plusDays(1);
  private static final LocalDate SUNDAY = SATURDAY.plusDays(1);
  private static final LocalDate NEXT_MONDAY = SUNDAY.plusDays(1);

  private static final Holiday SATURDAY_HOLIDAY = DayOfWeekHoliday.SATURDAY;
  private static final Holiday SUNDAY_HOLIDAY1 = DayOfWeekHoliday.SUNDAY;
  private static final Holiday SUNDAY_HOLIDAY2 = new MonthDayHoliday(MonthDay.from(SUNDAY));
  private static final Calendar WEEKEND_CALENDAR =
      new ConfigurableCalendar(SATURDAY_HOLIDAY, SUNDAY_HOLIDAY1, SUNDAY_HOLIDAY2);

  @Test
  public void holidaysMustNotBeNull() {
    assertThrows(
        NullPointerException.class, () -> new ConfigurableCalendar((Collection<Holiday>) null));
  }

  @Test
  public void oneHolidayMustNotBeNull() {
    assertThrows(
        NullPointerException.class,
        () -> new ConfigurableCalendar(SUNDAY_HOLIDAY1, null, SUNDAY_HOLIDAY2));
  }

  @Test
  public void emptyCalendarDateCalculation() {
    Calendar emptyCalendar = new ConfigurableCalendar();
    LocalDate date = LocalDate.of(2020, 4, 14);

    assertTrue(emptyCalendar.isBusinessDay(date));
    assertFalse(emptyCalendar.isHoliday(date));
    assertEquals(date.plusDays(1), emptyCalendar.nextBusinessDay(date));
    assertEquals(date.minusDays(1), emptyCalendar.previousBusinessDay(date));
  }

  @Test
  public void badCalendarDateCalculation() {
    Calendar fullCalendar = new ConfigurableCalendar(asList(DayOfWeekHoliday.values()));
    LocalDate date = LocalDate.of(2020, 4, 14);

    for (int i = 0; i < 365; i++) {
      assertTrue(fullCalendar.isHoliday(date));
      assertFalse(fullCalendar.isBusinessDay(date));
    }

    assertThrows(DateCalculationException.class, () -> fullCalendar.nextBusinessDay(date));
    assertThrows(DateCalculationException.class, () -> fullCalendar.previousBusinessDay(date));
  }

  @Test
  public void saturdayCalculation() {
    assertFalse(WEEKEND_CALENDAR.isBusinessDay(SATURDAY));
    assertTrue(WEEKEND_CALENDAR.isHoliday(SATURDAY));
    assertEquals(
        new HashSet<>(singletonList(SATURDAY_HOLIDAY)), WEEKEND_CALENDAR.getHolidaysFor(SATURDAY));
  }

  @Test
  public void fridayCalculation() {
    assertTrue(WEEKEND_CALENDAR.isBusinessDay(FRIDAY));
    assertFalse(WEEKEND_CALENDAR.isHoliday(FRIDAY));
    assertEquals(emptySet(), WEEKEND_CALENDAR.getHolidaysFor(FRIDAY));
    assertEquals(FRIDAY, WEEKEND_CALENDAR.previousBusinessDay(SATURDAY));
  }

  @Test
  public void sundayCalculation() {
    assertFalse(WEEKEND_CALENDAR.isBusinessDay(SUNDAY));
    assertTrue(WEEKEND_CALENDAR.isHoliday(SUNDAY));
    assertTrue(WEEKEND_CALENDAR.isHoliday(SUNDAY));
    assertEquals(
        new HashSet<>(asList(SUNDAY_HOLIDAY1, SUNDAY_HOLIDAY2)),
        WEEKEND_CALENDAR.getHolidaysFor(SUNDAY));
  }

  @Test
  public void nextMondayCalculation() {
    assertTrue(WEEKEND_CALENDAR.isBusinessDay(NEXT_MONDAY));
    assertFalse(WEEKEND_CALENDAR.isHoliday(NEXT_MONDAY));
    assertEquals(emptySet(), WEEKEND_CALENDAR.getHolidaysFor(NEXT_MONDAY));
    assertEquals(NEXT_MONDAY, WEEKEND_CALENDAR.nextBusinessDay(SATURDAY));
  }

  @Test
  public void fromCannotBeAfterToForHolidaysComputation() {
    assertThrows(
        IllegalArgumentException.class, () -> WEEKEND_CALENDAR.holidaysWithin(TUESDAY, MONDAY));
  }

  @Test
  public void fromCanBeEqualsToForHolidaysComputation() {
    assertTrue(WEEKEND_CALENDAR.holidaysWithin(MONDAY, MONDAY).isEmpty());
    assertEquals(1, WEEKEND_CALENDAR.holidaysWithin(SUNDAY, SUNDAY).size());
  }

  @Test
  public void holidaysComputation() {
    List<LocalDate> expected = asList(SATURDAY, SUNDAY);
    List<LocalDate> occurrences = WEEKEND_CALENDAR.holidaysWithin(MONDAY, SUNDAY);
    Assertions.assertEquals(expected, occurrences);
  }

  @Test
  public void fromCannotBeAfterToForBusinessDaysComputation() {
    assertThrows(
        IllegalArgumentException.class, () -> WEEKEND_CALENDAR.holidaysWithin(TUESDAY, MONDAY));
  }

  @Test
  public void fromCanBeEqualsToForBusinessDaysComputation() {
    assertTrue(WEEKEND_CALENDAR.holidaysWithin(MONDAY, MONDAY).isEmpty());
    assertEquals(1, WEEKEND_CALENDAR.holidaysWithin(SUNDAY, SUNDAY).size());
  }

  @Test
  public void businessDaysComputation() {
    List<LocalDate> expected = asList(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY);
    List<LocalDate> occurrences = WEEKEND_CALENDAR.businessDaysWithin(MONDAY, SUNDAY);
    Assertions.assertEquals(expected, occurrences);
  }
}
