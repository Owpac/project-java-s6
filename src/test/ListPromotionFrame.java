package test;

import school.Promotion;

import javax.swing.*;
import java.util.Map;

public class ListPromotionFrame extends JFrame {

    private Map<String, Promotion> promotions;

    public ListPromotionFrame(Map<String, Promotion> promotions) {

        this.promotions = promotions;

        //Frame's configuration
        BaseFrame.frame( this, "List Promotion", 500, true );

        JPanel container = new JPanel();
        container.setLayout( new BoxLayout( container, BoxLayout.PAGE_AXIS ) );

        for (Promotion promotion : this.promotions.values()) {
            JPanel row = new JPanel();
            row.add( new JLabel( "- Promotion " + promotion.getName() ) );
            container.add( row );
        }

        this.setContentPane( container );
        this.setVisible( true );
    }
}
