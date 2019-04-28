package test;

import school.Promotion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import static test.FilesMethods.savePromotions;

public class AddPromotionFrame extends JFrame implements ActionListener {

    private JTextField nameInput;
    private JButton addButton;
    private Map<String, Promotion> promotions;

    public AddPromotionFrame(Map<String, Promotion> promotions) {

        this.promotions = promotions;

        //Frame's configuration
        BaseFrame.frame(this, "Add Promotion", 400, true);

        //First row configuration
        JPanel row1 = new JPanel();
        row1.setLayout( new GridLayout( 1, 2 ) );

        JLabel name = new JLabel( "What is the name of this new promotion?" );
        row1.add( name );
        this.nameInput = new JTextField();
        row1.add( nameInput );

        //Second row configuration
        JPanel row2 = new JPanel();
        this.addButton = new JButton( "Add" );
        this.addButton.addActionListener( this );
        row2.add( this.addButton );

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

        if (source == this.addButton) {
            promotions.put(this.nameInput.getText(), new Promotion(this.nameInput.getText()));
            savePromotions(promotions);
        }
    }
}
