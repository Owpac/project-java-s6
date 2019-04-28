package test;

import school.Evaluation;
import school.Promotion;
import school.Student;

import java.util.Map;

public class DisplayMethods
{
    public static void displaySeparatorLine()
    {
        System.out.println("==========================================");
    }

    public static void displayTitle(String title)
    {
        displaySeparatorLine();
        System.out.println(title);
        displaySeparatorLine();
    }

    public static void displayPromotion(String title, Promotion promotion)
    {
        displayTitle(title);
        System.out.println(promotion + "\n");
    }

    public static void displayEvaluations(Map<Integer, Student> students)
    {
        for (Student student : students.values())
        {
            for (Evaluation evaluation : student.getEvaluations())
            {
                System.out.println(evaluation);
            }
        }
    }

    public static void displayPromotions(Map<String, Promotion> promotions)
    {
        for (Promotion promotion : promotions.values())
        {
            System.out.println("- Promotion " + promotion.getName());
        }
    }

    public static void displayStudents(Map<Integer, Student> students)
    {
        for (Student student : students.values())
        {
            System.out.println("- " + student.getFullName() + ": " + student.getId());
        }
    }

}
