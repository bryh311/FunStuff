package c43_oldskooldemos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlasmaTex extends JPanel implements ActionListener {
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    final int FPS = 60;
    int color;
    int[] palette = new int[256];
    int paletteShift = 0;
    int frameNum = 0;
    double movement = 0.1;

    Timer timer;


    public PlasmaTex() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        timer = new Timer(1000/FPS, this);
        timer.start();
        for(int i = 0; i < 256; i++) {
            Color c = hsvToRgb((i * (360/256)), 1.0, 1.0);
            palette[i] = c.getRGB();
        }
    }

    public void paint(Graphics g) {
        for(int y = 0; y < PANEL_HEIGHT; y++)
            for(int x = 0; x < PANEL_WIDTH; x++) {
                color = (int)  ((128.0 + (128.0 * Math.sin(x / 16.0 + movement))
                        + 128.0 + (128.0 * Math.sin(y / 8.0 - movement ))
                        + 128.0 + (128.0 * Math.cos((x + y) / 16.0 + movement))
                        + 128.0 + (128.0 * Math.sin(Math.sqrt((x * x + y * y)) / 8.0 ))) / 4.0);
                g.setColor(new Color(palette[((color + paletteShift) % 256)]));
                g.drawRect(x,y,0,0);
            }
    }


    /**
     * hsv to rgb
     * taken from Rosetta Code
     */
    private static Color hsvToRgb(int h, double s, double v) {
        double hp = h/60.0;
        double c = s * v;
        double x = c * (1 - Math.abs(hp % 2.0 - 1));
        double m = v - c;
        double r = 0, g = 0, b = 0;
        if (hp <= 1) {
            r = c;
            g = x;
        } else if (hp <= 2) {
            r = x;
            g = c;
        } else if (hp <= 3) {
            g = c;
            b = x;
        } else if (hp <= 4) {
            g = x;
            b = c;
        } else if (hp <= 5) {
            r = x;
            b = c;
        } else {
            r = c;
            b = x;
        }
        r += m;
        g += m;
        b += m;
        return new Color((int)(r * 255), (int)(g * 255), (int)(b * 255));
    }
    boolean sneed = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        frameNum++;
        paletteShift = (int) (frameNum / 60.0);
        movement = movement + 0.1;
        //if(frameNum())
        repaint();
    }
}
