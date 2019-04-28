package test;

import school.*;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static test.DisplayMethods.*;
import static test.DisplayMethods.displayTitle;
import static test.FilesMethods.savePromotions;
import static test.FilesMethods.saveStudentsAndEvaluations;

public class InputMethods
{
    private final static Scanner inputScanner = new Scanner(System.in);

    public static void addEvaluation(Map<Integer, Student> students)
    {
        displayTitle("Adding a new evaluation");

        System.out.println("Student ID?");
        displayStudents(students);

        Student student = null;
        while (student == null)
        {
            student = students.get(inputScanner.nextInt());
            if (student == null)
            {
                System.out.println("Unknown student ID");
            }
        }

        System.out.println("Topic?");
        String topic = inputScanner.next();

        System.out.println("Grade?");
        double grade = Double.valueOf(inputScanner.next());

        System.out.println("Professor first name?");
        String professorFirstName = inputScanner.next();

        System.out.println("Professor last name?");
        String professorLastName = inputScanner.next();

        new Evaluation(topic, grade, student, new Professor(professorFirstName, professorLastName));
        saveStudentsAndEvaluations(students);
    }

    public static void addStudent(Map<String, Promotion> promotions, Map<Integer, Student> students)
    {
        displayTitle("Adding a new student");
        System.out.println("First name?");
        String firstName = inputScanner.next();
        System.out.println("Last name?");
        String lastName = inputScanner.next();

        System.out.println("What promotion?");
        displayPromotions(promotions);
        Promotion promotion = null;
        while (promotion == null)
        {
            promotion = promotions.get(inputScanner.next());
            if (promotion == null)
            {
                System.out.println("This promotion does not exist.");
            }
        }

        Date dateOfBirth = new Date(askInt("Year of birth?"), askInt("Month of birth?"), askInt("Day of birth?"));
        Student student = new Student(firstName, lastName, promotion, dateOfBirth);
        students.put(student.getId(), student);
        saveStudentsAndEvaluations(students);
    }

    public static void addPromotion(Map<String, Promotion> promotions)
    {
        displayTitle("Adding a new promotion");
        System.out.println("What is the name of this new promotion?");
        String name = inputScanner.next();
        promotions.put(name, new Promotion(name));

        savePromotions(promotions);
    }

    public static int askInt()
    {
        return askInt(null);
    }

    public static int askInt(String message)
    {
        if (message != null)
        {
            System.out.println(message);
        }

        while (true)
        {
            try
            {
                return inputScanner.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Incorrect input.");
            }
        }
    }
}
