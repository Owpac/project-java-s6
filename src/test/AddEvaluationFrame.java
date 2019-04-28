package test;

import school.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import static test.FilesMethods.saveStudentsAndEvaluations;

public class AddEvaluationFrame extends JFrame implements ActionListener {

    private JTextField studentIdInput;
    private JTextField topicInput;
    private JTextField gradeInput;
    private JTextField professorFirstNameInput;
    private JTextField professorLastNameInput;
    private JButton addButton;
    private Map<Integer, Student> students;

    public AddEvaluationFrame(Map<Integer, Student> students) {

        this.students = students;

        //Frame's configuration
        BaseFrame.frame( this, "Add Evaluation", 500, true );

        //First row configuration
        JPanel row1 = new JPanel();
        /*row1.setLayout( new GridLayout( 1, 2 ) );*/

        row1.add( new JLabel( "Student ID?" ) );
        this.studentIdInput = new JTextField( 10 );
        row1.add( this.studentIdInput );

        JPanel row2 = new JPanel();
        row2.add( new JLabel( "Topic?" ) );
        this.topicInput = new JTextField( 10 );
        row2.add( this.topicInput );

        JPanel row3 = new JPanel();
        row3.add( new JLabel( "Grade?" ) );
        this.gradeInput = new JTextField( 10 );
        row3.add( this.gradeInput );

        JPanel row4 = new JPanel();
        row4.add( new JLabel( "Professor first name?" ) );
        this.professorFirstNameInput = new JTextField( 10 );
        row4.add( this.professorFirstNameInput );

        JPanel row5 = new JPanel();
        row5.add( new JLabel( "Professor last name?" ) );
        this.professorLastNameInput = new JTextField( 10 );
        row5.add( this.professorLastNameInput );

        JPanel row6 = new JPanel();
        this.addButton = new JButton( "Add" );
        this.addButton.addActionListener( this );
        row6.add( this.addButton );

        JPanel container = new JPanel();
        container.setLayout( new BoxLayout( container, BoxLayout.PAGE_AXIS ) );
        container.add( row1 );
        container.add( row2 );
        container.add( row3 );
        container.add( row4 );
        container.add( row5 );
        container.add( row6 );

        this.setContentPane( container );
        this.setVisible( true );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if (source == this.addButton) {

            try {

                int studentId = Integer.parseInt( this.studentIdInput.getText() );

                if (this.students.get( studentId) != null) {

                    if (!this.topicInput.getText().isEmpty() && !this.topicInput.getText().matches( "^ +$" )) {

                        try {
                            double grade = Double.parseDouble( this.gradeInput.getText() );

                            if (!this.professorFirstNameInput.getText().isEmpty() && !this.professorFirstNameInput.getText().matches( "^ +$" )) {

                                if (!this.professorLastNameInput.getText().isEmpty() && !this.professorLastNameInput.getText().matches( "^ +$" )) {

                                    new Evaluation( this.topicInput.getText(), grade, this.students.get( studentId ), new Professor( this.professorFirstNameInput.getText(), this.professorLastNameInput.getText() ) );
                                    saveStudentsAndEvaluations( this.students );

                                    JOptionPane.showMessageDialog( null, "Successfully added evaluation !", "Success", JOptionPane.INFORMATION_MESSAGE );

                                } else {
                                    JOptionPane.showMessageDialog( null, "Failed to add evaluation, professor last name not correct.", "Error", JOptionPane.ERROR_MESSAGE );
                                }

                            } else {
                                JOptionPane.showMessageDialog( null, "Failed to add evaluation, professor first name not correct.", "Error", JOptionPane.ERROR_MESSAGE );
                            }

                        } catch (NumberFormatException error) {
                            JOptionPane.showMessageDialog( null, "Error : incorrect input in grade.", "Error", JOptionPane.ERROR_MESSAGE );
                        }

                    } else {
                        JOptionPane.showMessageDialog( null, "Failed to add evaluation, topic not correct.", "Error", JOptionPane.ERROR_MESSAGE );
                    }

                } else {
                    JOptionPane.showMessageDialog( null, "Failed to add evaluation, this Student ID does not exist.", "Error", JOptionPane.ERROR_MESSAGE );
                }
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog( null, "Error : incorrect input in Student Id.", "Error", JOptionPane.ERROR_MESSAGE );
            }

        }
    }
}
