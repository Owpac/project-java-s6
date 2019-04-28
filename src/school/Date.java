package school;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public final class Date implements Cloneable
{
    final int year;
    final int month;
    final int day;

    final private LocalDate date;
    final private String display;

    /**
     * @param year  The year of birth.
     * @param month The month of birth. Starts with January = 0.
     *              Else, use Calendar.MONTH_NAME.
     * @param day   The day of birth. Starts with 1.
     */
    public Date(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;

        date = LocalDate.of(year, month + 1, day);
        display = date.format(DateTimeFormatter.ofPattern("dd LLLL yyyy").withLocale(Locale.US));
    }

    public int getYear()
    {
        return year;
    }

    public int getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
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
