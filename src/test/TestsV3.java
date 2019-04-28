package test;

import school.Promotion;
import school.Student;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static test.DisplayMethods.*;
import static test.FilesMethods.*;
import static test.InputMethods.*;
import static test.UtilityMethods.*;

public class TestsV3
{
    public static void start() throws FileNotFoundException
    {
        // Load data
        Map<String, Promotion> promotions = loadPromotions();
        Map<Integer, Student> students = loadStudents(promotions);
        loadEvaluations(students);

        displayTitle("Display a student's grades report.");
        System.out.println("Available students:");
        displayStudents(students);

        int studentID;
        do
        {
            studentID = askInt("Choose a student (by his ID)");
            if (!students.containsKey(studentID))
            {
                System.out.println("Unknown student");
            }
        } while (!students.containsKey(studentID));

        Student student = students.get(studentID);
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
}
