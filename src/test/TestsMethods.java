package test;

import school.Promotion;
import school.Student;

public class TestsMethods
{
    public static void displaySeparatorLine() {
        System.out.println("==========================================");
    }

    public static void displayTitle(String title) {
        displaySeparatorLine();
        System.out.println(title);
        displaySeparatorLine();
    }

    public static void displayPromotion(String title, Promotion promotion) {
        displayTitle(title);
        System.out.println(promotion + "\n");
    }

    public static void searchStudent(int studentID, Promotion promotion) {
        System.out.println("Searching for student n°" + studentID + " in promotion " + promotion.getName());
        Student student = promotion.search(studentID);

        if (student == null) {
            System.out.println("No student has been found!");
        }
        else {
            System.out.println("Found student:\n\t" + student.toString().replace("\n", "\n\t"));
        }

        System.out.println();
    }
}
