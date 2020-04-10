package fr.marcwrobel.jbanking.calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class FollowingWeekShiftingStrategyTest {

  private static final LocalDate FRIDAY = LocalDate.of(2020, 4, 3);
  private static final LocalDate SATURDAY = FRIDAY.plusDays(1);
  private static final LocalDate SUNDAY = SATURDAY.plusDays(1);
  private static final LocalDate MONDAY = SUNDAY.plusDays(1);
  private static final LocalDate TUESDAY = MONDAY.plusDays(1);

  private static final ShiftingStrategy STRATEGY = ShiftingStrategy.PLUS_TWO_DAYS;

  @Test
  public void fridayShift() {
    assertEquals(FRIDAY, STRATEGY.shift(FRIDAY));
  }

  @Test
  public void fridayUnshift() {
    assertEquals(FRIDAY, STRATEGY.unshift(FRIDAY));
  }

  @Test
  public void saturdayShift() {
    assertEquals(MONDAY, STRATEGY.shift(SATURDAY));
  }

  @Test
  public void saturdayUnshift() {
    assertEquals(SATURDAY, STRATEGY.unshift(SATURDAY));
  }

  @Test
  public void sundayShift() {
    assertEquals(TUESDAY, STRATEGY.shift(SUNDAY));
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
    assertEquals(SATURDAY, STRATEGY.unshift(MONDAY));
  }

  @Test
  public void tuesdayShift() {
    assertEquals(TUESDAY, STRATEGY.shift(TUESDAY));
  }

  @Test
  public void tuesdayUnshift() {
    assertEquals(SUNDAY, STRATEGY.unshift(TUESDAY));
  }
}
