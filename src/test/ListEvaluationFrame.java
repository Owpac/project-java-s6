package test;

import school.Evaluation;
import school.Student;

import javax.swing.*;
import java.util.Map;

public class ListEvaluationFrame extends JFrame {

    private Map<Integer, Student> students;

    public ListEvaluationFrame(Map<Integer, Student> students) {

        this.students = students;

        //Frame's configuration
        BaseFrame.frame( this, "List Evaluations", 650, true );

        JPanel container = new JPanel();
        container.setLayout( new BoxLayout( container, BoxLayout.PAGE_AXIS ) );

        for (Student student : students.values()) {
            for (Evaluation evaluation : student.getEvaluations()) {
                JPanel row = new JPanel();
                row.add( new JLabel( evaluation.toString() ) );
                container.add( row );
            }
        }

        this.setContentPane( container );
        this.setVisible( true );
    }
}
