package school;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Professor extends Human implements Cloneable
{
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

    /**
     * Search for a student in the given promotion, with the given ID
     *
     * @param promotion the promotion
     * @param studentID the id of the student
     * @return the student, or {@code null} if none were found
     */
    public Student search(Promotion promotion, int studentID)
    {
        return promotion.search(studentID);
    }

    /**
     * Sets the grade for a given evaluation of the given student
     *
     * @param promotion        the promotion of the student
     * @param studentId        the id of the student
     * @param evaluationNumber the number of the evaluation
     * @param newGrade         the new grade
     */
    public void setGrade(Promotion promotion, int studentId, int evaluationNumber, int newGrade) throws IllegalStateException, EvaluationDoesNotExistException
    {
        Student student = this.search(promotion, studentId);
        if (student == null)
        {
            throw new IllegalStateException("Student with id " + studentId + " is not in "
                                                + this.getFullName() + "'s promotions.");
        }
        setGrade(student, evaluationNumber, newGrade);
    }

    /**
     * Sets the grade for a given evaluation of the given student
     *
     * @param student          the student
     * @param evaluationNumber the number of the evaluation
     * @param newGrade         the new grade
     */
    public void setGrade(Student student, int evaluationNumber, int newGrade) throws EvaluationDoesNotExistException
    {
        student.setGrade(evaluationNumber, newGrade);
    }

    @Override
    public Professor clone() throws CloneNotSupportedException
    {
        return (Professor) super.clone();
    }
}
