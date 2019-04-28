package test;

import school.*;

import java.io.*;
import java.util.*;

import static test.FilesMethods.*;
import static test.UtilityMethods.*;
import static test.InputMethods.*;
import static test.DisplayMethods.*;

public class TestsV2
{
    public static void start() throws FileNotFoundException
    {
        displayTitle("Reading data from files.");

        // Load data
        System.out.println("Loading promotions");
        Map<String, Promotion> promotions = loadPromotions();

        System.out.println("Loading students");
        Map<Integer, Student> students = loadStudents(promotions);

        System.out.println("Loading evaluations");
        loadEvaluations(students);

        for (Promotion promotion : promotions.values())
        {
            displayTitle("Starting tests on promotion " + promotion.getName());
            testPromotion(promotion);
        }

        menu(promotions, students);
    }

    public static void menu(Map<String, Promotion> promotions, Map<Integer, Student> students)
    {
        while (true)
        {
            boolean correctChoice = false;
            int choice = 0;

            while (!correctChoice)
            {
                System.out.println("\nWhat do you want to do?");
                System.out.println("0. Leave the application");
                System.out.println("1. Add a promotion");
                System.out.println("2. Add a student");
                System.out.println("3. Add an evaluation");
                System.out.println("4. List promotions");
                System.out.println("5. List students");
                System.out.println("6. List evaluations");

                choice = askInt();

                correctChoice = 0 <= choice && choice <= 6;
                if (!correctChoice)
                {
                    System.out.println("This choice does not exist.");
                }
            }

            switch (choice)
            {
                case 0:
                    return;
                case 1:
                    addPromotion(promotions);
                    break;
                case 2:
                    addStudent(promotions, students);
                    break;
                case 3:
                    addEvaluation(students);
                    break;
                case 4:
                    displayPromotions(promotions);
                    break;
                case 5:
                    displayStudents(students);
                    break;
                case 6:
                    displayEvaluations(students);
                    break;
            }
        }
    }
}
