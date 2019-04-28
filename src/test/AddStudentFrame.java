package test;

import school.Date;
import school.Promotion;
import school.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import static test.FilesMethods.savePromotions;
import static test.FilesMethods.saveStudentsAndEvaluations;

public class AddStudentFrame extends JFrame implements ActionListener {

    private JTextField firstnameInput;
    private JTextField lastnameInput;
    private JTextField promotionInput;
    private JTextField dayInput;
    private JTextField monthInput;
    private JTextField yearInput;
    private JButton addButton;
    private Map<String, Promotion> promotions;
    private Map<Integer, Student> students;

    public AddStudentFrame(Map<String, Promotion> promotions, Map<Integer, Student> students) {

        this.promotions = promotions;
        this.students = students;

        //Frame's configuration
        BaseFrame.frame( this, "Add Student", 500, true );

        //First row configuration
        JPanel row1 = new JPanel();
        /*row1.setLayout( new GridLayout( 1, 2 ) );*/

        row1.add( new JLabel( "First name?" ) );
        this.firstnameInput = new JTextField( 10 );
        row1.add( this.firstnameInput );

        JPanel row2 = new JPanel();
        row2.add( new JLabel( "Last name?" ) );
        this.lastnameInput = new JTextField( 10 );
        row2.add( this.lastnameInput );

        JPanel row3 = new JPanel();
        row3.add( new JLabel( "What promotion?" ) );
        this.promotionInput = new JTextField( 10 );
        row3.add( this.promotionInput );

        JPanel row4 = new JPanel();
        row4.add( new JLabel( "Day of birth?" ) );
        this.dayInput = new JTextField( 10 );
        row4.add( this.dayInput );

        JPanel row5 = new JPanel();
        row5.add( new JLabel( "Month of birth?" ) );
        this.monthInput = new JTextField( 10 );
        row5.add( this.monthInput );

        JPanel row6 = new JPanel();
        row6.add( new JLabel( "Year of birth?" ) );
        this.yearInput = new JTextField( 10 );
        row6.add( this.yearInput );

        JPanel row7 = new JPanel();
        this.addButton = new JButton( "Add" );
        this.addButton.addActionListener( this );
        row7.add( this.addButton );

        JPanel container = new JPanel();
        container.setLayout( new BoxLayout( container, BoxLayout.PAGE_AXIS ) );
        container.add( row1 );
        container.add( row2 );
        container.add( row3 );
        container.add( row4 );
        container.add( row5 );
        container.add( row6 );
        container.add( row7 );

        this.setContentPane( container );
        this.setVisible( true );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if (source == this.addButton) {

            if (!this.firstnameInput.getText().isEmpty() && !this.firstnameInput.getText().matches( "^ +$" )) {

                if (!this.lastnameInput.getText().isEmpty() && !this.lastnameInput.getText().matches( "^ +$" )) {

                    if (this.promotions.get( this.promotionInput.getText() ) != null) {

                        try {

                            int day = Integer.parseInt( this.dayInput.getText() );
                            int month = Integer.parseInt( this.monthInput.getText() );
                            int year = Integer.parseInt( this.yearInput.getText() );

                            Date dateOfBirth = new Date( year, month, day );
                            Student student = new Student( this.firstnameInput.getText(), this.lastnameInput.getText(), this.promotions.get( this.promotionInput.getText() ), dateOfBirth );
                            students.put( student.getId(), student );
                            saveStudentsAndEvaluations( students );

                            JOptionPane.showMessageDialog( null, "Successfully added student '" + this.firstnameInput.getText() + "' !", "Success", JOptionPane.INFORMATION_MESSAGE );

                        } catch (NumberFormatException error) {
                            JOptionPane.showMessageDialog( null, "Error : incorrect input.", "Error", JOptionPane.ERROR_MESSAGE );
                        }

                    } else {
                        JOptionPane.showMessageDialog( null, "Failed to add student '" + this.firstnameInput.getText() + "', this promotion does not exist.", "Error", JOptionPane.ERROR_MESSAGE );
                    }

                } else {
                    JOptionPane.showMessageDialog( null, "Failed to add student '" + this.firstnameInput.getText() + "', lastname not correct.", "Error", JOptionPane.ERROR_MESSAGE );
                }

            } else {
                JOptionPane.showMessageDialog( null, "Failed to add student '" + this.firstnameInput.getText() + "', firstname not correct.", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
    }
}
