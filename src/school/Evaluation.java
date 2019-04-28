package school;

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
        String display = student.getFullName();
        display += " - " + topic + ": " + grade + ".";
        display += " Corrector: " + professor.getFullName();
        return display;
    }

    public String getTopic()
    {
        return topic;
    }

    public Professor getProfessor()
    {
        return professor;
    }

    public void setGrade(int newGrade)
    {
        this.grade = newGrade;
    }
}

interface ComparatorEvaluation
{
    Comparator<Evaluation> GRADE_ORDER = Comparator.comparingDouble(Evaluation::getGrade);
}
