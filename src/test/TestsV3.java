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
        displayStudentReport(promotions, student);

        displayPromotionMean(promotion);
        displayPromotionMedian(promotion);

        new StudentGradesHistogram(student.getFullName() + " means per topic", getMeansByTopic(student));
        new StudentGradesHistogram(student.getFullName() + " medians per topic", getMediansByTopic(student));
    }
}
