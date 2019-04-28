package test;

import school.Promotion;
import school.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import static test.FilesMethods.*;

public class TestsV4 extends JFrame implements ActionListener {

    private ArrayList<JButton> buttons;
    private Map<String, Promotion> promotions;
    private Map<Integer, Student> students;

    public TestsV4() throws FileNotFoundException {

        this.promotions = loadPromotions();

        this.students = loadStudents(promotions);

        loadEvaluations(this.students);

        //Attribute's initiaisation
        this.buttons = new ArrayList<>();

        //Frame's configuration
        BaseFrame.frame(this, "Menu", 400, true);

        //If we close this frame, we close all the program
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        //Panel's connfiguration
        JPanel panel = new JPanel();
        panel.setLayout( new GridLayout( 3, 2 ) );

        this.buttons.add( new JButton( "Add a promotion" ) );
        this.buttons.add( new JButton( "Add a student" ) );
        this.buttons.add( new JButton( "Add an evaluation" ) );
        this.buttons.add( new JButton( "List promotions" ) );
        this.buttons.add( new JButton( "List students" ) );
        this.buttons.add( new JButton( "List evaluations" ) );

        //Button's configuration
        for (JButton button : this.buttons) {
            button.addActionListener( this );
            panel.add( button );
        }

        this.setContentPane( panel );
        this.setVisible( true );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if (source == this.buttons.get( 0 )) {
            new AddPromotionFrame( this.promotions );
        } else if (source == this.buttons.get( 1 )) {
            new AddStudentFrame( this.promotions, this.students );
        } else if (source == this.buttons.get( 2 )) {

        } else if (source == this.buttons.get( 3 )) {

        } else if (source == this.buttons.get( 4 )) {

        } else if (source == this.buttons.get( 5 )) {

        } else if (source == this.buttons.get( 6 )) {

        }
    }
}
