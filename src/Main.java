import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        Promotion promotion = new Promotion("2021");
        Student student1 = new Student("Thomas", "Faugier", promotion, new Date(1998, Calendar.OCTOBER, 24));
        Student student2 = new Student("Florian", "Ernst", promotion, new Date(1999, Calendar.OCTOBER, 29));

        Evaluation eval1 = new Evaluation("mathematics", 5.0, student1, new Professor("Patrick", "TELLER"));
        Evaluation eval2 = new Evaluation("physics", 18.0, student2, new Professor("Catherine", "MARECHAL"));
        Evaluation eval3 = new Evaluation("english", 12.0, student1, new Professor("Ryan", "HOLMAN"));
        Evaluation eval4 = new Evaluation("java", 16.0, student2, new Professor("Michel", "LANDSCHOOT"));
        Evaluation eval5 = new Evaluation("communication", 0.0, student1, new Professor("Clara", "BOISSIER"));

        System.out.println(promotion);
    }
}