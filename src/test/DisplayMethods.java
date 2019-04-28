package test;

import school.Evaluation;
import school.Promotion;
import school.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static test.UtilityMethods.getMeansByTopic;
import static test.UtilityMethods.getMediansByTopic;

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

    public static void displayStudentReport(Map<String, Promotion> promotions, Student student)
    {
        Promotion promotion = promotions.get(student.getPromotionName());

        Map<String, Double> studentMeansByTopic = getMeansByTopic(student);
        Map<String, Double> studentMediansByTopic = getMediansByTopic(student);

        Map<String, Double> promotionMeansByTopic = getMeansByTopic(promotion);
        Map<String, Double> promotionMediansByTopic = getMediansByTopic(promotion);

        JTableBasic table = new JTableBasic("Grades report for " + student.getFullName());
        List<Object[]> rows = new ArrayList<>();

        // Create the table
        for (String topic : studentMeansByTopic.keySet())
        {
            // For each topic, get the student mean, the student median, the promotion mean & median
            Double studentMean = studentMeansByTopic.get(topic);
            Double studentMedian = studentMediansByTopic.get(topic);
            Double promotionMean = promotionMeansByTopic.get(topic);
            Double promotionMedian = promotionMediansByTopic.get(topic);

            rows.add(new Object[]{topic, studentMean, studentMedian, promotionMean, promotionMedian});
        }

        table.setHeaders(new String[]{"Topic", "Mean", "Median", "Promotion Mean", "Promotion Median"});
        table.setData(rows.toArray(new Object[0][]));

        table.pack();
        table.setVisible(true);
    }

    public static void displayPromotionMean(Promotion promotion)
    {
        // Gather all students means
        List<Double> allMeans = new ArrayList<>();
        for (Student student : promotion.getStudents())
        {
            if (student.wasEvaluated())
            {
                allMeans.add(student.mean());
            }
        }
        new GradesHistogram("Promotion " + promotion.getName() + " means", allMeans.stream().mapToDouble(d -> d).toArray());
    }

    public static void displayPromotionMedian(Promotion promotion)
    {
        // Gather all students medians
        List<Double> allMedians = new ArrayList<>();
        for (Student student : promotion.getStudents())
        {
            if (student.wasEvaluated())
            {
                allMedians.add(student.median());
            }
        }
        new GradesHistogram("Promotion " + promotion.getName() + " medians", allMedians.stream().mapToDouble(d -> d).toArray());
    }
}
