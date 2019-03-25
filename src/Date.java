import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

class Date
{
    private LocalDate date;
    private String display;

    /**
     * @param year  The year of birth.
     * @param month The month of birth. Starts with January = 0.
     *              Else, use Calendar.MONTH_NAME.
     * @param day   The day of birth. Starts with 1.
     */
    Date(int year, int month, int day)
    {
        date = LocalDate.of(year, month + 1, day);
        display = date.format(DateTimeFormatter.ofPattern("dd LLLL yyyy").withLocale(Locale.US));
    }

    @Override
    public String toString()
    {
        return display;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Date date1 = (Date) o;
        return date.equals(date1.date);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(date);
    }
}
