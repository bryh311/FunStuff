package c96_complimentarycolor;

import javax.swing.*;

public class ColorRunner {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Complementary Color App");
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.add(new ColorPanel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
