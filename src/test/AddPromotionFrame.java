package test;

import school.Promotion;

import javax.swing.*;
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
        BaseFrame.frame( this, "Add Promotion", 500, 100, true );

        //First row configuration
        JPanel row1 = new JPanel();
        /*row1.setLayout( new GridLayout( 1, 2 ) );*/
        row1.add( new JLabel( "What is the name of this new promotion?" ) );
        this.nameInput = new JTextField( 10 );
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

            if (!this.nameInput.getText().isEmpty() && !this.nameInput.getText().matches( "^ +$" )) {
                promotions.put( this.nameInput.getText(), new Promotion( this.nameInput.getText() ) );
                savePromotions( promotions );

                JOptionPane.showMessageDialog( null, "Correctly added promotion '" + this.nameInput.getText() + "' !", "Success", JOptionPane.INFORMATION_MESSAGE );
            } else {
                JOptionPane.showMessageDialog( null, "Failed to add promotion '" + this.nameInput.getText() + "', name not correct.", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
    }
}
