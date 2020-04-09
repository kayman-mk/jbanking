package fr.marcwrobel.jbanking.calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class ClosestWeekdayShiftingStrategyTest {

  private static final LocalDate THURSDAY = LocalDate.of(2020, 4, 2);
  private static final LocalDate FRIDAY = THURSDAY.plusDays(1);
  private static final LocalDate SATURDAY = FRIDAY.plusDays(1);
  private static final LocalDate SUNDAY = SATURDAY.plusDays(1);
  private static final LocalDate MONDAY = SUNDAY.plusDays(1);

  private static final ShiftingStrategy STRATEGY = ShiftingStrategy.CLOSEST_WEEKDAY;

  @Test
  public void thursdayShift() {
    assertEquals(THURSDAY, STRATEGY.shift(THURSDAY));
  }

  @Test
  public void thursdayUnshift() {
    assertEquals(THURSDAY, STRATEGY.unshift(THURSDAY));
  }

  @Test
  public void fridayShift() {
    assertEquals(FRIDAY, STRATEGY.shift(FRIDAY));
  }

  @Test
  public void fridayUnshift() {
    assertEquals(SATURDAY, STRATEGY.unshift(FRIDAY));
  }

  @Test
  public void saturdayShift() {
    assertEquals(FRIDAY, STRATEGY.shift(SATURDAY));
  }

  @Test
  public void saturdayUnshift() {
    assertEquals(SATURDAY, STRATEGY.unshift(SATURDAY));
  }

  @Test
  public void sundayShift() {
    assertEquals(MONDAY, STRATEGY.shift(SUNDAY));
  }

  @Test
  public void sundayUnshift() {
    assertEquals(SUNDAY, STRATEGY.unshift(SUNDAY));
  }

  @Test
  public void mondayShift() {
    assertEquals(MONDAY, STRATEGY.shift(MONDAY));
  }

  @Test
  public void mondayUnshift() {
    assertEquals(SUNDAY, STRATEGY.unshift(MONDAY));
  }
}
