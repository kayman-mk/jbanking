package fr.marcwrobel.jbanking.calendar;

/** Thrown when a date calculation was abandoned, probably because the calendar is not valid. */
public class DateCalculationException extends RuntimeException {

  /**
   * Creates a new instance with the given message.
   *
   * @param message the detail message.
   */
  public DateCalculationException(String message) {
    super(message);
  }
}
