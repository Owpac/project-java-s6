package school;

import com.sun.source.util.Trees;
import jdk.nashorn.api.tree.Tree;

import java.rmi.StubNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Promotion implements Cloneable
{
    private List<Student> students;
    private String name;

    public Promotion(String name)
    {
        this.name = name;
        students = new LinkedList<>();
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

    public List<Student> getStudents()
    {
        return students;
    }

    /**
     * Sort the students with the given comparator
     *
     * @param comparator the comparator used to sort students
     */
    private void sortBy(Comparator<Student> comparator)
    {
        this.students.sort(comparator);
    }

    /**
     * Sort the students by their mean
     *
     * @param ascending if true, then the order will be ascending, else descending
     */
    public void sortByMean(boolean ascending)
    {
        if (ascending)
        {
            sortBy(StudentEvaluation.GRADE_MEAN_ORDER_ASCENDING);
        }
        else
        {
            sortBy(StudentEvaluation.GRADE_MEAN_ORDER_DESCENDING);
        }
    }

    /**
     * Sort the students by their median
     *
     * @param ascending if true, then the order will be ascending, else descending
     */
    public void sortByMedian(boolean ascending)
    {
        if (ascending)
        {
            sortBy(StudentEvaluation.GRADE_MEDIAN_ORDER_ASCENDING);
        }
        else
        {
            sortBy(StudentEvaluation.GRADE_MEDIAN_ORDER_DESCENDING);
        }
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
        String display = "Promotion " + name + "\n";
        display += "Students:\n[\n\t";

        List<String> studentsDisplay = new ArrayList<>();
        for (Student student : students)
        {
            studentsDisplay.add(student.toString().replace("\n", "\n\t"));
        }
        display += String.join(",\n\n\t", studentsDisplay);
        display += "\n]";

        return display;
    }

    @Override
    public Promotion clone() throws CloneNotSupportedException
    {
        return (Promotion) super.clone();
    }
}
