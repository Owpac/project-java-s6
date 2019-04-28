package test;

import school.Promotion;
import school.Student;

import javax.swing.*;
import java.util.Map;

public class ListStudentFrame extends JFrame {

    private Map<Integer, Student> students;

    public ListStudentFrame(Map<Integer, Student> students) {

        this.students = students;

        //Frame's configuration
        BaseFrame.frame( this, "List Student", 500, true );

        JPanel container = new JPanel();
        container.setLayout( new BoxLayout( container, BoxLayout.PAGE_AXIS ) );

        for (Student student : students.values()) {
            JPanel row = new JPanel();
            row.add( new JLabel( "- " + student.getFullName() + ": " + student.getId() ) );
            container.add( row );
        }

        this.setContentPane( container );
        this.setVisible( true );
    }
}
