import java.util.Comparator;

public class Evaluation
{
    private String topic;
    private double grade;

    private Student student;
    private Professor professor;

    public Evaluation(String topic, double grade, Student student, Professor professor)
    {
        this.topic = topic;
        this.grade = grade;
        this.student = student;
        this.professor = professor;

        student.addEvaluation(this);
    }

    public double getGrade()
    {
        return grade;
    }

    @Override
    public String toString()
    {
        return "(" + professor + " " + student + " " + topic + " " + grade;
    }

    public String getTopic()
    {
        return topic;
    }

    public Professor getProfessor()
    {
        return professor;
    }
}

interface ComparatorEvaluation
{
    Comparator<Evaluation> GRADE_ORDER = Comparator.comparingDouble(Evaluation::getGrade);
}
