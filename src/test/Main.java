package test;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Main
{
    public static void main(String[] args)
    {
        JFrame jFrame = new JFrame("Menu");
        jFrame.setLocationRelativeTo( null );
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(new GridLayout(2, 2));

        // Tests 1
        JButton button1 = new JButton("Tests version 1");
        button1.addActionListener(e -> {
            jFrame.setVisible(false);
            TestsV1.start();
            jFrame.setVisible(true);
        });
        jFrame.add(button1);

        // Tests 2
        JButton button2 = new JButton("Tests version 2");
        button2.addActionListener(e -> {
            jFrame.setVisible(false);
            try
            {
                TestsV2.start();
            }
            catch (FileNotFoundException ex)
            {
                ex.printStackTrace();
            }
            jFrame.setVisible(true);
        });
        jFrame.add(button2);

        // Tests 3
        JButton button3 = new JButton("Tests version 3");
        button3.addActionListener(e -> {
            jFrame.setVisible(false);
            try
            {
                TestsV3.start();
            }
            catch (FileNotFoundException ex)
            {
                ex.printStackTrace();
            }
            jFrame.setVisible(true);
        });
        jFrame.add(button3);

        // Tests 4
        JButton button4 = new JButton("Tests version 4");
        button4.addActionListener(e -> {
            jFrame.setVisible(false);
            try
            {
                new TestsV4();
            }
            catch (FileNotFoundException ex)
            {
                ex.printStackTrace();
            }
            jFrame.setVisible(true);
        });
        jFrame.add(button4);

        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setSize(500, 500);
    }
}
