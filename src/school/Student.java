package school;

import java.util.*;

/**
 * Immutable object
 */
public class Student extends Human
{
    private final static int NB_EVALUATIONS = 10;

    private String promotionName;
    private Date birthDate;

    private int id;
    private List<Evaluation> evaluations;
    private Set<Professor> correctors;

    public Student(String firstName, String lastName, Promotion promotion, Date birthDate)
    {
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.promotionName = promotion.getName();

        evaluations = new ArrayList<>();
        correctors = new HashSet<>();

        // Ajout de l'élève à sa promotion
        promotion.addEleve(this);

        // Get the student id. If he's the 3d student in Promotion 2021, his ID should be 20210003.
        id = Integer.parseInt(promotion.getName()) * 10_000 + promotion.getSize();
    }

    public double mean() throws IllegalStateException
    {
        if (evaluations.size() < 1)
        {
            throw new IllegalStateException("Can't calculate the mean of a student with no evaluations.");
        }

        double total = 0;
        for (Evaluation evaluation : evaluations)
        {
            total += evaluation.getGrade();
        }
        return total / evaluations.size();
    }

    public double median() throws IllegalStateException
    {
        if (evaluations.size() < 1)
        {
            throw new IllegalStateException("Can't calculate the median of a student with no evaluations.");
        }

        evaluations.sort(ComparatorEvaluation.GRADE_ORDER);
        return evaluations.get(evaluations.size() / 2).getGrade();
    }

    void addEvaluation(Evaluation evaluation)
    {
        evaluations.add(evaluation);
        correctors.add(evaluation.getProfessor());
    }

    /**
     * Change the grade of the given evaluation
     *
     * @param evaluationNumber the number of the evaluation to change
     * @param newGrade         the new grade of the evaluation
     * @throws EvaluationDoesNotExistException thrown if the given evaluation does not exist
     */
    void setGrade(int evaluationNumber, int newGrade) throws EvaluationDoesNotExistException
    {
        try
        {
            this.evaluations.get(evaluationNumber).setGrade(newGrade);
        }
        catch (IndexOutOfBoundsException e)
        {
            throw new EvaluationDoesNotExistException("Student " + this.firstName + " " +
                                                          this.lastName + " only has " + this.evaluations.size()
                                                          + " evaluations. Can't set the grade of evaluation number " +
                                                          evaluationNumber + ".");
        }
    }

    public Set<Professor> getCorrectors()
    {
        return correctors;
    }

    @Override
    public String toString()
    {
        StringBuilder gradeDisplay = new StringBuilder();
        for (Evaluation evaluation : evaluations)
        {
            gradeDisplay.append(evaluation.getTopic()).append(":").append(evaluation.getGrade()).append(", ");
        }

        String display
            = super.toString() + "\n"
            + "id: " + id + "\n"
            + "Promotion: " + promotionName + "\n"
            + "Birth date: " + birthDate + "\n"
            + "Grades: " + gradeDisplay + "\n";

        if (this.evaluations.size() > 0)
        {
            display
                += "Mean: " + mean() + "\n"
                + "Median: " + median() + "\n"
                + "Correctors: " + correctors;
        }

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
        if (!super.equals(o))
        {
            return false;
        }
        Student student = (Student) o;
        return id == student.id &&
            birthDate.equals(student.birthDate);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), birthDate, id);
    }

    /**
     * Determines if the student has been evaluated at least once.
     *
     * @return {@code true} if the student has at least one evaluation, else {@code false}.
     */
    public boolean wasEvaluated()
    {
        return evaluations.size() > 0;
    }


    public int getId()
    {
        return id;
    }

    @Override
    public Student clone() throws CloneNotSupportedException
    {
        return (Student) super.clone();
    }
}

interface StudentEvaluation
{
    Comparator<Student> GRADE_MEAN_ORDER_ASCENDING =
        Comparator.comparingDouble(student -> student.wasEvaluated() ? student.mean() : 0);
    Comparator<Student> GRADE_MEAN_ORDER_DESCENDING =
        Comparator.comparingDouble(student -> student.wasEvaluated() ? -student.mean() : 0);

    Comparator<Student> GRADE_MEDIAN_ORDER_ASCENDING =
        Comparator.comparingDouble(student -> student.wasEvaluated() ? student.median() : 0);
    Comparator<Student> GRADE_MEDIAN_ORDER_DESCENDING =
        Comparator.comparingDouble(student -> student.wasEvaluated() ? -student.median() : 0);
}