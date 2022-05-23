package c43_oldskooldemos;

import javax.swing.*;
import java.awt.*;

public class DemoRunner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Demo");
        frame.setSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new Plasma());
//        frame.add(new Tunnel());
        frame.setVisible(true);
    }
}
