package c134_ulamspiral;

import javax.swing.*;

public class SpiralFrame extends JFrame {
    SpiralPanel panel;

    public SpiralFrame(int length) {
        panel = new SpiralPanel(length);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        //To change the number up to which primes are calculated, change the arguments of frame
        JFrame frame = new SpiralFrame(100000);
    }
}
