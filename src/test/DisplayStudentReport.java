package test;

import school.Promotion;
import school.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class DisplayStudentReport extends JFrame implements ActionListener {

    private JTextField studentIdInput;
    private JButton displayButton;
    private Map<String, Promotion> promotions;
    private Map<Integer, Student> students;

    public DisplayStudentReport(Map<String, Promotion> promotions, Map<Integer, Student> students) {

        this.promotions = promotions;
        this.students = students;

        //Frame's configuration
        BaseFrame.frame( this, "Display Student Report", 500, true );

        //First row configuration
        JPanel row1 = new JPanel();
        /*row1.setLayout( new GridLayout( 1, 2 ) );*/
        row1.add( new JLabel( "Student ID:" ) );
        this.studentIdInput = new JTextField( 10 );
        row1.add( studentIdInput );

        //Second row configuration
        JPanel row2 = new JPanel();
        this.displayButton = new JButton( "Display" );
        this.displayButton.addActionListener( this );
        row2.add( this.displayButton );

        JPanel container = new JPanel();
        container.setLayout( new BoxLayout( container, BoxLayout.PAGE_AXIS ) );
        container.add( row1 );
        container.add( row2 );

        this.setContentPane( container );
        this.setVisible( true );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if (source == this.displayButton) {
            if (this.promotions.get( this.studentIdInput.getText() ) != null) {
                DisplayMethods.displayStudentReport( this.promotions, this.students.get( this.studentIdInput.getText() ) );
            } else {
                JOptionPane.showMessageDialog( null, "Failed to display student report of '" + this.studentIdInput.getText() + "', this student does not exist.", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
    }
}
