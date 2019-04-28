package test;

import javax.swing.*;

public class BaseFrame {

    /**
     * Default configuration for a Frame.
     * @param frame The frame that we want to configure.
     * @param title The title of the frame.
     * @param width The width of the frame.
     * @param height The height of the frame.
     * @param resizable Boolean, true if you want to allow rezize of the frame, fasle if you don't want.
     */
    public static void frame(JFrame frame, String title, int width, int height, boolean resizable) {

        frame.setTitle( title );
        frame.setSize( width, height );
        frame.setLocationRelativeTo( null );
        frame.setResizable( resizable );
//        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    /**
     * Default configuration for a Frame, but with same size on width and height.
     * @param frame The frame that we want to configure.
     * @param title The title of the frame.
     * @param size The size of the frame.
     * @param resizable Boolean, true if you want to allow rezize of the frame, fasle if you don't want.
     */
    public static void frame(JFrame frame, String title, int size, boolean resizable) {
        frame( frame, title, size, size, resizable );
    }
}
