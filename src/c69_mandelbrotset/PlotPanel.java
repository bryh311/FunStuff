package c69_mandelbrotset;
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class PlotPanel extends JPanel {

    private final int MAX_ITERATIONS = 80;

    public PlotPanel() {
        this.setSize(800,800);
    }

    public int mandelbrot(Complex c) {
        Complex z = new Complex(0,0);
        int n = 0;
        while(Complex.abs(z) <= 2 && n < MAX_ITERATIONS) {
            z = Complex.add(Complex.square(z), c);
            n++;
        }
        return n;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(int x = 0; x <= this.getWidth(); x++) {
            for(int y = 0; y <= this.getHeight(); y++) {
                double dx = x;
                double dy = y;
                Complex c = new Complex(-2f + ((dx / this.getWidth()) * 4) , -2f + ((dy / this.getHeight())) * 4);
                int color = 255 - ((mandelbrot(c) * 255)/ MAX_ITERATIONS);
                g2d.setColor(new Color(color, color, color));
                g2d.drawLine(x,y,x,y);

            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mandelbrot set");
        frame.setSize(800, 800);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.add(new PlotPanel());
        frame.pack();
        frame.setVisible(true);
//        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
