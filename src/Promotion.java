import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Promotion
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

    public String getName()
    {
        return name;
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
}
