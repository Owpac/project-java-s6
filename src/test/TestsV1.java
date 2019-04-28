package test;

import school.*;

import java.util.Calendar;

import static test.UtilityMethods.*;

public class TestsV1
{
    public static void start()
    {
        // Create the promotions
        Promotion promotion2021 = new Promotion("2021");

        // Create the students
        Student thomas = new Student("Thomas", "Faugier", promotion2021, new Date(1998, Calendar.OCTOBER, 24));
        Student florian = new Student("Florian", "Ernst", promotion2021, new Date(1999, Calendar.OCTOBER, 29));
        Student celine = new Student("Celine", "YE", promotion2021, new Date(1996, Calendar.APRIL, 29));

        // Create the professors
        Professor teller = new Professor("Patrick", "TELLER");
        Professor zalamea = new Professor("Frederico", "ZALAMEA");
        Professor marechal = new Professor("Catherine", "MARECHAL");
        Professor holman = new Professor("Ryan", "HOLMAN");
        Professor landschoot = new Professor("Michel", "LANDSCHOOT");
        Professor boissier = new Professor("Clara", "BOISSIER");
        Professor breton = new Professor("Cristopher", "MARSHALL-BRETON");

        // Create the grades
        // -> Thomas
        new Evaluation("Mathematics", 5.0, thomas, teller);
        new Evaluation("English", 12.0, thomas, holman);
        new Evaluation("Communication", 1.5, thomas, boissier);
        new Evaluation("Transverse Project", 17.5, thomas, breton);

        // -> Florian
        new Evaluation("Physics", 18.0, florian, marechal);
        new Evaluation("Java", 16.0, florian, landschoot);
        new Evaluation("Communication", 16.0, florian, boissier);
        new Evaluation("Transverse Project", 17.5, florian, breton);

        // -> Céline
        new Evaluation("Physics", 19.5, celine, marechal);
        new Evaluation("Mathematics", 20.0, celine, zalamea);
        new Evaluation("Communication", 17.0, celine, boissier);
        new Evaluation("Communication", 16.5, celine, boissier);
        new Evaluation("Communication", 16.0, celine, boissier);

        testPromotion(promotion2021);
    }
}
