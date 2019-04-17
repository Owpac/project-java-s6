import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Promotion implements Cloneable
{
    private Set<Student> students;
    private Set<Student> immutableStudents;
    private String name;

    public Promotion(String name)
    {
        this.name = name;
        students = new TreeSet<>(StudentEvaluation.GRADE_MEAN_ORDER);
        immutableStudents = Collections.unmodifiableSet(students);
    }

    public void addEleve(Student student)
    {
        students.add(student);
    }

    /**
     * Search for a student in the promotion, with the given ID
     *
     * @param id the id of the student
     * @return the student, or {@code null} if none were found
     */
    public Student search(int id)
    {
        for (Student student : students)
        {
            if (student.getId() == id)
            {
                try
                {
                    return student.clone();
                }
                catch (CloneNotSupportedException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public String getName()
    {
        return name;
    }

    /**
     * Get the size of the promotion: the number of students in it.
     *
     * @return the number of students in the promotion
     */
    public int getSize()
    {
        return students.size();
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<Student> getStudents()
    {
        return immutableStudents;
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
        Promotion promotion = (Promotion) o;
        return students.equals(promotion.students) &&
            name.equals(promotion.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(students, name);
    }

    @Override
    public String toString()
    {
        StringBuilder display = new StringBuilder("Promotion " + name + "\n");
        display.append("Students:\n[\n");
        for (Student student : students)
        {
            display.append("\t")
                   .append(student.toString().replace("\n", "\n\t"))
                   .append(",\n\n");
        }
        display.append("]");
        return display.toString();
    }

    @Override
    public Promotion clone() throws CloneNotSupportedException {
        return (Promotion) super.clone();
    }
}
