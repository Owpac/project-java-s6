import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Professor extends Human implements Cloneable
{
    private Set<String> promotions;

    /**
     * Creates a professor with no promotions.
     *
     * @param firstName professor's first name
     * @param lastName  professor's last name
     */
    public Professor(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Professor(String firstName, String lastName, Collection<Promotion> promotions)
    {
        this(firstName, lastName);

        for (Promotion promotion : promotions)
        {
            addPromotion(promotion);
        }
    }

    public void addPromotion(Promotion promotion)
    {
        promotions.add(promotion.getName());
    }

    /**
     * Search for a student in the promotions this professor is responsible of, with the given ID
     *
     * @param studentID the id of the student
     * @return the student, or {@code null} if none were found
     */
    public Student search(int studentID)
    {
        for (String promotion : promotions)
        {
            Student s = promotion.search(studentID);
            if (s != null)
            {
                return s;
            }
        }
        return null;
    }

    @Override
    public Professor clone() throws CloneNotSupportedException
    {
        return (Professor) super.clone();
    }
}
