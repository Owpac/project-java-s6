package test;

import school.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FilesMethods
{
    private final static String delimiters = ", |,|\\r?\\n";

    public static void loadEvaluations(Map<Integer, Student> students) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("src/test/data/evaluations.csv"));

        scanner.useDelimiter(delimiters);

        while (scanner.hasNext())
        {
            String topic = scanner.next();
            double grade = Double.valueOf(scanner.next());
            Student student = students.get(scanner.nextInt());
            Professor professor = new Professor(scanner.next(), scanner.next());

            new Evaluation(topic, grade, student, professor);
        }
    }

    public static Map<String, Promotion> loadPromotions() throws FileNotFoundException
    {
        Map<String, Promotion> promotions = new HashMap<>();

        Scanner scanner = new Scanner(new File("src/test/data/promotions.csv"));
        scanner.useDelimiter(delimiters);

        while (scanner.hasNext())
        {
            String promotionName = scanner.next();
            promotions.put(promotionName, new Promotion(promotionName));
        }
        return promotions;
    }

    public static Map<Integer, Student> loadStudents(Map<String, Promotion> promotions) throws FileNotFoundException
    {
        Map<Integer, Student> students = new HashMap<>();

        Scanner scanner = new Scanner(new File("src/test/data/students.csv"));
        scanner.useDelimiter(delimiters);

        while (scanner.hasNext())
        {
            int studentId = scanner.nextInt();
            String firstName = scanner.next();
            String lastName = scanner.next();
            Promotion promotion = promotions.get(scanner.next());
            Date birthDate = new Date(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

            Student student = new Student(studentId, firstName, lastName, promotion, birthDate);
            students.put(student.getId(), student);
        }

        return students;
    }

    public static void savePromotions(Map<String, Promotion> promotions)
    {
        try
        {
            PrintWriter printWriter = new PrintWriter(new FileWriter("src/test/data/promotions.csv"));
            for (String promo : promotions.keySet())
            {
                printWriter.println(promo);
            }
            printWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void saveStudentsAndEvaluations(Map<Integer, Student> students)
    {
        PrintWriter printWriterStudents;
        PrintWriter printWriterEvaluations;
        try
        {
            printWriterStudents = new PrintWriter(new FileWriter("src/test/data/students.csv"));
            printWriterEvaluations = new PrintWriter(new FileWriter("src/test/data/evaluations.csv"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        for (Student student : students.values())
        {
            String firstName = student.getFirstName();
            String lastName = student.getLastName();
            String promotionName = student.getPromotionName();
            Date birth = student.getBirthDate();

            printWriterStudents.printf("%d, %s, %s, %s, %d, %d, %d\n", student.getId(), firstName, lastName,
                                       promotionName, birth.getYear(), birth.getMonth(), birth.getDay());

            for (Evaluation evaluation : student.getEvaluations())
            {
                String topic = evaluation.getTopic();
                double grade = evaluation.getGrade();
                String professorFirstName = evaluation.getProfessor().getFirstName();
                String professorLastName = evaluation.getProfessor().getLastName();

                printWriterEvaluations.printf("%s, %s, %d, %s, %s\n", topic, grade, student.getId(), professorFirstName, professorLastName);
            }
        }

        printWriterStudents.close();
        printWriterEvaluations.close();
    }
}
