package test;

import school.*;
import school.Date;

import java.util.*;

import static test.DisplayMethods.*;
import static test.FilesMethods.*;

public class UtilityMethods
{
    public static Map<String, Double> getMeansByTopic(Student student)
    {
        Map<String, Double[]> totals = new HashMap<>();
        for (Evaluation evaluation : student.getEvaluations())
        {
            String topic = evaluation.getTopic();
            double grade = evaluation.getGrade();
            // If the topic is NOT in the current means
            if (!totals.containsKey(topic))
            {
                totals.put(topic, new Double[]{grade, 1.0});
            }
            else
            {
                Double[] current = totals.get(topic);
                totals.put(topic, new Double[]{current[0] + grade, current[1] + 1});
            }
        }

        return totalsToMeans(totals);
    }

    public static Map<String, Double> getMeansByTopic(Promotion promotion)
    {
        Map<String, Double[]> totals = new HashMap<>();
        for (Student student : promotion.getStudents())
        {
            for (Map.Entry<String, Double> entry : getMeansByTopic(student).entrySet())
            {
                String topic = entry.getKey();
                double mean = entry.getValue();
                // If the topic is NOT in the current means
                if (!totals.containsKey(topic))
                {
                    totals.put(topic, new Double[]{mean, 1.0});
                }
                else
                {
                    Double[] current = totals.get(topic);
                    totals.put(topic, new Double[]{current[0] + mean, current[1] + 1});
                }
            }
        }

        return totalsToMeans(totals);
    }

    private static Map<String, Double> totalsToMeans(Map<String, Double[]> totals)
    {
        Map<String, Double> means = new HashMap<>();
        for (Map.Entry<String, Double[]> entry : totals.entrySet())
        {
            String topic = entry.getKey();
            Double total = entry.getValue()[0];
            Double numberOfGrades = entry.getValue()[1];

            means.put(topic, total / numberOfGrades);
        }
        return means;
    }


    public static void searchStudent(int studentID, Promotion promotion)
    {
        System.out.println("Searching for student n°" + studentID + " in promotion " + promotion.getName());
        Student student = promotion.search(studentID);

        if (student == null)
        {
            System.out.println("No student has been found!");
        }
        else
        {
            System.out.println("Found student:\n\t" + student.toString().replace("\n", "\n\t"));
        }

        System.out.println();
    }

    public static void testPromotion(Promotion promotion)
    {
        displayPromotion("Unsorted promotion:", promotion);

        promotion.sortByMean(true);
        displayPromotion("Promotion sorted by mean - ascending:", promotion);

        promotion.sortByMean(false);
        displayPromotion("Promotion sorted by mean - descending:", promotion);

        promotion.sortByMedian(true);
        displayPromotion("Promotion sorted by median - ascending:", promotion);

        promotion.sortByMedian(false);
        displayPromotion("Promotion sorted by median - descending:", promotion);

        displayTitle("Students search:");

        searchStudent(20210003, promotion);
        searchStudent(20210008, promotion);
        searchStudent(20210001, promotion);
        searchStudent(20210888, promotion);
    }
}
