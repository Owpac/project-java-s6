package test;

import school.Promotion;
import school.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import static test.UtilityMethods.getMeansByTopic;
import static test.UtilityMethods.getMediansByTopic;

public class DisplayStudentReport extends JFrame implements ActionListener
{

    private JTextField studentIdInput;
    private JButton displayButton;
    private Map<String, Promotion> promotions;
    private Map<Integer, Student> students;

    public DisplayStudentReport(Map<String, Promotion> promotions, Map<Integer, Student> students)
    {

        this.promotions = promotions;
        this.students = students;

        //Frame's configuration
        BaseFrame.frame(this, "Display Student Report", 500, true);

        //First row configuration
        JPanel row1 = new JPanel();
        /*row1.setLayout( new GridLayout( 1, 2 ) );*/
        row1.add(new JLabel("Student ID:"));
        this.studentIdInput = new JTextField(10);
        row1.add(studentIdInput);

        //Second row configuration
        JPanel row2 = new JPanel();
        this.displayButton = new JButton("Display");
        this.displayButton.addActionListener(this);
        row2.add(this.displayButton);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.add(row1);
        container.add(row2);

        this.setContentPane(container);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton source = (JButton) e.getSource();

        if (source == this.displayButton)
        {
            try
            {
                String textID = this.studentIdInput.getText();
                Integer id = Integer.valueOf(textID);
                Student student = this.students.get(id);
                if (student != null)
                {
                    DisplayMethods.displayStudentReport(this.promotions, student);
                    new StudentGradesHistogram(student.getFullName() + " means per topic", getMeansByTopic(student));
                    new StudentGradesHistogram(student.getFullName() + " medians per topic", getMediansByTopic(student));
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Failed to display student report of '" + this.studentIdInput.getText() + "', this student does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
            catch (Exception ignored) {
                JOptionPane.showMessageDialog(null, "Failed to display student report of '" + this.studentIdInput.getText() + "', this student does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
