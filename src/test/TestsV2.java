package test;

import school.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static test.TestsMethods.displaySeparatorLine;
import static test.TestsMethods.displayTitle;

public class TestsV2
{
    public static void start() throws FileNotFoundException
    {
        displayTitle("Reading data from files.");

        Map<String, Promotion> promotions = new HashMap<>();
        Map<Integer, Student> students = new HashMap<>();

        Scanner promotionsScanner = new Scanner(new File("src/test/data/promotions.csv"));
        Scanner studentsScanner = new Scanner(new File("src/test/data/students.csv"));
        Scanner evaluationsScanner = new Scanner(new File("src/test/data/evaluations.csv"));

        final String delimiters = ", |,|\\r?\\n";
        promotionsScanner.useDelimiter(delimiters);
        studentsScanner.useDelimiter(delimiters);
        evaluationsScanner.useDelimiter(delimiters);

        System.out.println("Reading promotions.");
        while (promotionsScanner.hasNext())
        {
            String promotionName = promotionsScanner.next();
            promotions.put(promotionName, new Promotion(promotionName));

            System.out.println("New promotion: " + promotionName);
        }

        System.out.println("\nReading students.");
        while (studentsScanner.hasNext())
        {
            String firstName = studentsScanner.next();
            String lastName = studentsScanner.next();
            Promotion promotion = promotions.get(studentsScanner.next());
            Date birthDate = new Date(studentsScanner.nextInt(), studentsScanner.nextInt(), studentsScanner.nextInt());

            Student student = new Student(firstName, lastName, promotion, birthDate);
            students.put(student.getId(), student);

            System.out.println("New student: " + student.getFullName());
        }

        System.out.println("\nReading evaluations.");
        while (evaluationsScanner.hasNext())
        {
            String topic = evaluationsScanner.next();
            String g = evaluationsScanner.next();
            double grade = evaluationsScanner.nextDouble();
            Student student = students.get(evaluationsScanner.nextInt());
            Professor professor = new Professor(evaluationsScanner.next(), evaluationsScanner.next());

            Evaluation eval = new Evaluation(topic, grade, student, professor);
            System.out.println("New evaluation: " + eval);
        }
    }
}
